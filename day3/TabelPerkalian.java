package day3;

import java.util.Scanner;

public class TabelPerkalian {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Input Jumlah Baris/Kolom: ");
    int value = input.nextInt();
    input.close();
    for (int i = 1; i <= value; i++) {
      for (int j = 1; j <= value; j++) {
        System.out.print(j * i + " ");
      }
      System.out.println("");
    }
  }
}
