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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/student/list")
public class StudentListController implements Command {
    private StudentRepository studentRepository;
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        List<Student> studentList = studentRepository.getStudents();
        //String id = req.getParameter("id");
        //studentRepository.getStudentById(id);
        req.setAttribute("studentList",studentList);
        return "/student/list.jsp";
    }
}

/*
@Slf4j
@WebServlet(urlPatterns = "/student/list")
public class StudentListServlet extends HttpServlet {
    private StudentRepository studentRepository;
    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //student list 구하기
        List<Student> studentList = studentRepository.getStudents();
        req.setAttribute("studentList",studentList);
         //todo view attribute - /student/list.jsp
        req.setAttribute("view","redirect:/student/list.do");
    }
}
*/