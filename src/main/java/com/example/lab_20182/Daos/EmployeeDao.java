package com.example.lab_20182.Daos;

import com.example.lab_20182.Beans.Employee;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDao {
    private Connection conn;
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","root");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Employee> listarEmpleados(){
        ArrayList<Employee> listaEmpleados=new ArrayList<>();
        String sql="select * from employees";
        try(Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql)){
            while(rs.next()){
                Employee e=new Employee();
                e.setEmployeeID(rs.getInt(1));
                e.setFirstName(rs.getString(2));
                e.setLastName(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setPhoneNumber(rs.getString(5));
                e.setHireDate(rs.getString(6));
                e.setJobID(rs.getString(7));
                e.setSalary(rs.getDouble(8));
                e.setCommission(rs.getDouble(9));
                e.setManagerID(rs.getInt(10));
                e.setDepartmentID(rs.getInt(11));
                listaEmpleados.add(e);
            }return listaEmpleados;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Employee listarEmpleados(int ID) {
        String sql="select * from employees where employee_id = ?";
        Employee e=new Employee();
        try(PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1,ID);
            try(ResultSet rs=pstmt.executeQuery()){
                if (rs.next()){
                    e.setEmployeeID(rs.getInt(1));
                    e.setFirstName(rs.getString(2));
                    e.setLastName(rs.getString(3));
                    e.setEmail(rs.getString(4));
                    e.setPhoneNumber(rs.getString(5));
                    e.setHireDate(rs.getString(6));
                    e.setJobID(rs.getString(7));
                    e.setSalary(rs.getDouble(8));
                    e.setCommission(rs.getDouble(9));
                    e.setManagerID(rs.getInt(10));
                    e.setDepartmentID(rs.getInt(11));
                }
            }return e;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void crearEmpleado(int employeeID,String firstName,String lastName,String email,String phoneNumber,String hireDate,String jobID,double salary,double commission,int managerID,int departmentID){
        String sql="insert into employees(employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id) values (?,?,?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement pstmt=conn.prepareStatement(sql);){
            pstmt.setInt(1,employeeID);
            pstmt.setString(2,firstName);
            pstmt.setString(3,lastName);
            pstmt.setString(4,email);
            pstmt.setString(5,phoneNumber);
            pstmt.setString(6,hireDate);
            pstmt.setString(7,jobID);
            pstmt.setDouble(8,salary);
            pstmt.setDouble(9,commission);
            pstmt.setInt(10,managerID);
            pstmt.setInt(11,departmentID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarEmpleado(int employeeID,String firstName,String lastName,String email,String phoneNumber,String hireDate,String jobID,double salary,double commission,int managerID,int departmentID){
        String sql="update employees set first_name=?,last_name=?,email=?,phone_number=?,hire_date=?,job_id=?,salary=?,commission_pct=?,manager_id=?,department_id=? where employee_id=?";
        try(PreparedStatement pstmt=conn.prepareStatement(sql);){
            pstmt.setString(1,firstName);
            pstmt.setString(2,lastName);
            pstmt.setString(3,email);
            pstmt.setString(4,phoneNumber);
            pstmt.setString(5,hireDate);
            pstmt.setString(6,jobID);
            pstmt.setDouble(7,salary);
            pstmt.setDouble(8,commission);
            pstmt.setInt(9,managerID);
            pstmt.setInt(10,departmentID);
            pstmt.setInt(11,employeeID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void eliminarEmpleado(int employeeID){
        String sql="delete from employees where employee_id=?";
        try(PreparedStatement pstmt=conn.prepareStatement(sql);){
            pstmt.setInt(1,employeeID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
