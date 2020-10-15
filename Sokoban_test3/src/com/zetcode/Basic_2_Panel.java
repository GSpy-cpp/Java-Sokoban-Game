package com.zetcode;

import java.awt.Component;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Basic_2_Panel extends JPanel {
	Image image;

	public Basic_2_Panel() {
		this.add(new Label("level 2 MODE"));
		image = Toolkit.getDefaultToolkit().getImage("IntroBackground_2.jpg");
	}
}