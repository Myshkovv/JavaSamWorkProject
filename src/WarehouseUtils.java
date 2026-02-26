public final class WarehouseUtils {

    private WarehouseUtils(){

    }

    public static void printPalletInfo(Pallet<? extends Box> pallet){
        System.out.println("Паллет [" + pallet.getId() + "], корбки: ");
        for (int i = 0; i< pallet.getCount(); i++){
            System.out.println("[" + pallet.getBox(i).getId() + "], объем - " + pallet.getBox(i).getVolume() + ", класс - " + pallet.getBox(i).getType());

        }

    }

    public static void loadFragileBoxes(Pallet<? super FragileBox> pallet, FragileBox[] boxes){
        for (int i = 0; i<boxes.length;i++){
            pallet.addBox(boxes[i]);
        }
    }

    public static double calculateTotalVolume(Pallet<? extends Box> pallet){
        return pallet.getVolume();
    }

    public static void transferBoxes(Pallet<? extends Box> pallet1, Pallet<Box> pallet2){
        Box[] pallet_transfer = pallet1.getBoxes().clone();

        for (Box box : pallet_transfer){
            if (box!=null){
                pallet2.addBox(box);
            }
        }

        for (int i = pallet1.getCount()-1; i>=0; i--){
            pallet1.deleteBox(i);
        }
    }

    public static Box findFirst(Pallet<? extends Box> pallet, BoxType boxType){
        for (Box box : pallet.getBoxes()){
            if (box != null){
                if (box.getType().equals(boxType.getName())) {
                    return box;
                }
            }
        }
        System.out.println("Ничего не найдено");
        return null;
    }



}
