package com.zetcode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class IntroKeyEvent implements KeyListener {
	IntroPanel introPanel;// 인트로패널을 생성자로 받음

	public IntroKeyEvent(IntroPanel introPanel) {
		this.introPanel = introPanel;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 38) {// 위
			introPanel.select = 0;
		} else if (e.getKeyCode() == 40) {// 아래
			introPanel.select = 1;
		} else if (e.getKeyCode() == 10) {// 엔터 키
			if (introPanel.select == 0)
				introPanel.gameStart();
			else if (introPanel.select == 1)
				System.exit(0);
		}
		introPanel.repaint();//key값을 통해 panel을 다시 그려준다
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
