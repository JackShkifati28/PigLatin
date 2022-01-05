/**
 * @Auther Yaaqov Shkifati
 * @since 05.10.2020
 * @verison 1.0 
 * Description: Our objective is to write a program that would
 * convert any word in English to pig-Latin. Pig-Latin is a made up language
 * that is used to speak in code. The way it works you take the first letter of
 * each word and place at the end and add the letters "ay". If the word starts
 * with a capital letter than you make into a lower case and move it to the end
 * of the word, and the second letter capital case.
 *
 * The way to write this program we will need to first create a method called
 * convertWord, with a parameter of an array of strings. The way this method
 * works it takes one word at a time and convert it to pig-Latin by using;
 * substring, charAT, indexOf, and contains method. The substring begins with
 * the character at the specified index and extends to the end of this string.
 * This would help because we could start each word with second character and
 * have another substring to move the first character to end of each word. If
 * the word contains a capital character we would us the method charAt to
 * identify the first character of each word and capitalize the second character
 * and lower case the first. Then will use the method contains from the string
 * class that would check to see if the word contains a punctuation. The
 * contains method is Java method to check if String contains another substring
 * or not. If the word does contain a punctuation we would use the indexOf
 * method which returns the location of a character. This way we could get the
 * location of the punctuation and move it to the end of each word. Then will
 * create another method, called processWord, which would populate the array and
 * send each word to convertWord method and store the pig-Latin words into a new
 * array. Then will create new method called countItemsInFile which will count
 * the number; of letters, white spaces , digits, Punctuation marks, and all the
 * Characters combined.
 *
 * Writing this program really helped me with improving the ability of string
 * manipulations. The most difficult part was moving around the punctuation
 * marks to the end of each word. It's because there is no methods of char or
 * String class for any punctuation functions. Therefore, i had look up String
 * class methods and found the contains method that returns true if and only if
 * a string contains char value. I could have also used the endsWith method that
 * tests if this string ends with the specified suffix, both could have worked.
 */
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
