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
    private final int na;
    private float cpfUser, weightUser, heighUser, imcUser;
    private boolean cpfAllowed;

    public Register(int numbAccount){
        this.nameUser = "";
        this.passwordUser = ""; 
        this.nicknameUser=""; 
        this.perfilUser = "";
        this.yearBornUser = 0;
        this.na = numbAccount;
        this.cpfUser = 0;
        this.weightUser = 0; 
        this.heighUser = 0;
        this.imcUser = 0;
        this.cpfAllowed = false;
    }
    
    public void registerPainel(String name, int year, float cpf){
       
        this.setNameUser(name);
        this.setYearBornUser(year);
        this.setCpfUser(cpf);
        
    }
    
    public String createPassword(String pass){
        
        this.setPasswordUser(pass);
        return this.getPasswordUser();
        
    }
    
    public String stopPerfilCreation(){
        return "This cps is already being used, or just dont exist.";
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
        this.setNicknameUser(this.getNameUser());
        return this.nicknameUser;
    }
    
    protected void setNicknameUser(String name){
        this.nicknameUser = name + this.getPerfilUser() +"_"+ na;
    }
    
    public void setPerfilUser(){
                
        this.setImcUser(this.getWeightUser(), this.getHeighUser());
        
        if(this.getImcUser() < 18.5){
            this.setPerfilUser("Magreza");
            
        }else if(this.getImcUser() < 24.9){
            this.setPerfilUser("Adequado");
        
        }else if(this.getImcUser() < 29.9){
            setPerfilUser("Sobrepeso");

        }else if(this.getImcUser() < 34.9){
            this.setPerfilUser("Obesidade grau I");
        
        }else if(this.getImcUser() < 39.9){
            this.setPerfilUser("Obesidade grau II");
            
        }else{
            this.setPerfilUser("Obesidade grau III");
        
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
        if(this.isCpfAllowed()){
            this.cpfUser = cpf;
            
        }else
            this.stopPerfilCreation();  
        
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

    public void setWeightUser(float weig) {
        this.weightUser = weig;
    }

    public float getHeighUser() {
        return this.heighUser;
    }
    
    public void setHeightUser(float heig) {
        this.heighUser = heig;
    }
    
    public float getImcUser(){
        return this.imcUser;
    }
    
    protected void setImcUser(float wei, float hei){
        this.imcUser = wei/(hei*hei);
        
    }
    
    public boolean isCpfAllowed(){
        this.setCpfAllowed();
        return this.cpfAllowed;
    }
    
    protected void setCpfAllowed(){
        this.cpfAllowed = this.isCpfExist(this.getCpfUser()) && !this.isCpfLogged(this.getCpfUser());
       
    }
    
    protected boolean isCpfExist(float cpf){
        return true;
    }
    
    protected boolean isCpfLogged(float cpf){
        return false;
    }

    @Override
    public String toString() {
        return "Register{" + "nameUser=" + nameUser + ", passwordUser=" + passwordUser + ", nicknameUser=" + nicknameUser + ", perfilUser=" + perfilUser + ", yearBornUser=" + yearBornUser + ", cpfUser=" + cpfUser + ", weightUser=" + weightUser + ", heightUser=" + heighUser + ", imcUser=" + imcUser + ", cpfAllowed=" + cpfAllowed + '}';
    }
    
    

   
    
    
    
}
