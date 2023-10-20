<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab_20182.Beans.Employee" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<%ArrayList<Employee>listaEmpleados=(ArrayList<Employee>) request.getAttribute("listaEmpleados");
Employee empleadoFoundSearch=(Employee) request.getAttribute("empleadoFoundSearch");
%>
<body>
<div class="container">
    <h1>Lista de empleados</h1>
    <br>
    <a href="https://paideia.pucp.edu.pe/cursos/">Regresar</a>
    <br>
    <a href="<%=request.getContextPath()%>/EmployeeServlet?action=addView">Agregar nuevo empleado</a>
    <br>
    <form method="post" action="<%=request.getContextPath()%>/EmployeeServlet?action=searchView">
        <label>Buscar: </label>
        <input type="text" class="form-control" name="searchEmployeeID" placeholder="Ingrese el ID del empleado" value="<%if(empleadoFoundSearch!=null)%><%=empleadoFoundSearch.getEmployeeID()%>">
    </form>
    <table>
        <tr>
            <th><h6>ID de empleado</h6></th>
            <th><h6>Nombre</h6></th>
            <th><h6>Apellido</h6></th>
            <th><h6>Correo</h6></th>
            <th><h6>Teléfono</h6></th>
            <th><h6>Fecha de contratación</h6></th>
            <th><h6>ID de trabajo</h6></th>
            <th><h6>Salario</h6></th>
            <th><h6>Comisión</h6></th>
            <th><h6>ID de jefe</h6></th>
            <th><h6>ID de departamento</h6></th>
        </tr>
        <%if(empleadoFoundSearch==null)
            for(Employee employee:listaEmpleados){%>
        <tr>
            <th><h6><%=employee.getEmployeeID()%></h6></th>
            <th><h6><%=employee.getFirstName()%></h6></th>
            <th><h6><%=employee.getLastName()%></h6></th>
            <th><h6><%=employee.getEmail()%></h6></th>
            <th><h6><%=employee.getPhoneNumber()%></h6></th>
            <th><h6><%=employee.getHireDate()%></h6></th>
            <th><h6><%=employee.getJobID()%></h6></th>
            <th><h6><%=employee.getSalary()%></h6></th>
            <th><h6><%=employee.getCommission()%></h6></th>
            <th><h6><%=employee.getManagerID()%></h6></th>
            <th><h6><%=employee.getDepartmentID()%></h6></th>
            <th><a href="<%=request.getContextPath()%>/EmployeeServlet?action=updateView&updateEmployeeID=<%=employee.getEmployeeID()%>">Editar</a></th>
        </tr>
        <%}else{%>
        <tr>
            <th><h6><%=empleadoFoundSearch.getEmployeeID()%></h6></th>
            <th><h6><%=empleadoFoundSearch.getFirstName()%></h6></th>
            <th><h6><%=empleadoFoundSearch.getLastName()%></h6></th>
            <th><h6><%=empleadoFoundSearch.getEmail()%></h6></th>
            <th><h6><%=empleadoFoundSearch.getPhoneNumber()%></h6></th>
            <th><h6><%=empleadoFoundSearch.getHireDate()%></h6></th>
            <th><h6><%=empleadoFoundSearch.getJobID()%></h6></th>
            <th><h6><%=empleadoFoundSearch.getSalary()%></h6></th>
            <th><h6><%=empleadoFoundSearch.getCommission()%></h6></th>
            <th><h6><%=empleadoFoundSearch.getManagerID()%></h6></th>
            <th><h6><%=empleadoFoundSearch.getDepartmentID()%></h6></th>
            <th><a href="<%=request.getContextPath()%>/EmployeeServlet?action=updateView&updateEmployeeID=<%=empleadoFoundSearch.getEmployeeID()%>">Editar</a></th>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>