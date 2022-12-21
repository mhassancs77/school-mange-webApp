/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.dao;

import com.mycompany.schoolwebapp.model.Teacher;
import java.util.Collections;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Teacher> getAllTeachers() {
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("from Teacher");
            return q.list();
        } catch (HibernateException e) {
            System.out.println(TeacherDaoImpl.class.getName() + " - " + e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Teacher> getTeachersByClassId(int classId) {
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("FROM Teacher t WHERE t.teacherClass.id =:classId ");
            q.setParameter("classId", classId);
            return q.list();
        } catch (HibernateException e) {
            System.out.println(TeacherDaoImpl.class.getName() + " - " + e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public Teacher getTeacherById(int teacherId) {
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("FROM Teacher t WHERE t.id =:teacherId ");
            q.setParameter("teacherId", teacherId);
            return (Teacher) q.uniqueResult();
        } catch (HibernateException e) {
            System.out.println(TeacherDaoImpl.class.getName() + " - " + e.getMessage());
        }
        return null;
    }

}
