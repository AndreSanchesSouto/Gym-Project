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

public class Register{
    
    Scanner sc = new Scanner(System.in);
    
    private String nameUser;
    private int yearBornUser;
    private float cpfUser, weightUser, heightUser, imcUser;
    private String perfilUser;
    
    public void registerPainel(){
        
        System.out.print("--Insert here yours informations--\nName user: ");
        setNameUser(sc.nextLine());
        
        System.out.print("Year you've born: ");
        setYearBornUser(sc.nextInt());
        
        System.out.print("Your CPF (with no character, just numbers): ");
        setCpfUser(sc.nextFloat());
        
        System.out.println("\n"+ nameUser +", you will be redirected to include your personalities information to help us on your plan of exercices");
        perfilUser();
        System.out.println(getPerfilUser());
        
    }
    
    private void perfilUser(){
        
        System.out.println("");
        setWeightUser(sc.nextFloat());
        
        System.out.println("");
        setHeightUser(sc.nextFloat());
        
        setImc();
        
        if(getImc() < 18.5){
            setPerfilUser("magreza");
            
        }else if(getImc() < 24.9){
            setPerfilUser("adequado");
        
        }else if(getImc() < 29.9){
            setPerfilUser("sobrepeso");

        }else if(getImc() < 34.9){
            setPerfilUser("Obesidade grau I");
        
        }else if(getImc() < 39.9){
            setPerfilUser("Obesidade grau II");
            
        }else{
            setPerfilUser("Obesidade grau III");
        
        }
        
    }
    
    public String getNameUser(){
        return this.nameUser;
    }

    public void setNameUser(String name){
        this.nameUser = name;
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
        this.cpfUser = cpf;
    }
    
    public String getPerfilUser(){
        return this.perfilUser;
    }
    
    private void setPerfilUser(String perfil){
        this.perfilUser = perfil;
    }

    public float getWeightUser() {
        return this.weightUser;
    }

    private void setWeightUser(float weig) {
        this.weightUser = weig;
    }

    public float getHeighUser() {
        return this.heightUser;
    }

    private void setHeightUser(float heig) {
        this.heightUser = heig;
    }
    
    public float getImc(){
        return this.imcUser;
    }
    
    private void setImc(){
        this.imcUser = getWeightUser()/(getHeighUser()*getHeighUser());
        
    }
    
    
    
    
}
