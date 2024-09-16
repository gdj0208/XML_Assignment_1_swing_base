package Main_Package;

import java.awt.*;

import javax.swing.*;

public class Edit_Manager extends JPanel{

	private JFrame Main_Frame;
	private JPanel Main_Manager;

	private JTextArea text_area;
	private JScrollPane scroll_text_area;
	
	private JTextField search_content;
	private JButton Search, Insert, Update, Delete;
	private JLabel Search_Result, Content;
	
	public Edit_Manager(JFrame Main_Frame, JPanel Main_Manager) {
		this.Main_Frame = Main_Frame;
		this.Main_Manager = Main_Manager;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
		
		init_components();
		add_components();
	}

	private void init_components() {
		Search_Result = new JLabel("Search Result");
		Content = new JLabel("Content");
		
		text_area = new JTextArea(20, 15);
		scroll_text_area = new JScrollPane(text_area);
		
		search_content = new JTextField(15);
		
		Search = new JButton("Search");
		Insert = new JButton("Insert");
		Update = new JButton("Update");
		Delete = new JButton("Delete");
	}
	
	private void add_components() {
		this.add(Search_Result);
		this.add(scroll_text_area);
		this.add(Content);
		this.add(search_content);
		this.add(Search);
		this.add(Insert);
		this.add(Update);
		this.add(Delete);
	}
}
