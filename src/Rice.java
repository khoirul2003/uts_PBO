public class Rice extends Plant{
  public Rice() {
        super("Padi", 40); 
    }

  @Override
  public void grow() {
    System.out.println("Padi tumbuh di lahan basah.");
    super.grow();
  }
}
