package com.practice.mars_rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.practice.mars_rover.constants.Move;
import com.practice.mars_rover.entities.CartesianCoordinate;
import com.practice.mars_rover.entities.Plateau;
import com.practice.mars_rover.entities.Rover;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * String input = br.readLine(); input = input.trim();
		 */
		CartesianCoordinate bL = new CartesianCoordinate(0, 0);
		CartesianCoordinate tR = new CartesianCoordinate(5, 5);
		Plateau plateau = new Plateau(bL, tR);

		/*
		 * input = br.readLine(); input = input.trim();
		 */
		CartesianCoordinate roverPosition = new CartesianCoordinate(3, 3);

		Rover r1 = new Rover(roverPosition, 'E', plateau);

		// input = br.readLine();
		String input = "MMRMMRMRRM";
		for (int i = 0; i < input.length(); i++) {
			switch (input.charAt(i)) {
			case Move.LEFT:
				r1.turnLeft();
				break;
			case Move.RIGHT:
				r1.turnRight();
				break;
			case Move.FORWARD:
				r1.move();
			}
		}
		r1.printCoordinates();
	}
}
