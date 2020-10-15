package com.zetcode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

//Panel단위로 화면이동을 하기위해 각화면은 Panel을 상속받아 클래스를 작성
public class IntroPanel extends JPanel {
	final static int FRAME_WIDTH = 500;
	final static int FRAME_HIGHT = 500;

	int select = 0;
	int bestscore = 100;// 최고점수
	Image intro_image;

	Sokoban sokoban;

	public IntroPanel(Sokoban sokoban) {
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HIGHT));// 프레임 창크기설정
		pack();// 컴포넌트크기만큼 창 크기
		intro_image = Toolkit.getDefaultToolkit().getImage("IntroBackground_2.jpg");

		IntroKeyEvent handler = new IntroKeyEvent(this);

		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HIGHT));// 프레임 창크기설정

		JButton btn1 = new JButton("GAME START");
		add(btn1);
		JButton btn2 = new JButton("QUIT");
		add(btn2);

		btn1.addActionListener(handler);
		btn2.addActionListener(handler);

		btn1.setBounds(160, 300, 150, 30);
		btn2.setBounds(160, 360, 150, 30);

		setLayout(null);
	}


	@Override
	public void paint(Graphics g) {
		g.drawImage(intro_image, 0, 0, 500, 500, this);// 이미지를 그려줌
		g.setFont(new Font("myFont", Font.BOLD, 60));
		g.setColor(Color.darkGray);
		g.drawString("sokoban", 115, 130);
		g.setFont(new Font("myFont", Font.BOLD, 20));
		g.setColor(Color.blue);
		g.drawString("BEST SCORE : " + bestscore, 145, 250);
		g.setFont(new Font("secondFont", Font.BOLD, 20));
		g.setColor(Color.red);
	}

	public void gameStart() {
		sokoban.changePanel(sokoban.getGamePanelName());
	}
}
