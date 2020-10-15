package com.zetcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BasicPanel extends JPanel {
	Image image;
	
	public BasicPanel(Sokoban sokoban) {
		BasicKeyEvent handler = new BasicKeyEvent(this);
		image = Toolkit.getDefaultToolkit().getImage("IntroBackground_2.jpg");
		
		JButton btn1 = new JButton("1LEVEL");
		add(btn1);
		JButton btn2 = new JButton("2LEVEL");
		add(btn2);
		JButton btn3 = new JButton("3LEVEL");
		add(btn3);
		JButton btn4 = new JButton("4LEVEL");
		add(btn4);
		JButton btn5 = new JButton("5LEVEL");
		add(btn5);
		
		btn1.addActionListener(handler);// 이벤트를 받아들인 컴포넌트 버튼 객체에 리스너 등록
		btn2.addActionListener(handler);//
		btn3.addActionListener(handler);
		btn4.addActionListener(handler);
		btn5.addActionListener(handler);
		
		btn1.setBounds(185,110,100,40);
		btn2.setBounds(185,170,100,40);
		btn3.setBounds(185,230,100,40);
		btn4.setBounds(185,290,100,40);
		btn5.setBounds(185,350,100,40);
		
		setLayout(null);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, 500, 500, this);
		g.setFont(new Font("myFont", Font.BOLD, 20));
		g.setColor(Color.blue);
		g.drawString("<< CHOICE A LEVEL >>",125, 70);
	}
	
//	public void level1_Start() {
//		controller.basic_leven1();
//	}
//	
//	public void level2_Start() {
//		controller.basic_leven2();
//	}
//	
//	public void level3_Start() {
//		controller.basic_leven3();
//	}
//	
//	public void level4_Start() {
//		controller.basic_leven4();
//	}
//	
//	public void level5_Start() {
//		controller.basic_leven5();
//	}
}
