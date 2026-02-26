
public class Main {
    public static void main(String[] args) {

        StandartBox standartBox1 = new StandartBox(7, 5, 5, 150);
        StandartBox standartBox2 = new StandartBox(6, 5, 5, 150);
        StandartBox standartBox3 = new StandartBox(5, 5, 5, 150);
        StandartBox standartBox4 = new StandartBox(4, 5, 5, 150);
        FragileBox fragileBox1 =  new FragileBox(5, 5, 3, Fragile.NORMAL);
        FragileBox fragileBox2 =  new FragileBox(2, 4, 1, Fragile.ALMOST);
        FragileBox fragileBox3 =  new FragileBox(3, 4, 5, Fragile.VERY);

        FragileBox[] fragileBoxes = new FragileBox[] {fragileBox1, fragileBox2, fragileBox3};


        Pallet pallet1 = new Pallet<>("4", PalletType.A, 10000);
        Pallet pallet2 = new Pallet<>("5", PalletType.B, 5000);

        pallet1.addBox(standartBox1);
        pallet1.addBox(standartBox1);
        pallet1.addBox(standartBox1);
        pallet1.addBox(standartBox1);
        pallet1.addBox(standartBox1);

        System.out.println("Остаточный обьем: " + pallet1.getDifferenceVolume());

        Conveyor conveyor = new Conveyor();
        conveyor.run();


        WarehouseUtils.printPalletInfo(pallet1);
        WarehouseUtils.loadFragileBoxes(pallet2, fragileBoxes);

        WarehouseUtils.printPalletInfo(pallet2);
        System.out.println(WarehouseUtils.calculateTotalVolume(pallet2));

        Pallet pallet3 = new Pallet<>("6", PalletType.A, 10000);
        Pallet pallet4 = new Pallet<>("7", PalletType.A, 5000);

        pallet3.addBox(standartBox4);
        pallet3.addBox(standartBox3);
        pallet3.addBox(standartBox1);
//        pallet3.addBox(fragileBox1);
        pallet3.addBox(standartBox2);

        WarehouseUtils.transferBoxes(pallet3, pallet4);
        WarehouseUtils.printPalletInfo(pallet4);
        WarehouseUtils.printPalletInfo(pallet3);

        System.out.println(WarehouseUtils.findFirst(pallet4, BoxType.STANDART).getId());

        pallet4.sort();
        WarehouseUtils.printPalletInfo(pallet4);

    }
}