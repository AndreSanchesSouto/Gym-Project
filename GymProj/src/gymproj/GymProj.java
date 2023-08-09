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
    
    public static int numberAccountRegister = 0;
            
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
                case 2 -> loggin(numberAccountRegister);
                case 3 -> info();
                case 4 -> mensageLeave();
            }
            
        }while(wantTo!=4);
        
    }
    
    public static void register(int na){
    
        registredUsers[na] = new Register(na);
        
        String name, yearBorn;
        int occupate;
        long cpf;
        
        //Codigo para as informações do usuario
        System.out.print("Tell me what's your name: ");
        name = sc.nextLine();
        System.out.print("Your birth day (yyyy-mm-dd): ");
        yearBorn = sc.nextLine();
        System.out.print("Type your cpf (just numbers): ");
        cpf = sc.nextLong();
        registredUsers[na].registerPainel(name, yearBorn, cpf);
        sc.nextLine();
        
        //verifica se os dados do usuario são válidos (cpf) levado em conta, se aprovado ele pode cirar o perfil, se não.. não
        if (registredUsers[na].isCpfAllowed()){
            System.out.println("\nYou'll be redirected to create your perfil\n[]- Ok;");
            sc.nextLine();

            System.out.print("Type here your height: ");
            registredUsers[na].setHeightUser(sc.nextFloat());
            System.out.print("Type here your weight: ");
            registredUsers[na].setWeightUser(sc.nextFloat());
            registredUsers[na].setPerfilUser();

            System.out.println("Do you want to be an coworker or studant?\n[1]- Coworker\n[2]- Studant;");
            occupate = sc.nextInt();
            System.out.println(occupate);
            if(occupate!=1 && occupate!=2) {
                System.out.println(registredUsers[na].stopPerfilCreation());
            
            }else {
                registredUsers[na].setOccupationUser(occupate);
                sc.nextLine();

                System.out.print("Now you need to create your password to the nick: "+ registredUsers[na].getNicknameUser()+"\nPassword: ");
                registredUsers[na].setPasswordUser(sc.nextLine());
                System.out.println("Your password is: "+ registredUsers[na].getPasswordUser() +"\n[]- Ok;");
                sc.nextLine();

                numberAccountRegister++;

                System.out.println("=="+registredUsers[na].toString()+"==");
                
            }

        }else
            System.out.println("=="+ registredUsers[na].stopPerfilCreation() +"==");   
    }
    
    public static void loggin(int na){
        
        int numbReg;
        
        System.out.print("Type your Register's Number: ");
        numbReg = sc.nextInt();
        sc.nextLine();

        if(numbReg<na && numbReg>-1) {
            if(registredUsers[numbReg].getOccupationUser().equals("coworker"))
                coworking(na, numbReg);
            
            else
                studying(na, numbReg);
                

        }else{
            System.out.println("This number doesn't exist as an registered one. Please, try again\n[]- Ok;");
            sc.nextInt();
            
        }
    }
    
    public static void coworking(int na, int reg){
        
        String nick, pass;
        int tries=4;

        Loggin loggedUser = new Loggin(reg, registredUsers[reg]);

        do{
            if(tries<1) {
                System.out.println("The perfil with register's number ["+ reg +"] is blocked.");
                break;

            }else if(tries<4) {
                System.out.println("Nickname or password are wrong. You have "+ tries +" tries before being temporality blocked...");
                
            }
            
            System.out.print("Type the nickname: ");
            nick = sc.nextLine();
            System.out.print("Password: ");
            pass = sc.nextLine();
            tries--;

        }while(!loggedUser.confirmIdentity(nick, pass));

        if(tries>0){
            System.out.println("-- You're inside of BG-System --\nWelcome, "+ registredUsers[reg].getNameUser());

        }
    }

    public static void studying(int na, int reg){
        
    }
     
    public static void mensageLeave(){
        System.out.println("Leaving...");
    }
    
    public static void info(){
        System.out.println("Info");
    }
    
}
