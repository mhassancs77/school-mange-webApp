/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.service;

import java.util.List;
import com.mycompany.schoolwebapp.model.Classes;


public interface ClassService {
    
    public List<Classes> getAllClasss();
    public Classes getClassById(int classId);
}
