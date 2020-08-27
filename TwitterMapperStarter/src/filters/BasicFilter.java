package filters;

import twitter4j.Status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * A basic filter that matches every tweet that contains the given word
 */
public class BasicFilter implements Filter {
    final private String word;
    final private Pattern pattern;

    public BasicFilter(String word) {
        this.word = word;
        pattern = Pattern.compile("(?i).*" + Pattern.quote(word) + ".*");
    }

    @Override
    public boolean matches(Status s) {
        String text = s.getText();
        return pattern.matcher(text).matches();
    }

    @Override
    public List<String> terms() {

        return Collections.singletonList(word);
    }

    @Override
    public String toString() {
        return word;
    }




}
