package pl.coderslab.servlets;

import pl.coderslab.DAO.EmployeeDao;
import pl.coderslab.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditEmployee", urlPatterns = "/EditEmployee")
public class EditEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("lastname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String note = request.getParameter("note");
        Double pph = Double.valueOf(request.getParameter("pph"));


        EmployeeDao employeeDao = EmployeeDao.getInstance();

        Employee employee = new Employee(id, name, surname, address, phone, note, pph);
        if (employeeDao.update(employee)) {
            request.setAttribute("employeeDao", employeeDao);

            response.sendRedirect("Employees");
        } else {
            response.sendRedirect("EditEmployee");
           


        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Employees/editEmployee.jsp").forward(request, response);
    }
}
