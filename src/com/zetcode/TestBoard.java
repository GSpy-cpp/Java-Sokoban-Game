package com.zetcode;

import javax.swing.*;
import java.awt.*;

public class TestBoard extends JFrame {
    private CardLayout cards;

    public TestBoard() {
        this.cards = new CardLayout();
        this.getContentPane().setLayout(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(new Board(this));
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TestBoard test = new TestBoard();
        });
    }
}