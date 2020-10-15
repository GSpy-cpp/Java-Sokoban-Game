package com.zetcode;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Basic_1_Panel extends JPanel {
	public Board board;
	public Basic_1_Panel() {
//		this.add(new Label("level 1 MODE"));
//		contentPane.add(new Board());
		board.initBoard();
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(250, 240, 170));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

}
