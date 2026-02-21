
public class Main {
    public static void main(String[] args) {

        StandartBox standartBox1 = new StandartBox(5, 5, 5, 150);

        Pallet pallet1 = new Pallet<>("4", PalletType.A, 1000);

        pallet1.addBox(standartBox1);
        pallet1.addBox(standartBox1);
        pallet1.addBox(standartBox1);
        pallet1.addBox(standartBox1);
        pallet1.addBox(standartBox1);

        System.out.println("Остаточный обьем: " + pallet1.getDifferenceVolume());

        Conveyor conveyor = new Conveyor();
        conveyor.run();



    }
}