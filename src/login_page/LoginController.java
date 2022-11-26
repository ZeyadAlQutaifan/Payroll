/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_page;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import main_page.MainView;

/**
 *
 * @author zeyad
 */
public class LoginController {

    private final LoginView view;
    FileReader reader;
    BufferedReader br ;

    public LoginController(LoginView view) throws FileNotFoundException {
        reader = new FileReader("users.txt");
        br = new BufferedReader(reader);
        this.view = view;
    }

    public void login(String username, String password) throws IOException {
        String line = br.readLine();
        String[] user = line.split(",");
        if (username.equals(user[0].trim())) {
            if (password.equals(user[1].trim())) {
                MainView mainView = new MainView();
                mainView.setVisible(true);
                view.dispose();
            } else {
                // user exist, mut password is not correct 
            }
        } else {
            // user name is not exist 
        }

    }

}
