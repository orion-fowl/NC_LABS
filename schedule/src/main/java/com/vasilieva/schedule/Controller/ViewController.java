package com.vasilieva.schedule.Controller;

import java.util.Objects;

import com.vasilieva.schedule.Intefaces.Controller;
import com.vasilieva.schedule.Intefaces.Model;
import com.vasilieva.schedule.Intefaces.TextFieldObserver;
import com.vasilieva.schedule.Intefaces.View;

public class ViewController implements Controller, TextFieldObserver{
	private View view;
	private Model model;
	
	public ViewController(View view, Model model) {
		this.view = Objects.requireNonNull(view, "Viev can not be null");
		this.model = Objects.requireNonNull(model, "Model can not be null");
		view.addSearchFieldObserver(this);
	}
	@Override
	public View getView() {
		return view;
	}
	@Override
	public Model getModel() {
		return model;
	}	
	@Override
	public void textWasChanged(View view) {
		getModel().search(view.getText());
		
	}
}
