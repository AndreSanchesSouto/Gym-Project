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
    private int yearBornUser, na;
    private float cpfUser, weightUser, heightUser, imcUser;
    private boolean cpfAllowed;

    public Register(int numbAccount){
        this.nameUser = "";
        this.passwordUser = ""; 
        this.nicknameUser=""; 
        this.perfilUser = "";
        this.yearBornUser = 0;
        this.na = ++numbAccount;
        this.cpfUser = 0;
        this.weightUser = 0; 
        this.heightUser = 0;
        this.imcUser = 0;
        this.cpfAllowed = false;
    }
    
    public void registerPainel(String name, int year, float cpf){
       
        setNameUser(name);
        setYearBornUser(year);
        setCpfUser(cpf);
        
    }
    
    public String createPassword(String pass){
        
        setPasswordUser(pass);
        return getPasswordUser();
        
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
        setNicknameUser();
        return this.nicknameUser;
    }
    
    private void setNicknameUser(){
        this.nicknameUser = getNameUser() + getPerfilUser() +"_"+ na;
    }
    
    public void setPerfilUser(){
                
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

    public void setWeightUser(float weig) {
        this.weightUser = weig;
    }

    public float getHeighUser() {
        return this.heightUser;
    }
    
    public void setHeightUser(float heig) {
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
    
    private void setCpfAllowed(){
        this.cpfAllowed = isCpfExist(getCpfUser()) && !isCpfLogged(getCpfUser());
       
    }
    
    private boolean isCpfExist(float cpf){
        return true;
    }
    
    private boolean isCpfLogged(float cpf){
        return false;
    }

    @Override
    public String toString() {
        return "Register{" + "nameUser=" + nameUser + ", passwordUser=" + passwordUser + ", nicknameUser=" + nicknameUser + ", perfilUser=" + perfilUser + ", yearBornUser=" + yearBornUser + ", cpfUser=" + cpfUser + ", weightUser=" + weightUser + ", heightUser=" + heightUser + ", imcUser=" + imcUser + ", cpfAllowed=" + cpfAllowed + '}';
    }
    
    

   
    
    
    
}
