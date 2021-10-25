import UI.UserInterface;

import java.sql.SQLException;
import java.util.Scanner;

//current working prototype
public class Main {
    public static void main(String[] args) {




        //this is the body of code needed in main for the basic program to run
        UserInterface UI = new UserInterface();
        try {
            UI.initGreeting(); //we greet user and take their information
            UI.userPage(); //here we load information to the user based on their selection
            //after they make their selection we run a sql query that will grab the information they wanted for display
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}






