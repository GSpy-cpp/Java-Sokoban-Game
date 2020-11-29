package com.zetcode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;

//Panel단위로 화면이동을 하기위해 각화면은 Panel을 상속받아 클래스를 작성
public class IntroPanel extends JPanel {
	final static int FRAME_WIDTH = 500;
	final static int FRAME_HIGHT = 500;

	Image intro_image;

	Sokoban sokoban;

	public IntroPanel(Sokoban sokoban) {
		this.sokoban = sokoban;
		sokoban.setSize(FRAME_WIDTH, FRAME_HIGHT); // 적당한 크기로 설정
		sokoban.setLocationRelativeTo(null);
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HIGHT));// 프레임 창크기설정

		intro_image = Toolkit.getDefaultToolkit().getImage("src/resources/IntroBackground_2.jpg");

		IntroKeyEvent handler = new IntroKeyEvent(this);

		JButton[] btn = new JButton[2];
		String[] btntext = { "GAME START", "QUIT" };
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(btntext[i]);
			btn[i].setVisible(true);
			btn[i].addActionListener(handler);// 이벤트를 받아들인 컴포넌트 버튼 객체에 리스너 등록
			add(btn[i]);
		}
		btn[0].setBounds(160, 300, 150, 30);
		btn[1].setBounds(160, 360, 150, 30);

		setLayout(null);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(intro_image, 0, 0, 500, 500, this);// 이미지를 그려줌
		g.setFont(new Font("myFont", Font.BOLD, 60));
		g.setColor(Color.darkGray);
		g.drawString("sokoban", 115, 130);
		g.setFont(new Font("SansSerif", Font.BOLD, 20));
		g.setColor(Color.blue);
		g.drawString("BEST SCORE : " + getBestScore(), 145, 250);
	}

	public void gameStart() {
		sokoban.changePanel(sokoban.getGamePanelName());
	}

	public int getBestScore() {
		File userfile = new File("src/resources/user"); // user 파일에서 데이터를 가져옴.
		int minScore = Integer.MAX_VALUE;
		try {
			Scanner scan = new Scanner(userfile);

			while (scan.hasNextLine()) {
				String[] userInfo = scan.nextLine().split("-");// 파일을 한줄 읽어옴.
				int scoreBuffer = Integer.valueOf(userInfo[2]); // 점수 부분을 분리해서
				if (scoreBuffer < minScore) {
					minScore = scoreBuffer; // 최솟값을 구함.
				}
			}

		} catch (FileNotFoundException e) { // 예외처리
			System.out.println("FileNotFoundException");
		}
		return minScore; // 최솟값 리턴
	}
}
