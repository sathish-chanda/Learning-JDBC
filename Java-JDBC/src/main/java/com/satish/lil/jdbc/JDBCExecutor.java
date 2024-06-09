package com.satish.lil.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class JDBCExecutor {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost","hplussport","postgres","password");
        try{
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM PRODUCT");
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        System.out.printf("Hello Learning JDBC!");
    }
}