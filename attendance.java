package com.attendance.list;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class attendance {

    /**
     * These methods returns the name of the day manager after checking the file and add one before printing another one
     * @return The name of the day manager
     * @throws IOException These throws exception of file not found in the program
     */
    public static String getDayManager() throws IOException
    {
        String presenter = " ";
        // Recreate a file
        File dayManager = new File("Lionsmanagers.txt");

        // Check if present or not
        if (dayManager.exists())
        {
            // Scanning the Managers file
            Scanner scanFile = new Scanner(dayManager);

            if(scanFile.hasNext()) {
                presenter = "DAYMANAGER: " +  scanFile.nextLine();
                // Show the name of the day manager depending on the current date using loop
                // JOptionPane.showMessageDialog(null, "DAY MANAGER: " + presenter);
                scanFile.close();
            }

        }else
        {
            JOptionPane.showMessageDialog(null, "The file doesn't exist");
        }

        return presenter;
    }

    /**
     * These method prints the user input to the day attendance list file in te program
     * @param input User input
     * @throws IOException Trows not found file excpetion in the program
     */

    public static void writeOnFile(String input) throws  IOException
    {
        int noOfLines = 4;
        File file = new File("C:/Users/Tukei/Desktop/Dayattendance.txt");
        if (file.exists())
        {
            FileWriter newFile = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(newFile);
            bw.close();
            newFile.close();

        }
        else {
            JOptionPane.showMessageDialog(null, "The file doesn't exists");

        }
    }

    public static void main(String[] args) throws IOException
    {
        String userInput; // Use these variable to take the user input
        // Show the date of day
        LocalDate currentDay = LocalDate.now();
        // Show the time of the day
        LocalTime currentTime = LocalTime.now();
        JOptionPane.showMessageDialog(null,
                "The current day and time is " + currentDay + " " + currentTime);

        // Checking if the time is valid and number doesn't exceed total number of students
        LocalTime attendenceOpen = LocalTime.of(7, 30);
        LocalTime attendenceClose = LocalTime.of(8, 30);

        // Getting period between the allocated time

        // Creating variable to represent the number of students
        int numberOfStudents = 3;
        int count = 1;

        // Using for loop to make the input dialog run until the total number of students is attained
        for (count = 1; count < numberOfStudents; count++)
        {
            // Show the day manager of the day
            userInput = JOptionPane.showInputDialog(null,
                    getDayManager() + " \nDATE: " + currentDay + " \n Please write Your name below: ");

            // Show the instructions, "deadline of attendance in time"
            // Ask the name of the lion
            writeOnFile(userInput);
        }

        // Use while to check if the attendance is between the right time.
    }
}
