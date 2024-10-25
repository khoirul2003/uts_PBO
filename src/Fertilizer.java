public class Fertilizer {
  protected String name;
  protected int effectiveness;

  public Fertilizer(String name, int effectiveness) {
    this.name = name;
    this.effectiveness = effectiveness;
  }

  public String getName() {
    return name;
  }

  public int getEffectiveness() {
    return effectiveness;
  }

  public void apply(Plant plant) {
    
    System.out.println("Menerapkan pupuk " + name + " pada tanaman " + plant.getName());
  }
}
