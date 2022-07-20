package day5;

import java.util.Scanner;

public class Abstraction {
  public static int startOrExit;

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    startOrExitSelect(input);
    if (startOrExit == 1) {
      calculator(input);
    } else {
      System.out.println("Keluar dari Calculator");
    }
    input.close();
  }

  public static void startOrExitSelect(Scanner input) {
    System.out.println("++++++++++++++++++++CALCULATOR++++++++++++++++++++");
    System.out.println("1: Open Calculator");
    System.out.println("99: Exit");
    System.out.print("Masukkan pilihan Anda: ");
    startOrExit = input.nextInt();
  }

  public static void calculator(Scanner input) {
    MyCalculator calculator = new MyCalculator();
    System.out.println("++++++++++++++++++++CALCULATOR++++++++++++++++++++");
    System.out.print("Masukkan Value 1 : ");
    calculator.setValue1(input.nextInt());
    System.out.print("Masukkan Value 2 : ");
    calculator.setValue2(input.nextInt());

    System.out.println("++++++++++++++++++++CALCULATOR++++++++++++++++++++");
    System.out.println("Please enter calculation operation:");
    System.out.println("1. Add Value");
    System.out.println("2. Sub Value");
    System.out.println("3. Multiply Value");
    System.out.println("4. Divide Value");
    System.out.println("++++++++++++++++++++CALCULATOR++++++++++++++++++++");
    System.out.print("Pilihan Anda : ");
    int selectedOperation = input.nextInt();
    switch (selectedOperation) {
      case 1:
        calculator.add();
        break;
      case 2:
        calculator.sub();
        break;
      case 3:
        calculator.multiply();
        break;
      case 4:
        calculator.divide();
        break;
      default:
        System.out.println("Pilihan tidak sesuai");
        break;
    }
  }
}

interface Calculator {

  public void add();

  public void sub();

  public void multiply();

  public void divide();
}

class MyCalculator implements Calculator {
  private int value1;
  private int value2;
  private int result;

  public int getValue1() {
    return value1;
  }

  public void setValue1(int value1) {
    this.value1 = value1;
  }

  public int getValue2() {
    return value2;
  }

  public void setValue2(int value2) {
    this.value2 = value2;
  }

  public double getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }

  @Override
  public void add() {
    result = value1 + value2;
    System.out.println("Hasil : " + result);
  }

  @Override
  public void sub() {
    result = value1 - value2;
    System.out.println("Hasil : " + result);
  }

  @Override
  public void multiply() {
    result = value1 * value2;
    System.out.println("Hasil : " + result);
  }

  @Override
  public void divide() {
    result = value1 / value2;
    System.out.println("Hasil : " + result);
  }
}