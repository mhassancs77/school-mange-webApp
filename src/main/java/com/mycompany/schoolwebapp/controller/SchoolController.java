/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/")
public class SchoolController {
    
    

    @RequestMapping
    public String getHome() {
        return "home";
    }

    @RequestMapping("/classes")
    public String getClasses() {
        return "classes";
    }

    @RequestMapping("/teachers")
    public String getTeachers() {
        return "teachers";
    }

    @RequestMapping("/students")
    public String getStudents() {
        return "students";
    }

    @RequestMapping("/about_us")
    public String getAbout() {
        return "about";
    }

}
