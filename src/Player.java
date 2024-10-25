public class Player {
  private String name;
  private int money;

  public Player() {
    this.money = 100000000; 
  }

  public void buyLand(int price) {
    this.money -= price; 
  }

  public void buyTool(int price) {
    money -= price; 
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money; 
  }
}
