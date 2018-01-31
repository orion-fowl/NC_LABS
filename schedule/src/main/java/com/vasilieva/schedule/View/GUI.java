package com.vasilieva.schedule.View;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import com.vasilieva.schedule.Intefaces.TextFieldObserver;
import com.vasilieva.schedule.Intefaces.View;
import com.vasilieva.schedule.utils.StringParser;

public class GUI extends JFrame implements View{
	private Vector<Vector<String> > data;
	private JTextField tField;
	private JButton btnAdd,
					btnAddFrom,
					btnSearch,
					btnDelete,
					btnEdit;
	private JTable table;
	private List<TextFieldObserver> observers;
	
	public GUI() {
		observers = new ArrayList<>();
		tField = textFieldConstruct();
		btnSearch = buttonConstruct("Search");
		btnAdd = buttonConstruct("Add");
		btnAddFrom = buttonConstruct("AddFrom");
		btnDelete = buttonConstruct("Delete");
		btnEdit = buttonConstruct("Edit");
		data = new Vector<Vector<String> >();
		data.addElement(new Vector<String>(1, 5));
		table = tableConstruct(data);
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireTextWasChanged();
			}
		});
		setSize(800, 600);
		createUI(getContentPane());
		
	}
	private JTable tableConstruct(Vector<Vector<String> > data) {
		Vector<String> columnHeader = new Vector<String>();
		for (String header : new String[]{"Train", "Start", "End", "Depart", "Travel"}) {
			columnHeader.add(header);
		}
		JTable table = new JTable(data, columnHeader);
		table.getColumnModel().getColumn(0).setMaxWidth(60);
		table.getColumnModel().getColumn(3).setMinWidth(120);
		table.getColumnModel().getColumn(3).setMaxWidth(140);
		table.getColumnModel().getColumn(4).setMaxWidth(60);
		table.setShowHorizontalLines(false);
		table.setPreferredScrollableViewportSize(new Dimension(800, 400));
		return table;
	}
	private JButton buttonConstruct(String label) {
		JButton btn = new JButton(label);
		btn.setBorder(BorderFactory.createEmptyBorder());
		btn.setBackground(Color.white);
		btn.setFocusPainted(false);
		btn.setSize(50, 20);
		return btn;
	}
	private JTextField textFieldConstruct() {
		JTextField tField = new JTextField(70);
		tField.setBorder(BorderFactory.createEmptyBorder());
		tField.setPreferredSize(new Dimension(140, 25));
		return tField;
	}
	private void createUI(Container container) {
		container.add(table);
	}
	public void setData(Vector<Vector<String> > data) {
		this.data = data;
	}
	
	public void setText(String text) {
		tField.setText(text);	
	}
	public String getText() {
		return tField.getText();
	}
	public void addSearchFieldObserver(TextFieldObserver observer) {
		observers.add(observer);
	}
	public void removeSearchFieldObserver(TextFieldObserver observer) {
		observers.remove(observer);
	}
	protected void fireTextWasChanged() {
		for (TextFieldObserver observer : observers) {
			observer.textWasChanged(this);
		}
		
	}
}
	