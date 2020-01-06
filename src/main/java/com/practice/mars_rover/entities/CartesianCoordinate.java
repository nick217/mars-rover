package com.practice.mars_rover.entities;

public final class CartesianCoordinate {

	private int xCoordinate;
	private int yCoordinate;

	public CartesianCoordinate(int x, int y) {
		this.xCoordinate = x;
		this.yCoordinate = y;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public CartesianCoordinate setxCoordinate(int x) {
		return new CartesianCoordinate(x, yCoordinate);
	}

	public CartesianCoordinate setyCoordinate(int y) {
		return new CartesianCoordinate(xCoordinate, y);
	}

	@Override
	public String toString() {
		return xCoordinate + " " + yCoordinate;
	}

}
