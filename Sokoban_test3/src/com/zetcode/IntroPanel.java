package com.zetcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

//
//Panel단위로 화면이동을 하기위해 각화면은 Panel을 상속받아 클래스를 작성
public class IntroPanel extends JPanel {
	int select = 0;
	int bestscore = 100;// 최고점수
	Image intro_image;
	viewController controller;

	public IntroPanel(viewController controller) {
		intro_image = Toolkit.getDefaultToolkit().getImage("IntroBackground_2.jpg");

		this.controller = controller;
		this.addKeyListener(new IntroKeyEvent(this));
	}


	@Override
	public void paint(Graphics g) {
		g.drawImage(intro_image, 0, 0, 500, 500, this);// 이미지를 그려줌
//		g.setColor(new Color(250, 240, 170));
//		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setFont(new Font("myFont", Font.BOLD, 60));
		g.setColor(Color.darkGray);
		g.drawString("sokoban", 115, 130);
		g.setFont(new Font("myFont", Font.BOLD, 15));
		g.setColor(Color.blue);
		g.drawString("BEST SCORE : " + bestscore, 165, 250);
		g.setFont(new Font("secondFont", Font.BOLD, 20));
		g.setColor(Color.red);
		g.drawString("GAME START", 175, 300);
		g.drawString("QUIT", 215, 350);

		// 화살표 위치
		if (select == 0) {
			g.drawString("→", 140, 300);
		} else if (select == 1)
			g.drawString("→", 140, 350);
	}

	public void gameStart() {
		controller.showGamePanel();
	}
}
