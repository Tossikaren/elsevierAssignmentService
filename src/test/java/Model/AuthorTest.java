package Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {

    private Author author = new Author("Martin", "Stentoft");

    @Test
    public void getFirstName() {
        assertEquals("Martin", author.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Stentoft", author.getLastName());
    }
}