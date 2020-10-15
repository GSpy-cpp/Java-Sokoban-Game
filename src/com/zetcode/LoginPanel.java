package com.zetcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginPanel extends JPanel {
    private Sokoban    frame;
    private JLabel     IDLabel;
    private JTextField IDTextField;
    private JLabel     passwordLabel;
    private JTextField passwordTextField;
    private JButton    loginBtn;

    private final int LEFTRIGHT_SPACE  = 10;
    private final int TOPBOTTOM_SPACE  = 20;
    private final int LABEL_WIDTH      = 60;
    private final int TEXTFIELD_HEIGHT = 30;
    private final int TEXTFIELD_WIDTH  = 150;
    private final int LOGINBTN_SPACE   = 0;
    private final int LOGINBTN_SIZE    = 2*(TEXTFIELD_HEIGHT-LOGINBTN_SPACE);

    private int getFrameWidth()  { return 2*LEFTRIGHT_SPACE + LABEL_WIDTH + TEXTFIELD_WIDTH + 2*LOGINBTN_SPACE + LOGINBTN_SIZE + 20; }
    private int getFrameHeight() { return 2*TOPBOTTOM_SPACE + 2*TEXTFIELD_HEIGHT + 40; }

    public LoginPanel(Sokoban frame) {
        initLoginUI();
        this.frame = frame;
        frame.setTitle("Login");

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id       = IDTextField.getText();
                String password = passwordTextField.getText();
                if (isValidUser(id, password)) {                 // 로그인에 성공한 경우 실행되는 코드
                    frame.changePanel(frame.getIntroPanelName());// ******** 수정 필요함 ********
                                                                 // 로그인에 성공한 경우 실행되는 코드
                } else {
                    System.out.println("login failed");
                }
            }
        });

        this.add(IDLabel);
        this.add(IDTextField);
        this.add(passwordLabel);
        this.add(passwordTextField);
        this.add(loginBtn);

        frame.setSize(this.getFrameWidth(), this.getFrameHeight());
        frame.setVisible(true);
    }

    private void initLoginUI() {
        this.setLayout(null);
        this.setBackground(new Color(250, 240, 170));

        this.IDLabel = new JLabel("ID");
        IDLabel.setBounds(LEFTRIGHT_SPACE, TOPBOTTOM_SPACE, LABEL_WIDTH, TEXTFIELD_HEIGHT);

        this.IDTextField = new JTextField();
        IDTextField.setBounds(LEFTRIGHT_SPACE+LABEL_WIDTH, TOPBOTTOM_SPACE, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);

        this.passwordLabel = new JLabel("password");
        passwordLabel.setBounds(LEFTRIGHT_SPACE, TOPBOTTOM_SPACE+TEXTFIELD_HEIGHT, LABEL_WIDTH, TEXTFIELD_HEIGHT);

        this.passwordTextField = new JTextField();
        passwordTextField.setBounds(LEFTRIGHT_SPACE+LABEL_WIDTH, TOPBOTTOM_SPACE+TEXTFIELD_HEIGHT,
                                    TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);

        this.loginBtn = new JButton("Login");
        loginBtn.setBounds(LEFTRIGHT_SPACE+LABEL_WIDTH+TEXTFIELD_WIDTH+LOGINBTN_SPACE,
                            TOPBOTTOM_SPACE+LOGINBTN_SPACE,
                            LOGINBTN_SIZE, LOGINBTN_SIZE);
    }

    private boolean isValidUser(String id, String password) {
        try {
            File usrFile = new File("src/resources/user");
            Scanner scan = new Scanner(usrFile);
            String[] usrInfo;
            while (scan.hasNextLine()) {
                usrInfo = scan.nextLine().split("-");

                if (usrInfo[0].equals(id) && usrInfo[1].equals(password)) {
                    scan.close();
                    return true;
                }

            }

            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        }

            return false;

    }

}
