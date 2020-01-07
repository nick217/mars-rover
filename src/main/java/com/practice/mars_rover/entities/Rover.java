package com.practice.mars_rover.entities;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.practice.mars_rover.constants.CompassPoint;
import com.practice.mars_rover.constants.Move;
import com.practice.mars_rover.exceptions.InvalidInputException;

public class Rover {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private CartesianCoordinate position;

	private char direction;

	private Plateau myPlateau;

	public Rover(CartesianCoordinate position, char direction, Plateau myPlateau) {
		this.position = position;
		this.direction = direction;
		this.myPlateau = myPlateau;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public void move() {
		CartesianCoordinate positionBeforeMoving = position;
		switch (this.direction) {
		case CompassPoint.NORTH:
			position = position.setyCoordinate(position.getyCoordinate() + 1);
			break;
		case CompassPoint.SOUTH:
			position = position.setyCoordinate(position.getyCoordinate() - 1);
			break;
		case CompassPoint.EAST:
			position = position.setxCoordinate(position.getxCoordinate() + 1);
			break;
		case CompassPoint.WEST:
			position = position.setxCoordinate(position.getxCoordinate() - 1);
			break;
		}
		if (!myPlateau.isPointOnPlateau(position)) {
			LOGGER.log(Level.WARNING, "Cannot move forward, At end of Plateau");
			position = positionBeforeMoving;
		}
	}

	public void turnLeft() {
		switch (this.direction) {
		case CompassPoint.NORTH:
			this.direction = CompassPoint.WEST;
			break;
		case CompassPoint.SOUTH:
			this.direction = CompassPoint.EAST;
			break;
		case CompassPoint.EAST:
			this.direction = CompassPoint.NORTH;
			break;
		case CompassPoint.WEST:
			this.direction = CompassPoint.SOUTH;
			break;
		}
	}

	public void turnRight() {
		switch (this.direction) {
		case CompassPoint.NORTH:
			this.direction = CompassPoint.EAST;
			break;
		case CompassPoint.SOUTH:
			this.direction = CompassPoint.WEST;
			break;
		case CompassPoint.EAST:
			this.direction = CompassPoint.SOUTH;
			break;
		case CompassPoint.WEST:
			this.direction = CompassPoint.NORTH;
			break;
		}
	}

	public void run(String commands) throws InvalidInputException {
		for (int i = 0; i < commands.length(); i++) {
			switch (commands.charAt(i)) {
			case Move.LEFT:
				turnLeft();
				break;
			case Move.RIGHT:
				turnRight();
				break;
			case Move.FORWARD:
				move();
				break;
			default:
				throw new InvalidInputException("Invalid Move: " + commands.charAt(i));
			}
		}
	}

	public void printCoordinates() {
		System.out.println(position.toString() + " " + direction);
	}

}
