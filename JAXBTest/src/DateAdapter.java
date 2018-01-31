import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, LocalDateTime>{
	@Override
	public LocalDateTime unmarshal(String date) throws Exception{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return LocalDateTime.parse(date, formatter);
	}
	@Override
	public String marshal(LocalDateTime date) throws Exception{
		return date.toString().replace('T', ' ');
	}
}