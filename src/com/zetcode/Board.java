package com.zetcode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class Board extends JPanel {

	private static final long serialVersionUID = 1L;

    protected final int OFFSET = 30;
    protected final int SPACE = 20;
    protected final int LEFT_COLLISION = 1;
    protected final int RIGHT_COLLISION = 2;
    protected final int TOP_COLLISION = 3;
    protected final int BOTTOM_COLLISION = 4;
    protected final int MAX_MOVE         = 300;
    protected final int LEFT_DIRECTION   = 1;
    protected final int RIGHT_DIRECTION  = 2;
    protected final int UP_DIRECTION     = 3;
    protected final int DOWN_DIRECTION   = 4;

    protected int gamemode = 0;

    protected ArrayList<Wall>    walls;
    protected ArrayList<Baggage> baggs;
    protected ArrayList<Area>    areas;

    protected Player soko;
    protected int    w = 0;
    protected int    h = 0;

    protected CircleStack<Integer> playerMoveStack;
    protected CircleStack<Boolean> bagMoveStack;
    protected int                  moveCount;
    protected int                  seconds;
    protected Timer                timer;

    protected Sokoban frame;

    protected boolean isCompleted = false;

    protected String level
            = "    ######\n"
            + "    ##   #\n"
            + "    ##$  #\n"
            + "  ####  $##\n"
            + "  ##  $ $ #\n"
            + "#### # ## #   ######\n"
            + "##   # ## #####  ..#\n"
            + "## $  $          ..#\n"
            + "###### ### #@##  ..#\n"
            + "    ##     #########\n"
            + "    ########\n";

    protected String level2
            ="   #####\n"
            +"####   #\n"
            +"#  #$  #####\n"
            +"# $$       #\n"
            +"#@   #$ $# #\n"
            +"###  #   # #\n"
            +" #   ##### #\n"
            +" #   ..... #\n"
            +" ###########\n";

    protected String level3
            ="##########\n"
            +"#     #  #\n"
            +"#  $  $$ #\n"
            +"#  # #   #\n"
            +"#### ###.#\n"
            +"#  #   #.#\n"
            +"# $  $ #.#\n"
            +"#  ##.##.#\n"
            +"##.##  #.#\n"
            +"# $  $ #.#\n"
            +"#   #  #.#\n"
            +"### ####.#\n"
            +"### #  @ #\n"
            +"#  $  $$ #\n"
            +"#        #\n"
            +"##########\n";

    protected String level4
            =" #######\n"
            +" #@    #\n"
            +"##$##$$#\n"
            +"# $    #\n"
            +"# ##$# ##\n"
            +"#.......#\n"
            +"### ##  #\n"
            +"#     $$#\n"
            +"#   #   #\n"
            +"#########\n";

    protected String level5
            = "      ########\n"
            + "      #      #\n"
            + "  ##### #### #\n"
            + "  #   # #  # #\n"
            + "  #        # #\n"
            + "#### ####  # #\n"
            + "#  $$## $$## #\n"
            + "# ##.......  #\n"
            + "# #   ## #####\n"
            + "# # $$$  #\n"
            + "# ### ####\n"
            + "#@     #\n"
            + "#######\n";

//    protected String level6
//            = "   ###  \n"
//            + "   #.#  \n"
//            + "   # #  \n"
//            + "   # #  \n"
//            + "   # ###\n"
//            + "   #   #\n"
//            + "#### $ #\n"
//            + "#.  $$##\n"
//            + "###   # \n"
//            + "  ##@## \n"
//            + "   #.#  \n"
//            + "   ###  \n";



    public Board(Sokoban f) {
        this.frame = f;
        initBoard();

        f.setSize(this.getBoardWidth() + 5*OFFSET,
                    this.getBoardHeight() + 3*OFFSET);
    }

    public Board(Sokoban f, int levelNum) {//basic 레벨
        this.frame = f;
        switch (levelNum) {
            case 1 :
                break;
            case 2 :
                level = level2;
                break;
            case 3 :
                level = level3;
                break;
            case 4 :
                level = level4;
                break;
            case 5 :
                level = level5;
                break;
        }
        initBoard();

        f.setSize(this.getBoardWidth() + 5*OFFSET,
                this.getBoardHeight() + 4*OFFSET);
    }

    protected void initBoard() {
        addKeyListener(createTAdapter());
        setFocusable(true);
        initWorld();
    }

    public int getBoardWidth() {
        return this.w;
    }

    public int getBoardHeight() {
        return this.h;
    }

    protected void initWorld() {
        playerMoveStack = new CircleStack<>(10);
        bagMoveStack    = new CircleStack<>(10);
        moveCount       = 0;
        seconds         = 0;

        walls = new ArrayList<>();
        baggs = new ArrayList<>();
        areas = new ArrayList<>();

        int x = OFFSET;
        int y = OFFSET;

        Wall    wall;
        Baggage b;
        Area    a;

        if (timer != null){
            timer.stop();
        }

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                repaint();
            }
        });
        timer.start();

        for (int i = 0; i < level.length(); i++) {

            char item = level.charAt(i);

            switch (item) {

                case '\n':
                    y += SPACE;

                    if (this.w < x) {
                        this.w = x;
                    }

                    x = OFFSET;
                    break;

                case '#':
                    wall = new Wall(x, y);
                    walls.add(wall);
                    x += SPACE;
                    break;

                case '$':
                    b = new Baggage(x, y);
                    baggs.add(b);//baggs�����̳ʿ� b�߰�
                    x += SPACE;//x��ġ�� 20��ŭ ���Ѵ�.
                    break;

                case '.':
                    a = new Area(x, y);
                    areas.add(a);
                    x += SPACE;
                    break;

                case '@':
                    soko = new Player(x, y);
                    x += SPACE;
                    break;

                case ' ':
                    x += SPACE;
                    break;

                default:
                    break;
            }

            h = y;
        }
    }

    protected void buildWorld(Graphics g) {

        g.setColor(new Color(250, 240, 170));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        ArrayList<Actor> world = new ArrayList<>();
        world.addAll(walls);
        world.addAll(areas);
        world.addAll(baggs);
        world.add(soko);
        for (int i = 0; i < world.size(); i++) {

            Actor item = world.get(i);

            if (item instanceof Player || item instanceof Baggage) {
                
                g.drawImage(item.getImage(), item.x() + 2, item.y() + 2, this);
            } else {
                
                g.drawImage(item.getImage(), item.x(), item.y(), this);
            }

            g.setColor(new Color(0, 0, 0));
            g.drawString("Timer : " + seconds + " sec", getBoardWidth() + OFFSET, 20);
            g.drawString("Moves : " + moveCount + " / " + MAX_MOVE, getBoardWidth() + OFFSET, 50);

            if (isCompleted) {
                g.setColor(new Color(0, 0, 0));
                g.drawString("Completed", 25, 20);

            } else if (moveCount == MAX_MOVE) {
                g.setColor(new Color(0, 0, 0));
                g.drawString("Game Over", 25, 20);
            }

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        buildWorld(g);
    }

    protected class TAdapter extends KeyAdapter {

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
                	
                    if (checkWallCollision(soko, LEFT_COLLISION)) {
                        return;
                    }
                    
                    if (checkBagCollision(LEFT_COLLISION)) {
                        return;
                    }
                    
                    soko.move(-SPACE, 0);
                    playerMoveStack.push(KeyEvent.VK_LEFT);
                    moveCount++;

                    break;
                    
                case KeyEvent.VK_RIGHT:
                    
                    if (checkWallCollision(soko, RIGHT_COLLISION)) {
                        return;
                    }
                    
                    if (checkBagCollision(RIGHT_COLLISION)) {
                        return;
                    }
                    
                    soko.move(SPACE, 0);
                    playerMoveStack.push(KeyEvent.VK_RIGHT);
                    moveCount++;

                    break;
                    
                case KeyEvent.VK_UP:
                    
                    if (checkWallCollision(soko, TOP_COLLISION)) {
                        return;
                    }
                    
                    if (checkBagCollision(TOP_COLLISION)) {
                        return;
                    }
                    
                    soko.move(0, -SPACE);
                    playerMoveStack.push(KeyEvent.VK_UP);
                    moveCount++;

                    break;
                    
                case KeyEvent.VK_DOWN:
                    
                    if (checkWallCollision(soko, BOTTOM_COLLISION)) {
                        return;
                    }
                    
                    if (checkBagCollision(BOTTOM_COLLISION)) {
                        return;
                    }
                    
                    soko.move(0, SPACE);
                    playerMoveStack.push(KeyEvent.VK_DOWN);
                    moveCount++;

                    break;
                    
                case KeyEvent.VK_R://RŰ�� ������ ������ ������Ѵ�.
                    
                    restartLevel();
                    
                    break;

                case KeyEvent.VK_U:

                    if (playerMoveStack.isEmpty()) {
                        return;
                    }

                    undo(playerMoveStack.pop());

                    break;
                    
                default:
                    break;
            }

            repaint();//ȭ���� �ٽ� �׷������� ��û
        }
    }

    protected boolean checkWallCollision(Actor actor, int type) {

        switch (type) {
            
            case LEFT_COLLISION:
                
                for (int i = 0; i < walls.size(); i++) {
                    
                    Wall wall = walls.get(i);
                    
                    if (actor.isLeftCollision(wall)) {
                        
                        return true;//����
                    }
                }
                
                return false;//����
                
            case RIGHT_COLLISION:
                
                for (int i = 0; i < walls.size(); i++) {
                    
                    Wall wall = walls.get(i);
                    
                    if (actor.isRightCollision(wall)) {
                        return true;
                    }
                }
                
                return false;
                
            case TOP_COLLISION:
                
                for (int i = 0; i < walls.size(); i++) {
                    
                    Wall wall = walls.get(i);
                    
                    if (actor.isTopCollision(wall)) {
                        
                        return true;
                    }
                }
                
                return false;
                
            case BOTTOM_COLLISION:
                
                for (int i = 0; i < walls.size(); i++) {
                    
                    Wall wall = walls.get(i);
                    
                    if (actor.isBottomCollision(wall)) {
                        
                        return true;
                    }
                }
                
                return false;
                
            default:
                break;
        }
        
        return false;
    }

    protected boolean checkBagCollision(int type) {
    	//baggage�� ��, ���ڹ�  ��ü �Ǵ� �ٸ� baggage�� �浹�� �� �ִ�. �ٸ� ��ü�� �浹���� �ʾƾ� baggage �ű�� ����
    	//baggage �ű涧�� isCompleted()�� ���� ������ �������� Ȯ���� ����.

        boolean bagMovedFlag = false;

        switch (type) {
            
            case LEFT_COLLISION:
                
                for (int i = 0; i < baggs.size(); i++) {

                    Baggage bag = baggs.get(i);

                    if (soko.isLeftCollision(bag)) {

                        for (int j = 0; j < baggs.size(); j++) {
                            
                            Baggage item = baggs.get(j);
                            
                            if (!bag.equals(item)) {//baggage�� baggage�� �浹�� ��
                                
                                if (bag.isLeftCollision(item)) {
                                    return true;
                                }
                            }
                            
                            if (checkWallCollision(bag, LEFT_COLLISION)) {//baggage�� ���� �浹�� ��
                                return true;
                            }
                        }
                        
                        bag.move(-SPACE, 0);
                        bagMoveStack.push(true);
                        bagMovedFlag = true;
                        isCompleted();
                    }
                }

                if (!bagMovedFlag) {
                    this.bagMoveStack.push(false);
                }
                return false;
                
            case RIGHT_COLLISION:
                
                for (int i = 0; i < baggs.size(); i++) {

                    Baggage bag = baggs.get(i);
                    
                    if (soko.isRightCollision(bag)) {
                        
                        for (int j = 0; j < baggs.size(); j++) {

                            Baggage item = baggs.get(j);
                            
                            if (!bag.equals(item)) {
                                
                                if (bag.isRightCollision(item)) {
                                    return true;
                                }
                            }
                            
                            if (checkWallCollision(bag, RIGHT_COLLISION)) {
                                return true;
                            }
                        }
                        
                        bag.move(SPACE, 0);
                        bagMoveStack.push(true);
                        bagMovedFlag = true;
                        isCompleted();
                    }
                }

                if (!bagMovedFlag) {
                    this.bagMoveStack.push(false);
                }
                return false;
                
            case TOP_COLLISION:
                
                for (int i = 0; i < baggs.size(); i++) {

                    Baggage bag = baggs.get(i);
                    
                    if (soko.isTopCollision(bag)) {
                        
                        for (int j = 0; j < baggs.size(); j++) {

                            Baggage item = baggs.get(j);

                            if (!bag.equals(item)) {
                                
                                if (bag.isTopCollision(item)) {
                                    return true;
                                }
                            }
                            
                            if (checkWallCollision(bag, TOP_COLLISION)) {
                                return true;
                            }
                        }
                        
                        bag.move(0, -SPACE);
                        bagMoveStack.push(true);
                        bagMovedFlag = true;
                        isCompleted();
                    }
                }

                if (!bagMovedFlag) {
                    this.bagMoveStack.push(false);
                }
                return false;
                
            case BOTTOM_COLLISION:
                
                for (int i = 0; i < baggs.size(); i++) {

                    Baggage bag = baggs.get(i);
                    
                    if (soko.isBottomCollision(bag)) {
                        
                        for (int j = 0; j < baggs.size(); j++) {

                            Baggage item = baggs.get(j);
                            
                            if (!bag.equals(item)) {
                                
                                if (bag.isBottomCollision(item)) {
                                    return true;
                                }
                            }
                            
                            if (checkWallCollision(bag,BOTTOM_COLLISION)) {
                                
                                return true;
                            }
                        }
                        
                        bag.move(0, SPACE);
                        bagMoveStack.push(true);
                        bagMovedFlag = true;
                        isCompleted();
                    }
                }

                if (!bagMovedFlag) {
                    this.bagMoveStack.push(false);
                }
                return false;
                
            default:
                break;
        }

        return false;
    }

    public void isCompleted() {
    	//������ �������� Ȯ���Ѵ�.
    	//baggage�� ���� ���� �� �ִ�. ��� baggage�� (x,y)��ǥ�� �������� ���Ѵ�.
        int nOfBags = baggs.size();
        int finishedBags = 0;

        for (int i = 0; i < nOfBags; i++) {
            
            Baggage bag = baggs.get(i);
            
            for (int j = 0; j < nOfBags; j++) {
                
                Area area =  areas.get(j);
                
                if (bag.x() == area.x() && bag.y() == area.y()) {
                    
                    finishedBags += 1;
                }
            }
        }

        if (finishedBags == nOfBags) {//finishedBags�� nOfBags(���� �� baggage��)�� ���� �� ������ ����ȴ�.
            
            isCompleted = true;

            if (isBoard()) {
                recordScore(this.moveCount);
            }

            repaint();
        }
    }

    protected void restartLevel() {//�����

        areas.clear();
        baggs.clear();
        walls.clear();

        initWorld();

        if (isCompleted) {
            isCompleted = false;
        }
    }

    protected void undo(int keyEvent) {

        switch (keyEvent) {
            case KeyEvent.VK_LEFT:

                if (this.bagMoveStack.pop()) {
                    for (Baggage bag : this.baggs) {
                        if (soko.isLeftCollision(bag)) {
                            bag.move(SPACE, 0);
                        }
                    }
                }
                soko.move(SPACE, 0);

                break;

            case KeyEvent.VK_RIGHT:

                if (this.bagMoveStack.pop()) {
                    for (Baggage bag : this.baggs) {
                        if (soko.isRightCollision(bag)) {
                            bag.move(-SPACE, 0);
                        }
                    }
                }
                soko.move(-SPACE, 0);

                break;

            case KeyEvent.VK_UP:

                if (this.bagMoveStack.pop()) {
                    for (Baggage bag : this.baggs) {
                        if (soko.isTopCollision(bag)) {
                            bag.move(0, SPACE);
                        }
                    }
                }
                soko.move(0, SPACE);

                break;

            case KeyEvent.VK_DOWN:

                if (this.bagMoveStack.pop()) {
                    for (Baggage bag : this.baggs) {
                        if (soko.isBottomCollision(bag)) {
                            bag.move(0, -SPACE);
                        }
                    }
                }
                soko.move(0, -SPACE);

                break;

            default:
                break;
        }
    }

    protected void moveDirection(int direction) {
        switch (direction) {
            case LEFT_DIRECTION:
                soko.move(-SPACE, 0);
                break;
            case RIGHT_DIRECTION:
                soko.move(SPACE, 0);
                break;
            case UP_DIRECTION:
                soko.move(0, -SPACE);
                break;
            case DOWN_DIRECTION:
                soko.move(0, SPACE);
                break;
            default:
                break;
        }
    }

    protected TAdapter createTAdapter() {
        return new TAdapter();
    }

    protected boolean isBoard() {
        return this.gamemode == 0;
    }

    protected void recordScore(int score) {
        try {
            File              userfile  = new File("src/resources/user");
            Scanner           scan      = new Scanner(userfile);
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
