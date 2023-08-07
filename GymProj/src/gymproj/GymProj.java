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
                
                sc.nextLine();

                System.out.print("Now you need to create your password to the nick: "+ registredUsers[na].getNicknameUser()+"\nPassword: ");
                registredUsers[na].setPasswordUser(sc.nextLine());
                System.out.println("Your password is: "+ registredUsers[na].getPasswordUser() +"\n[]- Ok;");
                sc.nextLine();
                
                numberAccountRegister++;
                
                System.out.println("=="+registredUsers[na].toString()+"==");

            }else
                System.out.println("=="+ registredUsers[na].stopPerfilCreation() +"==");   
    }
    
    public static void loggin(int na){
        
        String nick, pass;
        int numbReg, tries, choise;
                    
        System.out.print("Type your Register's Number: <"+ na);
        numbReg = sc.nextInt();
        sc.nextLine();

            if(numbReg<na && numbReg>-1){
                
                //definindo os valores do loggin como os mesmos do que foi registrado
                
                Loggin loggedUser = new Loggin(numbReg, registredUsers[numbReg]);
                
                //confirmação da identidaed do usuario com a senha e nick do perfil
                tries = 4;
                do{
                    if(tries<1){
                        System.out.println("The perfil with register's number ["+ numbReg +"] is blocked.");
                        break;
                        
                    }else if(tries<4)
                        System.out.println("Nickname or password are wrong. You have "+ tries +" tries before being temporality blocked...");

                    System.out.print("Type the nickname: ");
                    nick = sc.nextLine();
                    System.out.print("Password: ");
                    pass = sc.nextLine();
                    tries--;
                    
                }while(!loggedUser.confirmIdentity(nick, pass));
                
                if(tries>0){
                    System.out.println("-- You're inside of BG-System --\nWelcome, "+ registredUsers[numbReg].getNameUser());
                    System.out.println("You want to:\n[1]- Cowork;\n[2]- Study;\n[3]- Back;");
                    choise = sc.nextInt();
                    
                    switch(choise){
                        case 1 -> coworking(); 
                        case 2 -> studying();
                        default -> {
                            System.out.println("Returning...\n[]- Ok;");
                            sc.nextLine();
                        }
                    }
                    
                }
              
            }else{
                System.out.println("This number doesn't exit as an registered one. Please, try again\n[0]- Ok;");
                sc.nextInt();
            }
    }
 
    public static void coworking(){
    
    }

    public static void studying(){
        
    }
        
    
    public static void mensageLeave(){
        System.out.println("Leaving...");
    }
    
    public static void info(){
        System.out.println("Info");
    }
    
}
