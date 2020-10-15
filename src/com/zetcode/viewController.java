package com.zetcode;//package com.zetcode;
//
//import java.awt.Container;
//
//public class viewController {// frame view 변경, 추가하는 일
//	MainFrame mainFrame;// 메인프레임 생성자로 받을 예상
//	Container contentPane;// contentPane
//
//	IntroPanel introPanel;// 시작패널
//	GamePanel gamePanel;// 게임패널
//	BasicPanel basicPanel;// basic mode 선택시 패널
//
//	public viewController(MainFrame mainFrame) {
//		this.mainFrame = mainFrame;// 생성자로 메인프레임을 받는다
//
//		introPanel = new IntroPanel(this);// 시작패널생성
//		contentPane = mainFrame.getContentPane();// 메인프레임으로부터 컨텐트페인을 가져온다
//		contentPane.add(introPanel);// 컨텐트패인에 시작패널추가
//		introPanel.requestFocus();// 키이벤트를 받기위해 패널을 포커싱(패널에 이벤트가 달려있기때문)
//
//	}
//
////	public void GamePanelMake() {
////		gamePanel = new GamePanel(this);
////		contentPane = mainFrame.getContentPane();
////		contentPane.add(gamePanel);
////		gamePanel.requestFocus();
////	}
//
//	public void showGamePanel() {
//		contentPane.remove(introPanel);// introPanel제거
//		contentPane.add(new GamePanel(this));// 새로운 Panel추가
//
//		gamePanel = new GamePanel(this);
//		contentPane = mainFrame.getContentPane();
//		contentPane.add(gamePanel);
//		gamePanel.requestFocus();
//
//		mainFrame.setVisible(false);// 메인프레임 안보이게 한 후
//		mainFrame.setVisible(true);// 다시 보이게 한다
//	}
//
//	public void showBasicPanel() {// 기본소코반
//		contentPane.remove(gamePanel);// gamePanel제거
//		contentPane.add(new BasicPanel(this));
//
//		basicPanel = new BasicPanel(this);
//		contentPane = mainFrame.getContentPane();
//		contentPane.add(basicPanel);
//		basicPanel.requestFocus();
//
//		mainFrame.setVisible(false);
//		mainFrame.setVisible(true);
//	}
//
//	public void showHidePanel() {
//		contentPane.remove(gamePanel);// gamePanel제거
//		contentPane.add(new HidePanel());
//		mainFrame.setVisible(false);
//		mainFrame.setVisible(true);
//	}
//
//	public void showGaugePanel() {
//		contentPane.remove(gamePanel);// gamePanel제거
//		contentPane.add(new GaugePanel());
//		mainFrame.setVisible(false);
//		mainFrame.setVisible(true);
//	}
//
//	public void showPutInPanel() {
//		contentPane.remove(gamePanel);// gamePanel제거
//		contentPane.add(new PutInOrderPanel());
//		mainFrame.setVisible(false);
//		mainFrame.setVisible(true);
//	}
//
//	public void basic_leven1() {
//		contentPane.remove(basicPanel);// gamePanel제거
//		contentPane.add(new Basic_1_Panel());// leven 1
//		mainFrame.setVisible(false);
//		mainFrame.setVisible(true);
//
//	}
//
//	public void basic_leven2() {
//		contentPane.remove(basicPanel);// gamePanel제거
//		contentPane.add(new Basic_2_Panel());// leven 2
//		mainFrame.setVisible(false);
//		mainFrame.setVisible(true);
//	}
//
//	public void basic_leven3() {
//		contentPane.remove(basicPanel);// gamePanel제거
//		contentPane.add(new Basic_3_Panel());// leven 3
//		mainFrame.setVisible(false);
//		mainFrame.setVisible(true);
//	}
//
//	public void basic_leven4() {
//		contentPane.remove(basicPanel);// gamePanel제거
//		contentPane.add(new Basic_4_Panel());// leven 4
//		mainFrame.setVisible(false);
//		mainFrame.setVisible(true);
//	}
//
//	public void basic_leven5() {
//		contentPane.remove(basicPanel);// gamePanel제거
//		contentPane.add(new Basic_5_Panel());// leven 5
//		mainFrame.setVisible(false);
//		mainFrame.setVisible(true);
//	}
//}
