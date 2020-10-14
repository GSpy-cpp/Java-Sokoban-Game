package com.zetcode;
import java.awt.Container;

public class viewController {//frame view 변경, 추가하는 일
	MainFrame mainFrame;//메인프레임 생성자로 받을 예상
	Container contentPane; //contentPane
	IntroPanel introPanel;//시작패널
	GamePanel gamePanel;//게임패널

	public viewController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;//생성자로 메인프레임을 받는다
		init();
	}

	private void init() {
		introPanel = new IntroPanel(this);//시작패널생성
		contentPane = mainFrame.getContentPane();//메인프레임으로부터 컨텐트페인을 가져온다
		contentPane.add(introPanel);//컨텐트패인에 시작패널추가
		introPanel.requestFocus();//키이벤트를 받기위해 패널을 포커싱(패널에 이벤트가 달려있기때문)
	}
	
	public void showGamePanel() {
		gamePanel.requestFocus();//키이벤트를 받기위해 패널을 포커싱(패널에 이벤트가 달려있기때문)
		contentPane.remove(introPanel);//introPanel제거
		contentPane.add(new GamePanel());//새로운 Panel추가
		mainFrame.setVisible(false);//메인프레임 안보이게 한 후
		mainFrame.setVisible(true);//다시 보이게 한다
	}
	
	public void showBasicPanel() {//기본소코반
//		introPanel.requestFocus();//키이벤트를 받기위해 패널을 포커싱(패널에 이벤트가 달려있기때문)
		contentPane.remove(gamePanel);
		contentPane.add(new BasicPanel());
		mainFrame.setVisible(false);
		mainFrame.setVisible(true);
	}
}
