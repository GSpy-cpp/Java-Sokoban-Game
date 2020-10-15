package com.zetcode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class IntroKeyEvent implements ActionListener {
	IntroPanel introPanel;// 인트로패널을 생성자로 받음
	public IntroKeyEvent(IntroPanel introPanel) {
		this.introPanel = introPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "GAME START") {
			introPanel.gameStart();
		} else {
			System.exit(0);
		}
	}

}
