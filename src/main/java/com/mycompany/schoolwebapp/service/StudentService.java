/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.service;

import com.mycompany.schoolwebapp.dto.SearchStudent;
import com.mycompany.schoolwebapp.model.Student;
import java.util.List;


public interface StudentService {
    public List<Student> getAllStudents();
    public List<Student> getStudentsByClassId(int classId);
    public Student getStudentById(int studentId);
    public void addStudent(Student student);
    public void editStudent(Student student);
    public List<Student> getSearchStudents(SearchStudent searchStudent);
}
