package com.zetcode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HideSightPanel extends Board {

    private Image shadow;

    public HideSightPanel(Sokoban f) {
        super(f);
        gamemode = 1;
        ImageIcon iicon= new ImageIcon("src/resources/shadow2.png");
        shadow = iicon.getImage();
    }

    @Override
    protected void buildWorld(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        //??? (0,0)?? ???? ?????? ?????.
        ArrayList<Actor> world = new ArrayList<>();
        //world = ?????? ??? ????? ????
        world.addAll(walls);
        world.addAll(areas);
        world.addAll(baggs);
        world.add(soko);
        //???????? ???? ?????? ????? ?????. ?б└????? baggage????????? ???? ???? ????? 2px?? ????? ????? ??ве?.
        for (int i = 0; i < world.size(); i++) {

            Actor item = world.get(i);//?????????? ?????? ??????.

            int xDistance = Math.abs(soko.x() - item.x());
            int yDistance = Math.abs(soko.y() - item.y());
            if (xDistance > SPACE || yDistance > SPACE) {

                g.drawImage(shadow, item.x(), item.y(), this);
            } else if (item instanceof Player || item instanceof Baggage) {

                g.drawImage(item.getImage(), item.x() + 2, item.y() + 2, this);
            } else {

                g.drawImage(item.getImage(), item.x(), item.y(), this);
            }

            g.setColor(new Color(255, 255, 255));
            g.drawString("Timer : " + seconds + " sec", getBoardWidth() + OFFSET, 20);
            g.drawString("Moves : " + moveCount + " / " + MAX_MOVE, getBoardWidth() + OFFSET, 50);

            if (isCompleted) {
                g.setColor(new Color(255, 255, 255));
                g.drawString("Completed", 25, 20);

            } else if (moveCount == MAX_MOVE) {
                g.setColor(new Color(255, 255, 255));
                g.drawString("Game Over", 25, 20);
            }

        }
    }
}
