package com.vasilieva.schedule.Intefaces;

public interface View {
	public void setText(String text);
	public String getText();
	public void addSearchFieldObserver(TextFieldObserver observer);
	public void removeSearchFieldObserver(TextFieldObserver observer);
}
