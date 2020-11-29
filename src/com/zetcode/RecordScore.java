package com.zetcode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RecordScore {
	protected Sokoban frame;
	
	public void recordScore() {
	}
	
	public void recordScore(int score) {
		try {
			File userfile = new File("src/resources/user");
			Scanner scan = new Scanner(userfile);
			ArrayList<String> userInfos = new ArrayList<>();
	
			while (scan.hasNextLine()) {
				userInfos.add(scan.nextLine());
			}
			scan.close();
	
			String[] infoBuf;
			for (int i = 0; i < userInfos.size(); i++) {
				infoBuf = userInfos.get(i).split("-");
				if (!infoBuf[0].equals(frame.getUserid())) {
					continue;
				}
				if (Integer.valueOf(infoBuf[2]) > score) {
					String str = infoBuf[0] + "-" + infoBuf[1] + "-" + score;
					userInfos.set(i, str);
				}
			}
	
			BufferedWriter bf = new BufferedWriter(new FileWriter(userfile));
			for (String str : userInfos) {
				bf.write(str + "\n");
			}
	
			bf.close();
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
}
