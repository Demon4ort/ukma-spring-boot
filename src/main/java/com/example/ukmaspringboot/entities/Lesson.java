package com.example.ukmaspringboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lessonId;
    private String day;
    private LocalTime time;
    private String group;

    @ManyToOne
    @JoinColumn(name = "courseId")
    Course course;

        @ManyToMany
        @JoinTable(
            name = "user_enrolled",
            joinColumns = @JoinColumn(name = "lessonId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private Set<User> enrolledUsers = new HashSet<>();

    public void enrollUser(User user){
          enrolledUsers.add(user);
    }

    public Lesson() {
    }

    public Lesson(String day, LocalTime time, String group, Course course, Set<User> enrolledUsers) {
        this.day = day;
        this.time = time;
        this.group = group;
        this.course = course;
        this.enrolledUsers = enrolledUsers;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<User> getEnrolledUsers() {
        return enrolledUsers;
    }

    public void setEnrolledUsers(Set<User> enrolledUsers) {
        this.enrolledUsers = enrolledUsers;
    }
}
