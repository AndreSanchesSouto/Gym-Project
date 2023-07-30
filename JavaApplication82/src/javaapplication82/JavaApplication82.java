/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication82;

/**
 *
 * @author andre
 */

import java.util.Scanner;

public class JavaApplication82 {

    /**
     * @param args the command line arguments
     */
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        initialPainel();
        
    }
    
    public static void initialPainel(){
        
        int wantTo;
        
        System.out.println("""
                           --Wellcome to the BlubGym--\n\n
                           What do you want to?
                           [1]- Loggin;
                           [2]- Register;
                           [3]- Leave;
                           [4]- Info;
                           """);
        
        wantTo = sc.nextInt();
        
        switch(wantTo){
            
            case 1 -> {
               Loggin log = new Loggin();
               log.yes();
            }
            case 2 -> {
                Register reg = new Register();
                reg.registerPainel();
            }
            case 3 -> {
                mensageLeave();
            }
            case 4 -> {
                info();
            }
        }
        
    }
    
    public static void mensageLeave(){
        System.out.println("Leaving...");
    }
    
    public static void info(){
        System.out.println("Info");
    }
    
}
