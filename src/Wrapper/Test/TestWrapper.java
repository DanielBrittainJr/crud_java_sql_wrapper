package Wrapper.Test;

import Wrapper.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestWrapper {
    public static void main(String[] args) {

        /*
        //below we get values from columns, "first_name" and "last_name"
        try {
            Database dbConnect = new Database("sakila","root","itunes44");
            System.out.println("Database successfully connected");
            String[] column = {"first_name","last_name"};
            ResultSet rs = dbConnect.select("actor",column); //we need resultset methods to print
            while(rs.next()) {
                System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connection to db");
        }

         */


        //todo can we put all this in a method and call it? as long as method throws sql exception
        //below we get table actor, column "first_name" where "first_name" = "Nick"
        try {
            Database dbConnect = new Database("sakila","root","itunes44");
            System.out.println("Connect success");
            String[] column = {"first_name"};
            String conParameters = "Nick";
            ResultSet rs = dbConnect.selectWhere("actor",column,"first_name = ?",conParameters);//we take table,column,condition
            while(rs.next()) {
                System.out.println(rs.getString("first_name"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        //todo create premade queries that the user can look at without any input,
        //todo such as, "see employee info" "see salary information"
        //todo, these queries will pull from the wrapper with premade conditions that are common
        //todo tldr; create a class with premade queries for the employee page,
        // todo wrap the above in methods

    }
}
