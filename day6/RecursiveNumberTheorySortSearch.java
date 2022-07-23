package day6;

import java.util.*;

public class RecursiveNumberTheorySortSearch {
  public static void main(String[] args) {
    System.out.println("Bilangan Prima ke X");
    System.out.println(primeX(1));
    System.out.println(primeX(5));
    System.out.println();

    System.out.println("Fibonacci ke X");
    System.out.println(fibonacciX(10));

    System.out.println();
    minMaxNum(Arrays.asList(5, 7, 4, -2, -1, 8));

    System.out.println("Most Appear Item");
    mostAppearItem(Arrays.asList("go", "java", "go", "go", "java", "dart"));

    System.out.println("Max Buy Product");
    maxBuyProduct(Arrays.asList(25000, 25000, 10000, 14000), 50000);
    maxBuyProduct(Arrays.asList(15000, 10000, 12000, 5000, 3000), 30000);
  }

  public static int primeX(int n) {
    List<Integer> listPrime = new ArrayList<>();
    for (int i = 2; listPrime.size() < n; i++) {
      boolean isPrime = true;
      int sqrtNum = (int) Math.sqrt((double) i);
      for (int j = 2; j <= sqrtNum; j++) {
        if (i % j == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime)
        listPrime.add(i);
    }
    return listPrime.get(listPrime.size() - 1);
  }

  public static int fibonacciX(int n) {
    if (n == 1) {
      return 0;
    } else if (n < 3) {
      return 1;
    } else {
      return fibonacciX(n - 1) + fibonacciX(n - 2);
    }
  }

  public static void minMaxNum(List<Integer> listValue) {
    int min = listValue.get(0);
    int indexMin = 0;
    int max = listValue.get(0);
    int indexMax = 0;

    for (int i = 0; i < listValue.size(); i++) {
      int value = listValue.get(i);
      if (value < min) {
        min = value;
        indexMin = i;
      } else if (value > max) {
        max = value;
        indexMax = i;
      }
    }

    System.out.println("Min: " + min + ", index: " + indexMin);
    System.out.println("Max: " + max + ", index: " + indexMax);
  }

  public static void mostAppearItem(List<String> listWord) {
    Map<String, Integer> result = new HashMap<>();
    for (String string : listWord) {
      if (result.containsKey(string)) {
        result.replace(string, result.get(string) + 1);
      } else {
        result.put(string, 1);
      }
    }
    for (String key : result.keySet()) {
      System.out.print(key + " -> " + result.get(key) + ", ");
    }
    System.out.println();
  }

  public static void maxBuyProduct(List<Integer> listPrice, Integer money) {
    Map<Integer, List<Integer>> result = new HashMap<>();
    int maksimumBuy = 0;
    for (int i = 0; i < listPrice.size(); i++) {
      List<Integer> buy = new ArrayList<>();
      Integer total = listPrice.get(i);
      buy.add(listPrice.get(i));
      for (int j = 0; j < listPrice.size(); j++) {
        if (total >= money)
          break;
        if (i == j)
          continue;

        if (total + listPrice.get(j) <= money) {
          total = total + listPrice.get(j);
          buy.add(listPrice.get(j));
        }
      }
      result.put(i, buy);
      if (buy.size() > maksimumBuy)
        maksimumBuy = buy.size();
    }
    System.out.println(result);
    System.out.println(maksimumBuy);
  }
}
