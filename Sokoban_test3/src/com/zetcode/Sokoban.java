package com.zetcode;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Sokoban extends JFrame {// main Ŭ����

	final static int FRAME_WIDTH = 500;
	final static int FRAME_HIGHT = 500;
	
	private final int OFFSET = 30;
	private final String LOGINPANEl_NAME = "loginPanel";
	private final String INTROPANEL_NAME = "introPanel";
	private final String GAMEPANEL_NAME = "gamePanel";
	private final String BASICPANEL_NAME = "basicPanel";

	private CardLayout cards;

	public Sokoban() {
		initUI();
	}

	// public void changePanel(String name)
	// Panel에서 호출되는 메소드
	// JFrame에 표시되는 Panel을 바꿀 때 사용
	// 사용예 : frame.changePanel(frame.getLobbyPanelName());
	public void changePanel(String name) {
		this.cards.show(this.getContentPane(), name);
	}

	private void initUI() {
		setTitle("Sokoban");
		this.cards = new CardLayout();
		getContentPane().setLayout(cards);
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HIGHT));// 프레임 창크기설정
//		setResizable(false);// 사이즈조절x
		pack();// 컴포넌트크기만큼 창 크기, 왜 패널에서 사이즈를 정해야하지??
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		getContentPane().add(this.getIntroPanelName(), new IntroPanel());//??
	}

	public String getLoginPanelName() {
		return LOGINPANEl_NAME;
	}

	public String getIntroPanelName() {
		return INTROPANEL_NAME;
	}

	public String getGamePanelName() {
		return GAMEPANEL_NAME;
	}
	
	public String getBasicPanelName() {
		return BASICPANEL_NAME;
	}
	
	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {

			Sokoban game = new Sokoban();
			game.setVisible(true);
		});
	}

}
