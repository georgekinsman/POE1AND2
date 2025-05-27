/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe1and2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class Message {
    
    private static int messageCounter = 0;
      private static final List<Message> messageList = new ArrayList<>();
    
      
    //Instances variables for each message
    private final String messageId;
    private final int messageNumber;
    private final String recipient;
    private final String messageContent;
    private final String messageHash;
    private final List<String> storedMessages;
    
    public Message(String recipient,String messageContent) {
        
        
        //Constructor that initializes a new message object 
        
        this.messageId = generateMessageID();
        this.messageNumber = messageCounter++;
        this.recipient = recipient;
        this.messageContent = messageContent;
        this.messageHash = generateMessageHash();
        this.storedMessages = new ArrayList<>();
        messageList.add(this);
    }

    
    //Checks if the message ID is valid ( 10 digits or fewer)
    
    public boolean checkMessageID()  {
        return messageId.length() <= 10;
    }
    
    // checks if the cellphone is entered in international code of South Africa
    
    public int checkRecipientCell() { 
        if (recipient.length() <= 10 && recipient.startsWith("+")) {
            return 1;
        }
        return 0;
    }
    
    //Generates a hash based on message ID , number and content
    
    private String generateMessageHash()  {
        String[] words = messageContent.trim().split("\\s+");
        String first = words.length > 0 ? words[0] : "";
        String last = words.length > 1 ? words[words.length - 1] : first;
        
        return (messageId.substring(0, 2) + ":" + messageNumber + ":" + first + last).toUpperCase();
        
    }
    
    public String handleAction(String action) {
        
        switch (action.toLowerCase()) {
            case "send" -> {
                return "Message sent: " + messageContent;
              }
            case "store" -> {
                storeMessage(messageContent);
                return "Message stored.";
              }
            case "disregard" -> {
                return "Message disregarded.";
              }
            default -> {
                return "Unknown action.";
              }
        }
    }
    
    public String sentMessage(String send)  {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose action (send/store/disregard): ");
        String action = scan.nextLine().toLowerCase();
        
       
        
          return switch (action) {
              case "send" -> "Message sent: " + messageContent;
              case "store" -> "Message stored.";
              case "disregard" -> "Message disregarded.";
              default -> "Unknown action.";
          };
    }
    
    
    public String printMessages()  {
        StringBuilder sb = new StringBuilder("Sent Messages:\n");
        for (Message msg : messageList)  {
            sb.append("-").append(msg.messageContent).append("\n");
        }
        return sb.toString();
    }
    
    public int returnTotalMessagess()  {
        return messageList.size();
        
    }
    
    private String generateMessageID()  {
        Random rand = new Random();
        long id = 1000000000L + (long) (rand.nextDouble() * 9000000000L);
        return String.valueOf(id);    
    }
    public List<String> getStoredMessages() {
        return storedMessages;
    }
    public void storeMessage (String storeMessages)  {
        String json = String.format("{\"message\": \"%s\"} ", storeMessages.replace("\"", "\\\""));
        this.storedMessages.add(json);
        System.out.print("Storing message in JSON: " + json);
    }
    
    
}
