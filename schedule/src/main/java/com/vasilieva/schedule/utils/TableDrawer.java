package com.vasilieva.schedule.utils;

public class TableDrawer {
	private int colNumber = 8;
	private int colStart = 7;
	private int colEnd = 5;
	private int colDepart = 16;
	private int colDuration = 9;
	public TableDrawer() {}
	public void drawTable(String[][] data) {
		defineColWitgh(data);
		System.out.printf(rowFormat(), "Train �", "Start", "End", "Depart", "Travel time");
		for (int i = 0; i < data.length; i++) {
			System.out.printf(rowFormat(), data[i][0], data[i][1], data[i][2], data[i][3], data[i][4]);
		}
		
	}
	public void drawTable() {
		System.out.printf(rowFormat(), "Train �", "Start", "End", "Depart", "Travel time");
	}
	private void defineColWitgh(String[][] data) {
		for (int i = 0; i < data.length; i++) {
			int witgh = (data[i][1].length() > data[i][2].length()) ? data[i][1].length() : data[i][2].length();
			if (witgh > this.colStart) {
				this.colStart = witgh;
			}
		}
	}
	private String format(int colWitgh, char type) {
		return "%" + colWitgh + type;
	}
	private String rowFormat() {
		return format(colNumber, 's') + " |" + format(colStart, 's') + " |" + format(colEnd, 's') + " |" + format(colDepart, 's') + " |" + format(colDuration, 's');
	}
}
