package day7.DynamicProgramming;

public class Main {
  public static void main(String[] args) {
    System.out.println("Problem 1 - Fibonacci Number Top-down");
    System.out.println(fibonacci(7));
    System.out.println();

    System.out.println("Problem 2 - Fibonacci Number Bottom-up");
    System.out.println(fibonacci2(7));
    System.out.println();

    System.out.println("Problem 3 - Frog");
    System.out.println(problemFrog(new int[] { 10, 30, 40, 20 }));
    System.out.println(problemFrog(new int[] { 30, 10, 60, 10, 60, 50 }));
    System.out.println();

    System.out.println("Problem 4 - Roman Numerals");
    System.out.println(romanNumerals(10));
    System.out.println(romanNumerals(9));
    System.out.println(romanNumerals(23));
    System.out.println(romanNumerals(2021));
    System.out.println(romanNumerals(1646));
    System.out.println();
  }

  public static int fibonacci(int n) {
    if (n <= 2) {
      return 1;
    } else if (n < 3) {
      return 1;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

  public static int fibonacci2(int n) {
    int num1 = 0;
    int num2 = 1;
    for (int i = 1; i <= n; i++) {
      int prevNum = num1 + num2;
      num1 = num2;
      num2 = prevNum;
      if (i == n) {
        return num1;
      }
    }
    return num1;
  }

  public static int problemFrog(int[] input) {
    int result = 0;
    int result2 = 0;
    for (int i = 0; i < input.length; i++) {
      if ((i + 1) % 2 == 0) {
        continue;
      } else if (i != input.length - 1) {
        if ((i + 2) >= input.length) {
          result += Math.abs(input[i] - input[i + 1]);
        } else {
          result += Math.abs(input[i] - input[i + 2]);
        }
      }
    }
    for (int i = 0; i < input.length; i++) {
      if ((i + 1) % 2 != 0) {
        continue;
      } else if (i != input.length - 1) {
        if (i == 1) {
          result2 += Math.abs(input[0] - input[i]);
        }

        if ((i + 2) >= input.length) {
          result2 += Math.abs(input[i] - input[i + 1]);
        } else {
          result2 += Math.abs(input[i] - input[i + 2]);
        }
      }
    }
    if (result < result2) {
      return result;
    } else {
      return result2;
    }

  }

  public static String romanNumerals(int num) {
    int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] romanLetters = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    String roman = "";
    for (int i = 0; i < values.length; i++) {
      while (num >= values[i]) {
        num = num - values[i];
        roman += romanLetters[i];
      }
    }
    return roman;
  }
}
