package day3;

import java.util.Scanner;

public class Exponentiation {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Input Nilai X: ");
    int x = input.nextInt();
    System.out.print("Input Nilai Y: ");
    int y = input.nextInt();
    input.close();
    double result = Math.pow(x, y);
    System.out.println(x + " pangkat " + y + " = " + result);
  }
}
