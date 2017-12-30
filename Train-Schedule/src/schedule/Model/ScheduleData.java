package schedule.Model;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import schedule.utils.XMLValidator;

public class ScheduleData {
	private Train train;
	private Route route;
	private Date depart_time;
	private Date travel_time;
	
	public ScheduleData(Train train, Route route, Date depart_time, Date travel_time) {
		this.train = train;
		this.route = route;
		this.depart_time = depart_time;
		this.travel_time = travel_time;
	}
	public ScheduleData() {
	}
	public Date getDepartTime() {
		return depart_time;
	}
	public void setDepartTime(Date depart_time) {
		this.depart_time = depart_time;
	}
	public Date getTravelTime() {
		return travel_time;
	}
	public void setTravelTime(Date travel_time) {
		this.travel_time = travel_time;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public ScheduleData[] search(String search_query) {
		// TODO
		System.out.println("SEARCH Received: "+search_query);
		ScheduleData[] result = null;
		return result;
	}
	public void add(String arg) {
		// TODO
	}
	public void update(String old_data, String new_data) {
		System.out.println("UPDATE Received: "+old_data + "->"+new_data);
		// TODO
	}
	public void delete(String arg) {
		System.out.println("DELETE Received: "+arg);
		// TODO
	}
	public void addFrom(String path) {
		
	}
}
