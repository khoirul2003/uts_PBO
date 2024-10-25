import java.util.*;

public class Game {
  private int day;
  private int season;
  private Player player;
  private Weather weather;
  private Plant plant;
  private Land land;
  private List<Tool> playerTools; 
  private Store store; 
  private int lastPestAttackDay; 
  private Inventory inventory;

  public Game() {
    this.day = 1;
    this.season = 1;
    this.player = new Player();
    this.weather = new Weather();
    this.playerTools = new ArrayList<>(); 
    this.store = new Store(); 
    this.lastPestAttackDay = 0; 
    this.inventory = new Inventory();
    
  }

  public void nextDay() {
    day++;
    if (day > 30) {
      day = 1;
      season++;
      if (season > 4)
        season = 1;
    }
  }

  private Plant choosePlant() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n===================================================");
    System.out.println("=================== Pilih Tanaman ===================");
    System.out.println("(1) Padi");
    System.out.println("(2) Jagung");
    System.out.println("(3) Tomat");
    System.out.print("Pilihan Anda: ");
    int choice = scanner.nextInt();

    if (choice == 1) {
      return new Rice();
    } else if (choice == 2) {
      return new Corn();
    } else if (choice == 3){
      return new Tomato();
    }else {
      System.out.println("Pilihan tidak valid. Menanam Padi secara default.");
      return new Rice();
    }
  }

  private Pest generateRandomPest() {
    Random random = new Random();
    int pestType = random.nextInt(3);

    switch (pestType) {
      case 0:
        return new LocustPest();
      case 1:
        return new WormPest();
      case 2:
        return new CaterpillarPest();
      default:
        return new LocustPest();
    }
  }

  public MedicinePest chooseMedicine(Pest pest) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n===================================================");
    System.out.println("=== Pilih Obat Hama ===");
    System.out.println("(1) Obat Belalang");
    System.out.println("(2) Obat Ulat Tanah");
    System.out.println("(3) Obat Ulat Bulu");
    System.out.print("Pilihan Anda: ");
    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        return new LocustMedicine();
      case 2:
        return new WormMedicine();
      case 3:
        return new CaterpillarMedicine();
      default:
        System.out.println("Pilihan tidak valid. Menggunakan Obat Belalang sebagai default.");
        return new LocustMedicine();
    }
  }

  public void waterPlants() {
    if (land.getMoisture() < 50) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("\n===================================================");
      System.out.println("================ Penyiraman Tanaman =================");
      System.out.println("Kelembapan tanah saat ini: " + land.getMoisture() + "%");
      System.out.print("Apakah Anda ingin menyiram tanaman? (ya/tidak): ");
      String response = scanner.nextLine();

      if (response.equalsIgnoreCase("ya")) {
        land.setMoisture(land.getMoisture() + 30);
        System.out.println("Tanaman telah disiram. Kelembapan tanah saat ini: " + land.getMoisture() + "%");
      } else {
        System.out.println("Tanaman tidak disiram.");
      }
    } else {
      System.out.println("Kelembapan tanah cukup, tidak perlu menyiram.");
    }
  }

  public void fertilizePlants() {
    if (plant.getHealth() < 60) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("\n===================================================");
      System.out.println("================ Pemupukan Tanaman --================");
      System.out.println("Pilih jenis pupuk: (1) Pupuk Organik (2) Pupuk Kimia");
      int choice = scanner.nextInt();

      Fertilizer fertilizer;

      if (choice == 1) {
        fertilizer = new OrganicFertilizer();
      } else {
        fertilizer = new ChemicalFertilizer();
      }

      fertilizer.apply(plant);
      System.out.println("Pemupukan telah dilakukan pada tanaman " + plant.getName());
    } else {
      System.out.println("Kesehatan tanaman sudah cukup, tidak perlu pemupukan.");
    }
  }

  public void buyLand() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\\n===================================================");
      System.out.println("================== Pembelian Lahan ===================");
      System.out.println("Lahan 1 RU: 2000000");
      System.out.println("Uang Anda saat ini: " + player.getMoney());
      System.out.print("Masukkan ukuran lahan yang ingin dibeli (dalam RU): ");
      int sizeInRu = scanner.nextInt();

      int price = sizeInRu * 2000000;

      System.out.println("Harga untuk " + sizeInRu + " RU adalah: " + price);
      System.out.print("Apakah Anda ingin membeli lahan ini? (ya/tidak): ");
      String response = scanner.next();

      if (response.equalsIgnoreCase("ya")) {
        if (player.getMoney() >= price) {
          player.buyLand(price);
          land = new Land(sizeInRu);
          System.out.println("Anda telah membeli lahan " + sizeInRu + " RU.");
          break;
        } else {
          System.out.println("Uang Anda tidak cukup untuk membeli lahan ini.");
        }
      } else {
        System.out.println("Kembali ke menu pembelian lahan.");
      }
    }
  }

  public void buyTools() {
    Scanner scanner = new Scanner(System.in);
    store.displayTools();
    System.out.println("Uang Anda saat ini: " + player.getMoney());
    System.out.print("Pilih alat yang ingin dibeli (masukkan nomor alat): ");
    int choice = scanner.nextInt();

    Tool tool = store.buyTool(choice);
    if (tool != null) {
      if (player.getMoney() >= tool.getPrice()) {
        player.buyTool(tool.getPrice());
        playerTools.add(tool); 
        System.out.println("Anda telah membeli alat: " + tool.getName());
      } else {
        System.out.println("Uang Anda tidak cukup untuk membeli alat ini.");
      }
    } else {
      System.out.println("Pilihan tidak valid.");
    }
  }

  private void welcomeScreen() {
    System.out.println("=========================================");
    System.out.println("=                                       =");
    System.out.println("=     Selamat Datang di Game Simulasi   =");
    System.out.println("=                Sederhana              =");
    System.out.println("=                                       =");
    System.out.println("=========================================");
    System.out.println("=                                       =");
    System.out.println("=  Dalam game ini, Anda akan belajar    =");
    System.out.println("=  bagaimana mengelola pertanian mulai  =");
    System.out.println("=  dari menanam, merawat, hingga panen! =");
    System.out.println("=                                       =");
    System.out.println("=========================================");
    System.out.println("=                                       =");
    System.out.println("=     Tekan ENTER untuk memulai!        =");
    System.out.println("=                                       =");
    System.out.println("=========================================");

    // Menunggu pemain menekan ENTER untuk melanjutkan
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
  }

  public void play() {
    Scanner scanner = new Scanner(System.in);
    welcomeScreen();
    do {
      
      resetGame();

      System.out.print("Masukkan nama Anda: ");
      String playerName = scanner.nextLine();
      player.setName(playerName);

      buyLand();
      buyTools(); 
      plant = choosePlant();
      land.plantCrop(plant);

      weather.generateWeather();

      while (!land.isFullyGrown()) {
        nextDay();
        weather.generateWeather();
        plant.grow();
        System.out.println("\n===============================================================================");
        System.out.printf("| Tanaman: %-20s|Kesehatan Tanaman: %-10d| Kelembapan Tanah: %3d%%|\n",
            plant.getName(), plant.getHealth(), land.getMoisture());
        System.out.println("=================================================================================");

        land.adjustMoisture(weather.getCurrentWeather());

        waterPlants();
        fertilizePlants();

       
        if (day - lastPestAttackDay >= 7) {
          lastPestAttackDay = day;
          Pest pest = generateRandomPest();
          System.out.println("Hama muncul: " + pest.getName());
          MedicinePest medicine = chooseMedicine(pest);
          pest.attack(plant, medicine);

          if (plant.getHealth() <= 0) {
            System.out.println("Tanaman telah mati.");
            break;
          }
        }
      }
      int harvestQuantity = plant.getHarvest();
      inventory.addCrop(plant.getName(), harvestQuantity);
      System.out.println("Anda telah memanen " + harvestQuantity + " unit " + plant.getName() + ".");

      inventory.displayCrops();

      System.out.println("Permainan selesai. Hasil panen: " + plant.getHarvest() + " unit.");

     
      System.out.print("Apakah Anda ingin bermain lagi? (ya/tidak): ");
    } while (scanner.nextLine().equalsIgnoreCase("ya"));
  }

  private void resetGame() {
    this.day = 1;
    this.season = 1;
    this.lastPestAttackDay = 0; 
    this.plant = null;
    this.land = null;
    this.inventory = new Inventory(); 
    this.playerTools.clear(); 
    this.player = new Player(); 
    this.weather = new Weather(); 
  }

  public static void main(String[] args) {
    Game game = new Game();
    game.play();
  }
}
