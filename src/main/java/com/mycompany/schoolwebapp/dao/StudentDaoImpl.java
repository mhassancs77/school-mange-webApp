/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.dao;

import com.mycompany.schoolwebapp.dto.SearchStudent;
import com.mycompany.schoolwebapp.model.Student;
import java.util.Collections;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Student> getAllStudents() {
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("FROM Student");
            return q.list();
        } catch (HibernateException e) {
            System.out.println(StudentDaoImpl.class.getName() + " - " + e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Student> getStudentsByClassId(int classId) {
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("FROM Student s WHERE s.studentClass.id =:classId");
            q.setParameter("classId", classId);
            return q.list();
        } catch (HibernateException e) {
            System.out.println(StudentDaoImpl.class.getName() + " - " + e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public Student getStudentById(int studentId) {
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("FROM Student s WHERE s.id = :studentId");
            q.setParameter("studentId", studentId);
            return (Student) q.uniqueResult();
        } catch (HibernateException e) {
            System.out.println(StudentDaoImpl.class.getName() + " - " + e.getMessage());
        }
        return null;
    }

    @Override
    public void addStudent(Student student) {
        try {
            sessionFactory.getCurrentSession().save(student);
        } catch (HibernateException e) {
            System.out.println(StudentDaoImpl.class.getName() + " - " + e.getMessage());
        }
    }

    @Override
    public void editStudent(Student student) {
        try {
            Session se = sessionFactory.getCurrentSession();
            Student currentStudent = (Student) se.get(Student.class, student.getId());
            currentStudent.setName(student.getName());
            currentStudent.setAge(student.getAge());
            currentStudent.setGender(student.getGender());
            currentStudent.setCountry(student.getCountry());
            currentStudent.setPhone(student.getPhone());
            currentStudent.setStudentClass(student.getStudentClass());
            se.update(currentStudent);
        } catch (HibernateException e) {
            System.out.println(StudentDaoImpl.class.getName() + " - " + e.getMessage());
        }
    }

    @Override
    public List<Student> getSearchStudents(SearchStudent searchStudent) {

        StringBuilder queryString = new StringBuilder("FROM Student s WHERE 1=1 ");
        queryString = queryString.append(" AND s.studentClass.id = " + searchStudent.getSearchClass() + " ");
        queryString = queryString.append(" AND s.gender = '" + searchStudent.getSearchGender() + "' ");
        if (searchStudent.getSearchCountry() != null && !searchStudent.getSearchCountry().isEmpty()) {
            queryString = queryString.append(" AND s.country = '" + searchStudent.getSearchCountry() + "'  ");
        }

        try {
            Query q = sessionFactory.getCurrentSession().createQuery(queryString.toString());
            return q.list();
        } catch (HibernateException e) {
            System.out.println(StudentDaoImpl.class.getName() + " - " + e.getMessage());
        }
        return Collections.EMPTY_LIST;

    }

}
