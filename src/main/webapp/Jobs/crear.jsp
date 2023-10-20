<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Crear un empleado</h1>
<form method="POST" action="<%=request.getContextPath()%>/EmployeeServlet?action=addConfirm">
    <label>ID: </label>
    <input name="addEmployeeID" /><br />
    <label>Nombre: </label>
    <input name="addFirstName" /><br />
    <label>Apellido: </label>
    <input name="addLastName" /><br />
    <label>Correo: </label>
    <input name="addEmail" /><br />
    <label>Número de teléfono: </label>
    <input name="addPhoneNumber" /><br />
    <label>Fecha de contratación: </label>
    <input name="addHireDate" /><br />
    <label>ID de trabajo: </label>
    <input name="addJobID" /><br />
    <label>Salario: </label>
    <input name="addSalary" /><br />
    <label>Comisión: </label>
    <input name="addCommission" /><br />
    <label>ID de jefe: </label>
    <input name="addManagerID" /><br />
    <label>ID de departamento: </label>
    <input name="addDepartmentID" /><br />
    <button>Enviar</button>
</form>
<a href="<%=request.getContextPath()%>/EmployeeServlet"><button>Cancelar</button></a>
</body>
</html>

