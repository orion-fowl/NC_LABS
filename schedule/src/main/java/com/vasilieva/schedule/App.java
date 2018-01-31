package com.vasilieva.schedule;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;

import com.vasilieva.schedule.Controller.ViewController;
import com.vasilieva.schedule.Intefaces.Model;
import com.vasilieva.schedule.Model.Schedule;
import com.vasilieva.schedule.Model.ScheduleItem;
import com.vasilieva.schedule.View.GUI;
import com.vasilieva.schedule.utils.DirCreator;
import com.vasilieva.schedule.utils.StringParser;

public class App 
{
    public static void main( String[] args )
    {
    	DirCreator dirCreator = new DirCreator();
//        GUI view = new GUI();
//        Model model = new Schedule(new File(dirCreator.PATH + "schedule.xml"));
//		ViewController controller = new ViewController(view, model);
		
//		view.setLocationRelativeTo(null);
//		view.setVisible(true);
    	
    	String filepath = DirCreator.PATH + "/schedule.xml";
    	
    	String test0 = "444A \"Station One\" \"Station Two\" 2017-12-12 20:00 PT1H";
    	String test1 = "444A \"Station Two\" \"Station Three\" 2017-12-12 21:05 P1D";
    	String test2 = "444A \"Station Two\" \"Station Three\" 2017-12-12 21:05 P1D"; // will not be added, not unique
    	String test3 = "464A \"Station Two\" \"Station Three\" 2017-12-12 21:05 P1D";
    	String test4 = "44A \"Station Two\" \"Station Three\" 2017-12-12 21:05 P1D";
    	Model model = new Schedule();
    	
    	model.add(test3); // added
    	model.add(test1); // added
    	model.add(test2); // not added
    	model.remove(test3); // removed
    	model.add(test0);
    	model.add(test4);
    	
    	System.out.println("found " + model.search("444A*").size());
    	for (Vector<String> row : model.search("444A*")) {
    		for (String s : row) {
    			System.out.print(s + " ");
    		}
    		System.out.println();
    	}
    	
    	System.out.println("found " + model.search("?44A *").size());
    	
    	model.edit(test4, "555 \"Station Two\" \"Station Three\" 2017-12-12 21:05 P1D"); // modified
    	
    	// show all
    	Model newModel = new Schedule(new File(filepath));
    	for (Vector<String> row : newModel.search("*")) {
    		for (String s : row) {
    			System.out.print(s + " ");
    		}
    		System.out.println();
    	}
    	System.out.println("MERGE WITH WRONG FILE");
    	newModel.addFrom(new File(DirCreator.PATH + "/test0.xml"));
    	for (Vector<String> row : newModel.search("*")) {
    		for (String s : row) {
    			System.out.print(s + " ");
    		}
    		System.out.println();
    	}
    	System.out.println("MERGE WITH RIGHT FILE");
    	newModel.addFrom(new File(DirCreator.PATH + "/test1.xml"));
    	for (Vector<String> row : newModel.search("*")) {
    		for (String s : row) {
    			System.out.print(s + " ");
    		}
    		System.out.println();
    	}
    }
}
