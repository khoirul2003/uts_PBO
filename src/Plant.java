public class Plant {
  private String name;
  private int health;
  private boolean hasPests;
  private int growTime; 
  private int daysGrowing; 
  private int harvest;

  public Plant(String name, int growTime) {
    this.name = name;
    this.health = 100;
    this.hasPests = false;
    this.growTime = growTime;
    this.daysGrowing = 0;
  }

  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public void decreaseHealth(int amount) {
    this.health -= amount;
    if (this.health < 0)
      this.health = 0;
  }

  public void raiseHealth(int amount) {
    this.health += amount;
    if (this.health >= 100)
      this.health = 100;
  }

  public int getHarvest() {
    return harvest;
  }

  public void setHarvest(int harvest) {
    this.harvest = harvest;
  }

  public boolean hasPests() {
    return hasPests;
  }

  public void setPests(boolean hasPests) {
    this.hasPests = hasPests;
  }

  public int getGrowTime() {
    return growTime;
  }

  public int getDaysGrowing() {
    return daysGrowing;
  }

  public boolean isFullyGrown() {
    return daysGrowing >= growTime;
  }

  public void grow() {
    if (!isFullyGrown()) {
      daysGrowing++;
      System.out.println(name + " tumbuh, hari ke-" + daysGrowing + " dari " + growTime);
    } else {
      System.out.println(name + " sudah tumbuh sepenuhnya.");
    }
  }

  public void treatPests() {
    if (hasPests) {
      this.hasPests = false;
      System.out.println("Tanaman " + name + " berhasil diselamatkan dari hama.");
    } else {
      System.out.println("Tanaman " + name + " tidak ada hama.");
    }
  }
}
