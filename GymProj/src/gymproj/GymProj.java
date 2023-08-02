/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gymproj;

/**
 *
 * @author andre
 */

import java.util.Scanner;

public class GymProj {

    /**
     * @param args the command line arguments
     */
    
    static Scanner sc = new Scanner(System.in);
    
    public static int numberAccount=0;
            
    public static void main(String[] args) {
        // TODO code application logic here
        initialPainel();
        
    }
    
    public static void initialPainel(){
        
        int wantTo;
        
        do{
            System.out.print("""
                               --Wellcome to the BlubGym--\n\n
                               What do you want to?
                               [1]- Loggin;
                               [2]- Register;
                               [3]- Info;
                               [4]- Leave.
                               """);

            wantTo = sc.nextInt();

            switch(wantTo){

                case 1 -> {
                   Loggin loggin = new Loggin();
                   loggin.logg();
                }
                case 2 -> {
                    numberAccount++;
                    Register register[] = new Register[numberAccount];
                    numberAccount=register[numberAccount].regist(numberAccount);
                    
                }
                case 3 -> {
                   info();
                }
                case 4 -> {
                    mensageLeave();
                }
            }
        }while(wantTo!=4);
        
    }
    
    public static void mensageLeave(){
        System.out.println("Leaving...");
    }
    
    public static void info(){
        System.out.println("Info");
    }
    
}
