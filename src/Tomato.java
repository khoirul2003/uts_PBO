public class Tomato extends Plant{
  public Tomato() {
        super("Tomat", 30); 
    }

  @Override
  public void grow() {
    System.out.println("Tomat tumbuh di lahan basah.");
    super.grow();
  }
}
