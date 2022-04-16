package org.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void should_return_anagram_of_input()
    {
        var app = new AnagramResolver();
        app.init();

        String result = app.findAnagramOf("adaman");

        assertEquals("amanda", result);
    }
}
