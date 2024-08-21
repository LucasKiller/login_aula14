package events;

import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;

import entities.Aluno;
import screens.Login;
import screens.Main;

public class LoginEvents implements ActionListener{

    private Login loginScreen;
    private JTextField user_field;
    private JPasswordField pass_field;
    private JButton confirm_btn;
    private Connection conn;

    public LoginEvents(Login loginScreen, JTextField user_field, JPasswordField pass_field, JButton confirm_btn, Connection conn) {
        this.loginScreen = loginScreen;
        this.user_field = user_field;
        this.pass_field = pass_field;
        this.confirm_btn = confirm_btn;
        this.conn = conn;
    }

    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource() == confirm_btn) {

            if(user_field.getText().trim().length() == 0 || pass_field.getPassword().length == 0) {
                JOptionPane.showMessageDialog(loginScreen.getContentPane(), "Preencha ambos os campos!", "Alerta!", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Aluno user = new Aluno(user_field.getText(), new String(pass_field.getPassword()));

            user.carregar(conn);

            if(user.get_id() == 0) {
                JOptionPane.showMessageDialog(loginScreen.getContentPane(), "Usuario não encontrado na base de dados!", "Não foi possível realizar o login", JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                JOptionPane.showMessageDialog(loginScreen.getContentPane(), "Usuário logado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                new Main(conn, user, loginScreen);
                loginScreen.dispose();
            }

        }

        

    }

    

}
