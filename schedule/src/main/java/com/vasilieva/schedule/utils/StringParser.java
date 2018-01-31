package com.vasilieva.schedule.utils;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
	public static Vector<String> parse(String arg, boolean format) {
		Vector<String> result = new  Vector<String>(5);
		Pattern pattern = Pattern.compile("(\\w+)\\s+\"(.+)\"\\s+\"(.+)\"\\s+(.{16})\\s+(.+)");
		Matcher matcher = pattern.matcher(arg);
		if (matcher.matches()) {
			for (int i = 0; i < 5; ++i) {
				result.add(matcher.group(i + 1));
			}
		}
		if (format) {
			result.add(result.elementAt(3).replace("T", " "));
			result.add(result.elementAt(4).replace("P", "")
										  .replaceAll("T", "")
										  .replace("D", " days")
										  .replace("H", " hours")
										  .replace("M", " mins"));
			result.removeElementAt(4);
			result.removeElementAt(3);
		}
		return result;
	}
}
