package algos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class PermutationGenerator {
  private static final Predicate<String> ALPHABETIC = Pattern.compile("[a-zA-Z]").asPredicate();

  public List<String> letterCase(final String input) {
    if (input == null || input == "") return new ArrayList<>();
    return generateCasePermutations(input);
  }

  private List<String> generateCasePermutations(final String input) {
    return generateCasePermutations(input, 0, "", new ArrayList<String>());
  }

  private List<String> generateCasePermutations(final String input,
    final int idx, final String current, final List<String> output) {
    if (idx == input.length()) {
      output.add(current);
      return output;
    }
    final String head = input.substring(idx, idx + 1);
    if (ALPHABETIC.test(head)) {
      generateCasePermutations(input, idx + 1, current + head.toLowerCase(), output);
      generateCasePermutations(input, idx + 1, current + head.toUpperCase(), output);
    } else {
      generateCasePermutations(input, idx + 1, current + head, output);
    }
    return output;
  }
}