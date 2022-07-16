import java.util.Scanner;

public class FaktorBilangan {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Input Angka Bilangan: ");
    int value = input.nextInt();
    input.close();
    for (int i = 1; i <= value; i++) {
      if (value % i == 0) {
        System.out.println(i);
      }
    }
  }
}
