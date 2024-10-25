public class LocustMedicine extends MedicinePest{
  public LocustMedicine() {
    super("Obat Hama Belalang", 80); 
  }

  @Override
  public void useOnPest(Pest pest, Plant plant) {
    if (pest instanceof LocustPest) {
      System.out.println("Efektivitas tinggi untuk mengobati belalang!");
      super.useOnPest(pest, plant);
    } else {
      System.out.println("Efektivitas rendah terhadap hama ini.");
    }
  }
}
