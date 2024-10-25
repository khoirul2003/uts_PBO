import java.util.*;

public class Inventory {
  private Map<String, Integer> crops; 

  public Inventory() {
    crops = new HashMap<>(); 
  }

 
  public void addCrop(String cropName, int quantity) {
    crops.put(cropName, crops.getOrDefault(cropName, 0) + quantity);
    System.out.println(quantity + " unit " + cropName + " telah ditambahkan ke inventori.");
  }



  public void displayCrops() {
    System.out.println("\n=========================");
    System.out.println("=== Inventori Hasil Panen ===");
    if (crops.isEmpty()) {
      System.out.println("Inventori kosong.");
    } else {
      for (Map.Entry<String, Integer> entry : crops.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue() + " unit");
      }
    }
    System.out.println("=========================");
  }


  public int getCropQuantity(String cropName) {
    return crops.getOrDefault(cropName, 0);
  }
}
