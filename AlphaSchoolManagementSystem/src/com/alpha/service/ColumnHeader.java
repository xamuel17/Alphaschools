package com.alpha.service;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ColumnHeader  {
	public ColumnHeader() {
	
		Object[][] data = 
		
	{
	{"boy","man"},
	{"girl","woman"},
	};
	//column headers
	String[] columnheaders = {"1","2"};

	//create table
	JTable table = new JTable(data,columnheaders);
	table.setPreferredScrollableViewportSize(new Dimension(500,80));


	//scrollpane
	JScrollPane pane = new JScrollPane(table);
	getContentPane().add(pane,BorderLayout.CENTER);
	
	}

	private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}	

}
