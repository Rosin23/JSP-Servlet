package com.nhnacademy.student.admin;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
//@WebServlet(urlPatterns = "/student/delete")
public class StudentDeleteController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String id = req.getParameter("id");

        log.error("id:{}",id);
        studentRepository.deleteById(id);
        //view를 return합니다
        return "redirect:/student/list.do";
    }
}

    /*
    private StudentRepository studentRepository;
    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
        //todo init studentRepository
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //toSdo get parameter  : id , id가 존재하지 않을경우 throw new RuntimeException("...")
        String id = req.getParameter("id");
        if (Objects.isNull(id)) {
            throw new RuntimeException("id");
        }
        log.error("id:{}",id);
        studentRepository.deleteById(id);
        //resp.sendRedirect("/student/list");
        //todo view attribute - redirect:/student/list.jsp
        req.setAttribute("view","redirect:/student/list.do");
    }
}

     */