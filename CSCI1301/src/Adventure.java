/*
 * Adventure.java
 * Author: Jiyoon Shin
 * Submission Date: 
 *
 * Purpose: 
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither 
 * received nor given inappropriate assistance. I have not copied 
 * or modified code from any source other than the course webpage 
 * or the course textbook. I recognize that any unauthorized 
 * assistance or plagiarism will be handled in accordance with 
 * the University of Georgia's Academic Honesty Policy and the 
 * policies of this course. I recognize that my work is based 
 * on an assignment created by the School of Computing 
 * at the University of Georgia. Any publishing or
 * posting of source code for this assignment is strictly 
 * prohibited unless you have written consent from the 
 * School of Computing at the University of Georgia.  
 */

import java.util.Scanner;

public class Adventure {

	public static final Scanner INPUT = new Scanner(System.in);

	public static void printDescriptionIfRoomIsNotDark(Player player, Room currentRoom) {
		if (currentRoom.isDark() && (player.getLamp() == null || !player.getLamp().getIsLit())) {
			System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
		} else {
			System.out.println(currentRoom.getDescription());
		}
	}

	public static void main(String[] args) {

		System.out.println("Welcome to UGA Adventures: Episode 1");
		System.out.println("The adventure of the Cave of Redundancy Adventure");
		System.out.println("By: Jiyoon Shin");
		System.out.println();

		Player player = new Player();
		Map map = new Map();
		Room currentRoom = map.getRoom(player.getX(), player.getY());
		System.out.println(currentRoom.getDescription());

		while (true) {

			String userInput = INPUT.nextLine();

			if (userInput.equalsIgnoreCase("GET LAMP")) {
				Lamp theLamp = currentRoom.getLamp();
				if (theLamp == null) {
					System.out.println("No lamp present");
				} else {
					player.setLamp(theLamp);
					currentRoom.clearLamp();
					System.out.println("OK");
				}
			}

			else if (userInput.equalsIgnoreCase("LIGHT LAMP")) {
				Lamp theLamp = player.getLamp();
				if (theLamp == null) {
					System.out.println("You don't have the lamp to light");
				} else {
					theLamp.setIsLit(true);
					System.out.println("OK");
				}
			}

			else if (userInput.equalsIgnoreCase("NORTH") || userInput.equalsIgnoreCase("SOUTH")
					|| userInput.equalsIgnoreCase("EAST") || userInput.equalsIgnoreCase("WEST")) {
				if (currentRoom.isDark() && (player.getLamp() == null || !player.getLamp().getIsLit())) {
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					break;
				} else if (userInput.equalsIgnoreCase("NORTH") && currentRoom.canGoNorth()) {
					player.setX(player.getX() - 1);
					currentRoom = map.getRoom(player.getX(), player.getY());
					printDescriptionIfRoomIsNotDark(player, currentRoom);
				} else if (userInput.equalsIgnoreCase("SOUTH") && currentRoom.canGoSouth()) {
					player.setX(player.getX() + 1);
					currentRoom = map.getRoom(player.getX(), player.getY());
					printDescriptionIfRoomIsNotDark(player, currentRoom);
				} else if (userInput.equalsIgnoreCase("EAST") && currentRoom.canGoEast()) {
					player.setY(player.getY() + 1);
					currentRoom = map.getRoom(player.getX(), player.getY());
					printDescriptionIfRoomIsNotDark(player, currentRoom);
				} else if (userInput.equalsIgnoreCase("WEST") && currentRoom.canGoWest()) {
					player.setY(player.getY() - 1);
					currentRoom = map.getRoom(player.getX(), player.getY());
					printDescriptionIfRoomIsNotDark(player, currentRoom);
				} else {
					System.out.println("Can't go that way");
				}
			}

			else if (userInput.equalsIgnoreCase("LOOK")) {
				printDescriptionIfRoomIsNotDark(player, currentRoom);
				if (currentRoom.getLamp() != null) {
					System.out.println("There is an old oil lamp that was made long ago here.");
				}
				if (currentRoom.getKey() != null) {
					System.out.println("You see the outline of a key on a dusty shelf that's covered in dust.");
				}
				if (currentRoom.getChest() != null) {
					System.out.println(
							"There is a large, wooden, massive, oaken chest here with the word \"CHEST\" carved into it");
				}
				System.out.print("Exits are: ");
				if (currentRoom.canGoNorth()) {
					System.out.println("north");
				}
				if (currentRoom.canGoSouth()) {
					System.out.println("south");
				}
				if (currentRoom.canGoEast()) {
					System.out.println("east");
				}
				if (currentRoom.canGoWest()) {
					System.out.println("west");
				}
			}

			else if (userInput.equalsIgnoreCase("GET KEY")) {
				Key theKey = currentRoom.getKey();
				if (theKey == null) {
					System.out.println("No key present");
				} else {
					player.setKey(theKey);
					currentRoom.clearKey();
					System.out.println("OK");
				}
			}

			else if (userInput.equalsIgnoreCase("OPEN CHEST")) {
				Chest theChest = currentRoom.getChest();
				if (theChest == null) {
					System.out.println("No chest present");
				} else if (theChest.isLocked()) {
					System.out.println("The chest is locked");
				} else {
					System.out.println(theChest.getContents());
					break;
				}
			}

			else if (userInput.equalsIgnoreCase("UNLOCK CHEST")) {
				Chest theChest = currentRoom.getChest();
				if (theChest == null) {
					System.out.println("No chest to unlock");
				} else if (player.getKey() == null) {
					System.out.println("Need a key to do any unlocking!");
				} else {
					player.getKey().use(theChest);
					System.out.println("OK");
				}
			}

			else {
				System.out.println("I'm sorry I don't know how to do that.");
			}

		}

	}
}
