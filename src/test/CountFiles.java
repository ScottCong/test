package test;

import java.util.Scanner;
import java.io.File;

///Users/cs/Documents/usb 
public class CountFiles {

	public String fileCounter(Criteria c){
		Scanner sc = new Scanner(System.in);
		String path = sc.next();
		System.out.println(path);
		File file = new File(path);
		File[] tmpList = file.listFiles();
		int files = 0;
		int dirs = 0;
		for(int i = 0; i < tmpList.length; i++){
			if(tmpList[i].isFile()){
				files++;
				System.out.println(tmpList[i].getName());
			}
			else if(tmpList[i].isDirectory()){
				dirs++;
				System.out.println(tmpList[i].getName());
			}
		}
		return String.format("files : %d, dirs: %d", files, dirs);
	}
	
	private class Criteria{
		String path;
		String extension;
		boolean includeSubFolder;
		public Criteria(String path, String extension, boolean includeFolder){
			this.path = path;
			this.extension = extension;
			this.includeSubFolder = includeSubFolder;
		}
	}
	
	public static void main(String[] args){
		CountFiles c = new CountFiles();
		Criteria cr = new CountFiles().new Criteria("/Users/cs/Documents", ".txt", false);
		
		System.out.println(c.fileCounter(cr));
	}
}
