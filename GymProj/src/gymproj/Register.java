/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymproj;

/**
 *
 * @author andre
 */

public class Register{
    
    private String nameUser, passwordUser, nicknameUser, perfilUser;
    private int yearBornUser;
    private float cpfUser, weightUser, heightUser, imcUser;
    private boolean cpfAllowed;

    public Register(int numbAccount){
        this.nameUser = "";
        this.passwordUser = ""; 
        this.nicknameUser = ""; 
        this.perfilUser = "";
        this.yearBornUser = 0;
        this.cpfUser = 0;
        this.weightUser = 0; 
        this.heightUser = 0;
        this.imcUser = 0;
        this.cpfAllowed = false;
    }
    
    public void registerPainel(){
        
        System.out.print("--Insert here yours informations--\nYour name: ");
        setNameUser(sc.nextLine());
        
        System.out.print("Year you've born: ");
        setYearBornUser(sc.nextInt());
        
        System.out.print("Your CPF (just numbers): ");
        setCpfUser(sc.nextFloat());
        
        System.out.println("\n"+ getNameUser() +", you will be redirected to include your personalities information to help us on your plan of exercices");
        setPerfilUser();
        
    }
    
    private void createPassword(){
        System.out.println("Create your Password to the nick:"+ getNicknameUser());
        sc.nextLine();
        setPasswordUser(sc.nextLine());
        System.out.println("Your password is: "+getPasswordUser()+"\n[0]- Ok;");
        sc.nextInt();
        
    }
    
    private void stopPerfilCreation(){
        System.out.println("This cps is already being used, or just dont exist.\n[0]- Ok;");
        sc.nextInt();
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
    
    public void setNicknameUser(int na){
        this.nicknameUser = getNameUser() + getPerfilUser() + na;
    }
    
    protected void setPerfilUser(){
        
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
    
    public int getYearBornUser(){
        return this.yearBornUser;
    }

    public void setYearBornUser(int year){
        this.yearBornUser = year;
    }
    
    public float getCpfUser(){
        return this.cpfUser;
    }
    
    protected void setCpfUser(float cpf){
        if(isCpfAllowed()){
            this.cpfUser = cpf;
            
        }else
            stopPerfilCreation();  
        
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
    
    public boolean isCpfAllowed(){
        setCpfAllowed();
        return this.cpfAllowed;
    }
    
    protected void setCpfAllowed(){
        this.cpfAllowed = isCpfExist(getCpfUser()) && !isCpfLogged(getCpfUser());
       
    }
    
    public boolean isCpfExist(float cpf){
        return true;
    }
    
    private boolean isCpfLogged(float cpf){
        return false;
    }
    
    @Override
    public String toString() {
        return """
               --Registred--
               User name:""" + nameUser + "\n"
                + "Perfil User:" + perfilUser;
    }

   
    
    
    
}