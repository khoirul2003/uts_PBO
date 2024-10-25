public class ChemicalFertilizer extends Fertilizer{
  public ChemicalFertilizer() {
    super("Pupuk Kimia", 30); 
  }

  @Override
  public void apply(Plant plant) {
    super.apply(plant);
    plant.raiseHealth(effectiveness); 
    System.out.println("Tanaman " + plant.getName() + " mendapatkan kesehatan tambahan " + effectiveness);
  }
}
