package linter;

import org.junit.Rule;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static linter.Linter.linterJS;
import static org.junit.Assert.*;

public class LinterTest {

    // Test empty file
    @Test
    public void testLinterJSEmpty() {
        Linter test = new Linter();
        List<String> expected = new ArrayList<>();

        assertEquals("Nothing to return.", expected ,
                linterJS("src/main/resources/emptyFile.js"));
    }

    // Test file with few errors
    @Test
    public void testLinterJSFewErrors() {
        Linter test = new Linter();
        List<String> expected = new ArrayList<>();
        expected.add("Line 5: Missing semicolon.");
        expected.add("Line 11: Missing semicolon.");
        expected.add("Line 15: Missing semicolon.");

        assertEquals("Should return few errors.", expected ,
                linterJS("src/main/resources/fewErrors.js"));
    }

    // Test file with few errors
    @Test
    public void testLinterJSManyErrors() {
        Linter test = new Linter();
        List<String> expected = new ArrayList<>();
        expected.add("Line 3: Missing semicolon.");
        expected.add("Line 5: Missing semicolon.");
        expected.add("Line 11: Missing semicolon.");
        expected.add("Line 13: Missing semicolon.");
        expected.add("Line 15: Missing semicolon.");

        assertEquals("Should return many errors.", expected ,
                linterJS("src/main/resources/manyErrors.js"));
    }

    // Test file with no errors
    @Test
    public void testLinterJSNoError() {
        Linter test = new Linter();
        List<String> expected = new ArrayList<>();
        assertEquals("Nothing to return.", expected ,
                linterJS("src/main/resources/noError.js"));
    }

    // Test file with one error
    @Test
    public void testLinterJSOneError() {
        Linter test = new Linter();
        List<String> expected = new ArrayList<>();
        expected.add("Line 3: Missing semicolon.");
        assertEquals("Should return one error.", expected ,
                linterJS("src/main/resources/oneError.js"));
    }



}
