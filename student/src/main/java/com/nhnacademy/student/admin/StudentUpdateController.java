package com.nhnacademy.student.admin;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Slf4j
//@WebServlet(urlPatterns = "/student/update")
public class StudentUpdateController implements Command {
    //private StudentRepository studentRepository;
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {


        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String id = req.getParameter("id");
        log.info("id :");
        String name = req.getParameter("name");
        Gender gender = null;
        if(Objects.nonNull(req.getParameter("gender"))){
            gender = Gender.valueOf(req.getParameter("gender"));
        }
        Integer age = null;
        if(Objects.nonNull(req.getParameter("age"))){
            age = Integer.parseInt(req.getParameter("age"));
        }
        if(Objects.isNull(id) || Objects.isNull(name) || Objects.isNull(gender) || Objects.isNull(age)){
            throw new RuntimeException("id,name,gender,age 확인해줏메");
        }
        //todo student 저장
        Student student = new Student(id,name,gender,age);
        studentRepository.update(student);
        req.setAttribute("student",student);
        return "/student/view.jsp?id="+student.getId();
    }
}