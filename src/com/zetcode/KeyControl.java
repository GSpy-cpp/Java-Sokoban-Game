package com.zetcode;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//public class KeyControl {
//	Board board;
//	Player soko;
//	protected final int SPACE = 20;
//	
//	protected class TAdapter extends KeyAdapter {
//		
//		@Override
//		public void keyPressed(KeyEvent e) {
//
//			if (board.isCompleted) {
//				return;
//			}
//			if (board.moveCount == board.MAX_MOVE) {
//				return;
//			}
//
//			int key = e.getKeyCode();
//
//			switch (key) {
//			case KeyEvent.VK_LEFT:
//
//				if (board.checkWallCollision(soko, board.LEFT_COLLISION)) {
//					return;
//				}
//
//				if (board.checkBagCollision(board.LEFT_COLLISION)) {
//					return;
//				}
//
//				soko.move(-SPACE, 0);
//				board.playerMoveStack.push(KeyEvent.VK_LEFT);
//				board.moveCount++;
//
//				break;
//
//			case KeyEvent.VK_RIGHT:
//
//				if (board.checkWallCollision(soko, board.RIGHT_COLLISION)) {
//					return;
//				}
//
//				if (board.checkBagCollision(board.RIGHT_COLLISION)) {
//					return;
//				}
//
//				soko.move(SPACE, 0);
//				board.playerMoveStack.push(KeyEvent.VK_RIGHT);
//				board.moveCount++;
//
//				break;
//
//			case KeyEvent.VK_UP:
//
//				if (board.checkWallCollision(soko, board.TOP_COLLISION)) {
//					return;
//				}
//
//				if (board.checkBagCollision(board.TOP_COLLISION)) {
//					return;
//				}
//
//				soko.move(0, -SPACE);
//				board.playerMoveStack.push(KeyEvent.VK_UP);
//				board.moveCount++;
//
//				break;
//
//			case KeyEvent.VK_DOWN:
//
//				if (board.checkWallCollision(soko, board.BOTTOM_COLLISION)) {
//					return;
//				}
//
//				if (board.checkBagCollision(board.BOTTOM_COLLISION)) {
//					return;
//				}
//
//				soko.move(0, SPACE);
//				board.playerMoveStack.push(KeyEvent.VK_DOWN);
//				board.moveCount++;
//
//				break;
//
//			case KeyEvent.VK_R:// RŰ�� ������ ������ ������Ѵ�.
//
//				board.restartLevel();
//
//				break;
//
//			case KeyEvent.VK_U:
//
//				if (board.playerMoveStack.isEmpty()) {
//					return;
//				}
//
//				board.undo(board.playerMoveStack.pop());
//
//				break;
//
//			default:
//				break;
//			}
//		}
//	}

	
//	protected void undo(int keyEvent) {
//
//		switch (keyEvent) {
//		case KeyEvent.VK_LEFT:
//
//			if (this.bagMoveStack.pop()) {
//				for (Baggage bag : this.baggs) {
//					if (soko.isLeftCollision(bag)) {
//						bag.move(SPACE, 0);
//					}
//				}
//			}
//			soko.move(SPACE, 0);
//
//			break;
//
//		case KeyEvent.VK_RIGHT:
//
//			if (this.bagMoveStack.pop()) {
//				for (Baggage bag : this.baggs) {
//					if (soko.isRightCollision(bag)) {
//						bag.move(-SPACE, 0);
//					}
//				}
//			}
//			soko.move(-SPACE, 0);
//
//			break;
//
//		case KeyEvent.VK_UP:
//
//			if (this.bagMoveStack.pop()) {
//				for (Baggage bag : this.baggs) {
//					if (soko.isTopCollision(bag)) {
//						bag.move(0, SPACE);
//					}
//				}
//			}
//			soko.move(0, SPACE);
//
//			break;
//
//		case KeyEvent.VK_DOWN:
//
//			if (this.bagMoveStack.pop()) {
//				for (Baggage bag : this.baggs) {
//					if (soko.isBottomCollision(bag)) {
//						bag.move(0, -SPACE);
//					}
//				}
//			}
//			soko.move(0, -SPACE);
//
//			break;
//
//		default:
//			break;
//		}
//	}
//}
