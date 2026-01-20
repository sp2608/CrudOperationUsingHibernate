package com.lcwd.hiber;

import com.lcwd.hiber.entities.Student;
import com.lcwd.hiber.util.HibernateUtil;
import com.lcwd.hiber.StudentServices;
import com.lcwd.hiber.entities.Certificate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {
    	
    		StudentServices studentServices = new StudentServices();
    		 Student student = studentServices.getById(7);
    		 System.out.println(student.getName());
    		 
    		 student.getCertificates().forEach(Cer ->{
    			 
    			 System.out.println(Cer.getTitle());
    		 
    		 });
    		
    	
//    		Student student = new Student();
//    		student.setName("Prabh");
//    		student.setCollage("ZCOER");
//    		student.setActive(true);
//    		student.setAbout("This is dummy student");
//    		student.setFatherName("Dhyan");
//    		student.setPhone("9875648394");
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = null;
//        
//        Certificate certificate = new Certificate();
//        certificate.setTitle("Java Intern");
//        certificate.setAbout("I hava completed my intern in java");
//        certificate.setLink("https/ddd/sss");
//        certificate.setStudent(student);
//        
//        Certificate certificate1 = new Certificate();
//        certificate1.setTitle("Java Intern");
//        certificate1.setAbout("I hava completed my intern in java");
//        certificate1.setLink("https/ddd/sss");
//        certificate1.setStudent(student);
//        
//        student.getCertificates().add(certificate);
//        student.getCertificates().add(certificate1);
//
//        
//        try {
//        	
//			transaction = session.beginTransaction();
//			session.persist(student);
//			session.persist(certificate);
//			System.out.println("Student saved successfully");
//			transaction.commit();
//			
//		} catch (Exception e) {
//			
//			if(transaction != null) {
//				
//				transaction.rollback();
//				
//			}else{
//				
//				e.printStackTrace();
//			}
//			
//		}finally {
//			session.close();
//		}
        
        
    }
}
