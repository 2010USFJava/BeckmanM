package com.revature.loggy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.beanie.Cat;
import com.revature.list.AdoptionList;

public class FileThoseCats {
		public static final String adoptionFile = "adopationList.txt";
		
		//write
		public static void writeAdoptionFile(List<Cat> catList) {
			 try {
				ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(adoptionFile));
				objOut.writeObject(catList);
				objOut.close();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	
		//read
		@SuppressWarnings("unchecked")
		public static void readAdoptionFile() {
			try {
				ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(adoptionFile));
				AdoptionList.adoptionList =(ArrayList<Cat>) objIn.readObject();
				objIn.close();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			}
		}
}
