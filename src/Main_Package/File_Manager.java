package Main_Package;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class File_Manager extends JPanel {
	
	private JButton Open, Make, Re_inquiry, Save;
	private JFrame Main_Frame;
	private Main_Manager mManager;
	private JFileChooser fChooser = new JFileChooser();
    int option;
    File file;
	
	public File_Manager(JFrame Main_Frame, Main_Manager mManager) {
		this.Main_Frame = Main_Frame;
		this.mManager = mManager;
		
		make_buttons();
		add_buttons();
	}
	
	private void make_buttons() {
		Open = new JButton("Open File");
		Make = new JButton("Make File");
		Re_inquiry = new JButton("Reinquiry");
		Save = new JButton("Save File");
		
		Open.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { open_file(); }} );
		Make.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { make_file(); }} );
		Re_inquiry.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { re_inquiry(); }} );
		Save.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { save_file(); }} );
	}
	
	private void add_buttons() {
		this.add(Open);
		this.add(Make);
		this.add(Re_inquiry);
		this.add(Save);
	}
	
	private void open_file() {
		option = fChooser.showOpenDialog(fChooser);
		if (option == JFileChooser.APPROVE_OPTION) {
            file = fChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            	mManager.text_area.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                	mManager.text_area.append(line + "\n");
                }
            } 
            catch (IOException exc) { JOptionPane.showMessageDialog(this, "파일을 열 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE); }
        }
	}
	
	private void make_file() {
		String title = "example.txt";
        file = new File(title);
        save_file();
	}
	
	private void re_inquiry() {
		if(file == null) { JOptionPane.showMessageDialog(this,"파일을 불러오십시오.", "오류",JOptionPane.INFORMATION_MESSAGE); return; }
		
	}
	
	private void save_file() {
		if(file == null) { JOptionPane.showMessageDialog(this,"파일을 불러오십시오.", "오류",JOptionPane.INFORMATION_MESSAGE); return; }
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(mManager.text_area.getText());
        } 
		catch (IOException ex) { JOptionPane.showMessageDialog(this, "파일을 저장할 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE); }
	}
	
}