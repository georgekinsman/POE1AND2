/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe1and2;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class MessageTest {
    
    

    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        Message instance = null;
        boolean expResult = false;
        boolean result = instance.checkMessageID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkRecipientCell method, of class Message.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        Message instance = null;
        int expResult = 0;
        int result = instance.checkRecipientCell();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of handleAction method, of class Message.
     */
    @Test
    public void testHandleAction() {
        System.out.println("handleAction");
        String action = "";
        Message instance = null;
        String expResult = "";
        String result = instance.handleAction(action);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of sentMessage method, of class Message.
     */
    @Test
    public void testSentMessage() {
        System.out.println("sentMessage");
        String send = "";
        Message instance = null;
        String expResult = "";
        String result = instance.sentMessage(send);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of printMessages method, of class Message.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        Message instance = null;
        String expResult = "";
        String result = instance.printMessages();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of returnTotalMessagess method, of class Message.
     */
    @Test
    public void testReturnTotalMessagess() {
        System.out.println("returnTotalMessagess");
        Message instance = null;
        int expResult = 0;
        int result = instance.returnTotalMessagess();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getStoredMessages method, of class Message.
     */
    @Test
    public void testGetStoredMessages() {
        System.out.println("getStoredMessages");
        Message instance = null;
        List<String> expResult = null;
        List<String> result = instance.getStoredMessages();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of storeMessage method, of class Message.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        String storeMessages = "";
        Message instance = null;
        instance.storeMessage(storeMessages);
       
    }
    
}
