/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymproj;

import java.util.Calendar;

/**
 *
 * @author andre
 */

public class Register{
    
    Calendar cal = Calendar.getInstance();
    
    private String nameUser, passwordUser, nicknameUser, perfilUser, occupationUser;
    private int yearBirthUser;
    private final int na;
    private float weightUser, heighUser, imcUser;
    private long cpfUser;
    private boolean cpfAllowed;

    public Register(int numbAccount){
        this.nameUser = "";
        this.passwordUser = ""; 
        this.nicknameUser = ""; 
        this.perfilUser = "";
        this.occupationUser = "";
        this.yearBirthUser = 0;
        this.na = numbAccount;
        this.cpfUser = 0;
        this.weightUser = 0f; 
        this.heighUser = 0f;
        this.imcUser = 0f;
        this.cpfAllowed = false;
    }
    
    public void registerPainel(String name, String year, long cpf){
        this.setNameUser(name);
        this.setYearBirthUser(year);
        this.setCpfUser(cpf);
    }
    
    public String createPassword(String pass){
        
        setPasswordUser(pass);
        return getPasswordUser();
        
    }
    
    public String stopPerfilCreation(){
        return "We couldn't create yout perfil, please, try again";
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
        this.setNicknameUser(getNameUser());
        return this.nicknameUser;
    }
    
    protected void setNicknameUser(String name){
        this.nicknameUser = name + getPerfilUser() +"_"+ na;
    }
    
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
    
    public int getYearBirthUser(){
        return this.yearBirthUser;
    }

    public void setYearBirthUser(String year){
        int y = Integer.parseInt(year);
        this.yearBirthUser = y;
    }
    
    public float getCpfUser(){
        return this.cpfUser;
    }
    
    protected void setCpfUser(long cpf){
        
        long alg[] = new long[11];
        int res=0, res2=0, finish, finish2;
        short verif=10, verif2=11;
        
        for(short n=10; n>=0; n--){
            alg[n]=cpf%10;
            cpf/=10;
        }
        for(short n=0; n<11; n++){
            if(n<9){
                res+=alg[n]*verif;
                verif--;
            }
            if(n<10){
                res2+=alg[n]*verif2;
                verif2--;
            }
        }
        
        finish = res*10%11;
        finish2 = res2*10%11;
        
        System.out.println(finish +" "+ finish2);
        
        if(isCpfAllowed()){
            cpfUser = cpf;
            
        }else
            stopPerfilCreation();  
        
    }
    
    public String getPerfilUser(){
        return this.perfilUser;
    }
    
    protected void setPerfilUser(String perfil){
        this.perfilUser = perfil;
    }
    
    public String getOccupationUser(){
        return this.occupationUser;
    }
    
    public void setOccupationUser(int occ){
        switch(occ){
            case 1 -> this.occupationUser = "coworker";
            case 2 -> this.occupationUser = "studant";
           
        }
        
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
        setCpfAllowed();
        return this.cpfAllowed;
    }
    
    protected void setCpfAllowed(){
        this.cpfAllowed = isCpfExist(getCpfUser()) && !isCpfLogged(getCpfUser());
       
    }
    
    protected boolean isCpfExist(float cpf){
        return true;
    }
    
    protected boolean isCpfLogged(float cpf){
        return false;
    }
    
    @Override
    public String toString() {
        return "Register{" + "nameUser=" + nameUser + ", passwordUser=" + passwordUser + ", nicknameUser=" + nicknameUser + ", perfilUser=" + perfilUser + ", yearBornUser=" + yearBirthUser + ", cpfUser=" + cpfUser + ", weightUser=" + weightUser + ", heightUser=" + heighUser + ", imcUser=" + imcUser + ", cpfAllowed=" + cpfAllowed + '}';
    }
    
    

   
    
    
    
}
