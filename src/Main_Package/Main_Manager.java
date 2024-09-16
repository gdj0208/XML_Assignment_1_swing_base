package Main_Package;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
import Main_Package.Main_Class;

public class Main_Manager extends JPanel {
	
	private JFrame Main_Frame;
	private Edit_Manager eManager;
	public JTextArea text_area;
	private JScrollPane scroll_text_area;
	public List<String> text = new ArrayList<>();
    public boolean file_existence = false;
	
	public Main_Manager(JFrame Main_Frame) { 
		this.Main_Frame = Main_Frame;
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));
		
		init_components();
		add_components();
	}
	
	private void init_components() {
		text_area = new JTextArea();
		scroll_text_area = new JScrollPane(text_area);
		
		eManager = new Edit_Manager(Main_Frame, this);
	}
	
	private void add_components() {
		this.add(scroll_text_area, BorderLayout.CENTER);
		this.add(eManager, BorderLayout.EAST);
	}
	
}
