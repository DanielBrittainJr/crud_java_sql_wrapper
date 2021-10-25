package Wrapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class DefaultQueries {

    protected Database database;

    //sql query for basic user information
    public void selectBasicInfo(String firstName) throws SQLException{
            database = new Database("sakila","root","itunes44");
            String[] column = {"first_name","last_name","last_update"};
            String conParameters = firstName;
            ResultSet rs = database.selectWhere("actor",column,"first_name = ?",conParameters);//we take table,column,condition
            while(rs.next()) {
                System.out.println(rs.getString("first_name"));
                System.out.println(rs.getString("last_name"));
                System.out.println(rs.getString("last_update"));
            }


    }



}
