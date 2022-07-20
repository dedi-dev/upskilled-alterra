package day5;

public class InheritancePolimorphismAnimals {
  public static void main(String[] args) {
    parent();
    herbivor();
    carnivor();
    omnivor();
  }

  public static void parent() {
    Animals binatang = new Animals("Binatang");
    binatang.identityMySelf();
    System.out.println();
  }

  public static void herbivor() {
    Herbivor kambing = new Herbivor("Kambing");
    kambing.identityMySelf();
  }

  public static void carnivor() {
    Carnivor singa = new Carnivor("Singa");
    singa.identityMySelf();
    System.out.println();
  }

  public static void omnivor() {
    Omnivor ayam = new Omnivor("Ayam");
    ayam.identityMySelf();
  }
}

class Animals {
  protected String name;
  protected String feed;
  protected String teeth;

  public Animals() {
  }

  public Animals(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFeed() {
    return feed;
  }

  public void setFeed(String feed) {
    this.feed = feed;
  }

  public String getTeeth() {
    return teeth;
  }

  public void setTeeth(String teeth) {
    this.teeth = teeth;
  }

  public void identityMySelf() {
    System.out.println("Hi I'am Parent of All Animal, My Name is " + name);
  }
}

class Herbivor extends Animals {
  public Herbivor() {
    this.feed = "tumbuhan";
    this.teeth = "tumpul";
  }

  public Herbivor(String name) {
    super(name);
    this.feed = "tumbuhan";
    this.teeth = "tumpul";
  }

  @Override
  public void identityMySelf() {
    System.out
        .println("Hi I'am Herbivor, My Name is " + name + ", My Food is '" + feed + "', I have " + teeth + " teeth");
  }
}

class Carnivor extends Animals {
  public Carnivor() {
    this.feed = "daging";
    this.teeth = "tajam";
  }

  public Carnivor(String name) {
    super(name);
    this.feed = "daging";
    this.teeth = "tajam";
  }

  @Override
  public void identityMySelf() {
    System.out
        .println("Hi I'am Carnivor, My Name is " + name + ", My Food is '" + feed + "', I have " + teeth + " teeth");
  }
}

class Omnivor extends Animals {
  public Omnivor() {
    this.feed = "semua";
    this.teeth = "tumpul";
  }

  public Omnivor(String name) {
    super(name);
    this.feed = "semua";
    this.teeth = "tumpul";
  }

  public Omnivor(String name, String teeth) {
    super(name);
    this.feed = "semua";
    this.teeth = teeth;
  }

  @Override
  public void identityMySelf() {
    System.out
        .println("Hi I'am Omnivor, My Name is " + name + ", My Food is '" + feed + "', I have " + teeth + " teeth");
  }
}