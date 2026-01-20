package com.lcwd.hiber.hibernate_2;

import java.security.cert.Certificate;

import com.lcwd.hiber.StudentServices;
import com.lcwd.hiber.entities.Student;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{
    
	StudentServices studentServices = new StudentServices();
	
	public void getStudentId() {
		 Student student = studentServices.getById(7);
		 System.out.println(student.getName());
		 
		 student.getCertificates().forEach(Cer ->{
			 
			 System.out.println(Cer.getTitle());
		 
		 });
	}
	
}
