package com.nhnacademy.student.admin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

//@WebServlet(urlPatterns = "/student/update")
public class StudentUpdateFormController implements Command {
    private StudentRepository studentRepository;
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String id = req.getParameter("id");
        Student student = studentRepository.getStudentById(id);

        if(Objects.isNull(student)) {
            throw new RuntimeException("Student not found :" + id);
        }
        req.setAttribute("student",student);

        return "/student/register.jsp";
    }
}
