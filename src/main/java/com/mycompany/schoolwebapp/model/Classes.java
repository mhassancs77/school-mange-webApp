/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


@Entity
@Table(name = "classes")
@NamedQueries({
    @NamedQuery(name = "Classes.findAll", query = "FROM Classes WHERE 1=1")
    ,
@NamedQuery(name = "Classes.findById", query = "FROM Classes c WHERE c.id =:classId")
})

public class Classes {

    public Classes() {

    }

    public Classes(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    @Column(name = "c_name")
    String name;

    @Column(name = "c_address")
    String address;

    @Column(name = "c_capacity")
    int capacity;

    @Column(name = "c_space")
    int space;

    @OneToMany(mappedBy = "studentClass", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Student> students;

    @OneToMany(mappedBy = "teacherClass", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Teacher> teachers;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public static Classes getAnynomusClassesObjectForSearch() {
        return new Classes(0, "All Classes");
    }

}
