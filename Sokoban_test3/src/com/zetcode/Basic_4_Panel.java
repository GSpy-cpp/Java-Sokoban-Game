package com.zetcode;

import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Basic_4_Panel extends JPanel {
	Image image;

	public Basic_4_Panel() {
		this.add(new Label("level 4 MODE"));
		image = Toolkit.getDefaultToolkit().getImage("IntroBackground_2.jpg");
	}
}
