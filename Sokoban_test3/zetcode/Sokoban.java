package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Sokoban extends JFrame {//main Ŭ����

	private static final long serialVersionUID = 1L;
	
	private final int OFFSET = 30;
    public Sokoban() {

        initUI();
    }

    private void initUI() {
        
        Board board = new Board();
        add(board);

        setTitle("Sokoban");
        
        setSize(board.getBoardWidth() + OFFSET, board.getBoardHeight() + 2 * OFFSET);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
    	//Swing������Ʈ���� ��� ������ ���� �����忡���� �̷�������Ѵ� = event-dispatch thread
    	//event-dispatch thread �� �½�ũ�� �����ؾ������� ������� �ʿ������ʰ� �½�ũ�� ���� ������ ������ٸ�, EventQueue�� public static void invokeLater(Runnable runnable) �޼ҵ带 ��� 
        EventQueue.invokeLater(() -> {
            Sokoban game = new Sokoban();
            game.setVisible(true);
        });
    }
}
