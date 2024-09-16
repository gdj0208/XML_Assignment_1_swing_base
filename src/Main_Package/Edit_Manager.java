package Main_Package;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Edit_Manager extends JPanel{

	private JFrame Main_Frame;
	private Main_Manager mManager;

	private JTextArea text_area;
	private JScrollPane scroll_text_area;
	
	private JTextField search_content, change_content;
	private JButton Next, Search, Insert, Update, Delete;
	private JLabel Search_Result, From, To;
	
	private int line_index = 0;
	private String Searching_Word;
	
	public Edit_Manager(JFrame Main_Frame, Main_Manager Main_Manager) {
		this.Main_Frame = Main_Frame;
		this.mManager = Main_Manager;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
		
		init_components();
		add_button_action_listener();
		add_components();
	}

	private void init_components() {
		Search_Result = new JLabel("Search Result");
		
		text_area = new JTextArea(15, 15);
		scroll_text_area = new JScrollPane(text_area);

		From = new JLabel("From");
		search_content = new JTextField(15);
		
		To = new JLabel("To");
		change_content = new JTextField(15);
		
		Next = new JButton("Next");
		Search = new JButton("Search");
		Insert = new JButton("Insert");
		Update = new JButton("Update");
		Delete = new JButton("Delete");
	}
	
	private void add_components() {
		this.add(Search_Result);
		this.add(scroll_text_area);
		this.add(Next);
		
		this.add(From);
		this.add(search_content);
		
		this.add(To);
		this.add(change_content);
		
		this.add(Search);
		this.add(Insert);
		this.add(Update);
		this.add(Delete);
	}
	
	private void add_button_action_listener() {
		Next.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { show_next(); }} );
		Search.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { show_search_result(); }} );
		Insert.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { insert_cont(); }} );
		Update.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { update_cont(); }} );
		Delete.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { delete_cont(); }} );
	}
	
	private void show_next() {
		line_index++;
		
		if(Searching_Word == null) { JOptionPane.showMessageDialog(this,"검색할 단어를 먼저 입력해주십시오.", "오류",JOptionPane.INFORMATION_MESSAGE); return; }
		
		while(!mManager.text.get(line_index).contains(Searching_Word)) { 
			line_index++;
			if(line_index >= mManager.text.size() - 1) { 
				JOptionPane.showMessageDialog(this,"더 이상 검색 결과가 없습니다.", "오류",JOptionPane.INFORMATION_MESSAGE);
				line_index = 0;
				return;
			}
		}
		text_area.setText("");
		text_area.append(mManager.text.get(line_index));
	}
	
	private void show_search_result() {
		if(mManager.file_existence == false) {JOptionPane.showMessageDialog(this,"파일을 불러오거나 생성하십시오.", "오류",JOptionPane.INFORMATION_MESSAGE);}
		
		line_index = -1;
		Searching_Word = search_content.getText();
		show_next();
	}
	
	private void insert_cont() {
		if(mManager.file_existence == false) {JOptionPane.showMessageDialog(this,"파일을 불러오거나 생성하십시오.", "오류",JOptionPane.INFORMATION_MESSAGE);}
		if(Searching_Word == null) { JOptionPane.showMessageDialog(this,"검색할 단어를 먼저 검색해주세요.", "오류",JOptionPane.INFORMATION_MESSAGE); return; }
		if(change_content.getText() == null) { JOptionPane.showMessageDialog(this,"수정할 단어를 입력해주십시오.", "오류",JOptionPane.INFORMATION_MESSAGE); return; }
		
		mManager.text.set(line_index, mManager.text.get(line_index).replaceAll(Searching_Word, change_content.getText()+Searching_Word)); 
	}
	
	private void update_cont() {
		if(mManager.file_existence == false) {JOptionPane.showMessageDialog(this,"파일을 불러오거나 생성하십시오.", "오류",JOptionPane.INFORMATION_MESSAGE);}
		if(Searching_Word == null) { JOptionPane.showMessageDialog(this,"검색할 단어를 먼저 검색해주세요.", "오류",JOptionPane.INFORMATION_MESSAGE); return; }
		if(change_content.getText() == null) { JOptionPane.showMessageDialog(this,"수정할 단어를 입력해주십시오.", "오류",JOptionPane.INFORMATION_MESSAGE); return; }
		
		mManager.text.set(line_index, mManager.text.get(line_index).replaceAll(Searching_Word, change_content.getText())); 
		}
	
	private void delete_cont() {
		if(mManager.file_existence == false) {JOptionPane.showMessageDialog(this,"파일을 불러오거나 생성하십시오.", "오류",JOptionPane.INFORMATION_MESSAGE);}
		if(Searching_Word == null) { JOptionPane.showMessageDialog(this,"검색할 단어를 먼저 검색해주세요.", "오류",JOptionPane.INFORMATION_MESSAGE); return; }
		if(change_content.getText() == null) { JOptionPane.showMessageDialog(this,"수정할 단어를 입력해주십시오.", "오류",JOptionPane.INFORMATION_MESSAGE); return; }
		
		mManager.text.set(line_index, mManager.text.get(line_index).replaceAll("\\b" + Searching_Word + "\\b\\s*", ""));
	}
}
