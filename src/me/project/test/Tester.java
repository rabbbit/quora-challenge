package me.project.test;

import java.util.LinkedList;
import java.util.Scanner;

public class Tester {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String[] line = scanner.nextLine().split(" ");
		int width = Integer.valueOf(line[0]);
		int height = Integer.valueOf(line[1]);
		Board board = new Board(width, height);

		for (int i = 0; i < height; i++) {
			line = scanner.nextLine().split(" ");
			for (int j = 0; j < width; j++) {
				if (Integer.valueOf(line[j]) == 1) {
					board.setAsBusy(j, i);
				} else if (Integer.valueOf(line[j]) == 2) {
					board.setAsBusy(j, i);
					board.setAsCurrent(j, i);
				} else if (Integer.valueOf(line[j]) == 3) {
					board.setAsBusy(j, i);
					board.setAsExit(j, i);
				}
			}
		}

		long time = System.currentTimeMillis();

		LinkedList<Board> list = new LinkedList<Board>();
		list.add(board);

		while ((board = list.pollLast()) != null) {
			// System.out.println("Removing item from the list");
			board.iterate(list);
			// System.out.println("Current list size: " + list.size());
		}

		System.out.println(System.currentTimeMillis() - time);
		System.out.println("Found: " + Board.found);

	}
}
