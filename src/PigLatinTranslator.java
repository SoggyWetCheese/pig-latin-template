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

  public static String translate(String input)
  {
    // System.out.println("Translate String: '" + input + "'");

    // Replace this code to translate a string input.
    // The input to this function could be any English string. 
    // A sentence, paragraph, or a single word. 
    // It should call translateWord at least once.
    String punctuation = "";
    if (input.trim().isEmpty()) {
      return input;
    }
    if (!Character.isLetter(input.charAt(input.length() - 1))) {
      punctuation = input.substring(input.length() - 1);  // Extract punctuation
      input = input.substring(0, input.length() - 1);  // Remove punctuation from input
    }
    if (input.substring(0, 1).equals("a") || input.substring(0, 1).equals("e") || input.substring(0, 1).equals("i") || input.substring(0, 1).equals("o") || input.substring(0, 1).equals("u")){
      input += "ay";
    }
    else {
      int vowelIndex = -1;
      for (int i = 0; i < input.length(); i++) {
          if (input.substring(i, i + 1).equals("a") || input.substring(i, i + 1).equals("e") || 
              input.substring(i, i + 1).equals("i") || input.substring(i, i + 1).equals("o") || 
              input.substring(i, i + 1).equals("u")) {
              vowelIndex = i;
              break;
          }
      }
      if (vowelIndex != -1) {
          input = input.substring(vowelIndex) + input.substring(0, vowelIndex) + "ay";
      }
    }
    String result = translateWord(input);

    return result + punctuation;
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