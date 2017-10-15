package org.itstep.service;

import static org.junit.Assert.*;

import org.itstep.App;
import org.itstep.dao.pojo.Student;
import org.itstep.dao.pojo.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)

public class TeacherServiceTest {
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	SubjectService subjectService;

	@Test
	public void createAndUpdateTeacher() {
		
		Teacher teacher = new Teacher();
		teacher.setLogin("Ivan84");
		teacher.setPassword("1234567");
		teacher.setFirstName("Ivan");
		teacher.setLastName("Ivanov");
		teacher.setSubject("Programming");
		Teacher teacherFromDB = teacherService.createAndUpdateTeacher(teacher);
		assertNotNull(teacherFromDB);
		Teacher checkedTeacher = teacherService.getTeacher(teacherFromDB.getLogin());
		assertEquals("Ivan84", checkedTeacher.getLogin());

	}
	
	@Test
	public void deleteTeacher() {
		Teacher teacher = new Teacher();
		teacher.setLogin("Ivan84");
		teacher.setPassword("1234567");
		teacher.setFirstName("Ivan");
		teacher.setLastName("Ivanov");
		teacher.setSubject("Programming");
		Teacher teacherFromDB = teacherService.createAndUpdateTeacher(teacher);
		teacherService.deleteTeacher(teacherFromDB.getLogin());
		Teacher checkedTeacher = teacherService.getTeacher(teacherFromDB.getLogin());
	    assertNull (checkedTeacher);
	}

}
