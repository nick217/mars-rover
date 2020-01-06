package com.practice.mars_rover.entities;

public class Plateau {
	private CartesianCoordinate bottomLeft;
	private CartesianCoordinate topRight;

	public Plateau(CartesianCoordinate bottomLeft, CartesianCoordinate topRight) {
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
	}

	public CartesianCoordinate getBottomLeft() {
		return bottomLeft;
	}

	public void setBottomLeft(CartesianCoordinate bottomLeft) {
		this.bottomLeft = bottomLeft;
	}

	public CartesianCoordinate getTopRight() {
		return topRight;
	}

	public void setTopRight(CartesianCoordinate topRight) {
		this.topRight = topRight;
	}

	public boolean isPointOnPlateau(CartesianCoordinate point) {
		int x = point.getxCoordinate();
		int y = point.getyCoordinate();
		
		if (x >= bottomLeft.getxCoordinate() && x <= topRight.getxCoordinate()) {
			if (y >= bottomLeft.getyCoordinate() && y <= topRight.getyCoordinate()) {
				return true;
			}
		}
		return false;
	}

}
