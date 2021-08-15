package com.lockedMe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeProject 
{
	static final String FolderPath = "D:\\Project1\\LockedFiles";

	public static void main(String[] args) 
	{
		int flag = 1;
		do 
		{
			// Variable declaration
			int choice;

			// calling menu method
			choice = displayMenu();

			switch (choice) 
			{
			case 1:
				getAllFiles();
				break;

			case 2:
				appendFile();
				break;

			case 3:
				deleteFile();
				break;

			case 4:
				searchFile();
				break;

			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Options");
			}

		} while (flag > 0);

	}

	public static int displayMenu() 
	{
		int choice;
		System.out.println("**************************************************");
		System.out.println("\t\tLockers Pvt. Ltd.");
		System.out.println("**************************************************");
		System.out.println("1. Display All Files");
		System.out.println("2. Add New Files");
		System.out.println("3. Delete a File");
		System.out.println("4. Search a file");
		System.out.println("5. Exit");
		System.out.println("*************************");

		Scanner obj = new Scanner(System.in);
		System.out.println("Enter your choice :");
		choice = Integer.parseInt(obj.nextLine());
		return choice;
	}

	public static void getAllFiles() 
	{
		// Get file names
		List<String> fileNames = FileOrganization.getAllFiles(FolderPath);

		if (fileNames.size() == 0)
			System.out.println("Folder is empty");
		else {
			System.out.println("File list is below:\n");
			for (String s : fileNames)
				System.out.println(s);

		}

	}

	public static void appendFile() 
	{
		// Variable declaration
		String fileName;
		int linesCount;

		List<String> content = new ArrayList<String>();

		Scanner obj = new Scanner(System.in);

		// Read Filename from user
		System.out.println("Enter the file name");
		fileName = obj.nextLine();

		// Read number of lines from user
		System.out.println("number of lines in the file");
		linesCount = Integer.parseInt(obj.nextLine());

		for (int i = 1; i <= linesCount; i++) {
			System.out.println("Enter line" + i + ":");
			content.add(obj.nextLine());
		}
		// Save content into the file
		boolean isSaved = FileOrganization.appendFile(FolderPath, fileName, content);

		if (isSaved)
			System.out.println("Data saved successfully");
		else
			System.out.println("Process got failed.Please contact to Admin");

	}

	public static void deleteFile() 
	{
		String fileName;
		Scanner obj = new Scanner(System.in);
		System.out.println("enter file to be deleted:");
		fileName = obj.nextLine();
		boolean isDeleted = FileOrganization.deleteFile(FolderPath, fileName);

		if (isDeleted)
			System.out.println("File deleted Successfully");
		else
			System.out.println("Process got failed.Please contact to Admin");

	}

	public static void searchFile() 
	{
		String fileName;
		Scanner obj = new Scanner(System.in);

		// Code for searching a file in the folderPath
		System.out.println("Enter the file name to search");
		fileName = obj.nextLine();
		boolean isSearch = FileOrganization.searchFile(FolderPath, fileName);

		if (isSearch)
			System.out.println("File found in the folder");
		else
			System.out.println("File not found");

	}

}
