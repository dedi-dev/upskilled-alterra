package day4;

import java.util.*;

public class Iterable {
  public static void main(String[] args) {
    // 1. Array Merge
    List<String> list1 = Arrays.asList("abcd", "efg");
    List<String> list2 = Arrays.asList("abcd", "hij");
    System.out.println("1. Array Merge");
    System.out.println(list1 + " + " + list2);
    arrayMerge(list1, list2);
    System.out.println();

    // 2. Angka muncul sekali
    System.out.println("2. Angka muncul sekali");
    onceNumber("11223445667");
    System.out.println();

    // 3. Pair With Target Sum
    List<Integer> listAngka = Arrays.asList(1, 2, 3, 4, 6);
    System.out.println("3. Pair With Target Sum");
    pairSum(listAngka, 6);
    System.out.println();

    // 4. Array Unique
    List<Integer> array1 = Arrays.asList(1, 2, 3, 4, 6);
    List<Integer> array2 = Arrays.asList(1, 2, 4, 5, 7, 8);
    System.out.println("4. Array Unique");
    arrayUniq(array1, array2);
    System.out.println();

    // 5. Remove Duplicate
    List<Integer> array3 = Arrays.asList(1, 1, 2, 2, 4, 5, 7, 7, 7, 8);
    System.out.println("5. Remove Duplicate");
    removeDuplicate(array3);
    System.out.println();

    // 6. Maximum Sum Subarray of Size K"
    List<Integer> array4 = Arrays.asList(2, 3, 4, 1, 5);
    System.out.println("6. Maximum Sum Subarray of Size K");
    maxSumK(array4, 2);
  }

  public static void arrayMerge(List<String> array1, List<String> array2) {
    List<String> merge = new ArrayList<String>();
    for (String text : array1) {
      merge.add(text);
    }
    for (String text : array2) {
      if (merge.contains(text))
        continue;
      merge.add(text);
    }
    System.out.println(merge);
  }

  public static void onceNumber(String angka) {
    HashMap<Character, Integer> result = new HashMap<Character, Integer>();
    for (int i = 0; i < angka.length(); i++) {
      if (result.containsKey(angka.charAt(i))) {
        Integer value = result.get(angka.charAt(i));
        result.replace(angka.charAt(i), value + 1);
      } else {
        result.put(angka.charAt(i), 1);
      }
    }
    ArrayList<Character> onceNumbers = new ArrayList<Character>();
    for (Character key : result.keySet()) {
      if (result.get(key) != 1) {
        continue;
      }
      onceNumbers.add(key);
    }
    System.out.println(angka);
    System.out.println(onceNumbers);
  }

  public static void pairSum(List<Integer> list, int target) {
    List<Integer> result = new ArrayList<Integer>();
    for (int i = 0; i < list.size(); i++) {
      Integer value = list.get(i);
      if (list.contains(target - value)) {
        result.add(i);
        result.add(list.indexOf(target - value));
        break;
      }
    }
    System.out.println("Input: " + list + " target = " + target);
    System.out.println(result);
  }

  public static void arrayUniq(List<Integer> array1, List<Integer> array2) {
    List<Integer> result = new ArrayList<Integer>();
    for (Integer val : array1) {
      if (!array2.contains(val)) {
        result.add(val);
      }
    }
    System.out.println("input " + array1 + " dan " + array2);
    System.out.println(result);
  }

  public static void removeDuplicate(List<Integer> list) {
    HashSet<Integer> result = new HashSet<Integer>(list);
    System.out.println("Input: " + list);
    System.out.println(result.size());
  }

  public static void maxSumK(List<Integer> list, int k) {
    System.out.println(list);
    int result = 0;
    for (int i = 0; i <= list.size() - k; i++) {
      int sum = 0;
      for (int j = 0; j < k; j++) {
        int value = list.get(i + j);
        sum += value;
        System.out.print(value + " ");
      }
      System.out.println("= " + sum);
      if (sum > result) {
        result = sum;
      }
    }
    System.out.println(result);
  }
}
