/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe1and2;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author RC_Student_lab
 */
public class POE1AND2 {

    
    private static String username;
    private static String password;
    private static int totalMessageSent = 0;
    private static final List<String> storedMessages = new ArrayList<>();

    public static void main(String[] args) {
        
        //Importing a login object
        
        Login objlogin = new Login();

        //  Prompt the user to enter their Username
        
        username = JOptionPane.showInputDialog("Enter a username:");
        if (objlogin.checkUserName(username)) {
            JOptionPane.showMessageDialog(null, "Username successfully captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Username incorrectly formatted.");
        }

        // Prompt the user to enter their Password
        
        password = JOptionPane.showInputDialog("Enter a password:");
        if (objlogin.checkpassword(password)) {
            JOptionPane.showMessageDialog(null, "Password successfully captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Password incorrectly formatted.");
        }

        // Prompt the user to enter their Cellphone number
        
        String cellPhoneNumber = JOptionPane.showInputDialog("Enter your cellphone number:");
        if (objlogin.checknumber(cellPhoneNumber)) {
            JOptionPane.showMessageDialog(null, "Cellphone number successfully added.");
        } else {
            JOptionPane.showMessageDialog(null, "Cellphone number incorrectly formatted.");
        }

        // Confirmation of the user Username
        
        String confirmUsername = JOptionPane.showInputDialog("Confirm your username:");
        if (objlogin.verifyUsername(confirmUsername, username)) {
            JOptionPane.showMessageDialog(null, "Correct username.");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect username.");
        }
          
        
        // Confirmation of the user Password
        
        String verifyPassword = JOptionPane.showInputDialog("Confirm your password:");
        if (objlogin.verifyPassword(verifyPassword, password)) {
            JOptionPane.showMessageDialog(null, "Correct password.");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect password.");
        }

        
        //Corfirmation of the user Cellphone
        
        String confirmCell = JOptionPane.showInputDialog("Confirm your cellphone number:");
        if (objlogin.verifyCellphoneNumber(confirmCell, cellPhoneNumber)) {
            JOptionPane.showMessageDialog(null, "Correct cellphone number.");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect cellphone number.");
        }

        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");

        // Simulated login
        
        JOptionPane.showMessageDialog(null, "Login successful . Welcome to Quickchat"+ " " + firstName + " " + lastName + "!");
        runApplication();
    }
    
    
     // POE PART 2
    private static void runApplication() {
        int maxMessages = 0;
        
         //Read number of messages to send from user input
         
        try {
            maxMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages would you like to send?"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number entered. Exiting.");
            return;
        }

        
        //Tracks how many messages have been sent so far in this session
        
        
        int messageCount = 0;
        
         //Main menu Loop
         
        while (true) {
            String choice = JOptionPane.showInputDialog("""
                    Choose an option:
                    1. Send Message
                    2. View Messages Sent
                    3. Quit""");

            
             //Handle menu options
             
             
            switch (choice) {
                
                //if the user hasnt reached their limit
                
                case "1" -> {
                    if (messageCount < maxMessages) {
                        
                         //call send message method
                         
                        sendMessage(messageCount);
                        messageCount++;
                        totalMessageSent++;
                    } else {
                        JOptionPane.showMessageDialog(null, "Message limit reached.");
                    }
                }
                case "2" -> JOptionPane.showMessageDialog(null, "Total messages sent: " + totalMessageSent);
                case "3" -> {
                    
                     //Exit program and show total messages sent
                     
                    JOptionPane.showMessageDialog(null, "Exiting Quickchat " + totalMessageSent + " messages.");
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option. Try again.");
            }
        }
    }

    private static void sendMessage(int messageNumber) {
        String messageId = generateMessageID();
            
        //Prompt the user for recipient number
        
        
        String recipient = JOptionPane.showInputDialog("Enter recipient number (e.g. +27831234567):");
        if (!recipient.matches("^\\+27\\d{9}$")) {
            JOptionPane.showMessageDialog(null, "Invalid recipient number.");
            return;
        }
        
        //prompt the user for message content 

        String message = JOptionPane.showInputDialog("Enter message (max 250 characters):");
        if (message.length() > 250) {
            
            //Validate message length
            
            JOptionPane.showMessageDialog(null, "Message too long. Must be under 250 characters.");
            return;
        }
        
        //Creating a new message object 

        String messageHash = generateMessageHash(messageId, messageNumber, message);

         //prompt the user to choose an action for message
        
        String action = JOptionPane.showInputDialog("""
                Choose What do you want to do with the message?
                1. Send message
                2. Disregard message
                3. Store message to send later""");

        switch (action) {
            case "1" -> JOptionPane.showMessageDialog(null, """
                    Message Sent!
                    ID: %s
                    Hash: %s
                    Recipient: %s
                    Message: %s
                    """.formatted(messageId, messageHash, recipient, message));
            case "2" -> JOptionPane.showMessageDialog(null, "Message disregarded.");
            case "3" -> storeMessage(message);
            default -> JOptionPane.showMessageDialog(null, "Invalid action.");
        }
    }

    private static String generateMessageID() {
        Random rand = new Random();
        long id = 1000000000L + (long) (rand.nextDouble() * 9000000000L);
        return String.valueOf(id);
    }

    private static String generateMessageHash(String id, int messageNum, String message) {
        String[] words = message.trim().split("\\s+");
        String first = words.length > 0 ? words[0] : "";
        String last = words.length > 1 ? words[words.length - 1] : first;
        return (id.substring(0, 2) + ":" + messageNum + ":" + first + last).toUpperCase();
    }

    private static void storeMessage(String message) {
        String json = "{\"message\": \"" + message.replace("\"", "\\\"") + "\"}";
        storedMessages.add(json);
        JOptionPane.showMessageDialog(null, "Message stored (simulated): " + json);
    }

}
