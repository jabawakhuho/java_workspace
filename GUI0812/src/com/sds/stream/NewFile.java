package com.sds.stream;

import java.awt.MenuItem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

import javax.swing.JFileChooser;

public class NewFile extends MenuItem{
	JFileChooser chooser;
	FileReader reader;
	BufferedReader buffr;
	StringWriter writer;
	StringBuffer sb;
	Editor editer;
	
	public NewFile(Editor editer) {
		this.editer = editer;
		chooser = new JFileChooser("C:/java_workspace/GUI0812/res");
		if(chooser.showOpenDialog(this.editer)==JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			try {
				reader = new FileReader(file);
				buffr = new BufferedReader(reader);
				String data;
				sb = new StringBuffer();
				while((data=buffr.readLine()) != null){
					sb.append(data+"\n");
				}
				
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
