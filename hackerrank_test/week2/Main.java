package hackerrank_test.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println(findLongestSubsequence(Arrays.asList(2, 4, 1, 7)));
    System.out.println(getMinimumOperations("101"));
    System.out.println(getMinimumOperations("1111"));

    System.out.println(findNumberSequence("LRRLLL"));
  }

  public static int findLongestSubsequence(List<Integer> arr) {
    // Write your code here
    int length = 0;
    for (int i = 0; i <= arr.size(); i++) {
      int sumSub = 0;
      int lengthSub = 0;
      if (i == 0) {
        List<Integer> subSequence = new ArrayList<>();
        for (int j = 0; j < arr.size(); j++) {
          subSequence.add(arr.get(j));
          lengthSub += 1;
        }
        Collections.sort(subSequence);
        for (int k = subSequence.size() - 1; k > 0; k--) {
          sumSub += subSequence.get(k) - subSequence.get(k - 1);
        }
        if (sumSub % 2 == 0 && lengthSub > length) {
          length = lengthSub;
        }
      } else if (i == arr.size()) {
        List<Integer> subSequence = new ArrayList<>();
        for (int j = 0; j < arr.size(); j++) {
          if (j % 2 == 0) {
            subSequence.add(arr.get(j));
            lengthSub += 1;
          }
        }
        Collections.sort(subSequence);
        for (int k = subSequence.size() - 1; k > 0; k--) {
          sumSub += subSequence.get(k) - subSequence.get(k - 1);
        }
        if (sumSub % 2 == 0 && lengthSub > length) {
          length = lengthSub;
        }
      } else {
        List<Integer> subSequence = new ArrayList<>();
        for (int j = 0; j < arr.size(); j++) {
          if (j == 0 || j != i) {
            subSequence.add(arr.get(j));
            lengthSub += 1;
          }
        }
        Collections.sort(subSequence);
        for (int k = subSequence.size() - 1; k > 0; k--) {
          sumSub += subSequence.get(k) - subSequence.get(k - 1);
        }
        if (sumSub % 2 == 0 && lengthSub > length) {
          length = lengthSub;
        }
      }
    }

    return length;
  }

  public static int getMinimumOperations(String binaryStr) {
    // Write your code here
    String str = binaryStr;
    int numOperation = 0;
    List<Character> listChar = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      listChar.add(str.charAt(i));
    }
    for (int i = 0; i < listChar.size() - 1; i++) {
      if (i % 2 == 0) {
        if (listChar.get(i) == '1') {
          numOperation += 1;
          if (listChar.get(i + 1) == '0') {
            numOperation += 1;
            listChar.set(i, '0');
          } else {
            listChar.set(i, '0');
            listChar.set(i + 1, '0');
          }
        }
      }
    }

    if (listChar.size() % 2 != 0) {
      if (listChar.get(listChar.size() - 1) == '1') {
        numOperation += 2;
      }
    }

    return numOperation;
  }

  public static List<Integer> findNumberSequence(String direction) {
    // Write your code here
    List<Integer> result = new ArrayList<>();

    List<Integer> right = new ArrayList<>();
    List<Integer> left = new ArrayList<>();

    for (int i = 0; i < direction.length(); i++) {
      if (direction.charAt(i) == 'R') {
        right.add(i + 1);
      } else {
        left.add(i + 1);
      }
    }

    result.addAll(right);

    for (int i = left.size() - 1; i >= 0; i--) {
      result.add(left.get(i));
    }

    return result;
  }

}