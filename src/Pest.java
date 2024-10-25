public class Pest {
  private String name;
  private int damage;

  public Pest(String name, int damage) {
    this.name = name;
    this.damage = damage;
  }

  public String getName() {
    return name;
  }

  public int getDamage() {
    return damage;
  }

  public void attack(Plant plant, MedicinePest medicine) {
    System.out.println(name + " menyerang " + plant.getName() + " dengan kerusakan: " + damage);

    
    if (medicine != null) {
      System.out.println("Menggunakan " + medicine.getName() + " untuk mengatasi hama.");
      damage /= 2; 
    }

    plant.decreaseHealth(damage);
  }
}
