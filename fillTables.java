//Maximillian Marciel
//Creates the SQL files required for testing.

import java.io.FileInputStream;
import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class fillTables {
    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        try {
            //Write to file name
            //Change the file name according to what you are writing to.
            BufferedWriter writer = new BufferedWriter(new FileWriter("hw10-data-1000000.sql"));
            
            //Do something
            createEntries(writer);
			
            //Close the connection (if the code ever reaches this point)
            writer.close();
        }
        catch(Exception err) {
            System.out.println("Failed to create entries");
            err.printStackTrace();
        }
        
    }
    //-----------------------------------------------------------------------
    public static void createEntries(BufferedWriter writer) {
        try {
            //Receive user input for the amount
            System.out.print("How many insertions do you want?: ");
            Scanner reader = new Scanner(System.in);
            String userChoiceString = reader.next();
            int userNumber = Integer.parseInt(userChoiceString);
            
            //Prepare variables
            int choice = 0;
            Random r = new Random();
            String q = "INSERT INTO employee VALUES ";
            writer.write(q);
            int id;
            int salary;
            
            //Perform insertions
            for (int i = 0; i < userNumber - 1; i++) {
                
                if (choice == 0) //Engineer
                {
                    choice += 1;
                    id = i + 1;
                    salary = r.nextInt((150000 - 12000) + 1) + 12000;
                    q = "(" + Integer.toString(id) + ", " +
                         Integer.toString(salary) + ", " + "\"engineer\"" + "), ";
                    writer.append(q);
                }
                else if (choice == 1) //Manager
                {
                    choice += 1;
                    id = i + 1;
                    salary = r.nextInt((150000 - 12000) + 1) + 12000;
                    q = "(" + Integer.toString(id) + ", " +
                         Integer.toString(salary) + ", " + "\"manager\"" + "), ";
                    writer.append(q);
                }
                else if (choice == 2) //Salesperson
                {
                    choice += 1;
                    id = i + 1;
                    salary = r.nextInt((150000 - 12000) + 1) + 12000;
                    q = "(" + Integer.toString(id) + ", " +
                         Integer.toString(salary) + ", " + "\"salesperson\"" + "), ";
                    writer.append(q);
                }
                else if (choice == 3) //Administrator
                {
                    choice = 0;
                    id = i + 1;
                    salary = r.nextInt((150000 - 12000) + 1) + 12000;
                    q = "(" + Integer.toString(id) + ", " +
                         Integer.toString(salary) + ", " + "\"administrator\"" + "), ";
                    writer.append(q);
                }
            }
            
            //This ensures that the final statement has a ; on it.
            choice += 1;
            id = userNumber;
            salary = r.nextInt((150000 - 12000) + 1) + 12000;
            q = "(" + Integer.toString(id) + ", " +
                 Integer.toString(salary) + ", " + "\"engineer\"" + ");";
            writer.append(q);
        }
        
        catch(Exception err) {
            System.out.println("Failed to create entries");
            err.printStackTrace();
        }
    }
}