package UI;

import Wrapper.DefaultQueries;

import java.sql.SQLException;
import java.util.Scanner;
/*
info on using scanner in classes
https://stackoverflow.com/questions/64619712/please-can-you-tell-me-the-reason-why-we-declare-a-scanner-class-object-the-sec

 */

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    DefaultQueries standardQuery = new DefaultQueries();
    String firstName;
    String lastName;
    String password;


    public void initGreeting() {
        System.out.println("[=HELLO!=]");
        System.out.println("[=WELCOME TO THE MCMILLAN HUMAN RESOURCE AND INFORMATION SYSTEM=]");
        System.out.println("[=PLEASE FOLLOW THE PROMPTS BELOW=]");
        //System.out.println("[=TO QUIT AT ANYTIME TYPE 'quit' AND HIT ENTER=]");
        System.out.println();
        auth(); //pseudo db call to check credentials
    }

    public void auth() {
        System.out.println("TO BEGIN PLEASE ENTER YOUR FIRST NAME:");
        this.firstName = scanner.nextLine();
        System.out.println("FIRST NAME IS " + firstName);
        System.out.println("NOW ENTER YOUR LAST NAME:");
        this.lastName = scanner.nextLine();
        System.out.println("LAST NAME IS " + lastName);
        System.out.println("NOW ENTER PASSWORD:");
        this.password = scanner.nextLine();
        System.out.println("PASSWORD IS " + password);
    }

    public void userPage() throws SQLException {
        System.out.println("WELCOME " + firstName + " " + lastName);
        System.out.println("WHAT INFORMATION WOULD YOU LIKE TO SEE?");
        System.out.println("FOR BASIC EMPLOYEE INFO E.G. 'ADDRESS','PHONE NUMBER'");
        System.out.println("ENTER THE WORD 'basic'");
        //System.out.println("FOR SALARY AND BENEFITS INFO ENTER THE WORD 'sal'");
        //System.out.println("FOR ATTENDANCE HISTORY TYPE 'at'");
        String userInfoChoice = scanner.nextLine();
        switch (userInfoChoice) {
            case "basic":
                standardQuery.selectBasicInfo(firstName);
                break;


        }

    }



}
