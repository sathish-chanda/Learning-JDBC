package com.satish.lil.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class JDBCExecutor {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost","hplussport","postgres","password");
        CustomerDAO customerDAO;
        try{
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM PRODUCT");
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }

            // Insert
            customerDAO = new CustomerDAO(connection);
            Customer dummy = new Customer();
            dummy.setFirstName("Michel");
            dummy.setLastName("Jackson");
            dummy.setAddress("520 Saint-Marc");
            dummy.setCity("Toronto");
            dummy.setEmail("michel.jackson@gmail.com");
            dummy.setPhone("9876 543 210");
            dummy.setState("Ontario");
            dummy.setZipCode("H4F 1W3");
            Customer added = customerDAO.create(dummy);

            // findById
            customerDAO = new CustomerDAO(connection);
            Customer customer = customerDAO.findById(added.getId());
            System.out.println(customer);

            // Update
            customer.setPhone("(987)654-3210");
            customerDAO.update(customer);
            customer = customerDAO.findById(added.getId());
            System.out.println(customer);

            // Delete
            customerDAO.delete(customer.getId());

            List<Customer> customers = customerDAO.findAll();
            System.out.println("List size = " + customers.size());
            OrderDAO orderDAO = new OrderDAO(connection);
            Order order = orderDAO.findById(1068);
            System.out.println(order);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}