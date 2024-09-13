package Main_Package;
import Main_Package.File_Manager;
import java.io.*;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

//com
public class Main_Class {
	private static Scanner my_scanner = new Scanner(System.in);
	private static int operation = -1;
	public static List<String> file_data;
	private static File_Manager fManager;
	private static Finder finder;
	private static boolean run;
	public static String file_Name;
	
	public static void main(String[] args) {
		Main_Class main_class = new Main_Class();
		fManager = new File_Manager(main_class);
		finder = new Finder(main_class);
		
		fManager.request_load_or_make_file();
		
		run = true;
		
		while(run) {
			print_operation_list();
			get_operation();
			operate();
		}
	}
	
	private static void print_operation_list() {
		System.out.println("\nChoose your operation.");
		System.out.println("0. Exit");
		System.out.println("1. Find");
		System.out.println("2. Save");
		System.out.println("3. Print");
	}
	
	private static void get_operation() {
		while(true) {
			operation = my_scanner.nextInt();
			
			if(0 <= operation && operation <= 3) { break; }
			System.out.println("Choose right operation");
		}
	}
	
	private static void operate() {
		switch(operation) {
		case 0 : run = false; break;
		case 1:		// 특정 문자열 검색 
			//System.out.println("미구현 상태입니다.");
			finder.run_Finder();
			break;
		case 2:		// 파일 저장 
			fManager.save_file();
			//System.out.println("미구현 상태입니다.");
			break;
		case 3:		// 파일 출력 
			print();
			break;
		}
	}
	
	private static void print() { file_data.forEach(System.out::println); }
}
