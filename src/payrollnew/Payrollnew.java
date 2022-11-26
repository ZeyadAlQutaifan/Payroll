/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollnew;


import globals.GlobalVariable;
import java.io.IOException;
import login_page.LoginView;
import main_page.MainView;

/**
 *
 * @author zeyad
 */
public class Payrollnew {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println(new GlobalVariable());
        
        MainView loginView = new MainView();
        loginView.setVisible(true);
        
        
      
    }
    
}
