package Main_Package;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import Main_Package.Main_Class;

public class File_Manager {
	private Scanner my_scanner = new Scanner(System.in);
	private Main_Class main_Class;
	private int order = 0;
	
	public File_Manager( Main_Class main_Class) { this.main_Class = main_Class; }
	
	public void request_load_or_make_file() {
		print_operation();
		get_operation();
		load_or_make_file();
	}
	
	private void print_operation() {
		//파일 불러오기 또는 생성 요청 출력 
		System.out.println("\nChoose your operation.");
		System.out.println("1. Load");
		System.out.println("2. Make");
	}
	
	private void get_operation() {
		while(true) {
			// 파일 불러오기 또는 생성 
			order = my_scanner.nextInt();
			
			// 잘못된 입력시 다시 입력 요구 
			if(1 <= order && order <= 2) { break; }
			System.out.println("Choose right operation");
		}
	}
	
	private void load_or_make_file() {
		if(order == 1) { load_file(); }
		else { make_file(); }
	}
	
	// 파일 불러오기 
	private void load_file() {
		main_Class.file_Name = "input";
		try { main_Class.file_data = Files.readAllLines(Paths.get(main_Class.file_Name+".txt")); } 
		catch (IOException e) { e.printStackTrace(); }
		System.out.println("File has successfully loaded!");
	}
	
	// 파일 생성 
	private void make_file() {
		System.out.print("\nName your new File : ");
		main_Class.file_Name = my_scanner.next();
		
		try { 
			main_Class.file_data = new ArrayList<String>();
			Files.write(Paths.get(main_Class.file_Name+".txt"), main_Class.file_data);
		}
		catch (IOException e) { e.printStackTrace(); }
		System.out.println("File " + main_Class.file_Name + " has successfully made!");
	}
	
	// 파일 쓰
	public void save_file() {
		try { Files.write(Paths.get(main_Class.file_Name+".txt"), main_Class.file_data); } 
		catch (IOException e) { e.printStackTrace(); }
		System.out.println("File has successfully saved!");
	}
}