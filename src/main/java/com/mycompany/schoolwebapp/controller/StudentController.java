/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.controller;

import com.mycompany.schoolwebapp.dto.SearchStudent;
import com.mycompany.schoolwebapp.model.Classes;
import com.mycompany.schoolwebapp.model.Student;
import com.mycompany.schoolwebapp.service.ClassService;
import com.mycompany.schoolwebapp.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    ClassService classService;
    
    private SearchStudent searchStudent = new SearchStudent();

    private int detailStudentId;
    private int detailClassId;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllStudents(ModelMap modelMap) {
        modelMap.addAttribute("students", studentService.getAllStudents());
        modelMap.addAttribute("searchStudent", searchStudent);
        List<Classes> AllClasses = classService.getAllClasss();
        modelMap.addAttribute("classes", AllClasses);
        modelMap.addAttribute("s_next", "N");
        return "students";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String getSearchStudents(@ModelAttribute SearchStudent searchStudent, BindingResult result, ModelMap modelMap) {
        List<Student> serachResult = studentService.getSearchStudents(searchStudent);
        modelMap.addAttribute("students", serachResult);
        modelMap.addAttribute("searchStudent", searchStudent);
        List<Classes> AllClasses = classService.getAllClasss();
        modelMap.addAttribute("classes", AllClasses);
        modelMap.addAttribute("s_next", "N");
        return "students";
    }

    @RequestMapping("/class/{id}")
    public String getAllStudentsForClass(@PathVariable("id") int id, ModelMap modelMap) {
        Classes classes = classService.getClassById(id);
        modelMap.addAttribute("students", classes.getStudents());
        modelMap.addAttribute("searchStudent", searchStudent);
        List<Classes> AllClasses = classService.getAllClasss();
        modelMap.addAttribute("classes", AllClasses);
        modelMap.addAttribute("id", id);
        modelMap.addAttribute("s_prev", "Y");

        if (detailStudentId != 0) {
            modelMap.addAttribute("s_next", "Y");
            modelMap.addAttribute("detailStudentId", detailStudentId);
        } else {
            modelMap.addAttribute("s_next", "N");
        }
        detailClassId = id;
        return "students";
    }

    @RequestMapping("/detail/{id}")
    public String getStudentDetail(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("student", studentService.getStudentById(id));
        detailStudentId = id;
        return "student-details";
    }

    @RequestMapping("/addPage")
    public String getAddStudentPage(ModelMap modelMap) {
        modelMap.addAttribute("classes", classService.getAllClasss());
        modelMap.addAttribute("student", new Student());

        return "add-student";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute Student student, BindingResult result, ModelMap modelMap) {
//        if (result.hasErrors()) {
//            return "add-student";
//        }
        Classes classes = classService.getClassById(student.getClassId());
        student.setStudentClass(classes);
        studentService.addStudent(student);
        return "redirect:/student/all";
    }

    @RequestMapping("/editPage/{id}")
    public String getEditStudentPage(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("classes", classService.getAllClasss());
        Student selectedStudent = studentService.getStudentById(id);
        selectedStudent.setClassId(selectedStudent.getStudentClass().getId());
        modelMap.addAttribute("student", selectedStudent);
        return "edit-student";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editStudent(@ModelAttribute Student student, BindingResult result, ModelMap modelMap) {
//        if (result.hasErrors()) {
//            return "add-student";
//        }
        Classes classes = classService.getClassById(student.getClassId());
        student.setStudentClass(classes);
        studentService.editStudent(student);
        return "redirect:/student/all";

    }

    //get student/all page As Previous page
    @RequestMapping(value = "/prev", method = RequestMethod.GET)
    public String getAllStudentsAsPrevious(ModelMap modelMap) {

        if (detailClassId != 0) {
            Classes classes = classService.getClassById(detailClassId);
            modelMap.addAttribute("students", classes.getStudents());
            modelMap.addAttribute("id", detailClassId);
            modelMap.addAttribute("s_prev", "Y");
        } else {
            modelMap.addAttribute("students", studentService.getAllStudents());
            modelMap.addAttribute("s_prev", "N");
        }
        modelMap.addAttribute("searchStudent", searchStudent);
        List<Classes> AllClasses = classService.getAllClasss();
         modelMap.addAttribute("classes", AllClasses);
        modelMap.addAttribute("s_next", "Y");
        modelMap.addAttribute("detailStudentId", detailStudentId);
        return "students";

    }

}
