package com.lcwd.hiber;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.lcwd.hiber.entities.Student;
import com.lcwd.hiber.util.HibernateUtil;


public class StudentServices {
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	//Save
	public void saveStudent(Student student) {
		try(Session session = sessionFactory.openSession()){
			
			Transaction transaction = session.beginTransaction();
			
			session.persist(student);
			transaction.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Get By ID
	public Student getById(long studentId) {
		try (Session session = sessionFactory.openSession()){
			return session.get(Student.class, studentId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Update
	public Student updateStudent(long studentId, Student student) {
		
		try (Session session = sessionFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			
			Student oldStudent = session.get(Student.class, student);
			
			if(oldStudent!=null) {
				oldStudent.setName(student.getName());
				oldStudent.setFatherName(student.getFatherName());
				
			}
			session.merge(oldStudent);
			
			transaction.commit();
			
			return oldStudent;
		} 
	}
	
	//Delete
	public void deleteStudent(long studentId) {
		
		try(Session session = sessionFactory.openSession()){
			
			Transaction transaction = session.beginTransaction();
	
			Student student = session.get(Student.class,studentId);
			
			if (student != null) {
				session.remove(student);
			}
			
			transaction.commit();

		}
		
	}
	
	
	//HQL[JPA]--> native query

	//get all student using HQL
	public List<Student> getAllStudentsHQL(){
		
		try(Session session = sessionFactory.openSession()){
			
			String getHQL = "FROM Student";
			Query<Student> query = session.createQuery(getHQL, Student.class);
			return query.list();
			
		}
	}
	
	//get student by name
	
	public Student getStudentByName(String name) {
		
		try(Session session = sessionFactory.openSession()){
			
			String getByNameHQL = "FROM Student WHERE name = :studentName";
			
			Query<Student> query = session.createQuery(getByNameHQL, Student.class);
			query.setParameter("studentName", name);
		
			return query.uniqueResult();
		}
	}
}
