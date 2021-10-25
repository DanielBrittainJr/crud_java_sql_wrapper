package Wrapper;


import java.sql.*;

public class Database { // here we create the connection, grab the queries and take the input

    protected Connection connection;
    protected Query query;

    //create connection
    public Database(String databaseName, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, userName, password);
    }
    //SELECT "columns" FROM "table"
    public ResultSet select(String table, String[] columns) throws SQLException { //returns values all from column/s
        query = new Query(); //create query object
        //here we chain sql for readability
        query.select(columns).from(table); //SELECT column FROM table WHERE condition
        //here we use prepared statement to create our query
        PreparedStatement preparedStatement = connection.prepareStatement(query.getQuery());
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    //select with where condition
    public ResultSet selectWhere(String table, String[] columns,String condition,String conParameter) throws SQLException {
        query = new Query();
        query.select(columns).from(table).where(condition);
        PreparedStatement preparedStatement = connection.prepareStatement(query.getQuery());
        preparedStatement.setObject(1,conParameter);
        ResultSet resultSet = preparedStatement.executeQuery();
        return  resultSet;
    }

    public ResultSet insertInto(String table, String[] columns,String[] values) throws SQLException {
        query = new Query();
        query.insert(table,columns).values(values);
        PreparedStatement preparedStatement = connection.prepareStatement(query.getQuery());
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

}