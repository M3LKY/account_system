/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SC;

import javax.swing.JOptionPane;

/**
 *
 * @author melki
 */
public class Check {
    public void check(String[] users, String user, String pass){
        boolean find = false;
        for(int i = 9; i < users.length; i++){
            if((users[i].equals(user)) && (users[i+1].equals(pass))){
                find = true;
                Menu menu = new Menu();
                menu.setVisible(true);
                //this.dispose();
            }
        }
        if(find == false){
            JOptionPane.showMessageDialog(null, "Incorrect data.");
        }
    }
}
