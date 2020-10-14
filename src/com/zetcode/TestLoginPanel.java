package com.zetcode;

import javax.swing.*;
import java.awt.*;

public class TestLoginPanel extends JFrame {
    private CardLayout cards;

    public TestLoginPanel() {
        this.cards = new CardLayout();
        this.getContentPane().setLayout(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(new LoginPanel(this));
        this.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TestLoginPanel test = new TestLoginPanel();
        });
    }
}
