package com.zetcode;

import java.awt.*;
import javax.swing.JFrame;

public class Sokoban extends JFrame {

    private final int    OFFSET          = 30;
    private final String LOGINPANEl_NAME = "loginPanel";
    private final String LOBBYPANEL_NAME = "lobbyPanel";
    private final String GAMEPANEL_NAME = "gamePanel";

    private CardLayout cards;

    public Sokoban() {
        initUI();
    }

    // public void changePanel(String name)
    // Panel에서 호출되는 메소드
    // JFrame에 표시되는 Panel을 바꿀 때 사용
    // 사용예 : frame.changePanel(frame.getLobbyPanelName());
    public void changePanel(String name) {
        this.cards.show(this.getContentPane(), name);
    }

    private void initUI() {
        setTitle("Sokoban");
        this.cards = new CardLayout();
        getContentPane().setLayout(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 사용되는 panel을 모두 add 해야 함.
        getContentPane().add(this.getLoginPanelName(), new LoginPanel(this));
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            
            Sokoban game = new Sokoban();
            game.setVisible(true);
        });
    }

    public String getLoginPanelName() {
        return LOGINPANEl_NAME;
    }

    public String getLobbyPanelName() {
        return LOBBYPANEL_NAME;
    }
    
    public String getGamePanelName() {//
    	return GAMEPANEL_NAME;
    }
    
    
}
