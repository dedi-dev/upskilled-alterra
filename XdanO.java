import java.util.Scanner;

public class XdanO {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Input Text X dan O: ");
    String text = input.nextLine().toLowerCase();
    input.close();
    int valueX = 0;
    int valueO = 0;

    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == 'o') {
        valueO++;
      } else if (text.charAt(i) == 'x') {
        valueX++;
      }
    }
    System.out.println(valueO == valueX ? true : false);
  }
}
