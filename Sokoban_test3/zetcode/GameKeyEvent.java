package com.zetcode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyEvent implements KeyListener {
	GamePanel gamePanel;// 게임패널을 생성자로 받음

	public GameKeyEvent(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 38) {// 위
			gamePanel.choice = 0;
			if(e.getKeyCode() == 10) {
				gamePanel.basic();
			}
		} 
		else if (e.getKeyCode() == 40) {// 아래
			gamePanel.choice = 0;
			if(e.getKeyCode() == 10) {
				gamePanel.hide();
			}
		}
		else if (e.getKeyCode() == 10) {// 엔터 키
			
		}	
		gamePanel.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
