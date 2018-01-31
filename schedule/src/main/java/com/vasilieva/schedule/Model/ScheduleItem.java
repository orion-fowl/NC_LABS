package com.vasilieva.schedule.Model;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.vasilieva.schedule.utils.*;

@XmlRootElement (name = "schedule")
@XmlType (propOrder = {"train", "startStation", "endStation", "departTime", "travelTime"})
public class ScheduleItem {
	private String 	train,
					startStation,
					endStation;
	private LocalDateTime departTime;
	private Duration travelTime;
	public ScheduleItem(String arg) {
		Vector<String> source = StringParser.parse(arg, false);
		this.train = source.elementAt(0);
		this.startStation = source.elementAt(1);
		this.endStation = source.elementAt(2);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.departTime = LocalDateTime.parse(source.elementAt(3), formatter);
		this.travelTime = Duration.parse(source.elementAt(4));
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
	@XmlElement (name = "travel_time")
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

	@Override
	public String toString() {
		return 	this.getTrain() + " \"" +
				this.getStartStation() + "\" \"" +
				this.getEndStation() + "\" " +
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
