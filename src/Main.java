
public class Main {
    public static void main(String[] args) {

        StandartBox standartBox1 = new StandartBox(10, 10, 5, 120);
        StandartBox standartBox2 = new StandartBox(8, 7, 7, 170);
        StandartBox standartBox3 = new StandartBox(12, 4, 4, 320);
        StandartBox standartBox4 = new StandartBox(2, 10, 5, 120);
        StandartBox standartBox5 = new StandartBox(10, 10, 5, 560);
        FragileBox fragileBox1 = new FragileBox(10, 3, 1, Fragile.ALMOST);
        FragileBox fragileBox2 = new FragileBox(5, 3, 2, Fragile.NORMAL);
        FragileBox fragileBox3 = new FragileBox(1, 3, 1, Fragile.VERY);
        FragileBox fragileBox4 = new FragileBox(1, 1, 2, Fragile.VERY);


        Pallet pallet5 = new Pallet<>("4", 500, 10);
//
        System.out.println(pallet5.isFull());
        pallet5.addBox(standartBox2);
        System.out.println(pallet5.isFull());
        pallet5.addBox(standartBox3);
        System.out.println(pallet5.isFull());
        pallet5.addBox(standartBox3);
        System.out.println(pallet5.isFull());
        pallet5.addBox(standartBox3);
        System.out.println(pallet5.isFull());
        pallet5.addBox(standartBox3);


    }
}