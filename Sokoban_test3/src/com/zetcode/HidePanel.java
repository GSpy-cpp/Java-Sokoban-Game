package com.zetcode;

import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class HidePanel extends JPanel{
	Image image;
	
	public HidePanel() {
		this.add(new Label("HIDE MODE"));
		image = Toolkit.getDefaultToolkit().getImage("IntroBackground_2.jpg");
	} 
}
