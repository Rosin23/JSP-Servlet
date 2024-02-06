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
import java.rmi.StubNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@WebServlet(urlPatterns = "/student/view")
public class StudentViewController implements Command {
    private StudentRepository studentRepository;
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        //List<Student> studentList = studentRepository.getStudents();
        String id = req.getParameter("id");
        if (Objects.isNull(id)) {
            throw new RuntimeException("parameter [id] : null");
        }

        Student student = studentRepository.getStudentById(id);
        if(Objects.isNull(student)) {
            throw new NullPointerException(id);
        }
        req.setAttribute("student", student);

        return "/student/view.jsp";
    }
}