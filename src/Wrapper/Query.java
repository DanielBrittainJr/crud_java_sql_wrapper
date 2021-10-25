package Wrapper;


public class Query { // here we deal with the query building

    private StringBuilder query;

    public Query select(String[] columns) {
        query = new StringBuilder(); //create stringbuilder object
        query.append("SELECT "); //begin query with SELECT
        if (columns != null) { //if the array of columns isn't empty
            for (String column : columns) { // for each column in the columns array
                query.append(column); // add column to query object
                query.append(","); // we add commas to the SELECT statement to keep adding columns
            }
            query.deleteCharAt(query.lastIndexOf(",")); //we delete the last comma so the query doesnt error
        } else {
            query.append("*"); // if columns are empty then we select all with *
        }
        return this;
    }

    public Query from(String table) {
        query.append(" FROM ");
        query.append(table);
        return this;
    }

    public Query where(String condition) {
        query.append(" WHERE ");
        query.append(condition);
        return this;
    }

    public Query delete(String table) {
        query = new StringBuilder();
        query.append("DELETE FROM ");
        query.append(table);
        return this;
    }

    public Query update(String table) {
        query = new StringBuilder();
        query.append("UPDATE ");
        query.append(table);
        query.append(" SET ");
        return this;
    }

    public Query insert(String table,String[] columns) {
        query = new StringBuilder();
        query.append("INSERT INTO ");
        query.append(table);
        query.append(" (" + columns + " )");
        for(int i =0; i< columns.length; i++) {
            query.append("?,");
        }
        query.deleteCharAt(query.lastIndexOf(","));
        query.append(")");
        return this;
    }
    
    public Query values(String[] params) {
        query.append(" VALUES(");
        for(int i =0;i<params.length; i++) {
            query.append("?,");
        }
        query.deleteCharAt(query.lastIndexOf(","));
        query.append(");");
        return this;
    }


    public String getQuery() {
        return query.toString();
    }
}



