/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymproj;

/**
 *
 * @author andre
 */

import java.util.Scanner;

public class Register{
    
    Scanner sc = new Scanner(System.in);
   
    
    private String nameUser, passwordUser, nicknameUser;
    private int yearBornUser;
    private float cpfUser, weightUser, heightUser, imcUser;
    private String perfilUser;
    
    public int regist(int na){
        registerPainel();
        setNicknameUser();
        createPassword();
        return na;
        
    }
    
    private void registerPainel(){
        
        System.out.print("--Insert here yours informations--\nYour name: ");
        setNameUser(sc.nextLine());
        
        System.out.print("Year you've born: ");
        setYearBornUser(sc.nextInt());
        
        System.out.print("Your CPF (just numbers): ");
        setCpfUser(sc.nextFloat());
        
        System.out.println("\n"+ getNameUser() +", you will be redirected to include your personalities information to help us on your plan of exercices");
        perfilUser();
        
        System.out.println(getPerfilUser());
        
    }
    
    protected void perfilUser(){
        
        System.out.print("type here your weight: ");
        setWeightUser(sc.nextFloat());
        
        System.out.print("Type here your height: ");
        setHeightUser(sc.nextFloat());
        
        setImc(getWeightUser(), getHeighUser());
        
        if(getImc() < 18.5){
            setPerfilUser("Magreza");
            
        }else if(getImc() < 24.9){
            setPerfilUser("Adequado");
        
        }else if(getImc() < 29.9){
            setPerfilUser("Sobrepeso");

        }else if(getImc() < 34.9){
            setPerfilUser("Obesidade grau I");
        
        }else if(getImc() < 39.9){
            setPerfilUser("Obesidade grau II");
            
        }else{
            setPerfilUser("Obesidade grau III");
        
        }
        
    }
    
    private void createPassword(){
        System.out.println("Create your Password to the nick:"+ getNicknameUser());
        sc.nextLine();
        setPasswordUser(sc.nextLine());
        System.out.println(getPasswordUser());
        
    }
    
    private boolean cpfNotLogged(float cpf){
        return false;
    }
    
    private void stopRegister(){
        System.out.println("This cpf is already being used\n[0]- Ok;");
        sc.nextLine();
        GymProj.initialPainel();
    }
    
    public String getNameUser(){
        return this.nameUser;
    }

    public void setNameUser(String name){
        this.nameUser = name;
    }

    protected String getPasswordUser(){
        return this.passwordUser;
    }

    protected void setPasswordUser(String password){
        this.passwordUser = password;
    }
    
    public String getNicknameUser(){
        return this.nicknameUser;
    }
    
    public void setNicknameUser(){
        this.nicknameUser = getNameUser() + getPerfilUser() + getYearBornUser();
    }
    
    public int getYearBornUser(){
        return this.yearBornUser;
    }

    public void setYearBornUser(int year){
        this.yearBornUser = year;
    }

    public double getCpfUser(){
        return this.cpfUser;
    }

    public void setCpfUser(float cpf){
        if(cpfNotLogged(cpf)){
            this.cpfUser = cpf;
            
        }else{
            stopRegister();
        }
        
    }
    
    public String getPerfilUser(){
        return this.perfilUser;
    }
    
    protected void setPerfilUser(String perfil){
        this.perfilUser = perfil;
    }

    public float getWeightUser() {
        return this.weightUser;
    }

    protected void setWeightUser(float weig) {
        this.weightUser = weig;
    }

    public float getHeighUser() {
        return this.heightUser;
    }
    
    protected void setHeightUser(float heig) {
        this.heightUser = heig;
    }
    
    public float getImc(){
        return this.imcUser;
    }
    
    private void setImc(float wei, float hei){
        this.imcUser = wei/(hei*hei);
        
    }
    
}
