import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class IntroPanel extends JPanel {
	public IntroPanel() {
		
	}

	@Override
	public void paint(Graphics g) {
	g.setColor(new Color(250, 240, 170));
	g.fillRect(0, 0, this.getWidth(), this.getHeight());
	g.setFont(new Font("myFont", Font.BOLD, 30));
	g.setColor(Color.darkGray);
	g.drawString("sokoban", 130, 100);
	g.setFont(new Font("secondFont", Font.ITALIC, 20));
	g.setColor(Color.red);
	g.drawString("GAME START", 130, 250);
	g.drawString("Quit", 130, 300);
	}
}