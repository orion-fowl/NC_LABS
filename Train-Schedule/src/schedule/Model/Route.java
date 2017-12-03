package schedule.Model;

public class Route {
	private String start_point;
	private String end_point;
	public Route(String start_point, String end_point) {
		this.start_point = start_point;
		this.end_point = end_point;
	}
	public String getStartStation() {
		return start_point;
	}
	public void setStartStation(String start_point) {
		this.start_point = start_point;
	}
	public String getEndStation() {
		return end_point;
	}
	public void setEndStation(String end_point) {
		this.end_point = end_point;
	}
}
