import Model.Author;

import java.util.ArrayList;

public class Main implements AuthorStringParserInterface{

    public static void main(String[] args) {
        String[] authorNamesArray = {
                "John Doe",
                "Doe, John",
                "Hans-Christian Jensen",
                "H-C Jensen",
                "P. H. Kristensen",
                "Kristensen, P. H.",
                "Peter Hans Kristensen",
                "Peter H. Kristensen"
        };

        String authorNamesString = "H-C Jensen, Peter Hans Kristensen, John Doe";

        Main main = new Main();

        //parser hver enkelt streng i array'et og returner et forfatterobjekt med fornavn og efternavn. Det kan så sendes videre til andre dele af systemet, men her looper jeg det bare lige ud så man kan se fornavn og efternavn på hvert objekt i run vinduet
        for (String authorName : authorNamesArray) {
            Author author = main.parseAuthorString(authorName);
            System.out.println(author.toString());
        }

        System.out.println("\n");

        //parser strengen med flere forfattere og returnerer en liste med forfatterobjekter som jeg så looper ud som ved ovenstående
        ArrayList<Author> authorList = main.parseAuthorStringMultipleAuthors(authorNamesString);

        for (Author author : authorList) {
            System.out.println(author.toString());
        }
    }

    /**
     * @param authorString Streng med et forfatternavn i formattet "fornavn efternavn" eller "efternavn, fornavn"
     * @return {@inheritDoc}
     * @throws IndexOutOfBoundsException Hvis der kun er fornavn eller efternavn
     * @throws NullPointerException hvis authorString er null
     */
    public Author parseAuthorString(String authorString){
        String firstName = null;
        String surName = null;
        try {
            if (authorString != null) {
                if (authorString.contains(",")) {
                    firstName = authorString.split(", ")[authorString.split(",").length - 1];
                    surName = authorString.substring(0, authorString.length() - (firstName.length() + 2));
                } else {
                    surName = authorString.split(" ")[authorString.split(" ").length - 1];
                    firstName = authorString.substring(0, authorString.length() - (surName.length() + 1));
                }
            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("Parsing string with author name " + authorString + " but got IndexOutOfBoundsException: " + indexOutOfBoundsException);
        } catch (NullPointerException nullPointerException){
            //TODO: Hvordan notificeres frontend udvikleren hvis der opstår en exception?
        }
        return new Author(firstName, surName);
    }


    /**
     * @param authorsString Streng med flere forfatternavne der er sepereret med komma
     * @return {@inheritDoc}
     * @see     #parseAuthorString(String)
     */
    public ArrayList<Author>parseAuthorStringMultipleAuthors(String authorsString){
        ArrayList<Author> authorList = new ArrayList<>();
        if(authorsString != null){
            String[] authorsStringSplitToArray = authorsString.split(", ");
            for (String authorStringFromSplit : authorsStringSplitToArray) {
                Author author = parseAuthorString(authorStringFromSplit);
                authorList.add(author);
            }
        }
        return authorList;
    }
}
