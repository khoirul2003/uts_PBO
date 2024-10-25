public class CaterpillarPest extends Pest{
  public CaterpillarPest() {
    super("Ulat Bulu", 20); 
  }

  @Override
  public void attack(Plant plant, MedicinePest medicine) {
    super.attack(plant, medicine); 
  }
}
