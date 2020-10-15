package com.zetcode;

import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class PutInOrderPanel extends JPanel {
	Image image;

	public PutInOrderPanel(Sokoban sokoban) {
		this.add(new Label("PUT IN ORDER"));
		image = Toolkit.getDefaultToolkit().getImage("IntroBackground_2.jpg");
	}
}
