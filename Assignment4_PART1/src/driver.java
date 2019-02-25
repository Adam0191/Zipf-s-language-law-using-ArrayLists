// -----------------------------------------------------
// Assignment 4
// Question: PART I, Driver.java
// Written by: Fouad Serradj | ID : 40009794
// ---------------------------------------------
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class driver {

	private static boolean isValidWord(String w){
		
	
		for(int i = 0; i < w.length(); i++) {
			if(!Character.isAlphabetic(w.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	private static void outputStats(Wordlist list, int wordsNbr) {
		
		list.sortFrequency();
		list.outputResult();
		int Distinct = list.getDistinctCount();
		int NbHappax = list.happaxWordNbr();
		int NbStops = list.stopWordNbr();
		int FrenquencyStops = list.stopTotalFrequency();
		System.out.println("Nbr of word tokens: " + wordsNbr);
		System.out.println("Nbr of word types: " + Distinct);
		System.out.println("\nNbr of Happax: " + NbHappax);
		System.out.println("% of Happax: " + (int)(NbHappax * 100/Distinct) + "%");
		System.out.println("Happax account for: " + (int)(NbHappax * 100/wordsNbr) + "% of the text \n");
		System.out.println("\nNb of stop words: " + NbStops);
		System.out.println("% of stop words: " + (int)(NbStops * 100/Distinct) + "%");
		System.out.println("Stop words account for: " + (int)(FrenquencyStops * 100/wordsNbr) + "% of the text \n");
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		String file ;
		System.out.println("please enter the name of input file (don't forget the extension .txt :) )");
		
		file = kb.nextLine();
		
		try {
			Scanner sc = new Scanner(new FileInputStream(file));
			String w ;
			int WordsNb = 0 ;
			Wordlist wl = new Wordlist();
			
			while(sc.hasNext()) {
				w = sc.next();
				if(!isValidWord(w)) {
					
					continue ;
				}
				
				WordsNb ++ ;
				wl.addWord(w);
			}
			
			sc.close();
			outputStats(wl,WordsNb);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}







