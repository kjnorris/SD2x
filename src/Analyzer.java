import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {
		List<Sentence> sentences = new ArrayList<Sentence>();

		if (filename != null) {
			try {
				FileReader in = new FileReader(filename);
				BufferedReader buffer = new BufferedReader(in);
				String line;

				while ((line = buffer.readLine()) != null) {

					try {
						String [] wordScore = line.split(" ", 2);

						try {
							Integer score = Integer.parseInt(wordScore[0], 10);
							if ((score >= -2) && (score <= 2)) {
								Sentence sentence = new Sentence(score, wordScore[1]);
								sentences.add(sentence);
							}
						} catch (NumberFormatException e) {
							continue;
							// e.printStackTrace();
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}

				}

				in.close();

			} catch (IOException e) {
				// e.printStackTrace();
			}
		}
		return sentences; // this line is here only so this code will compile if you don't modify it
	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
		Set<Word> words = new HashSet<Word>();
		
		if (sentences != null) {
			try {
				for (Sentence sentence: sentences) {
					if (sentence == null) {
						continue;
					}
					StringTokenizer theseWords = new StringTokenizer(sentence.getText());
					while (theseWords.hasMoreElements()) {
						String candidate = theseWords.nextToken().toLowerCase();
						if (Character.isLetter(candidate.charAt(0))) {
							Word curr = new Word(candidate);
							if (words.contains(curr)) {
								for (Word thisWord: words) {
									if (thisWord.equals(curr)) {
										thisWord.increaseTotal(sentence.getScore());
									}
								}
							} else {
								curr.increaseTotal(sentence.getScore());
								words.add(curr);
							}
						}
					}
				}
			} catch (NullPointerException e) {
				// do nothing
			}
		}
		return words; // this line is here only so this code will compile if you don't modify it
	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {
		Map<String, Double> scores = new HashMap<String, Double>();
		
		if ((words != null) && (!words.isEmpty())) {
			for (Word word: words) {
				if (word != null) {
					String curr = word.getText();
					Double score = word.calculateScore();
					scores.put(curr, score);
				}
			}
		}
		return scores; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		Double score = 0.0;
		
		if ((wordScores != null) && (!wordScores.isEmpty()) && (sentence != null) && (!sentence.isEmpty())) {
			StringTokenizer theseWords = new StringTokenizer(sentence);
			Double totalScore = 0.0;
			int numWords = 0;
			while(theseWords.hasMoreTokens()) {
				String curr = theseWords.nextToken().toLowerCase();
				if (Character.isLetter(curr.charAt(0))) {
					if (wordScores.containsKey(curr)) {
						totalScore += wordScores.get(curr);
						numWords++;
					} else {
						numWords++;
					}
				}
			}
			
			if (numWords == 0) {
				score = 0.0;
			} else {
				score = totalScore / (double) numWords;
			}
			
		}
		return score; // this line is here only so this code will compile if you don't modify it
	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
