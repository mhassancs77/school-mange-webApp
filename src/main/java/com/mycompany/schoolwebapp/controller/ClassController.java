/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.controller;

import com.mycompany.schoolwebapp.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/class")
public class ClassController {

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllStudents(ModelMap modelMap) {
        modelMap.addAttribute("classes", classService.getAllClasss());
        modelMap.addAttribute("c_t_next", "N");
        modelMap.addAttribute("c_s_next", "N");
        return "classes";
    }

    @RequestMapping(value = "/teacherPrev/{teacherId}", method = RequestMethod.GET)
    public String getAllStudentsAsTeacherPrev(@PathVariable("teacherId") int teacherId,ModelMap modelMap) {
        modelMap.addAttribute("classes", classService.getAllClasss());
        modelMap.addAttribute("c_t_next", "Y");
        modelMap.addAttribute("c_s_next", "N");
        modelMap.addAttribute("detailTeacherId", teacherId);
        return "classes";
    }

    @RequestMapping(value = "/studentPrev/{studentId}", method = RequestMethod.GET)
    public String getAllStudentsAsStudentPrev(@PathVariable("studentId") int studentId,ModelMap modelMap) {
        modelMap.addAttribute("classes", classService.getAllClasss());
        modelMap.addAttribute("c_t_next", "N");
        modelMap.addAttribute("c_s_next", "Y");
        modelMap.addAttribute("detailStudentId", studentId);
        return "classes";
    }
}
