public class OrganicFertilizer extends Fertilizer {
  public OrganicFertilizer() {
    super("Pupuk Organik", 20); 
  }

  @Override
  public void apply(Plant plant) {
    super.apply(plant);
    plant.raiseHealth(effectiveness); 
    System.out.println("Tanaman " + plant.getName() + " mendapatkan kesehatan tambahan " + effectiveness);
  }
}
