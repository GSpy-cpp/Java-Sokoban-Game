package com.zetcode;

import javax.swing.*;
import java.awt.*;

public class TestBoard extends Sokoban {
    private CardLayout cards;

    public TestBoard() {
        this.cards = new CardLayout();
        this.getContentPane().setLayout(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add("1", new Board(this));
        this.getContentPane().add("2", new GaugePanel((this)));
        cards.show(this.getContentPane(), "2");
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TestBoard test = new TestBoard();
        });
    }
}