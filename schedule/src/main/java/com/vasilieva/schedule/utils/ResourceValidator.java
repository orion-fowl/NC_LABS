package com.vasilieva.schedule.utils;

import java.io.File;

public class ResourceValidator {
	public ResourceValidator() {
	}
	public static boolean validate(File file) {
		if (JaxbWorker.xmlToObject(file) == null) {
			return false;
		}
		return true;
	}
}
