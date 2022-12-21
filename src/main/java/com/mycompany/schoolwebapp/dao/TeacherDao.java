/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.dao;

import com.mycompany.schoolwebapp.model.Teacher;
import java.util.List;


public interface TeacherDao {
    
    public List<Teacher> getAllTeachers();
    public List<Teacher> getTeachersByClassId(int classId); 
    public Teacher getTeacherById(int teacherId);
}
