package com.zetcode;

import java.awt.*;
import javax.swing.JFrame;

public class Sokoban extends JFrame {// main Ŭ����

	final static int FRAME_WIDTH = 500;
	final static int FRAME_HIGHT = 500;

	private final int    OFFSET               = 30;
	private final String LOGINPANEl_NAME      = "loginPanel";
	private final String INTROPANEL_NAME      = "introPanel";
	private final String GAMEPANEL_NAME       = "gamePanel";
	private final String BASICPANEL_NAME      = "basicPanel";
	private final String HIDEPANEL_NAME       = "hidePanel";
	private final String PUTINORDERPANEL_NAME = "putinorderPanel";
	private final String GAUGEPANEL_NAME      = "gaugePanel";

	private String userid;

	private CardLayout cards;

	public Sokoban() {
		initUI();
	}

	// public void changePanel(String name)
	// Panel에서 호출되는 메소드
	// JFrame에 표시되는 Panel을 바꿀 때 사용
	// 사용예 : frame.changePanel(frame.getLobbyPanelName());
	public void changePanel(String name) {
		getContentPane().removeAll();

		if (name.equals(INTROPANEL_NAME)) {
			getContentPane().add(new IntroPanel(this));
		}
		if (name.equals(GAMEPANEL_NAME)) {
			getContentPane().add(new GamePanel(this));
		}
		if (name.equals(BASICPANEL_NAME)) {
			getContentPane().add(new BasicPanel(this));
		}
		if (name.equals(HIDEPANEL_NAME)) {
			getContentPane().add(new HideSightPanel(this));
		}
		if (name.equals(PUTINORDERPANEL_NAME)) {
			getContentPane().add(new PutInOrderPanel(this));
		}
		if (name.equals(GAUGEPANEL_NAME)) {
			getContentPane().add(new GaugePanel(this));
		}

		repaint();
	}

	private void initUI() {
		setTitle("Sokoban");
		this.cards = new CardLayout();
		getContentPane().setLayout(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// 사용되는 panel을 모두 add 해야 함.
		getContentPane().add(this.getLoginPanelName(), new LoginPanel(this));
//		getContentPane().add(this.getIntroPanelName(), new IntroPanel(this));
//		getContentPane().add(this.getGamePanelName(), new GamePanel(this));
//		getContentPane().add(this.getBasicPanelName(), new BasicPanel(this));
//		getContentPane().add(this.getHidePanelName(), new HidePanel(this));
//		getContentPane().add(this.getPutInOrderPanelName(), new PutInOrderPanel(this));

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

	public String getHidePanelName() {
		return HIDEPANEL_NAME;
	}

	public String getPutInOrderPanelName() {
		return PUTINORDERPANEL_NAME;
	}

	public String getGaugePanelName() {
		return GAUGEPANEL_NAME;
	}

	public String getUserid() { return this.userid; }

	public void setUserid(String id) { this.userid = id; }

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {

			Sokoban game = new Sokoban();
			game.setVisible(true);
		});
	}

}
