package schedule.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
	public static String[] parse(String arg) {
		String[] result = new String[5];
		Pattern pattern = Pattern.compile("(\\w+)\\s+\"(.+)\"\\s+\"(.+)\"\\s+(.{16})\\s+(.+)");
		Matcher matcher = pattern.matcher(arg);
		if (matcher.matches()) {
			for (int i = 0; i < 5; ++i) {
				result[i] = matcher.group(i + 1);
			}
		}
		return result;
	}
}
