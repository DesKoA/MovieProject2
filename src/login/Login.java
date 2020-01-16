package login;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
 private String id = "admin";
 private String password = "1234";
 private JTextField tf;
 private JPasswordField pf;
 private JButton login;
 JLabel loginText = new JLabel();
 private boolean isLogin = false;

 public Login() {
  JPanel idPanel = new JPanel();
  JPanel passPanel = new JPanel();
  tf = new JTextField(12);
  pf = new JPasswordField(10);
  loginText.setForeground(Color.RED);
  
  JLabel idLabel = new JLabel("ID : ");
  JLabel passLabel = new JLabel("PASSWORD : ");
  login = new JButton("LOGIN");
  login.addActionListener(this);
  
  idPanel.add(idLabel);
  idPanel.add(tf);

  passPanel.add(passLabel);
  passPanel.add(pf);

  this.add(idPanel);
  this.add(passPanel);
  this.add(login);
  this.add(loginText);
  
  setLayout(new FlowLayout());

  setTitle("LOGIN");
  setSize(300, 200);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  setVisible(true);
 }

 @Override
 public void actionPerformed(ActionEvent e) {
  // TODO Auto-generated method stub
  if (e.getSource() == login) {
   try {
    if (id.equals(tf.getText()) && password.equals(pf))
     isLogin = true;
    else
     isLogin = false;
    if (isLogin) {
     loginText.setText("로그인되었습니다. ");
    } else {
     loginText.setText("ID 또는 password가 잘못되었습니다.");
    }
   } catch (Exception e1) {
    System.out.println("false");
   }
  }
 }

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  Login my = new Login();
 }
} 



