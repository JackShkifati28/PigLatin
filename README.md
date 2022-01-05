# PigLatin

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
