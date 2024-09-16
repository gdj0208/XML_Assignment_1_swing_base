package Main_Package;

import Main_Package.*;

import java.io.*;
import javax.swing.*;
import java.awt.*;

//com
public class Main_Class {
	public static String file_Name;
	private static JFrame Main_Frame = new JFrame();
	private static Main_Manager mManager = new Main_Manager(Main_Frame);
	private static File_Manager fManager = new File_Manager(Main_Frame, mManager);
	
	public static void main(String[] args) {
		init_gui();
		Main_Frame.setVisible(true);
	}
	private static void init_gui() {
		Main_Frame.setTitle("XML_Assignemt_1");
		Main_Frame.setSize(800, 600);
		Main_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main_Frame.setLayout(new BorderLayout());
		
		Main_Frame.add(fManager, BorderLayout.NORTH);
		Main_Frame.add(mManager, BorderLayout.CENTER);
	}
}
