import java.util.*;

public class Land {
  private int size;
  private int moisture;
  private List<Plant> plants;

  // Updated constructor to set initial moisture based on size
  public Land(int sizeInRu) {
    this.size = sizeInRu * 50; // Convert RU to size (assuming 1 RU = 50 units)
    this.moisture = 50;
    this.plants = new ArrayList<>();
  }

  public int getSize() {
    return size;
  }

  public int getMoisture() {
    return moisture;
  }

  public void setMoisture(int moisture) {
    this.moisture = moisture;
  }

  public void adjustMoisture(String weather) {
    switch (weather) {
      case "Hujan":
        moisture = Math.min(moisture + 8, 100);
        break;
      case "Cerah":
        moisture = Math.max(moisture - 4, 0);
        break;
      case "Mendung":
        moisture = Math.max(moisture - 2, 0);
        break;
      default:
        break;
    }
    System.out.println("Kelembapan tanah saat ini: " + moisture + "%");
  }

  public boolean plantCrop(Plant plant) {
    int maxPlants = size / 50; // Calculate maximum plants based on the land size (1 RU = 50 units)

    if (plants.size() < maxPlants) {
      plants.add(plant);
      System.out.println(plant.getName() + " berhasil ditanam di lahan.");
      return true;
    } else {
      System.out.println("Lahan tidak cukup untuk menanam " + plant.getName() + ".");
      return false;
    }
  }

  public void growPlants() {
    for (Plant plant : plants) {
      plant.grow();
      System.out
          .println("Pertumbuhan " + plant.getName() + ": " + plant.getDaysGrowing() + " / " + plant.getGrowTime());
    }
  }

  public boolean isFullyGrown() {
    for (Plant plant : plants) {
      if (!plant.isFullyGrown()) {
        return false;
      }
    }
    return true;
  }
}
