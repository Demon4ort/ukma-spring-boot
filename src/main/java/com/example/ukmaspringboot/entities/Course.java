package com.example.ukmaspringboot.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String name;
    private String teacher;
    private String year;


    @OneToMany(mappedBy = "course")
    Set<Lesson> lessons;



//    public Set<User> getEnrolledUsers() {
//        return enrolledUsers;
//    }
//    @ManyToMany
//    @JoinTable(
//            name = "user_enrolled",
//            joinColumns = @JoinColumn(name = "courseId"),
//            inverseJoinColumns = @JoinColumn(name = "userId")
//    )
//    private Set<User> enrolledUsers = new HashSet<>();

    public Course(String name, String teacher, String year) {
        this.name = name;
        this.teacher = teacher;
        this.year = year;
    }

    public Course() {
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
//    public void enrollUser(User user){
//            enrolledUsers.add(user);
//    }

}















