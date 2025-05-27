/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe1and2;

/**
 *
 * @author RC_Student_lab
 */
class Login {
    
     public boolean checkUserName(String username){
        
        if(username.contains("_") && username.length() == 5){
        return true;
            
        }else{
            return false;
        }
    }
    public boolean checkpassword(String password) {
    
    return password.length() >=8 &&
       password.matches(".*[A-Z].*" )&&
       password.matches(".*[0-9].*") &&
       password.matches(".*[!@#$%^&*()_+:|<>?=./;'].*");
    
    }
    
    public boolean checknumber(String number) {
        
        if(number.matches("^\\+27[6-8][0-9]{8}$")){
            return true;
        
    }else{
            return false;
        }       
}

    public boolean verifyUsername(String verifyUsername, String username) {
       if(verifyUsername.equals(username)){
           return true;
       }else{
           return false;
       }
              
    }

    public boolean verifyPassword(String verifyPassword , String password){
       if(verifyPassword.equals(password)) {
           return true;
       }else{
           return false;
       }
    }

     public boolean verifyCellphoneNumber(String verifyCellphoneNumber,String cellphoneNumber) {
       if(verifyCellphoneNumber.equals(cellphoneNumber)) {
           return true;
       }else{
           return false;
         }

           }
     public boolean login(String username , String password, String loginPassword, String loginUsername) {
         if (loginUsername.equals(username) && loginPassword.matches(password)){
             System.out.println("Login Successful ,Welcome" + username +"!");
             return true;
         }else{
             System.out.println("Login unsuccessful,Please try again");
             return false;
         }
     }
    
  
}
