package com.zetcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	int choice = 0;
	Image image;
	viewController controller;

	public GamePanel() {
//		this.add(new Label("GAME MODE"));
		image = Toolkit.getDefaultToolkit().getImage("IntroBackground_2.jpg");
	}

	public GamePanel(viewController controller) {
//		this.add(new Label("GAME MODE"));
		this.controller = controller;
		this.addKeyListener(new GameKeyEvent(this));
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(lobby_image, 0, 0, 500, 500, this);
		g.setFont(new Font("myFont", Font.BOLD, 20));
		g.setColor(Color.blue);
		g.drawString("CHOICE A GAME MODE", 120, 70);
		g.setColor(Color.black);
		g.drawString("BASIC MODE", 150, 120);
		g.drawString("HIDE SIGHT MODE", 150, 160);
		g.drawString("GAUGE MODE", 150, 200);
		g.drawString("PUT IN ORDER MODE", 150, 240);
		
		//화살표
		if (choice == 0) {
			g.drawString("→", 120, 120);
		} else if (choice == 1) {
			g.drawString("→", 120, 160);
		} else if (choice == 2) {
			g.drawString("→", 120, 200);
		} else
			g.drawString("→", 120, 240);
	}
	
	public void basic() {
		controller.
	}
	
	public void hide() {
		
	}
	
	public void gauge() {
		
	}
	
	public void putinorder() {
		
	}
}