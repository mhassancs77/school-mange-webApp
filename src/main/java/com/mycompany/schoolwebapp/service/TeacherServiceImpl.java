/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.service;

import com.mycompany.schoolwebapp.dao.TeacherDao;
import com.mycompany.schoolwebapp.model.Teacher;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherDao teacherDao;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }

    @Override
    public List<Teacher> getTeachersByClassId(int classId) {
        return teacherDao.getTeachersByClassId(classId);
    }

    @Override
    public Teacher getTeachersById(int teacherId) {
        return teacherDao.getTeacherById(teacherId);
    }

}
