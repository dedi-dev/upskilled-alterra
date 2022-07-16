package day3;

import java.util.*;

public class VocalConsonant {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input String: ");
        String text = input.nextLine().toLowerCase();
        input.close();
        List<Character> listVocalChar = Arrays.asList('a', 'i', 'u', 'e', 'o');
        int vocalCount = 0;
        int consonantCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (listVocalChar.contains(ch)) {
                vocalCount++;
            } else {
                consonantCount++;
            }
        }
        System.out.println("Jumlah Vokal = " + vocalCount);
        System.out.println("Jumlah Konsonan = " + consonantCount);
        System.out.println("Total Karakter = " + text.length());
    }
}