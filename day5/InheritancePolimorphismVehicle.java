package day5;

public class InheritancePolimorphismVehicle {
  public static void main(String[] args) {
    parent();
    bikes();
    cars();
    buses();
  }

  public static void parent() {
    Vehicle gerobak = new Vehicle("Gerobak", false);
    gerobak.identityMySelf();
    System.out.println();
  }

  public static void bikes() {
    Bikes pedal = new Bikes("Pedal", false, 2);
    pedal.identityMySelf();

    Bikes motor = new Bikes("Motor", true, 2);
    motor.identityMySelf();

    System.out.println();
  }

  public static void cars() {
    Cars sport = new Cars("Sport", true, 4, "vs");
    sport.identityMySelf();

    Cars pickup = new Cars("Pickup", true, 4, "solar");
    pickup.identityMySelf();

    System.out.println();
  }

  public static void buses() {
    Buses trans = new Buses("Trans Jakarta", true, 4, false);
    trans.identityMySelf();

    Buses school = new Buses("School Bus", true, 4, true);
    school.identityMySelf();

    System.out.println();
  }
}

class Vehicle {
  protected String name;
  protected boolean withEngine;

  public Vehicle() {
  }

  public Vehicle(String name, boolean withEngine) {
    this.name = name;
    this.withEngine = withEngine;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isWithEngine() {
    return withEngine;
  }

  public void setWithEngine(boolean withEngine) {
    this.withEngine = withEngine;
  }

  public String getStatusEngine() {
    return withEngine ? "'with engine'" : "'no engine'";
  }

  public void identityMySelf() {
    System.out
        .println("Hi I'am Parent of all vehicles, My Name is " + name + ", My Engine status is " + getStatusEngine());
  }
}

class Bikes extends Vehicle {
  private int wheelCount;

  public Bikes() {
  }

  public Bikes(String name, boolean withEngine, int wheelCount) {
    super(name, withEngine);
    this.wheelCount = wheelCount;
  }

  public int getWheelCount() {
    return wheelCount;
  }

  public void setWheelCount(int wheelCount) {
    this.wheelCount = wheelCount;
  }

  @Override
  public void identityMySelf() {
    System.out
        .println("Hi I'am Bike, My Name is " + name + " Bikes, My Engine status is " + getStatusEngine() + ", I have "
            + wheelCount + " wheel(s)");
  }
}

class Cars extends Vehicle {
  private int wheelCount;
  private String engineType;

  public Cars() {
  }

  public Cars(String name, boolean withEngine, int wheelCount, String engineType) {
    super(name, withEngine);
    this.wheelCount = wheelCount;
    this.engineType = engineType;
  }

  public int getWheelCount() {
    return wheelCount;
  }

  public void setWheelCount(int wheelCount) {
    this.wheelCount = wheelCount;
  }

  public String getEngineType() {
    return engineType;
  }

  public void setEngineType(String engineType) {
    this.engineType = engineType;
  }

  @Override
  public void identityMySelf() {
    System.out
        .println("Hi I'am Car, My Name is " + name + " Cars, My Engine status is " + getStatusEngine() + ", I have "
            + wheelCount + " wheel(s), My Engine Type = " + engineType);
  }
}

class Buses extends Vehicle {
  private int wheelCount;
  private boolean privateBus;

  public Buses() {
  }

  public Buses(String name, boolean withEngine, int wheelCount, boolean privateBus) {
    super(name, withEngine);
    this.wheelCount = wheelCount;
    this.privateBus = privateBus;
  }

  public int getWheelCount() {
    return wheelCount;
  }

  public void setWheelCount(int wheelCount) {
    this.wheelCount = wheelCount;
  }

  public boolean isPrivateBus() {
    return privateBus;
  }

  public void setPrivateBus(boolean privateBus) {
    this.privateBus = privateBus;
  }

  public String getStatusBus() {
    return privateBus ? "[Private Bus]" : "[Public Bus]";
  }

  @Override
  public void identityMySelf() {
    System.out
        .println("Hi I'am Bus " + getStatusBus() + ", My Name is " + name + ", My Engine status is "
            + getStatusEngine() + ", I have "
            + wheelCount + " wheel(s)");
  }
}
