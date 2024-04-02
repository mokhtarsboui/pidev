package edu.esprit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private final String URL="jdbc:mysql://localhost:3306/webpi";
    private final String User="root";
    private final String PASSWD="";
    private Connection cnx;
    private static DataSource instance;
    private DataSource(){
        try {
            cnx=DriverManager.getConnection( URL , User , PASSWD);
            System.out.println("connected to database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static DataSource getInstance(){
        if(instance==null){
            instance=new DataSource();

        }
        return instance;
    }
    public Connection getCnx(){
        return this.cnx;
    }
}
