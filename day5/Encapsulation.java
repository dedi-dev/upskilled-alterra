package day5;

public class Encapsulation {
  public static void main(String[] args) {
    cat();
    fish();
    flower();
    car();
  }

  public static void cat() {
    Cat hitam = new Cat("Hitam", 4);
    hitam.showIdentity();

    Cat putih = new Cat();
    putih.setFunColor("Putih");
    putih.setNumOfLeg(3);
    putih.showIdentity();

    Cat hitamPutih = new Cat("Hitam Putih", 4);
    hitamPutih.showIdentity();

    Cat poleng = new Cat("Poleng poleng", 3);
    poleng.showIdentity();

    Cat bintik = new Cat("Bintik bintik", 4);
    bintik.showIdentity();
    System.out.println();
  }

  public static void fish() {
    Fish paus = new Fish("Paus", "plankton");
    paus.showIdentity();

    Fish cupang = new Fish();
    cupang.setType("Cupang");
    cupang.setFeed("cacing");
    cupang.showIdentity();

    Fish arwana = new Fish("Arwana", "jangkrik");
    arwana.showIdentity();

    Fish sapuSapu = new Fish("Sapu sapu", "pelet");
    sapuSapu.showIdentity();
    System.out.println();
  }

  public static void flower() {
    Flower bangkai = new Flower("Bangkai", "Merah", 12);
    bangkai.showIdentity();

    Flower anggrek = new Flower("Anggrek", "Putih", 8);
    anggrek.showIdentity();

    Flower mawar = new Flower("Mawar", "Merah", 3);
    mawar.showIdentity();

    Flower melati = new Flower("Melati", "Kuning", 5);
    melati.showIdentity();
    System.out.println();
  }

  public static void car() {
    Car sedan = new Car("Sedan", "Merah", 4);
    sedan.showIdentity();

    Car truk = new Car("Truk", "Hijau", 6);
    truk.showIdentity();

    Car tronton = new Car("Tronton", "Coklat", 12);
    tronton.showIdentity();

    Car angkot = new Car("Angkot", "Kuning", 4);
    angkot.showIdentity();
  }
}

class Cat {
  private String funColor;
  private int numOfLeg;

  Cat() {
  }

  Cat(String funColor, int numOfLeg) {
    this.funColor = funColor;
    this.numOfLeg = numOfLeg;
  }

  public void setFunColor(String funColor) {
    this.funColor = funColor;
  }

  public void setNumOfLeg(int numOfLeg) {
    this.numOfLeg = numOfLeg;
  }

  public String getFunColor() {
    return this.funColor;
  }

  public int getNumOfLeg() {
    return this.numOfLeg;
  }

  public void showIdentity() {
    System.out
        .println("Saya kucing dengan detail, Warna Bulu " + funColor + " dengan jumlah kaki : " + numOfLeg);
  }
}

class Fish {
  private String type;
  private String feed;

  Fish() {
  }

  Fish(String type, String feed) {
    this.type = type;
    this.feed = feed;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setFeed(String feed) {
    this.feed = feed;
  }

  public String getType() {
    return this.type;
  }

  public String getFeed() {
    return this.feed;
  }

  public void showIdentity() {
    System.out
        .println("Saya Ikan dengan detail, Jenis " + type + ", makanan: " + feed);
  }
}

class Flower {
  private String nama;
  private String color;
  private int numOfPetal;

  public Flower() {
  }

  public Flower(String nama, String color, int numOfPetal) {
    this.nama = nama;
    this.color = color;
    this.numOfPetal = numOfPetal;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getNumOfPetal() {
    return numOfPetal;
  }

  public void setNumOfPetal(int numOfPetal) {
    this.numOfPetal = numOfPetal;
  }

  public void showIdentity() {
    System.out
        .println("Saya Bunga dengan detail, Jenis: " + nama + ", color : " + color + ", num of petal: "
            + numOfPetal);
  }
}

class Car {
  private String type;
  private String color;
  private int numOfTire;

  public Car() {
  }

  public Car(String type, String color, int numOfTire) {
    this.type = type;
    this.color = color;
    this.numOfTire = numOfTire;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getNumOfTire() {
    return numOfTire;
  }

  public void setNumOfTire(int numOfTire) {
    this.numOfTire = numOfTire;
  }

  public void showIdentity() {
    System.out
        .println("Saya Mobil dengan detail, Type: " + type + ", color : " + color + ", num of tire: "
            + numOfTire);
  }
}
