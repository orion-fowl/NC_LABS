package schedule.Model;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import schedule.utils.*;

@XmlRootElement (name = "schedule")
@XmlType (propOrder = {"train", "startStation", "endStation", "departTime", "travelTime"})
public class ScheduleItem {
	private String 	train,
					startStation,
					endStation;
	private LocalDateTime departTime;
	private Duration travelTime;
	public ScheduleItem(String arg) {
		String[] data = StringParser.parse(arg);
		this.train = data[0];
		this.startStation = data[1];
		this.endStation = data[2];
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.departTime = LocalDateTime.parse(data[3], formatter);
		this.travelTime = Duration.parse(data[4]);
	}
	public ScheduleItem() {
		
	}
	public LocalDateTime getDepartTime() {
		return departTime;
	}
	@XmlElement (name = "depart_time")
	@XmlJavaTypeAdapter (DateAdapter.class)
	public void setDepartTime(LocalDateTime departTime) {
		this.departTime = departTime;
	}
	@XmlElement (name = "depart_time")
	@XmlJavaTypeAdapter (DateAdapter.class)
	public void setDepartTime(String departTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.departTime = LocalDateTime.parse(departTime, formatter);
	}
	public Duration getTravelTime() {
		return travelTime;
	}
	@XmlElement (name = "traverl_time")
	@XmlJavaTypeAdapter (DurationAdapter.class)
	public void setTravelTime(Duration travelTime) {
		this.travelTime = travelTime;
	}
	@XmlElement (name = "traverl_time")
	public void setTravelTime(String travelTime) {
		this.travelTime = Duration.parse(travelTime);
	}
	public String getStartStation() {
		return startStation;
	}
	@XmlElement (name = "start_station")
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	public String getEndStation() {
		return endStation;
	}
	@XmlElement (name = "end_station")
	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}
	public String getTrain() {
		return train;
	}
	@XmlElement (name = "train")
	public void setTrain(String train) {
		this.train = train;
	}
	public boolean saveToFile() {
		Schedule schedule = new Schedule();
		File file = new File(DirCreator.PATH + "schedule.xml");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			schedule.pullFromXml(file);
		}
		boolean result = schedule.add(this);
		schedule.saveToXml(file);
		return result;
	}
	public void deleteFromFile() {
		Schedule schedule = new Schedule();
		File file = new File(DirCreator.PATH + "schedule.xml");
		schedule.pullFromXml(file);
		schedule.deleteItem(this);
		schedule.saveToXml(file);
	}
	public boolean exists() {
		Schedule schedule = new Schedule();
		File file = new File(DirCreator.PATH + "schedule.xml");
		schedule.pullFromXml(file);
		return schedule.contains(this);
	}
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ScheduleItem)) {
			return false;
		}
		ScheduleItem item = (ScheduleItem)o;
		return (this.getTrain().equals(item.getTrain()) &&
				this.getStartStation().equals(item.getStartStation()) &&
				this.getEndStation().equals(item.getEndStation()) &&
				this.getDepartTime().equals(item.getDepartTime()) &&
				this.getTravelTime().equals(item.getTravelTime()));
	}
	public static Schedule search(String search) {;
		Schedule result = new Schedule();
		search = search.replace("*", "(.*)");
		search = search.replace("?", ".");
		System.out.println(search);
		Schedule schedule = new Schedule(new File(DirCreator.PATH + "schedule.xml"));
		Pattern pattern = Pattern.compile(search);
		for (ScheduleItem item : schedule.getContent()) {
			Matcher matcher = pattern.matcher(item.toString());
			if (matcher.matches()) {
				result.add(item);
			}
		}
		return result;
	}
	public void update(ScheduleItem item) {
		if (item.saveToFile()) {
			this.deleteFromFile();
		}
	}
	@Override
	public String toString() {
		return 	this.getTrain() + " " +
				this.getStartStation() + " " +
				this.getEndStation() + " " +
				this.getDepartTime() + " " +
				this.getTravelTime();
	}
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + train.hashCode();
		result = 31 * result + startStation.hashCode();
		result = 31 * result + endStation.hashCode();
		result = 31 * result + departTime.hashCode();
		result = 31 * result + travelTime.hashCode();
		return result;
	}
}
