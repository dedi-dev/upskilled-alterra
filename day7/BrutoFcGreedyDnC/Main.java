package day7.BrutoFcGreedyDnC;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    int[] list = { 1, 1, 3, 5, 5, 6, 7 };
    System.out.println(binarySearch(list, 5, 0, list.length - 1));
    System.out.println();

    System.out.println(moneyChange(123));
    System.out.println(moneyChange(432));
    System.out.println();

    System.out.println(simleEquation(6, 6, 14));
    System.out.println();

    System.out.println(chopDragonHead(new int[] { 5, 4 }, new int[] { 7, 8, 4 }));
    System.out.println(chopDragonHead(new int[] { 5, 10 }, new int[] { 5 }));
    System.out.println(chopDragonHead(new int[] { 7, 2 }, new int[] { 4, 3, 1, 2 }));
    System.out.println(chopDragonHead(new int[] { 7, 2 }, new int[] { 2, 1, 8, 5 }));
  }

  public static int binarySearch(int[] list, int x, int low, int high) {
    if (low > high) {
      return -1;
    } else {
      int mid = (low + high) / 2;
      if (x == list[mid]) {
        return mid;
      } else if (x > list[mid]) {
        return binarySearch(list, x, mid + 1, high);
      } else {
        return binarySearch(list, x, low, mid - 1);
      }
    }
  }

  public static List<Integer> moneyChange(int input) {
    List<Integer> result = new ArrayList<>();
    List<Integer> eachMoney = Arrays.asList(1, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000);
    int moneyLeft = input;
    if (moneyLeft == 0) {
      result.add(moneyLeft);
      return result;
    } else {
      int high = input > 200 ? eachMoney.size() - 1 : eachMoney.size() / 2;
      for (int i = high; i >= 0; i--) {
        while (moneyLeft > eachMoney.get(i)) {
          result.add(eachMoney.get(i));
          moneyLeft -= eachMoney.get(i);
        }
      }
    }
    if (moneyLeft == 1) {
      result.add(moneyLeft);
    }
    return result;
  }

  public static String simleEquation(int inputA, int inputB, int inputC) {
    int a = inputA;
    int b = 1;
    int c = 0;

    int[] result = new int[3];
    String resultString = "";
    int valueA = a;
    for (int i = result.length - 1; i >= 0; i--) {
      if (i == 0) {
        result[i] = valueA;
        b *= result[i];
        c += result[i] * result[i];
      } else {
        if (valueA % 2 == 1) {
          result[i] = (valueA / 2) + 1;
          b *= result[i];
          c += result[i] * result[i];
        } else {
          result[i] = valueA / 2;
          b *= result[i];
          c += result[i] * result[i];
        }
        valueA -= result[i];
      }
    }

    for (int i : result) {
      resultString += i + " ";
    }
    if (b != inputB && c != inputC) {
      return "No solution.";
    } else {
      return resultString;
    }
  }

  public static String chopDragonHead(int[] dragonHeads, int[] knightHeights) {
    List<Integer> knightWinners = new ArrayList<>();
    int minTotalHeight = 0;
    Arrays.sort(dragonHeads);
    Arrays.sort(knightHeights);

    for (int i = 0; i < dragonHeads.length; i++) {
      for (int j = 0; j < knightHeights.length; j++) {
        if (dragonHeads[i] <= knightHeights[j]) {
          knightWinners.add(knightHeights[j]);
          minTotalHeight += knightHeights[j];
          break;
        }
      }
      if (knightWinners.size() == dragonHeads.length) {
        return "" + minTotalHeight;
      }
    }
    return "knight fall";
  }

}
