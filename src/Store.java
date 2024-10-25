import java.util.*;;

public class Store {
  private List<Tool> tools;

  public Store() {
    tools = new ArrayList<>();
    tools.add(new WateringCan());
    tools.add(new PlantingTool());
    tools.add(new HarvestingTool());
  }

  public void displayTools() {
    System.out.println("\n=========================");
    System.out.println("=== Toko Alat Pertanian ===");
    for (int i = 0; i < tools.size(); i++) {
      Tool tool = tools.get(i);
      System.out.printf("(%d) %s - Harga: %d\n", i + 1, tool.getName(), tool.getPrice());
    }
  }

  public Tool buyTool(int choice) {
    if (choice > 0 && choice <= tools.size()) {
      return tools.get(choice - 1);
    }
    return null;
  }
}
