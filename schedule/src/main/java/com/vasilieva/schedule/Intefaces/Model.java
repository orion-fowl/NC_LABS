package com.vasilieva.schedule.Intefaces;

import java.io.File;
import java.util.Vector;

public interface Model {
	public Vector<Vector<String> > search(String text);
	public boolean add(String text);
	public boolean remove(String text);
	public boolean edit(String oldItem, String newItem);
	public void addFrom(File file);
}
