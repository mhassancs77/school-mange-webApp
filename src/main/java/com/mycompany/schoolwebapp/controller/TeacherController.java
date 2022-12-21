/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.controller;

import com.mycompany.schoolwebapp.model.Classes;
import com.mycompany.schoolwebapp.service.ClassService;
import com.mycompany.schoolwebapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    ClassService classService;

    private int detailTeacherId;
    private int detailClassId;

    @RequestMapping("/all")
    public String getAllTeachers(ModelMap modelMap) {
        modelMap.addAttribute("teachers", teacherService.getAllTeachers());
        modelMap.addAttribute("t_next", "N");
        return "teachers";
    }

    @RequestMapping("/class/{id}")
    public String getAllTeachersforClass(@PathVariable("id") int id, ModelMap modelMap) {
        Classes classes = classService.getClassById(id);
        modelMap.addAttribute("teachers", classes.getTeachers());
        modelMap.addAttribute("id", id);
        modelMap.addAttribute("t_prev", "Y");
        if (detailTeacherId != 0) {
            modelMap.addAttribute("t_next", "Y");
            modelMap.addAttribute("detailTeacherId", detailTeacherId);
        } else {
            modelMap.addAttribute("t_next", "N");
        }
        detailClassId = id;
        return "teachers";
    }

    @RequestMapping("/detail/{id}")
    public String getTeacherDetail(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("teacher", teacherService.getTeachersById(id));
        detailTeacherId = id;
        return "teacher-details";
    }

    //get teachers/all page As Previous page
    @RequestMapping("/prev")
    public String getAllTeachersAsPrevious(ModelMap modelMap) {
        if (detailClassId != 0) {
            Classes classes = classService.getClassById(detailClassId);
            modelMap.addAttribute("teachers", classes.getTeachers());
            modelMap.addAttribute("id", detailClassId);
            modelMap.addAttribute("t_prev", "Y");
        } else {
            modelMap.addAttribute("teachers", teacherService.getAllTeachers());
            modelMap.addAttribute("t_prev", "N");
        }
        modelMap.addAttribute("t_next", "Y");
        modelMap.addAttribute("detailTeacherId", detailTeacherId);
        return "teachers";
    }

//      @RequestMapping("/class/{id}")
//    public String getAllTeachersforClass(@PathVariable("id") int id, ModelMap modelMap) {
//        Classes classes = classService.getClassById(id);
//        modelMap.addAttribute("teachers", classes.getTeachers());
//        modelMap.addAttribute("id", id);
//        modelMap.add Attribute("t_prev", "Y");
//        modelMap.addAttribute("t_next", "N");
//        return "teachers";
//    }
}
