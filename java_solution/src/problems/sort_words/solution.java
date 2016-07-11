package problems.sort_words;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given 2 arrays.
 *   and first array is a list of words.
 *   and second array is a list of valid indexes for the first array.
 *  When I try to use the indexes from second array to build a word from the word array.
 *  Then I get a list of words (3rd array).
 */
public class solution {
    private void doIt() {
        final int BLANK_WORD_INDEX = -1;

        ArrayList<String> list = new ArrayList<String>() {{
            add("This");
            add("That");
            add("and");
            add("the");
            add("other");
        }};

        ArrayList<Integer> order = new ArrayList<Integer>() {{
            add(-1);
            add(0);
            add(1);
            add(-1);
            add(2);
            add(3);
            add(-1);
            add(4);
        }};

        LinkedList<String> output = new LinkedList<>();
        order.forEach(wordIndex-> output.add(wordIndex != BLANK_WORD_INDEX ? list.get(wordIndex) : ""));

        System.out.println(output);
    }

    public static void main(String args[]) {
        new solution().doIt();
    }
}
