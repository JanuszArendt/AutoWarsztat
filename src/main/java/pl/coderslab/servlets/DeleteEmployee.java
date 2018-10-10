package pl.coderslab.servlets;

import pl.coderslab.DAO.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteEmployee", urlPatterns = "/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.valueOf(request.getParameter("id"));

        EmployeeDao employeeDao = EmployeeDao.getInstance();

        if (employeeDao.delete(id)) {
            request.setAttribute("employeeDao", employeeDao);

            response.sendRedirect("Employees");
        } else {
            response.sendRedirect("DeleteEmployees");

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Employees/deleteEmployee.jsp").forward(request, response);
    }
}
