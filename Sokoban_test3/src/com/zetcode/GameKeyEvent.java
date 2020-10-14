package com.zetcode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameKeyEvent implements ActionListener {
	GamePanel gamePanel;// 게임패널을 생성자로 받음

	public GameKeyEvent(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "1번") {
			gamePanel.basicStart();
		} else if (e.getActionCommand() == "2번") {
			gamePanel.hideStart();
		} else if (e.getActionCommand() == "3번") {
			gamePanel.gaugeStart();
		} else
			gamePanel.putinStart();

	}

}
