import Model.Author;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTest {

    private Main main = new Main();

    @Test
    public void parseAuthorString() {
        String authorName = "John Doe";
        assertEquals(Author.class, main.parseAuthorString(authorName).getClass());
        assertEquals("John", main.parseAuthorString(authorName).getFirstName());
        assertEquals("Doe", main.parseAuthorString(authorName).getLastName());
    }

    @Test
    public void parseAuthorStringMultipleAuthors() {
        String authorNamesString = "H-C Jensen, Peter Hans Kristensen";
        assertEquals(ArrayList.class, main.parseAuthorStringMultipleAuthors(authorNamesString).getClass());
        assertArrayEquals(new int [2], new int [main.parseAuthorStringMultipleAuthors(authorNamesString).size()]);
        assertEquals("Peter Hans", main.parseAuthorStringMultipleAuthors(authorNamesString).get(1).getFirstName());
        assertEquals("Kristensen", main.parseAuthorStringMultipleAuthors(authorNamesString).get(1).getLastName());
    }
}