// -----------------------------------------------------
// Assignment 4
// Question: PART I, Wordlist.java
// Written by: Fouad Serradj | ID : 40009794
// ---------------------------------------------

import java.util.*;


public class Wordlist {
	
	// defining some constant to work with 
	private static final int LENGTH_STOPWORD = 4;
	private static final int FREQUENCY_STOPWORD = 10;
	
	
	// defining inner class wordInfo contains the required information about any word in the input file
	class WordInfo{
		
		int frequency ;
		String word ;
		
		WordInfo(String s){
			word = s ;
			frequency = 1 ;
		}
	}
	
	// defining an ArrayList of WordInfo parameter type since it s a structure type that will allow us the change the size dynamically
	
	ArrayList<WordInfo> List = new ArrayList<WordInfo>() ;
	
	// Method to add word created dynamically using an input string, if the string/word exists already then the frequency is incremented
	void addWord(String s) {
	
		for(int i=0; i < List.size() ; i++) {
			if(s.compareTo(List.get(i).word) == 0) {
				List.get(i).frequency ++ ;
				return ;
			}
		}
		List.add(new WordInfo(s));
	}
	
	
	public int getDistinctCount() {
		return List.size();
	}
	
	// Method to return the number of happax words
	public int happaxWordNbr() {
		
		int nb = 0 ;
		for (WordInfo n:List) 
			if(n.frequency == 1) {
				nb++ ;
			}
		
		return nb ;
	}
	
	public int stopWordNbr() {
		
		int nb = 0 ;
		for(WordInfo n:List) 
			
			if(n.frequency >= FREQUENCY_STOPWORD && n.word.length() <= LENGTH_STOPWORD ) {
				nb++ ;
			}
		return nb ;
	}
	
	public int stopTotalFrequency() {
		int nb = 0 ;
		for(WordInfo n:List) {
			if(n.frequency >= FREQUENCY_STOPWORD && n.word.length() <= LENGTH_STOPWORD  ) {
				nb = nb + n.frequency ;
			}
		}
		
		return nb ;
	}
	
	// Method to sort output frequencies 
	
	public void sortFrequency() {
		for(int i = 0; i < List.size(); i++) {
			int max = i ;
			for(int j = i+1; j<List.size(); j++) {
				if(List.get(j).frequency > List.get(max).frequency) {
					max = j;
				}
			}
			if(max != i) {
				WordInfo temp = List.get(i);
				List.set(i, List.get(max));
				List.set(max, temp);
			}
		}
	}
	
	
	// Method to display the results of the words scanning 
	public void outputResult() {
		{
			System.out.println("-----------------------------");
			System.out.printf("%-10s %-10s %-20s\n", "RANK", "FREQ", "WORD");
			System.out.println("-----------------------------");
			for(int i = 0; i < List.size(); i++)
			{
			System.out.printf("%-10d %-10d %-20s\n", (i+1), List.get(i).frequency, List.get(i).word);
			}
			System.out.println("---------------------------------");
			System.out.println();
			}
	}
	
	
	
	
	
}
