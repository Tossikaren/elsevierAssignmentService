import Model.Author;

import java.util.ArrayList;

public interface AuthorStringParserInterface {

    /**
     * Metode som splitter en streng op og returnerer et forfatterobjekt med fornavn og efternavn.
     *
     * @param   authorString    Streng med et forfatternavn i formattet "fornavn efternavn" eller "efternavn, fornavn"
     * @return  Returnerer et Author object med et fornavn og efternavn
     */
    Author parseAuthorString(String authorString);

    /**
     * Metode som splitter en streng med flere forfattere i og laver et array med en streng for hver forfatter som så indsættes i metoden #parseAuthorString(String) og returnerer en liste med Author objekter med fornavn og efternavn.
     * @param   authorsString   Streng med flere forfatternavne der er sepereret med komma
     * @return  Returnerer en arraylist med Author objekter med fornavn og efternavn
     * @see     #parseAuthorString(String)
     * {@link   #parseAuthorString}
     */
    ArrayList<Author> parseAuthorStringMultipleAuthors(String authorsString);

}
