package com.lockedMe;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileOrganization 
{
	/**
	 * This method will return the file names from the folder
	 * @param FolderPath
	 * @return
	 */
  public static List<String> getAllFiles(String FolderPath)
  {
	  //Creating File object
	  File f1 = new File(FolderPath);
	  
	  // List of Files into FileArray
	  File[] listofFiles = f1.listFiles();
	  
	  //Define a list to store file names
	  List<String> fileNames = new ArrayList<String>();
	  
	  for(File f:listofFiles) 
		  fileNames.add(f.getName());
		  
	  // return the list
	  return fileNames;
  }
  /**
   * This method will append the file in the directory
   * @param FolderPath
   * @param Filename
   * @param content
   * @return
   */
  public static boolean appendFile (String FolderPath,String filename,List<String> content)
  {
	  try 
	  {
		  //Create File object with Folderpath and File name parameters
		  File f1 = new File(FolderPath,filename);
		  
		  FileWriter fw = new FileWriter(f1);
		  
		  for(String s:content) 
		  {  
			fw.write(s+"\n");
	      }
		  fw.close();
		  return true;
	  }	  
	  catch(Exception Ex)
	  {
		  return false;
	  }
  }
  
 /**
  * This method will delete the file name if it exists
  * @param FolderPath
  * @param fileName
  * @return
  */
  public static boolean deleteFile(String FolderPath,String fileName) 
  {
	  //adding folder path with filename and creating file object
	File file = new File(FolderPath+"\\"+fileName);
	
	try
	{
		if(file.delete())
			return true;
		else
			return false;
	}
	catch(Exception Ex)
	{
		return false;
	}
  }

  /**
   * This method will search the filename in the folderpath
   * @param FolderPath
   * @param fileName
   * @return
   */
  public static boolean searchFile(String FolderPath,String fileName) 
  {
	  //adding folderpath with filename and creating file object
	File file = new File(FolderPath+"\\"+fileName);
	
	try
	{
		if(file.exists())
			return true;
		else
			return false;
	}
	catch(Exception Ex)
	{
		return false;
	}
  }

}
