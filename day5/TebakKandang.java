package day5;

import java.util.*;

public class TebakKandang {

  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String CLEAR_CONSOLE = "\033[H\033[2J";

  public static int startSelected;
  public static HashMap<Integer, Kandang> tebakKandang;

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    startMenu(input);
    if (startSelected == 1) {
      playGame(input);
    } else {
      System.out.print(CLEAR_CONSOLE);
      System.out.println("Exit");
      System.out.flush();
    }
    input.close();
  }

  public static void startMenu(Scanner input) {
    System.out.println("---------------------------------------");
    System.out.println(ANSI_BLUE + "            Tebak Kandang" + ANSI_RESET);
    System.out.println("---------------------------------------");
    System.out.println("1. Jumlah Kandang");
    System.out.println("99. Exit");
    System.out.println("---------------------------------------");
    System.out.print("Pilih Menu: ");
    int select = input.nextInt();
    startSelected = select;
  }

  public static void playGame(Scanner input) {
    System.out.print(CLEAR_CONSOLE);
    System.out.print("Masukkan Jumlah Kandang: ");
    int jmlKandang = input.nextInt();
    tebakKandang = initKandang(jmlKandang);
    boolean hasWrong = !checkIsAllTrue(tebakKandang);
    while (hasWrong) {
      showDaftarKandang(tebakKandang);
      System.out.print("Pilih Kandang yang ingin dibuka: ");
      int pilihKandang = input.nextInt();
      System.out.println("---PILIHAN---");
      System.out.println(ANSI_BLUE + "K" + ANSI_RESET + ": Kambing");
      System.out.println(ANSI_RED + "Z" + ANSI_RESET + ": Zebra");
      System.out.println(ANSI_YELLOW + "B" + ANSI_RESET + ": Bebek");
      System.out.print("Masukkan Tebakan: ");
      String inputTebakan = input.next();
      percobaanBuka(tebakKandang, pilihKandang);
      if (isSame(inputTebakan, tebakKandang.get(pilihKandang).initial())) {
        System.out.println(ANSI_GREEN + "Tebakan Benar!" + ANSI_RESET);
        hasWrong = !checkIsAllTrue(tebakKandang);
      } else {
        System.out.println(ANSI_YELLOW + "Tebakan Salah!" + ANSI_RESET);
        tebakKandang.get(pilihKandang).setTrue(false);
      }
    }
    if (checkIsAllTrue(tebakKandang)) {
      System.out.println(ANSI_GREEN + "Selamat! Anda menebak semua kandang" + ANSI_RESET);
      System.out.flush();
    }
  }

  public static HashMap<Integer, Kandang> initKandang(int input) {
    HashMap<Integer, Kandang> result = new HashMap<>();
    for (int i = 1; i <= input; i++) {
      Random rand = new Random();
      int random = rand.nextInt(4);
      switch (random) {
        case 1:
          result.put(i, new KandangKambing(i));
          break;
        case 2:
          result.put(i, new KandangBebek(i));
          break;
        default:
          result.put(i, new KandangZebra(i));
          break;
      }
    }
    return result;
  }

  public static void percobaanBuka(HashMap<Integer, Kandang> kandang, int noKandang) {
    System.out.println("PERCOBAAN BUKA:");
    for (Integer key : kandang.keySet()) {
      if (key == noKandang) {
        kandang.get(key).setTrue(true);
      }
      kandang.get(key).showKandang();
    }
  }

  public static void showDaftarKandang(HashMap<Integer, Kandang> kandang) {
    for (Integer key : kandang.keySet()) {
      kandang.get(key).showKandang();
    }
  }

  public static boolean isSame(String input, String comparator) {
    if (input.toLowerCase().equals(comparator.toLowerCase()))
      return true;
    return false;
  }

  public static boolean checkIsAllTrue(HashMap<Integer, Kandang> kandang) {
    for (Integer key : kandang.keySet()) {
      if (kandang.get(key).isTrue == false) {
        return false;
      }
    }
    return true;
  }
}

class Kandang {
  protected int noKandang;
  protected String namaBinatang;
  protected boolean isTrue;

  public Kandang(int noKandang) {
    this.noKandang = noKandang;
  }

  public int getNoKandang() {
    return noKandang;
  }

  public void setNoKandang(int noKandang) {
    this.noKandang = noKandang;
  }

  public String getnamaBinatang() {
    return namaBinatang;
  }

  public void setnamaBinatang(String namaBinatang) {
    this.namaBinatang = namaBinatang;
  }

  public boolean isTrue() {
    return isTrue;
  }

  public void setTrue(boolean isTrue) {
    this.isTrue = isTrue;
  }

  public String initial() {
    return "";
  }

  public void showKandang() {
    System.out.println("|||");
    System.out.println("|" + noKandang + "|");
    System.out.println("|||");
    System.out.println();
  }
}

class KandangKambing extends Kandang {
  public KandangKambing(int noKandang) {
    super(noKandang);
    this.namaBinatang = "Kambing";
  }

  @Override
  public void showKandang() {
    System.out.println("|||");
    System.out
        .println(isTrue ? "|" + TebakKandang.ANSI_BLUE + "K" + TebakKandang.ANSI_RESET + "|" : "|" + noKandang + "|");
    System.out.println("|||");
    System.out.println();
  }

  @Override
  public String initial() {
    return "K";
  }
}

class KandangBebek extends Kandang {
  public KandangBebek(int noKandang) {
    super(noKandang);
    this.namaBinatang = "Bebek";
  }

  @Override
  public void showKandang() {
    System.out.println("|||");
    System.out
        .println(isTrue ? "|" + TebakKandang.ANSI_YELLOW + "B" + TebakKandang.ANSI_RESET + "|" : "|" + noKandang + "|");
    System.out.println("|||");
    System.out.println();
  }

  @Override
  public String initial() {
    return "B";
  }
}

class KandangZebra extends Kandang {
  public KandangZebra(int noKandang) {
    super(noKandang);
    this.namaBinatang = "Zebra";
  }

  @Override
  public void showKandang() {
    System.out.println("|||");
    System.out
        .println(isTrue ? "|" + TebakKandang.ANSI_RED + "Z" + TebakKandang.ANSI_RESET + "|" : "|" + noKandang + "|");
    System.out.println("|||");
    System.out.println();
  }

  @Override
  public String initial() {
    return "Z";
  }
}