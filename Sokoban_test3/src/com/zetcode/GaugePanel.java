package com.zetcode;

import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class GaugePanel extends JPanel{
	Image image;
	
	public GaugePanel() {
		this.add(new Label("GAUGE MODE"));
		image = Toolkit.getDefaultToolkit().getImage("IntroBackground_2.jpg");
	}
}
