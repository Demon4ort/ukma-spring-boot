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
    private String time;
    private String groupNumber;


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

    public Lesson(String day, String time, String groupNumber, Course course) {
        this.day = day;
        this.time = time;
        this.groupNumber = groupNumber;
        this.course = course;
    }

    public void enrollUser(User user){
          enrolledUsers.add(user);
    }

    public Lesson() {
    }

    public Lesson(String day, String time, String group, Course course, Set<User> enrolledUsers) {
        this.day = day;
        this.time = time;
        this.groupNumber = group;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGroup() {
        return groupNumber;
    }

    public void setGroup(String group) {
        this.groupNumber = group;
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
