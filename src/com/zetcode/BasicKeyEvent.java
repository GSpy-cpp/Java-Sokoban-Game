package com.zetcode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicKeyEvent implements ActionListener {
	BasicPanel basicPanel_level;// basic모드 생성자로 받음

	public BasicKeyEvent(BasicPanel basicPanel_level) {
		this.basicPanel_level = basicPanel_level;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "1LEVEL") {
			basicPanel_level.level1_Start();
		} else if (e.getActionCommand() == "2LEVEL") {
			basicPanel_level.level2_Start();
		} else if (e.getActionCommand() == "3LEVEL") {
			basicPanel_level.level3_Start();
		} else if (e.getActionCommand() == "4LEVEL") {
			basicPanel_level.level4_Start();
		} else
			basicPanel_level.level5_Start();
	}

}
