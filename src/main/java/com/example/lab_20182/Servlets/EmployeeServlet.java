package com.example.lab_20182.Servlets;

import com.example.lab_20182.Beans.Employee;
import com.example.lab_20182.Daos.EmployeeDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String action = request.getParameter("action") == null ? "indexView" : request.getParameter("action");
        switch (action){
            case "indexView":
                ArrayList<Employee>listaEmpleados=new EmployeeDao().listarEmpleados();
                request.setAttribute("listaEmpleados",listaEmpleados);
                request.getRequestDispatcher("Jobs/index.jsp").forward(request,response);
                break;
            case "addView":
                request.getRequestDispatcher("Jobs/crear.jsp").forward(request,response);
                break;
            case "updateView":
                int employeeID=Integer.parseInt(request.getParameter("updateEmployeeID"));
                Employee e=new EmployeeDao().listarEmpleados(employeeID);
                request.setAttribute("empleadoFoundUpdate",e);
                request.getRequestDispatcher("Jobs/editar.jsp").forward(request,response);
                break;
            case "deleteConfirm":
                new EmployeeDao().eliminarEmpleado(Integer.parseInt(request.getParameter("deleteEmployeeID")));
                response.sendRedirect(request.getContextPath()+"/EmployeeServlet");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String action = request.getParameter("action") == null ? "default" : request.getParameter("action");
        switch (action) {
            case "searchView":
                String recv = request.getParameter("searchEmployeeID");
                if (recv != null) {
                    request.setAttribute("empleadoFoundSearch", new EmployeeDao().listarEmpleados(Integer.parseInt(recv)));
                    request.getRequestDispatcher("Jobs/index.jsp").forward(request, response);
                } else
                    response.sendRedirect(request.getContextPath() + "/EmployeeServlet");
                break;
            case "addConfirm":
                int addEmployeeID = Integer.parseInt(request.getParameter("addEmployeeID"));
                String addFirstName = request.getParameter("addFirstName");
                String addLastName = request.getParameter("addLastName");
                String addEmail = request.getParameter("addEmail");
                String addPhoneNumber = request.getParameter("addPhoneNumber");
                String addHireDate = request.getParameter("addHireDate");
                String addJobID = request.getParameter("addJobID");
                double addSalary = Double.parseDouble(request.getParameter("addSalary"));
                double addCommission = Double.parseDouble(request.getParameter("addCommission"));
                int addManagerID = Integer.parseInt(request.getParameter("addManagerID"));
                int addDepartmentID = Integer.parseInt(request.getParameter("addDepartmentID"));
                new EmployeeDao().crearEmpleado(addEmployeeID, addFirstName, addLastName, addEmail, addPhoneNumber, addHireDate, addJobID, addSalary, addCommission, addManagerID, addDepartmentID);
                response.sendRedirect(request.getContextPath()+"/EmployeeServlet");
                break;
            case "updateConfirm":
                int updateEmployeeID=Integer.parseInt(request.getParameter("updateEmployeeID"));
                String updateFirstName=request.getParameter("updateFirstName");
                String updateLastName=request.getParameter("updateLastName");
                String updateEmail=request.getParameter("updateEmail");
                String updatePhoneNumber=request.getParameter("updatePhoneNumber");
                String updateHireDate=request.getParameter("updateHireDate");
                String updateJobID=request.getParameter("updateJobID");
                double updateSalary=Double.parseDouble(request.getParameter("updateSalary"));
                double updateCommission=Double.parseDouble(request.getParameter("updateCommission"));
                int updateManagerID=Integer.parseInt(request.getParameter("updateManagerID"));
                int updateDepartmentID=Integer.parseInt(request.getParameter("updateDepartmentID"));
                new EmployeeDao().actualizarEmpleado(updateEmployeeID,updateFirstName,updateLastName,updateEmail,updatePhoneNumber,updateHireDate,updateJobID,updateSalary,updateCommission,updateManagerID,updateDepartmentID);
                response.sendRedirect(request.getContextPath()+"/EmployeeServlet");
                break;
        }
    }
}