package com.vasilieva.schedule.Model;

import java.io.File;
import java.util.HashSet;
import java.util.Observable;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.*;

import com.vasilieva.schedule.Intefaces.Model;
import com.vasilieva.schedule.utils.DirCreator;
import com.vasilieva.schedule.utils.JaxbWorker;
import com.vasilieva.schedule.utils.ResourceValidator;
import com.vasilieva.schedule.utils.StringParser;

@XmlRootElement (name = "schedules")
public class Schedule implements Model{
	private HashSet<ScheduleItem> content;
	
	public Schedule(File file) {
		this.content = JaxbWorker.xmlToObject(file).getContent();
	}
	public Schedule() {
		this.content = new HashSet<ScheduleItem>();
	}
	
	@XmlElement (name = "schedule")
	public void setContent(HashSet<ScheduleItem> content) {
		this.content = content;
	}
	public HashSet<ScheduleItem> getContent() {
		return content;
	}
	
	public boolean add(String text) {
		ScheduleItem item = new ScheduleItem(text);
		saveToXml(new File (DirCreator.PATH + "/schedule.xml"));
		return this.content.add(item);
	}
	public boolean add(ScheduleItem item) {
		boolean result = content.add(item);
		saveToXml(new File (DirCreator.PATH + "/schedule.xml"));
		return result;
	}
	public boolean remove(String text) {
		ScheduleItem item = new ScheduleItem(text);
		saveToXml(new File (DirCreator.PATH + "/schedule.xml"));
		return this.content.remove(item);
	}
	public boolean remove(ScheduleItem item) {
		boolean result = content.remove(item);
		saveToXml(new File (DirCreator.PATH + "/schedule.xml"));
		return result;
	}
	public boolean edit(String oldItem, String newItem) {
		if (add(newItem) && contains(oldItem)) {
			return remove(oldItem);
		}
		saveToXml(new File (DirCreator.PATH + "/schedule.xml"));
		return false;
	}
	
	public void pullFromXml(File file) {
		this.content = JaxbWorker.xmlToObject(file).getContent();	
	
	}
	public void saveToXml(File file) {
		JaxbWorker.objectToXML(this, file);
	}
	public boolean contains(String text) {
		ScheduleItem item = new ScheduleItem(text);
		return this.content.contains(item);
	}
	public void addFrom(File file) {
		if (ResourceValidator.validate(file)) {
			Schedule source = JaxbWorker.xmlToObject(file);
			this.content.addAll(source.getContent());
		}
		saveToXml(new File (DirCreator.PATH + "/schedule.xml"));
	}
	public Vector<Vector<String> > toStringVector() {
		Vector<Vector<String> > result = new Vector<Vector<String> >(this.content.size(), 5);
		for (ScheduleItem item : this.content) {
			result.add(StringParser.parse(item.toString(), true));
		}
		return result;
	}
	public Vector<Vector<String>> search(String search) {
		search = search.replace("*", "(.*)").replace("?", ".");
		Schedule result = new Schedule();
		Pattern pattern = Pattern.compile(search);
		for (ScheduleItem item : content) {
			Matcher matcher = pattern.matcher(item.toString());
			if (matcher.matches()) {
				result.add(item);
			}
		}
		return result.toStringVector();
	}
}
