package com.zetcode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	final static int FRAME_WIDTH = 500;
	final static int FRAME_HIGHT = 500;
	Image image;
	
	Sokoban sokoban;

	public GamePanel(Sokoban sokoban) {
		this.sokoban = sokoban;
		image = Toolkit.getDefaultToolkit().getImage("src/resources/IntroBackground_2.jpg");

		GameKeyEvent handler = new GameKeyEvent(this);// 이벤트 리스너 객체
		
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HIGHT));// 프레임 창크기설정

		sokoban.changePanel(sokoban.getGamePanelName());

		JButton btn1 = new JButton("1번");
		add(btn1);
		JButton btn2 = new JButton("2번");
		add(btn2);
		JButton btn3 = new JButton("3번");
		add(btn3);
		JButton btn4 = new JButton("4번");
		add(btn4);

		btn1.addActionListener(handler);// 이벤트를 받아들인 컴포넌트 버튼 객체에 리스너 등록
		btn2.addActionListener(handler);//
		btn3.addActionListener(handler);
		btn4.addActionListener(handler);

		btn1.setBounds(125, 125, 30, 30);
		btn2.setBounds(125, 185, 30, 30);
		btn3.setBounds(125, 245, 30, 30);
		btn4.setBounds(125, 305, 30, 30);

		setLayout(null);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, 500, 500, this);
		g.setFont(new Font("myFont", Font.BOLD, 20));
		g.setColor(Color.blue);
		g.drawString("<< CHOICE A GAME MODE >>", 95, 70);
		g.setColor(Color.black);
		g.drawString("BASIC MODE", 170, 145);
		g.drawString("HIDE SIGHT MODE", 170, 205);
		g.drawString("GAUGE MODE", 170, 265);
		g.drawString("PUT IN ORDER MODE", 170, 325);

	}

	public void basicStart() {
		sokoban.changePanel(sokoban.getBasicPanelName());
	}

	public void hideStart() {
		sokoban.changePanel(sokoban.getHidePanelName());
	}
//
//	public void gaugeStart() {
//		controller.showGaugePanel();
//	}
//
//	public void putinStart() {
//		controller.showPutInPanel();
//	}
}