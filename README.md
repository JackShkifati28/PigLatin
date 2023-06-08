# PigLatin

## Description
Our objective is to write a program that would convert any word in English to pig-Latin. Pig-Latin is a secret language often used by children to communicate in code. It works by taking the first letter of each word, moving it to the end, and then adding the letters "ay". If a word starts with a capital letter, then we make it lower case, move it to the end of the word, and convert the second letter to uppercase.

To write this program, we will first need to create a method called `convertWord` with a parameter of an array of strings. This method works by taking one word at a time and converting it to pig-Latin using methods such as `substring`, `charAt`, `indexOf`, and `contains`.

- The `substring` method begins with the character at the specified index and extends to the end of the string. This helps us start each word with the second character and create another substring to move the first character to the end of each word. 

- If the word contains a capital character, we use the `charAt` method to identify the first character of each word and capitalize the second character, making the first one lowercase.

- We use the `contains` method from the String class to check if the word contains any punctuation. The `contains` method in Java checks if a String contains another substring or not. 

- If the word does contain a punctuation, we use the `indexOf` method, which returns the location of a character. This allows us to get the location of the punctuation and move it to the end of each word. 

We will then create another method called `processWord` which will populate the array, send each word to the `convertWord` method, and store the pig-Latin words into a new array. 

We will then create a new method called `countItemsInFile` which will count the number of letters, white spaces, digits, punctuation marks, and all the combined characters.

