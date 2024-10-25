public class WormPest extends Pest{
  public WormPest() {
    super("Ulat", 10);
  }

  @Override
  public void attack(Plant plant, MedicinePest medicine) {
    super.attack(plant, medicine);
  }
}
