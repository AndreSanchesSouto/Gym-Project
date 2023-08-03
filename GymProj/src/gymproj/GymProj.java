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
    static Register registredUsers[] = new Register[100];
    
    public static int numberAccountRegister=0;
            
    public static void main(String[] args) {
  
        int wantTo;
         
        do{
            
            System.out.print("""
                               --Wellcome to the BlubGym--\n
                               What do you want to?
                               [1]- Register;
                               [2]- Loggin;
                               [3]- Info;
                               [4]- Leave.
                               """);

            wantTo = sc.nextInt();

            switch(wantTo){

                case 1 -> {
                    Register register[] = new Register[numberAccountRegister+1];
                    register[numberAccountRegister] = new Register(numberAccountRegister);
                    register[numberAccountRegister].registerPainel();
                    if(register[numberAccountRegister].isCpfAllowed()){
                        
                        registredUsers[numberAccountRegister] = register[numberAccountRegister];
                        System.out.println("=========");
                        System.out.println(registredUsers[0].getNameUser());
                        System.out.println("=========");
                        numberAccountRegister++;
                        
                    }
                }
                
                case 2 -> {
                    int numbReg;
                    
                    System.out.print("Whitch is your Register's Number: "+numberAccountRegister);
                    numbReg=sc.nextInt()-1;
                    System.out.println(numberAccountRegister+" "+numbReg);
                        if(numberAccountRegister>0 && numbReg<=numberAccountRegister){
                            Loggin loggin[] = new Loggin[numberAccountRegister];
                            loggin[numbReg] = new Loggin(numbReg);

                        }else{
                            System.out.println("This number doesn't exit as an registered one. Please, try again\n[0]- Ok;");
                            sc.nextInt();
                        }
                }
                
                case 3 -> info();
                
                case 4 -> mensageLeave();
                
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
