import java.util.ArrayList;

public class Main {

    private static String[] authorNamesArray = {
            "John Doe",
            "Doe, John",
            "Hans-Christian Jensen",
            "H-C Jensen",
            "P. H. Kristensen",
            "Kristensen, P. H.",
            "Peter Hans Kristensen",
            "Peter H. Kristensen"
    };

    private static String authorNamesString = "H-C Jensen, Peter Hans Kristensen, John Doe";

    public static void main(String[] args) {

        AuthorStringParser authorStringParser = new AuthorStringParser();

        //parse hver enkelt streng i array'et og returner et forfatterobjekt med fornavn og efternavn. Det kan så sendes videre til andre dele af systemet, men her looper jeg det bare lige ud så man kan se fornavn og efternavn på hvert objekt i run vinduet
        for (int i = 0; i < authorNamesArray.length; i++) {
            Author author = authorStringParser.parseAuthorString(authorNamesArray[i]);
            System.out.println("First name: " + author.getFirstName() + " Last name: " + author.getLastName());
        }

        System.out.println("\n");

        //parser strengen med flere forfattere og returnerer en liste med forfatterobjekter som jeg så looper ud som ved ovenstående
        ArrayList<Author> authorList = authorStringParser.parseAuthorStringMultipleAuthors(authorNamesString);
        for (int i = 0; i < authorList.size(); i++) {
            System.out.println("First name: " + authorList.get(i).getFirstName() + " Last name: " + authorList.get(i).getLastName());
        }
    }
}
