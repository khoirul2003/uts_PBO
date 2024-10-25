public class MedicinePest {
  private String name;
  private int effectiveness;

  public MedicinePest(String name, int effectiveness) {
    this.name = name;
    this.effectiveness = effectiveness;
  }

  public String getName() {
    return name;
  }

  public int getEffectiveness() {
    return effectiveness;
  }

  public void useOnPest(Pest pest, Plant plant) {
    System.out.println(name + " digunakan pada " + pest.getName() + ".");
    plant.treatPests(); 
    System.out.println("Efektivitas obat: " + effectiveness + ", Mengobati hama " + pest.getName());
  }
}
