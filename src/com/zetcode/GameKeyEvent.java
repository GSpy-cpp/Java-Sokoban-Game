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

		Sokoban frame = gamePanel.sokoban;

		if (e.getActionCommand() == "1번") {
			frame.changePanel(frame.getBasicPanelName());
		} else if (e.getActionCommand() == "2번") {
			frame.changePanel(frame.getHidePanelName());
		} else if (e.getActionCommand() == "3번") {
			frame.changePanel(frame.getGaugePanelName());
		}
	}
}
