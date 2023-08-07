/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymproj;

/**
 *
 * @author andre
 */ 

public class Loggin extends Register{
    
    int numbAccount;
    String nameUser,  passwordUser,  nicknameUser, perfilUser;
    int yearBornUser;
    float cpfUser,  weightUser,  heighUser,  imcUser;
    boolean cpfAllowed;
    
    public Loggin(  int na, String name, String password, String nickname,String perfil, 
                    int year, float cpf, float weight, float heigh, float imc, boolean cpfAll) {
        super(na);
        this.numbAccount = na;
        this.nameUser = name;  
        this.passwordUser = password;  
        this.nicknameUser = nickname; 
        this.perfilUser = perfil;
        this.yearBornUser = year;
        this.cpfUser = cpf;  
        this.weightUser = weight;  
        this.heighUser = heigh;  
        this.imcUser = imc;
        this.cpfAllowed = cpfAll;
    }
    
    public boolean confirmIdentity(String nick, String pass){
        return getNicknameUser().equals(nick) && getPasswordUser().equals(pass);
    }
    
    @Override
    public String getNameUser(){
        return this.nameUser;
    }
    
    @Override
    public void setNameUser(String name){
        this.nameUser = name;
    }
    
    @Override
    protected String getPasswordUser(){
        return this.passwordUser;
    }
    
    @Override
    protected void setPasswordUser(String password){
        this.passwordUser = password;
    }
    
    @Override
    public String getNicknameUser(){
        setNicknameUser(getNameUser());
        return this.nicknameUser;
    }
    
    @Override
    public void setNicknameUser(String name){
        this.nicknameUser = name + getPerfilUser() +"_"+ numbAccount;
    }
    
    @Override
    public void setPerfilUser(){
                
       setImcUser(getWeightUser(), getHeighUser());
        
        if(getImcUser() < 18.5){
            setPerfilUser("Magreza");
            
        }else if(getImcUser() < 24.9){
            setPerfilUser("Adequado");
        
        }else if(getImcUser() < 29.9){
            setPerfilUser("Sobrepeso");

        }else if(getImcUser() < 34.9){
            setPerfilUser("Obesidade grau I");
        
        }else if(getImcUser() < 39.9){
            setPerfilUser("Obesidade grau II");
            
        }else{
            setPerfilUser("Obesidade grau III");
        
        }
        
    }
    
    @Override
    public int getYearBornUser(){
        return this.yearBornUser;
    }
    
    @Override
    public void setYearBornUser(int year){
        this.yearBornUser = year;
    }
    
    @Override
    public float getCpfUser(){
        return this.cpfUser;
    }
    
    @Override
    protected void setCpfUser(float cpf){
        if(isCpfAllowed()){
            this.cpfUser = cpf;
            
        }else
            stopPerfilCreation();  
        
    }
    
    @Override
    public String getPerfilUser(){
        return this.perfilUser;
    }
    
    @Override
    protected void setPerfilUser(String perfil){
        this.perfilUser = perfil;
    }
    
    @Override
    public float getWeightUser() {
        return this.weightUser;
    }
    
    @Override
    public void setWeightUser(float weig) {
        this.weightUser = weig;
    }
    
    @Override
    public float getHeighUser() {
        return this.heighUser;
    }
    
    @Override
    public void setHeightUser(float heig) {
        this.heighUser = heig;
    }
    
    @Override
    public float getImcUser(){
        return this.imcUser;
    }
    
    @Override
    protected void setImcUser(float wei, float hei){
        this.imcUser = wei/(hei*hei);
        
    }
    
    @Override
    public boolean isCpfAllowed(){
        setCpfAllowed();
        return this.cpfAllowed;
    }
    
    @Override
    protected void setCpfAllowed(){
        this.cpfAllowed = isCpfExist(getCpfUser()) && !isCpfLogged(getCpfUser());
       
    }
    
    @Override
    protected boolean isCpfExist(float cpf){
        return true;
    }
    
    @Override
    protected boolean isCpfLogged(float cpf){
        return false;
    }

    @Override
    public String toString() {
        return "Register{" + "nameUser=" + nameUser + ", passwordUser=" + passwordUser + ", nicknameUser=" + nicknameUser + ", perfilUser=" + perfilUser + ", yearBornUser=" + yearBornUser + ", cpfUser=" + cpfUser + ", weightUser=" + weightUser + ", heightUser=" + heighUser + ", imcUser=" + imcUser + ", cpfAllowed=" + cpfAllowed + '}';
    }
  
}
            
