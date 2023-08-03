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
            sc.nextLine();

            switch(wantTo){

                case 1 -> register(numberAccountRegister);
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
    
    public static void register(int na){
    
        Register register[] = new Register[na+1];
        register[na] = new Register(na);
        
        String name;
        int yearBorn;
        float cpf;
        
        //setting information of user
        System.out.print("Tell me what's your name: ");
        name=sc.nextLine();
        System.out.print("Year you've born: ");
        yearBorn = sc.nextInt();
        System.out.print("Type your cpf (just numbers): ");
        cpf = sc.nextFloat();
        register[na].registerPainel(name, yearBorn, cpf);
        sc.nextLine();
        //verivication of the cpf is real, because if it isn't the user cannot create a perfil
            if (register[na].isCpfAllowed()){
                System.out.println("\nYou'll be redirected to create your perfil\n[]- Ok;");
                sc.nextLine();
                
                System.out.print("Type here your height: ");
                register[na].setHeightUser(sc.nextFloat());
                System.out.print("Type here your weight: ");
                register[na].setWeightUser(sc.nextFloat());
                register[na].setPerfilUser();
                
                sc.nextLine();

                System.out.print("Now you need to create your password to the nick: "+ register[na].getNicknameUser()+"\nPassword: ");
                register[na].setPasswordUser(sc.nextLine());
                System.out.println("Your password is: "+ register[na].getPasswordUser() +"\n[]- Ok;");
                sc.nextLine();
                numberAccountRegister++;
                
                        System.out.println( register[na].toString());

            }else
                System.out.println("=="+ register[na].stopPerfilCreation() +"==");
        
    }
    
    public static void mensageLeave(){
        System.out.println("Leaving...");
    }
    
    public static void info(){
        System.out.println("Info");
    }
    
}
