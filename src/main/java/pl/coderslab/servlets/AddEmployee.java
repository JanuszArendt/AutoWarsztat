package pl.coderslab.servlets;

import pl.coderslab.DAO.EmployeeDao;
import pl.coderslab.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddEmployee", urlPatterns = "/AddEmployee")
public class AddEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String note = request.getParameter("note");
        Double pph = Double.valueOf(request.getParameter("pph"));

        EmployeeDao employeeDao = EmployeeDao.getInstance();
        Employee employee = new Employee(name, lastname, address, phone, note, pph);

        employeeDao.save(employee);
        request.setAttribute("employeeDao", employeeDao);
        response.sendRedirect("Employees");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Employees/addEmployee.jsp").forward(request, response);
    }
}
