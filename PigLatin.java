package piglatin;

import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

public class PigLatin {

    public static PrintStream latin;

    public static void main(String[] args) throws Exception {

        final int MAXNUMBER = 1000;

        String[] word = new String[MAXNUMBER];

        latin = new PrintStream("word.txt");

        processWords(word);
        countItemsInFile();

    }//End of main

// This method is to converts words to pig latin.
    public static String convertWord(String[] word, int count) {

        char c;
        int punctuation;
        String ay = "ay";
        String pigLatinWord = "";

        for (int i = 0; i < count; i++) {

            // For word starts with a capital letter.
            if (Character.isUpperCase(c = word[i].charAt(0))) {

                pigLatinWord = word[i].substring(1, 2).toUpperCase() + word[i].substring(2) + word[i].substring(0, 1).toLowerCase() + ay;

                // A few words in the paragraph that starts with a capital letter and ends with a comma.
                if (word[i].contains(",")) {

                    punctuation = word[i].indexOf(",");

                    pigLatinWord = word[i].substring(1, 2).toUpperCase() + word[i].substring(2, punctuation) + word[i].substring(0, 1).toLowerCase() + ay + ",";

                }

            } // For words that dosn't start with a capital letter.
            else {

                if (word[i].contains(".")) {

                    punctuation = word[i].indexOf(".");

                    pigLatinWord = word[i].substring(1, punctuation) + word[i].substring(0, 1) + ay + ".";
                } else if (word[i].contains(",")) {

                    punctuation = word[i].indexOf(",");

                    pigLatinWord = word[i].substring(1, punctuation) + word[i].substring(0, 1) + ay + ",";

                } else if (word[i].contains("-")) {

                    punctuation = word[i].indexOf("-");

                    pigLatinWord = word[i].substring(1, punctuation) + word[i].substring(0, 1) + ay + "-";
                } else {

                    pigLatinWord = word[i].substring(1) + word[i].substring(0, 1) + ay;
                }
            }
        }

        return pigLatinWord;
    }// End of convertWord method.

    // This Method to used read the data in and switch each word to pig latain and to count the amount of words.
    public static void processWords(String[] word) throws Exception {

        final int MAXNUMBER = 1000;
        int count = 0, j = 0;
        String[] pigLatinWord = new String[MAXNUMBER];

        Scanner sc = new Scanner(new File("GettyburgsAddress.txt"));

        while (sc.hasNext()) {
            word[count] = sc.next();
            count++;
            pigLatinWord[j] = convertWord(word, count);
            j++;
        }
        for (int i = 0; i < count; i++) {
            if (i % 10 == 0) {
                latin.println();
            }
            latin.printf("%s ", pigLatinWord[i]);

        }
        latin.printf("\n\nNumber of words= %d\n", count);

    }//End of processWord method.

    // This method is used to count the amount of; letters, white spaces, digits, Punctuation marks, and the sum of all the Characters.  
    public static void countItemsInFile() throws Exception {

        int countletters = 0, countPunctuation = 0, countWhiteSpace = 0, countDigit = 0;
        int sumOfAll;
        char c;
        String word;

        Scanner sc2 = new Scanner(new File("GettyburgsAddress.txt"));

        while (sc2.hasNext()) {
            word = sc2.nextLine();

            for (int i = 0; i < word.length(); i++) {

                c = word.charAt(i);

                if (Character.isLetter(c)) {
                    countletters++;
                } else if (Character.isWhitespace(c)) {
                    countWhiteSpace++;
                } else if (Character.isDigit(c)) {
                    countDigit++;
                } else {
                    countPunctuation++;
                }

            }

        }
        sumOfAll = countletters + countWhiteSpace + countDigit + countPunctuation;

        latin.printf("Number of letters=%d\nNumber of Whitespace=%d\n", countletters, countWhiteSpace);

        latin.printf("Number of digits=%d\nNumber of Punctuation=%d\n ", countDigit, countPunctuation);

        latin.printf("Number of all Characters= %d\n", sumOfAll);

    }//End of countItemsInFile method.

}
