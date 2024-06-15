package com.satish.lil.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCExecutor {

    public static void main(String... args){
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                "hplussport", "postgres", "password");
        try{

            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            List<Customer> customers = customerDAO.findAllSorted(20);
            customers.forEach(System.out::println);
            // Paging
            System.out.println("Paged");
            for(int i=1;i<4;i++) {
                System.out.println("Page Number: "+ i);
                customerDAO.findAllPaged(10,i).forEach(System.out::println);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
