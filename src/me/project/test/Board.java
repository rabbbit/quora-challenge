package me.project.test;

import java.util.Arrays;
import java.util.List;

public class Board {

	public static int found = 0;
	private boolean[][] board;
	private Point current;
	private static Point exit;

	public Board(int width, int height) {
		this.board = new boolean[width][height];
	}

	public Board(boolean[][] board) {
		this.board = board;
	}

	public void print() {
		System.out.println(Arrays.deepToString(board));
	}

	public Board getClone() {
		Board clone = new Board(this.board.length, this.board[0].length);
		for (int i = 0; i < board.length; i++) {
			clone.board[i] = this.board[i].clone();
		}

		return clone;
	}

	public boolean isItDone() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// print();
				if (board[i][j] == false) {
					return false;
				}
			}
		}
		return true;
	}

	public void setAsBusy(int x, int y) {
		board[x][y] = true;
	}

	public void setAsCurrent(int x, int y) {
		current = new Point(x, y);
	}

	public void setAsExit(int x, int y) {
		exit = new Point(x, y);
	}

	public void iterate(List<Board> list) {
		int counter = 0;
		// System.out.println("Current item: " + current.getX() + " "
		// + current.getY());

		int i = this.current.getX();
		int j = this.current.getY() - 1;

		if (i >= 0 && i < this.board.length && j >= 0
				&& j < this.board[0].length && board[i][j] == false) {

			Board clone = this.getClone();
			clone.setAsBusy(i, j);
			clone.setAsCurrent(i, j);
			list.add(clone);
			// System.out.println("Adding to list: " + i + " " + j);
			counter++;
		}
		i = this.current.getX() - 1;
		j = this.current.getY();

		if (i >= 0 && i < this.board.length && j >= 0
				&& j < this.board[0].length && board[i][j] == false) {

			Board clone = this.getClone();
			clone.setAsBusy(i, j);
			clone.setAsCurrent(i, j);
			list.add(clone);
			// System.out.println("Adding to list: " + i + " " + j);
			counter++;
		}
		i = this.current.getX() + 1;
		j = this.current.getY();

		if (i >= 0 && i < this.board.length && j >= 0
				&& j < this.board[0].length && board[i][j] == false) {

			Board clone = this.getClone();
			clone.setAsBusy(i, j);
			clone.setAsCurrent(i, j);
			list.add(clone);
			// System.out.println("Adding to list: " + i + " " + j);
			counter++;
		}
		i = this.current.getX();
		j = this.current.getY() + 1;

		if (i >= 0 && i < this.board.length && j >= 0
				&& j < this.board[0].length && board[i][j] == false) {

			Board clone = this.getClone();
			clone.setAsBusy(i, j);
			clone.setAsCurrent(i, j);
			list.add(clone);
			// System.out.println("Adding to list: " + i + " " + j);
			counter++;
		}
		if (counter == 0) {
			if ((Math.abs(current.getX() - exit.getX()) <= 1)
					&& (Math.abs(current.getY() - exit.getY()) <= 1)
					&& this.isItDone()) {
				found++;
			}
		}
	}
}
