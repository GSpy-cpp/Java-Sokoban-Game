package com.zetcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private JFrame     frame;
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

    public LoginPanel(JFrame frame) {
        initLoginUI();
        this.frame = frame;
        frame.setTitle("Login");
        /*
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id       = IDTextField.getText();
                String password = passwordTextField.getText();
                if (this.isValidUser(id, password)) {
                    frame.changePanel(frame.getLobbyPanelName());
                } else {

                }
            }
        });
        */
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
    /*
    private boolean isValidUser(String id, String password) {

    }

     */
}
