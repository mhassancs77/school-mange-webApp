/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.service;

import com.mycompany.schoolwebapp.dao.StudentDao;
import com.mycompany.schoolwebapp.dto.SearchStudent;
import com.mycompany.schoolwebapp.model.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentDao studentDao;
    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public List<Student> getStudentsByClassId(int classId) {
        return studentDao.getStudentsByClassId(classId);
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentDao.getStudentById(studentId);
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void editStudent(Student student) {
        studentDao.editStudent(student);
    }

    @Override
    public List<Student> getSearchStudents(SearchStudent searchStudent) {
        return studentDao.getSearchStudents(searchStudent);
    }
    
}
