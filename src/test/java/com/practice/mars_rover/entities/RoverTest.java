package com.practice.mars_rover.entities;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.practice.mars_rover.constants.CompassPoint;
import com.practice.mars_rover.exceptions.InvalidInputException;

public class RoverTest {

	@Test
	public void canTurnRight() {
		// Given
		CartesianCoordinate bL = new CartesianCoordinate(0, 0);
		CartesianCoordinate tR = new CartesianCoordinate(5, 5);
		Plateau plateau = new Plateau(bL, tR);

		CartesianCoordinate roverPosition = new CartesianCoordinate(3, 3);

		Rover rover = new Rover(roverPosition, CompassPoint.EAST, plateau);

		// When
		rover.turnRight();

		// Then
		Assert.assertEquals("3 3 S", rover.currentCoordinates());
	}

	@Test
	public void canRunWithMultipleCommands() throws InvalidInputException {

		// Given
		CartesianCoordinate bL = new CartesianCoordinate(0, 0);
		CartesianCoordinate tR = new CartesianCoordinate(5, 5);
		Plateau plateau = new Plateau(bL, tR);

		CartesianCoordinate roverPosition = new CartesianCoordinate(3, 3);

		Rover rover = new Rover(roverPosition, CompassPoint.EAST, plateau);

		// When
		rover.run("MMRMMRMRRM");

		// then
		Assert.assertEquals("5 1 E", rover.currentCoordinates());

	}

	@Test(expected = InvalidInputException.class)
	public void wontRunWithInvalidInput() throws InvalidInputException {

		// Given
		CartesianCoordinate bL = new CartesianCoordinate(0, 0);
		CartesianCoordinate tR = new CartesianCoordinate(5, 5);
		Plateau plateau = new Plateau(bL, tR);

		CartesianCoordinate roverPosition = new CartesianCoordinate(3, 3);

		Rover rover = new Rover(roverPosition, CompassPoint.EAST, plateau);

		// When
		rover.run("MMRMMRMRRK");

		// then
		// Generate exception

	}
}
