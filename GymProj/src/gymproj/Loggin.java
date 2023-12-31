/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymproj;

/**
 *
 * @author andre
 */ 

public class Loggin extends Register {
    
    private final int numbAccount;
    private String nameUser,  passwordUser,  nicknameUser, perfilUser;
    private int yearBornUser;
    private float cpfUser,  weightUser,  heighUser,  imcUser;
    private boolean cpfAllowed;
    
    public Loggin(int na, Register regist) {
        super(na);
        this.numbAccount = na;       
        this.nameUser = regist.getNameUser();  
        this.passwordUser = regist.getPasswordUser();  
        this.nicknameUser = regist.getNicknameUser(); 
        this.perfilUser = regist.getPerfilUser();
        this.yearBornUser = regist.getYearBirthUser();
        this.cpfUser = regist.getCpfUser();  
        this.weightUser = regist.getWeightUser();  
        this.heighUser = regist.getHeighUser();  
        this.imcUser = regist.getImcUser();
        this.cpfAllowed = regist.isCpfAllowed();
    }
    
    public boolean confirmIdentity(String nick, String pass) {
        return getNicknameUser().equals(nick) && getPasswordUser().equals(pass);
    }
    
    @Override
    public String getNicknameUser(){
        return this.nicknameUser;
    }
    
    @Override
    public String getPasswordUser(){
        return this.passwordUser;
    }
    
    @Override
    public String toString() {
        return "Register{" + "nameUser=" + nameUser + ", passwordUser=" + passwordUser + ", nicknameUser=" + nicknameUser + ", perfilUser=" + perfilUser + ", yearBornUser=" + yearBornUser + ", cpfUser=" + cpfUser + ", weightUser=" + weightUser + ", heightUser=" + heighUser + ", imcUser=" + imcUser + ", cpfAllowed=" + cpfAllowed + '}';
    }
  
}
            
