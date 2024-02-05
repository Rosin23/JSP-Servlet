package com.nhnacademy.student.admin;

import org.apache.commons.math3.random.RandomDataGenerator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class WebApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        StudentRepository studentRepository = new MapStudentRepository();

        //List<Student> studentList = new ArrayList<>();
        for(int i=1; i<=10; i++){
            String id = "student" +i;
            String name = "askman" + i;
            Gender gender;
            int age = new RandomDataGenerator().nextInt(20,30);
            if(age%2==1) {
                gender = Gender.M;
            } else {
                gender = Gender.F;
            }
            // ... student 1 ~ 10 생성하기
            // 나이 : random 처리 : 20~30
            //studentList.add(new Student(id, name, gender, age));

            studentRepository.save(new Student(id,name,gender,age));
        }
        // ... application scope에서 studentRepository 객체에 접근할 수 있도록 구현하기
        context.setAttribute("studentRepository", studentRepository);

    }
}