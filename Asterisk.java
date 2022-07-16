import java.util.Scanner;

public class Asterisk {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Input Jumlah Baris: ");
    int value = input.nextInt();
    input.close();
    for (int i = 1; i <= value; i++) {
      for (int j = 1; j <= value - i; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= i; k++) {
        System.out.print("* ");
      }
      System.out.println("");
    }
  }
}
