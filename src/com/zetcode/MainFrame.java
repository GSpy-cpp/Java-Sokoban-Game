package com.zetcode;//package com.zetcode;
//
//import java.awt.Dimension;
//import java.awt.Point;
//
//import javax.swing.JFrame;
//
//public class MainFrame extends JFrame {
//	final static int FRAME_WIDTH = 500;
//	final static int FRAME_HIGHT = 500;
//
//	Sokoban sokoban;
//
//	public MainFrame() {
//		setLocation(new Point(500, 200));
//		setTitle("Sokoban");
//		setVisible(true);
//		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HIGHT));// 프레임 창크기설정
//		setResizable(false);// 사이즈조절x
//		pack();// 컴포넌트크기만큼 창 크기
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
//
//	public static void main(String[] args) {
//		MainFrame mainFrame = new MainFrame();
//
//	}
//
//}