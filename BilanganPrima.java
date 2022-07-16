import java.util.Scanner;

public class BilanganPrima {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Input Angka Bilangan: ");
    int value = input.nextInt();
    input.close();
    boolean isPrima = value > 1;
    for (int i = 2; i < value; i++) {
      if (value % i == 0) {
        isPrima = false;
        break;
      }
    }

    if (isPrima) {
      System.out.println(value + " Adalah Bilangan Prima");
    } else {
      System.out.println(value + " Bukan Bilangan Prima");
    }
  }
}
