package Main_Package;

import java.util.Scanner;
import Main_Package.Main_Class;

public class Finder {
	private Scanner my_scanner = new Scanner(System.in);
	private Main_Class main_Class;
	private String word_2_find;
	private boolean run;
	private int operation;
	
	public Finder(Main_Class main_Class) { this.main_Class = main_Class;}

	public void run_Finder() {
		run = true;
		word_2_find = "";
		
		while(run) {
			print_operation();
			get_operation();
			operate();
		}
	}
	
	private void print_operation() {
		//파일 불러오기 또는 생성 요청 출력 
		System.out.println("\nChoose your operation.");
		System.out.println("Current finding word : " + word_2_find);
		System.out.println("0. Exit");
		System.out.println("1. Find");
		System.out.println("2. Insert");
		System.out.println("3. Update");
		System.out.println("4. Delete");
	}
	
	private void get_operation() {
		while(true) {
			// 파일 불러오기 또는 생성 
			operation = my_scanner.nextInt();
			
			// 잘못된 입력시 다시 입력 요구 
			if(0 <= operation &&  operation <= 4) { break; }
			System.out.println("Choose right operation");
		}
	}
	
	private void operate() {
		switch(operation) {
		case 0: run = false; break;
		case 1: find();
			break;
		case 2:
			insert();
			//System.out.println("미구현 상태입니다.");
			break;
		case 3:
			update();
			//System.out.println("미구현 상태입니다.");
			break;
		case 4:
			delete();
			//System.out.println("미구현 상태입니다.");
			break;
		}
	}
	
	private void find() {
		System.out.print("Search : ");
		if(my_scanner.hasNext()) {my_scanner.nextLine();}
		word_2_find = my_scanner.nextLine();
		
		for (int i = 0; i < main_Class.file_data.size(); i++) {
            String currentString = main_Class.file_data.get(i);
            
            // 현재 문자열에 검색 문자열이 포함되어 있는지 확인
            if (currentString.contains(word_2_find)) {
                System.out.println("line " + (i + 1) + ": " + currentString);
            }
        }
	}

	private void insert() {
		System.out.print("Insert : ");
		if(my_scanner.hasNext()) {my_scanner.nextLine();}
		String word_2_insert = my_scanner.nextLine();
		
		for (int i = 0; i < main_Class.file_data.size(); i++) {
            String currentString = main_Class.file_data.get(i);
            
            if (currentString.contains(word_2_find)) {
            	main_Class.file_data.set(i, insert_word_before_target(currentString, word_2_insert, word_2_find));
            }
        }
	}
	
	public static String insert_word_before_target(String original, String wordToInsert, String target) {
		return original.replaceAll("(?i)" + target, wordToInsert + target);
	}
	
	private void update() {
		System.out.print("Update : ");
		if(my_scanner.hasNext()) {my_scanner.nextLine();}
		String word_2_change = my_scanner.nextLine();
		
		for (int i = 0; i < main_Class.file_data.size(); i++) {
            String currentString = main_Class.file_data.get(i);
            
            if (currentString.contains(word_2_find)) {
            	while(true) {
                	System.out.println("\nDo you want to change words in this senetence?");
                	System.out.println(currentString);
                	System.out.println("0. YES\n1. No");
                	
                	int op = my_scanner.nextInt();
                	if(op == 0 || op == 1) {
                		if(op == 0) {main_Class.file_data.set(i, currentString.replaceAll(word_2_find, word_2_change));}
                		break;
                	}

        			System.out.println("Choose right operation");
            	}
            }
        }
	}
	
	private void delete() {
		if(word_2_find == "") { System.out.println("Choose right word to delete."); return; }
		
		for (int i = 0; i < main_Class.file_data.size(); i++) {
            String currentString = main_Class.file_data.get(i);
            
            if (currentString.contains(word_2_find)) {
            	while(true) {
                	System.out.println("\nDo you want to change words in this senetence?");
                	System.out.println(currentString);
                	System.out.println("0. YES\n1. No");
                	
                	int op = my_scanner.nextInt();
                	if(op == 0 || op == 1) {
                		if(op == 0) {main_Class.file_data.set(i, currentString.replaceAll("\\b" + word_2_find + "\\b\\s*", ""));}
                		break;
                	}

        			System.out.println("Choose right operation");
            	}
            }
        }
	}
}
