import java.util.ArrayList;

public class AuthorStringParser {

    //Metode som splitter en streng op og returnerer et forfatterobjekt med fornavn og efternavn. Først undersøges om strengen indeholder et komma da fornavn og efternavn i så fald skal byttes om. Dette ville selvfølgelig ikke være muligt hvis alle strengene havde kommasepareret fornavn og efternavn.
    public Author parseAuthorString(String authorString){
        String firstName = null;
        String surName = null;
        try {
            if (authorString.contains(",")) {
                firstName = authorString.split(", ")[authorString.split(",").length - 1];
                surName = authorString.substring(0, authorString.length() - (firstName.length() + 2));
            } else {
                surName = authorString.split(" ")[authorString.split(" ").length - 1];
                firstName = authorString.substring(0, authorString.length() - (surName.length() + 1));
            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("Parsing string with author name " + authorString + ": " + indexOutOfBoundsException);
        }
        return new Author(firstName, surName);
    }

    //Metode som splitter en streng med flere forfattere i op og laver et array med en streng for hver forfatter som så indsættes i ovenstående metode og returnerer en liste med forfatterobjekt med fornavn og efternavn.
    public ArrayList<Author> parseAuthorStringMultipleAuthors(String authorsString){
        ArrayList authorList = new ArrayList();
        String[] authorsStringSplitToArray = authorsString.split(", ");
        for (int i = 0; i < authorsStringSplitToArray.length; i++) {
            Author author = parseAuthorString(authorsStringSplitToArray[i]);
            authorList.add(author);
        }
        return authorList;
    }
}
