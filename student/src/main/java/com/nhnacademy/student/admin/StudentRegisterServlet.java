package com.nhnacademy.student.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet( urlPatterns = "/student/register")
public class StudentRegisterServlet extends HttpServlet {

    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
        //todo  init studentRepository
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        RequestDispatcher rd = req.getRequestDispatcher("/student/register.jsp");
        rd.forward(req,resp);
         */

        //todo view attribute 설정 - /student/register.jsp
        req.setAttribute("view","redirect:/student/register.do");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");

        Gender gender = null;
        if(Objects.nonNull(req.getParameter("gender"))) {
            gender = Gender.valueOf(req.getParameter("gender"));
        }

        Integer age = null;
        if(Objects.nonNull(req.getParameter("age"))) {
            age = Integer.parseInt(req.getParameter("age"));
        }

        if(Objects.isNull(id) || Objects.isNull(name) || Objects.isNull(gender) || Objects.isNull(age)) {
            throw new RuntimeException("id,name,gender,age를 확인해주세요");
        }

        //studentRepository.save(new Student(id,name,gender,age));
        Student student = new Student(id,name,gender,age);
        studentRepository.save(student);
        //todo redirect view attribute 설정   resp.sendRedirect("/student/view?id="+student.getId());
        req.setAttribute("view","redirect:/student/view?id="+student.getId());
    }
}