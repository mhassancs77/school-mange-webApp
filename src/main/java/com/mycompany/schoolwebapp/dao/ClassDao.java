/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.dao;
import com.mycompany.schoolwebapp.model.Classes;
import java.util.List;


public interface ClassDao {
    public List<Classes> getAllClasss();
    public Classes getClassById(int classId);
}
