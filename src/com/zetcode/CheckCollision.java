package com.zetcode;

public class CheckCollision {
	Board board;
	Baggage b;

	public CheckCollision() {
	}

	public boolean CheckCollision(Baggage bag){
		boolean checkBagBottom0(Baggage bag) {
		for (int j = 0; j < board.baggs.size(); j++) {

			Baggage item = baggs.get(j);

			if (!bag.equals(item)) {

				if (bag.isBottomCollision(item)) {
					return true;
				}
			}

			if (checkWallCollision(bag, BOTTOM_COLLISION)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkBagTop0(Baggage bag) {
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
		return false;
	}

	protected boolean checkBagRight0(Baggage bag) {
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
		return false;
	}

	protected boolean checkBagLeft0(Baggage bag) {
		for (int j = 0; j < baggs.size(); j++) {

			Baggage item = baggs.get(j);

			if (!bag.equals(item)) {// baggage�� baggage�� �浹�� ��

				if (bag.isLeftCollision(item)) {
					return true;
				}
			}

			if (checkWallCollision(bag, LEFT_COLLISION)) {// baggage�� ���� �浹�� ��
				return true;
			}
		}
		return false;
	}
	}
}
