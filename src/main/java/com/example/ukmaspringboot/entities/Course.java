package com.example.ukmaspringboot.entities;
//Course_id
       // Name(string)
       // T_name (string)          //teacher`s name
      //  Groups (Int)
       // Year (Int)

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String name;
    private String teacher_name;

    public Course(){}

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

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public Integer getGroups() {
        return groups;
    }

    public void setGroups(Integer groups) {
        this.groups = groups;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    private Integer groups;
    private String year;

    public Course(String name, String teacher_name, Integer groups, String year) {
        this.name = name;
        this.teacher_name = teacher_name;
        this.groups = groups;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", groups=" + groups +
                ", year='" + year + '\'' +
                '}';
    }


}
