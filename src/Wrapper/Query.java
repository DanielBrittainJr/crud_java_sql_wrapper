package Wrapper;


public class Query { // here we deal with the query building

    private StringBuilder Query;

    public Query select(String[] columns) {
        Query = new StringBuilder(); //create stringbuilder object
        Query.append("SELECT "); //begin query with SELECT
        if (columns != null) { //if the array of columns isn't empty
            for (String column : columns) { // for each column in the columns array
                Query.append(column); // add column to query object
                Query.append(","); // we add commas to the SELECT statement to keep adding columns
            }
            Query.deleteCharAt(Query.lastIndexOf(",")); //we delete the last comma so the query doesnt error
        } else {
            Query.append("*"); // if columns are empty then we select all with *
        }
        return this;
    }

    public Query from(String table) {
        Query.append(" FROM ");
        Query.append(table);
        return this;
    }

    public Query where(String condition) {
        Query.append(" WHERE ");
        Query.append(condition);
        return this;
    }


    public String getQuery() {
        return Query.toString();
    }
}



