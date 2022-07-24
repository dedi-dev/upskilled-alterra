package hackerrank_test.week1;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println(lastLetters("APPLES"));
    System.out.println();

    System.out.println(smallestString(Arrays.asList("c", "cc", "cca", "cccb")));

    System.out.println(maximumSum(Arrays.asList(-1, 3, 4, -2, 5, -7)));
    System.out.println(maximumSum(Arrays.asList(4, -1, -2, 1, 3)));
    System.out.println(maximumSum(Arrays.asList(4, 1, 2, 3, 4)));

    maxSubArray(Arrays.asList(4, -1, -2, 1, 3));
    maxSubArray(Arrays.asList(4, 1, 2, 3, 4));
  }

  public static String lastLetters(String word) {
    String result = "";

    result += word.charAt(word.length() - 1) + " ";
    result += word.charAt(word.length() - 2);

    return result;
  }

  public static String smallestString(List<String> substrings) {
    String result = "";
    for (int i = 0; i < substrings.size(); i++) {
      for (int j = i + 1; j < substrings.size(); j++) {
        if (((substrings.get(i) + substrings.get(j)).compareTo(substrings.get(j) + substrings.get(i))) > 0) {
          String temp = substrings.get(i);
          substrings.set(i, substrings.get(j));
          substrings.set(j, temp);
        }
      }
    }

    for (String string : substrings) {
      result += string;
    }
    return result;
  }

  public static long maximumSum(List<Integer> arr) {
    long result = 0;
    int resultInt = 0;
    int max = arr.get(1);
    int indexMax = 1;
    boolean minusBetween = false;

    for (int i = 2; i < arr.size(); i++) {
      if (arr.get(i) > max) {
        max = arr.get(i);
        indexMax = i;
      }
    }

    if (arr.get(1) >= 0) {
      minusBetween = true;
      for (int i = 1; i <= indexMax; i++) {
        resultInt += arr.get(i);
      }
    } else {
      for (int i = 2; i < indexMax; i++) {
        if ((arr.get(i) < 0) && (arr.get(i - 1) > 0)) {
          minusBetween = true;
          break;
        }
      }
    }

    if (!minusBetween) {
      resultInt = 0;
      for (int i = indexMax; i > 0; i--) {
        if (arr.get(i) > 0) {
          resultInt += arr.get(i);
        }
      }
    }
    result = (long) resultInt;
    return result;
  }

  public static int maxSubArray(List<Integer> arr) {
    int maximumSubArraySum = 0;
    int start = 1;
    int end = 0;

    for (int left = 1; left < arr.size(); left++) {

      int runningWindowSum = 0;

      for (int right = left; right < arr.size(); right++) {
        runningWindowSum += arr.get(right);

        if (runningWindowSum > maximumSubArraySum) {
          maximumSubArraySum = runningWindowSum;
          start = left;
          end = right;
        }
      }
    }
    System.out.println("Found Maximum Subarray between " + start + " " + end);
    System.out.println(maximumSubArraySum);
    return maximumSubArraySum;
  }
}
