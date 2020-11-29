package com.zetcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SignUp extends JDialog {

    private Sokoban    frame;
    private JLabel     IDLabel;
    private JTextField IDTextField;
    private JLabel     passwordLabel;
    private JTextField passwordTextField;
    private JButton    signUpBtn;

    private final int LEFTRIGHT_SPACE  = 10;
    private final int TOPBOTTOM_SPACE  = 20;
    private final int LABEL_WIDTH      = 60;
    private final int TEXTFIELD_HEIGHT = 30;
    private final int TEXTFIELD_WIDTH  = 150;
    private final int SIGNUPBTN_SPACE  = 0;
    private final int SIGNUPBTN_SIZE   = 2*(TEXTFIELD_HEIGHT- SIGNUPBTN_SPACE);

    public SignUp(Sokoban sokoban, String title) {
        super(sokoban, title);
        frame = sokoban;
        initSignUpUI();

        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register(IDTextField.getText(), passwordTextField.getText());
            }
        });

        this.add(IDLabel);
        this.add(IDTextField);
        this.add(passwordLabel);
        this.add(passwordTextField);
        this.add(signUpBtn);

        this.setSize(this.getFrameWidth(), this.getFrameHeight());
    }

    private void initSignUpUI() {
        this.setLayout(null);


        this.IDLabel = new JLabel("ID");
        IDLabel.setBounds(LEFTRIGHT_SPACE, TOPBOTTOM_SPACE, LABEL_WIDTH, TEXTFIELD_HEIGHT);

        this.IDTextField = new JTextField();
        IDTextField.setBounds(LEFTRIGHT_SPACE+LABEL_WIDTH, TOPBOTTOM_SPACE, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);

        this.passwordLabel = new JLabel("password");
        passwordLabel.setBounds(LEFTRIGHT_SPACE, TOPBOTTOM_SPACE+TEXTFIELD_HEIGHT, LABEL_WIDTH, TEXTFIELD_HEIGHT);

        this.passwordTextField = new JTextField();
        passwordTextField.setBounds(LEFTRIGHT_SPACE+LABEL_WIDTH, TOPBOTTOM_SPACE+TEXTFIELD_HEIGHT,
                TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);

        this.signUpBtn = new JButton("Sign Up");
        signUpBtn.setBounds(LEFTRIGHT_SPACE+LABEL_WIDTH+TEXTFIELD_WIDTH+ SIGNUPBTN_SPACE,
                TOPBOTTOM_SPACE+ SIGNUPBTN_SPACE,
                SIGNUPBTN_SIZE, SIGNUPBTN_SIZE);

        setLocationRelativeTo(null);
        this.setBackground(new Color(250, 240, 170));
    }

    private void register(String ID, String password) {
        try {
            String line = ID + "-" + password + "-" + Integer.MAX_VALUE + "\n";
            File usrFile = new File("src/resources/user");
            BufferedWriter writer = new BufferedWriter(new FileWriter(usrFile, true));
            writer.append(line);
            writer.close();
            setVisible(false);

        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    private int getFrameWidth()  { return 2*LEFTRIGHT_SPACE + LABEL_WIDTH + TEXTFIELD_WIDTH + 80; }

    private int getFrameHeight() { return 2*TOPBOTTOM_SPACE + 2*TEXTFIELD_HEIGHT + 40; }
}
