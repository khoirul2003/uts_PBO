public class Tool {
  private String name;
  private int price;

  public Tool(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public void use() {
    System.out.println("Menggunakan alat: " + name);
  }
}
