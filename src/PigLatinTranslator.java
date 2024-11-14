import java.lang.*;

public class PigLatinTranslator
{
  public static Book translate(Book input)
  {
    Book translatedBook = new Book();

    // Add code here to populate translatedBook with a translation of the input book.
    // Curent do-nothing code will return an empty book.

    return translatedBook;
  }

  public static String translate(String input) {
    if (input.trim().isEmpty()) {
        return input;
    }

    String[] words = input.split("\\s+");
    String result = "";

    for (String word : words) {
        String punctuation = "";
        int punctuationIndex = word.length() - 1;

        // Handle punctuation at the end of the word
        while (punctuationIndex >= 0 && !Character.isLetterOrDigit(word.charAt(punctuationIndex))) {
            punctuation = word.charAt(punctuationIndex) + punctuation;
            punctuationIndex--;
        }

        // Get the base word without punctuation
        word = word.substring(0, punctuationIndex + 1);

        if (word.trim().length() > 0) {
            // Save the original word to preserve case
            String originalWord = word;

            // Apply Pig Latin rules to the word in lowercase
            String pigLatin = word.toLowerCase();
            boolean isVowel = pigLatin.charAt(0) == 'a' || pigLatin.charAt(0) == 'e' || pigLatin.charAt(0) == 'i' || pigLatin.charAt(0) == 'o' || pigLatin.charAt(0) == 'u';

            if (isVowel) {
                pigLatin += "ay";
            } else {
                int vowelIndex = -1;
                for (int i = 0; i < pigLatin.length(); i++) {
                    if ("aeiou".indexOf(pigLatin.charAt(i)) != -1) {
                        vowelIndex = i;
                        break;
                    }
                }

                if (vowelIndex != -1) {
                    pigLatin = pigLatin.substring(vowelIndex) + pigLatin.substring(0, vowelIndex) + "ay";
                }
            }

            // Now we need to rebuild the word with proper capitalization from originalWord
            StringBuilder finalWord = new StringBuilder();

            // Capitalize the first letter of the transformed word if the original first letter was capitalized
            if (Character.isUpperCase(originalWord.charAt(0))) {
                finalWord.append(Character.toUpperCase(pigLatin.charAt(0))); // Capitalize first letter
            } else {
                finalWord.append(Character.toLowerCase(pigLatin.charAt(0))); // Lowercase if the original first letter was lowercase
            }

            // Rebuild the rest of the word, ensuring only the first vowel and first letter are capitalized (no consonants like 'r' are capitalized)
            for (int i = 1; i < pigLatin.length(); i++) {
                if (i < originalWord.length()) {
                    if (Character.isUpperCase(originalWord.charAt(i)) && pigLatin.charAt(i) == 'h') {
                        finalWord.append(Character.toUpperCase(pigLatin.charAt(i))); // Only capitalize 'h' if it was capitalized in the original
                    } else {
                        finalWord.append(Character.toLowerCase(pigLatin.charAt(i))); // Keep consonants lowercase
                    }
                } else {
                    finalWord.append(pigLatin.charAt(i)); // If the transformed word is longer (e.g., with "ay")
                }
            }

            word = finalWord.toString(); // Final transformed word
        }

        // Append the word with its punctuation and continue
        result += word + punctuation + " ";
    }

    return result.trim();
}








  private static String translateWord(String input)
  {
    // System.out.println("translateWord: '" + input + "'");

    // Replace this code to correctly translate a single word.
    // Start here first!
    String result = input;
    
    return result;
  }

  // Add additonal private methods here.
  // For example, I had one like this:
  // private static String capitalizeFirstLetter(String input)

}