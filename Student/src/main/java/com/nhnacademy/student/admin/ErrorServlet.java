package com.nhnacademy.student.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/error")
public class ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("status_code", req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        //todo exception_type
        req.setAttribute("exception_type", req.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE));
        //todo message
        req.setAttribute("message", req.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        //todo exception
        req.setAttribute("exception", req.getAttribute(RequestDispatcher.ERROR_EXCEPTION));
        //todo request_uri
        req.setAttribute("request_uri", req.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));

        //todo /error.jsp forward 처리
        RequestDispatcher rd = req.getRequestDispatcher("/student/error.jsp");
        rd.forward(req,resp);
    }
}