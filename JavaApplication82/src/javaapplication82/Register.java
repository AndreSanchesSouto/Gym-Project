/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication82;

/**
 *
 * @author andre
 */

import java.util.Scanner;

public class Register {
    
    Scanner sc = new Scanner(System.in);
    public String nameUser;
    public int yearBornUser;
    protected double cpfUser;
    
    public void registerPainel(){
        
        System.out.print("--Insert here yours informations--\nName user: ");
        nameUser = sc.nextLine();
        
        System.out.print("Year you've born: ");
        yearBornUser =  sc.nextInt();
        
        System.out.print("Your CPF (with no character, just numbers): ");
        cpfUser =  sc.nextDouble();
        
        System.out.println("\n"+ nameUser +", you will be redirected to include your personalities information to help us on your plan of exercices");
        
    }
}
