/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.service;

import com.mycompany.schoolwebapp.dao.ClassDao;
import com.mycompany.schoolwebapp.model.Classes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassDao classDao;

    @Override
    public List<Classes> getAllClasss() {
        return classDao.getAllClasss();
    }

    @Override
    public Classes getClassById(int classId) {
        return classDao.getClassById(classId);
    }

}
