package util.test;

import filters.*;
import org.junit.jupiter.api.Test;
import util.Parser;
import util.SyntaxError;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test the parser.
 */
public class TestParser {
    @Test
    public void testBasic() throws SyntaxError {
        Filter f = new Parser("trump").parse();
        assertTrue(f instanceof BasicFilter);
        assertEquals("trump", ((BasicFilter) f).toString());
    }


    @Test
    public void testAnd() throws SyntaxError{
        Filter f = new Parser("john and trump").parse();
        assertTrue(f instanceof AndFilter);
    }

    @Test
    public void testOr() throws SyntaxError{
        Filter f = new Parser("john or trump").parse();
        assertTrue(f instanceof OrFilter);
    }

    @Test
    public void testHairy() throws SyntaxError {
        Filter x = new Parser("trump and (evil or blue) and red or green and not not purple").parse();
        assertEquals("(((trump and (evil or blue)) and red) or (green and not not purple))", x.toString());
    }
}
