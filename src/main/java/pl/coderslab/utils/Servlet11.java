package pl.coderslab.utils;

import pl.coderslab.utils.DAO.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet11", urlPatterns = "/test")
public class Servlet11 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDao cDao = EmployeeDao.getInstance();

        cDao.delete(1);

        response.getWriter().append("zrobione");


    }
}
