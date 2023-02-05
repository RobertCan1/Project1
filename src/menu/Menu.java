package menu;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import application.Application;

public class Menu {
	
	static Scanner sc = new Scanner(System.in);
	static String repository = "src/repository";

	public static void FileOperations() {
		System.out.println("");
		System.out.println("Press 1 Add a new file");
		System.out.println("Press 2 Delete file");
		System.out.println("Press 3 to Search a file");
		System.out.println("Press 4 to go Back to the Main Menu");
		
		String choice = sc.nextLine();
		handle(choice);
	}
	
	public static void handle(String num) {
		switch(num) {
			case "1":
				System.out.println("Option 1 was selected");
				add();
				break;
			case "2":
				System.out.println("Option 2 was selected");
				delete();
				break;
			case "3":
				System.out.println("Option 3 was selected");
				find();
				break;
			case "4":
				System.out.println("Option 4 was selected");
				Application.menus();
				break;				
			default:
				System.out.println("Error:Invalid Selection");
		}
		FileOperations();
	}
	

	
	public static void add() throws InvalidPathException {
		System.out.println("Enter file location");
		String input = sc.nextLine();
		Path path;
		try {
			path = Paths.get(input);	
		} catch (Exception e) {
			System.out.println("Error:Invalid Selection");
			return;
		}

		if (!Files.exists(path)) {
			System.out.println("File not found");
			return;
		}else {
			System.out.println("File is found");
			
		}
		
		String newPath = repository + "/" + path.getFileName();
		int i = 0;
		while (Files.exists(Paths.get(newPath))) {
			i++;
			newPath = repository + "/" + i + "_" + path.getFileName();
		}
		
		try {
			Files.copy(path,  Paths.get(newPath));
			System.out.println("File saved");
		} catch (IOException e) {
			System.out.println("Error: File not saved");
			System.out.println(e);
		}

	}
	
	
	
	public static void delete() throws InvalidPathException {
		System.out.println("Enter file location");
		String input = sc.nextLine();
		String Path = repository + "/" + input;
		Path path;
		
		try {
			path = Paths.get(Path);	
		} catch (Exception e) {
			System.out.println("Error:Invalid Selection");
			return;
		}
		
		if (!Files.exists(path)) {
			System.out.println("Error:Invalid Selection");
			return;
		} else {
			System.out.println("File found");
		}
		
		File Delete = new File(Path);
		try {
			Delete.delete();
			System.out.println("File deleted");
		} 
		catch (Exception e) {
	
			System.out.println("Error: File not deleted");
			System.out.println(e);
		}
	}
	

	
	public static void find() throws InvalidPathException{
		System.out.println("Enter the file name");	
		String input = sc.nextLine();
		String Path = repository + "/" + input;
		Path path;
		
		try {
			path = Paths.get(Path);	
		} catch (Exception e) {
			System.out.println("Error:Invalid Selection");
			return;
		}
		
		if(!Files.exists(path)) {
			System.out.println("Error: File not found");
			return;
		} else {
			System.out.println("File Found");
		}

	}
}
