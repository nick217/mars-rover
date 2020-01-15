package com.practice.mars_rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.practice.mars_rover.constants.Move;
import com.practice.mars_rover.entities.CartesianCoordinate;
import com.practice.mars_rover.entities.Plateau;
import com.practice.mars_rover.entities.Rover;
import com.practice.mars_rover.exceptions.InvalidInputException;

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
		String commands = "MMRMMRMRRM";
		try {
			r1.run(commands);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(r1.currentCoordinates());
	}
}
