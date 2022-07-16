import java.util.Scanner;

public class Palindrome {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Input String untuk cek palindrome atau bukan: ");
    String text = input.nextLine();
    input.close();
    String reverseText = "";
    for (int i = text.length() - 1; i >= 0; i--) {
      reverseText += text.charAt(i);
    }
    boolean isPalindrome = text.equals(reverseText);
    System.out.println(isPalindrome ? text + " adalah Palindrome" : text + " bukan Palindrome");
  }
}
