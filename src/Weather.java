import java.util.*;

public class Weather {
  private String currentWeather;

  public void generateWeather() {
    String[] weatherTypes = { "Cerah", "Hujan", "Mendung", "Badai" };
    Random random = new Random();
    this.currentWeather = weatherTypes[random.nextInt(weatherTypes.length)];
  }

  public String getCurrentWeather() {
    return currentWeather;
  }

  public void affectPlants(Plant plant) {
    if (currentWeather.equals("Badai")) {
      System.out.println("Cuaca buruk! Tanaman " + plant.getName() + " mengalami kerusakan.");
      plant.decreaseHealth(3);
    } else if (currentWeather.equals("Hujan")) {
      System.out.println("Cuaca hujan! Tanaman " + plant.getName() + " tumbuh subur.");
      plant.raiseHealth(2);
    } else {
      System.out.println("Cuaca " + currentWeather + ", tidak ada pengaruh khusus pada tanaman.");
    }
  }
}
