package Wrapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class DefaultQueries {

    protected Database database;

    String[] employeeInfoColumns;

    //sql query for basic user information
    public void selectBasicInfo(String firstName) throws SQLException{
            database = new Database("sakila","root","itunes44");
            String[] column = {"firstName","lastName","middleName"};
            String conParameters = firstName;
            ResultSet rs = database.selectWhere("actor",column,"first_name = ?",conParameters);//we take table,column,condition
            while(rs.next()) {
                System.out.println(rs.getString("firstName"));
                System.out.println(rs.getString("last_name"));
                System.out.println(rs.getString("middleName"));
            }

    }

    public void insertBasicInfo(String[] basicInfo) throws SQLException {
        database = new Database("hris1","root","itunes44");

        ResultSet rs = database.insertInto("hris1",employeeInfoColumns,basicInfo);
        while(rs.next()) {
            System.out.println(rs.getString("firstName"));
        }

        }

    }

//    public void insertBenefits(int benefitID) {






