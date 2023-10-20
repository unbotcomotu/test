<%@page import="java.util.ArrayList"%>
<%@ page import="com.example.lab_20182.Beans.Employee" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Employee employee = (Employee) request.getAttribute("empleadoFoundUpdate");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Actualizar un empleado</h1>
<form method="POST" action="<%=request.getContextPath()%>/EmployeeServlet?action=updateConfirm">
    <label>Nombre: </label>
    <input name="updateFirstName" value="<%=employee.getFirstName()%>" /><br />
    <label>Apellido: </label>
    <input name="updateLastName" value="<%=employee.getLastName()%>"/><br />
    <label>Correo: </label>
    <input name="updateEmail" value="<%=employee.getEmail()%>"/><br />
    <label>Número de teléfono: </label>
    <input name="updatePhoneNumber" value="<%=employee.getPhoneNumber()%>"/><br />
    <label>Fecha de contratación: </label>
    <input name="updateHireDate" value="<%=employee.getHireDate()%>"/><br />
    <label>ID de trabajo: </label>
    <input name="updateJobID" value="<%=employee.getJobID()%>"/><br />
    <label>Salario: </label>
    <input name="updateSalary" value="<%=employee.getSalary()%>"/><br />
    <label>Comisión: </label>
    <input name="updateCommission" value="<%=employee.getCommission()%>"/><br />
    <label>ID de jefe: </label>
    <input name="updateManagerID" value="<%=employee.getManagerID()%>"/><br />
    <label>ID de departamento: </label>
    <input name="updateDepartmentID" value="<%=employee.getDepartmentID()%>"/><br />
    <input name="updateEmployeeID" value="<%=employee.getEmployeeID()%>" type="hidden">
    <button>Enviar</button>
</form>
<a href="<%=request.getContextPath()%>/EmployeeServlet?action=deleteConfirm&deleteEmployeeID=<%=employee.getEmployeeID()%>"><button>Borrar</button></a>
<a href="<%=request.getContextPath()%>/EmployeeServlet"><button>Cancelar</button></a>
</body>
</html>