public class CaterpillarMedicine extends MedicinePest{
  public CaterpillarMedicine() {
    super("Obat Hama Ulat Bulu", 90);
  }

  @Override
  public void useOnPest(Pest pest, Plant plant) {
    if (pest instanceof CaterpillarPest) {
      System.out.println("Efektivitas tinggi untuk mengobati ulat bulu!");
      super.useOnPest(pest, plant);
    } else {
      System.out.println("Efektivitas rendah terhadap hama ini.");
    }
  }
}
