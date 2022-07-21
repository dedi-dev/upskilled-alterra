package day6;

public class TimeComplexity {
  public static void main(String[] args) {
    isPrime(1000000007);
    isPrime(1500450271);
    System.out.println();
    System.out.println("Exponentiation:");
    System.out.println(pow(2, 3));
    System.out.println(pow(5, 3));
    System.out.println(pow(10, 2));
    System.out.println(pow(2, 5));
    System.out.println(pow(7, 3));
  }

  public static void isPrime(int number) {
    boolean isPrime = true;
    if (number < 2) {
      isPrime = false;
    } else {
      int sqrtNum = (int) Math.sqrt((double) number);
      for (int i = 2; i <= sqrtNum; i++) {
        if (number % i == 0) {
          isPrime = false;
          break;
        }
      }
    }
    if (isPrime) {
      System.out.println(number + " Adalah Bilangan Prima");
    } else {
      System.out.println(number + " Bukan Bilangan Prima");
    }
  }

  public static int pow(int number1, int number2) {
    int result = 1;
    if (number2 > 0 && number2 < 3) {
      for (int i = 1; i <= number2; i++) {
        result *= number1;
      }
    } else if (number2 >= 3) {
      for (int i = 1; i <= number2 / 2; i++) {
        result *= number1 * number1;
      }
      if (number2 % 2 == 1)
        result *= number1;
    }

    return result;
  }
}
