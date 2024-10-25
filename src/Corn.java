public class Corn extends Plant{
  public Corn() {
        super("Padi", 35);  
    }

  @Override
  public void grow() {
    System.out.println("Padi tumbuh di lahan basah.");
    super.grow();
  }
}
