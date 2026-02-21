import java.util.Random;

public class Conveyor {
    private int nextId;
    private String id = "0";
    private Box box;
    private Pallet longSlot;
    private Pallet shortSlot;
    private Pallet[] longFullPallets = new Pallet[1000];
    private Pallet[] shortFullPallets = new Pallet[1000];
    private int fullPalletsCount = 0;
    Random random = new Random();

    public Conveyor(){
        updateSlots();
    }

    private Box createBox(){
        if (random.nextBoolean()){
            return new FragileBox(5, 5, 3, Fragile.NORMAL);
        }
        return new StandartBox(10, 5, 6, 400);
    }

    private void updateSlots(){
        longSlot = new Pallet<>(id, PalletType.A, 10000);
        nextId++;
        id = String.valueOf(nextId);
        shortSlot = new Pallet<>(id, PalletType.B, 5000);
        nextId++;
        id = String.valueOf(nextId);
    }

    private void printPalletsUpdating(Pallet pallet){
        System.out.println("Паллет [" + pallet.getId() + "] заполнен, отправлен на склад");
    }

    public void run(){
        while (fullPalletsCount <10){
            box = createBox();
            if (box instanceof FragileBox){
                FragileBox fragileBox = (FragileBox) box;
                if (shortSlot.addBox(fragileBox)){
                } else if (longSlot.addBox(fragileBox)){

                } else {
                    //соханяем палеты
                    int i = fullPalletsCount / 2;
                    shortFullPallets[i] = shortSlot;
                    longFullPallets[i] = longSlot;
                    printPalletsUpdating(shortSlot);
                    printPalletsUpdating(longSlot);
                    updateSlots();
                    fullPalletsCount+=2;
                    shortSlot.addBox(fragileBox);
                }
            } else if (box instanceof StandartBox){
                StandartBox standartBox = (StandartBox) box;
                if (longSlot.addBox(standartBox)){

                } else if (shortSlot.addBox(standartBox)){

                } else {
                    int i = fullPalletsCount / 2;
                    shortFullPallets[i] = shortSlot;
                    longFullPallets[i] = longSlot;
                    printPalletsUpdating(shortSlot);
                    printPalletsUpdating(longSlot);
                    updateSlots();
                    fullPalletsCount+=2;
                    longSlot.addBox(standartBox);
                }

            }
        }
        System.out.println("КОНЕЦ!");
    }


}
