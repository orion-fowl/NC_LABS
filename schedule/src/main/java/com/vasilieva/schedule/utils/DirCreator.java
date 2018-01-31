package com.vasilieva.schedule.utils;

import java.io.File;

public class DirCreator {
	public static String PATH = new File("").getAbsolutePath() + "/resources/";
	private boolean dirExists = false;
	public DirCreator() {
		this.dirExists = checkDir();
		if (!this.dirExists) {
			this.createDir();
		}
	}
	private void createDir() {
		File folder = new File(DirCreator.PATH);
		folder.mkdir();
		this.dirExists = true;
	}
	public boolean checkDir() {
		File file = new File(DirCreator.PATH);
		return file.exists();
	}
}
