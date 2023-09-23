package com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] args) throws IOException {
		String mainPath = "C:/";
		
		List<String> programList = searchDir(mainPath, "Program Files", new ArrayList<String>());
		List<String> rarList = new ArrayList<String>();
		
		for(String path:programList) {
			rarList = searchDir(path, "WinRAR", rarList);
		}
		
		System.out.println(programList);
		System.out.println(rarList);
		

	}

	private static List<String> searchDir(String path, String name, List<String> pathList) {

		File[] files = new File(path).listFiles();

		for (File file : files) {
			if (file.isDirectory() && file.getName().indexOf(name) >= 0) {
				pathList.add(file.getPath());
			}
		}

		return pathList;
	}
}
