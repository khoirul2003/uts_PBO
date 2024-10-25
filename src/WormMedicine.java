public class WormMedicine extends MedicinePest{
  public WormMedicine() {
    super("Obat Hama Ulat Tanah", 70); 
  }

  @Override
  public void useOnPest(Pest pest, Plant plant) {
    if (pest instanceof WormPest) {
      System.out.println("Efektivitas tinggi untuk mengobati ulat tanah!");
      super.useOnPest(pest, plant);
    } else {
      System.out.println("Efektivitas rendah terhadap hama ini.");
    }
  }
}
