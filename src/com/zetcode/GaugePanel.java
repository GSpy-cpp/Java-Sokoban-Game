package com.zetcode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GaugePanel extends Board {
    private final int GAUGE_LEVEL_1 = 1;
    private final int GAUGE_LEVEL_2 = 2;
    private final int GAUGE_LEVEL_3 = 3;

    private Timer moveTimer;
    private int pressedTime;

    public GaugePanel(Sokoban f) {
        super(f);
        gamemode = 3;
        moveTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ++pressedTime;
            }
        });
    }

    @Override
    protected void initWorld() {
        super.initWorld();
        pressedTime = 0;
    }

    private void gaugeMove(int t, int moveDirection) {
        int moves = 0;
        if (t < GAUGE_LEVEL_1) {                             // if t < GUAGE_LEVEL_1
            moves = 0;                                       // 안움직임

        } else if (t >= GAUGE_LEVEL_1 && t < GAUGE_LEVEL_2) {// if GAUGE_LEVEL_1 <= t < GAUGE_LEVEL_2
            moves = 1;                                       // 1칸 움직임

        } else if (t >= GAUGE_LEVEL_2 && t < GAUGE_LEVEL_3) {// if GAUGE_LEVEL_2 <= t < GAUGE_LEVEL_3
            moves = 2;                                       // 2칸 움직임

        } else {                                             // if GAUGE_LEVEL_3 <= t
            moves = 3;                                       // 3칸 움직임
        }

        for (int i = 0; i < moves; i++) {

            switch (moveDirection) {
                case LEFT_DIRECTION:

                    if (checkWallCollision(soko,
                            LEFT_COLLISION)) {
                        break;
                    }

                    if (checkBagCollision(LEFT_COLLISION)) {
                        break;
                    }
                    moveDirection(moveDirection);
                    break;

                case RIGHT_DIRECTION:
                    if (checkWallCollision(soko, RIGHT_COLLISION)) {
                        break;
                    }

                    if (checkBagCollision(RIGHT_COLLISION)) {
                        break;
                    }
                    moveDirection(moveDirection);
                    break;

                case UP_DIRECTION:
                    if (checkWallCollision(soko, TOP_COLLISION)) {
                        break;
                    }

                    if (checkBagCollision(TOP_COLLISION)) {
                        break;
                    }
                    moveDirection(moveDirection);
                    break;

                case DOWN_DIRECTION:

                    if (checkWallCollision(soko, BOTTOM_COLLISION)) {
                        break;
                    }

                    if (checkBagCollision(BOTTOM_COLLISION)) {
                        break;
                    }
                    moveDirection(moveDirection);
                    break;
            }

        }
        moveCount++;
    }

    class TAdapter extends Board.TAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            if (isCompleted) {
                return;
            }
            if (moveCount == MAX_MOVE) {
                return;
            }

            int key = e.getKeyCode();

            switch (key) {

                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_UP:
                case KeyEvent.VK_DOWN:
                    moveTimer.start();
                    break;

                case KeyEvent.VK_R:

                    restartLevel();


                    break;

                case KeyEvent.VK_1:
                    frame.changePanel("1");
                    break;
                default:
                    break;
            }

            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {

            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_LEFT:
                    moveTimer.stop();
                    gaugeMove(pressedTime, LEFT_DIRECTION);
                    pressedTime = 0;
                    break;
                case KeyEvent.VK_RIGHT:
                    moveTimer.stop();
                    gaugeMove(pressedTime, RIGHT_DIRECTION);
                    pressedTime = 0;
                    break;
                case KeyEvent.VK_UP:
                    moveTimer.stop();
                    gaugeMove(pressedTime, UP_DIRECTION);
                    pressedTime = 0;
                    break;
                case KeyEvent.VK_DOWN:
                    moveTimer.stop();
                    gaugeMove(pressedTime, DOWN_DIRECTION);
                    pressedTime = 0;
                    break;
            }
        }
    }

    @Override
    protected TAdapter createTAdapter() {
        return new TAdapter();
    }
}
