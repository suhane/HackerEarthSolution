package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class compareLogs {
	public static void main(String args[]){
		BufferedReader br = null;
		BufferedReader br2 = null;

		try {

			String sCurrentLine;
			int count=0;
			br = new BufferedReader(new FileReader("/Users/suhane/Downloads/mcdplogs"));
			br2 = new BufferedReader(new FileReader("/Users/suhane/Downloads/miologs"));
			
			while ((sCurrentLine = br.readLine()) != null) {
				count++;
				//System.out.println(sCurrentLine);
			}
			System.out.println("Count in mcdp: "+count);
			count=0;
			while ((sCurrentLine = br2.readLine()) != null) {
				count++;
				//System.out.println(sCurrentLine);
			}
			System.out.println("Count in mio: "+count);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
