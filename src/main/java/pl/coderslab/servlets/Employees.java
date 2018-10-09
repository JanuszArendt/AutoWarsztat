package pl.coderslab.servlets;

import pl.coderslab.DAO.EmployeeDao;
import pl.coderslab.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Employees", urlPatterns = "/Employees")
public class Employees extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDao employeeDao= EmployeeDao.getInstance();
        List<Employee> cList = employeeDao.getAllEmployees();
        request.setAttribute("employees", cList);

        request.getRequestDispatcher("/WEB-INF/Employees/employees.jsp").forward(request, response);
    }
}
