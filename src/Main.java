
public class Main {
    public static void main(String[] args) {

        Transport[] transportList = {new Airplane(1, 800, 100),
        new Bike(2, 10, 20),
        new Car(3, 70, 300),
        new Ship(4, 40, 40000),
        new Drone(5, 60, 30)};

        Cargo cargo1 = new Cargo("яблоко", 0.01);
        Cargo cargo2 = new Cargo("шкаф", 150);
        Cargo cargo3 = new Cargo("большой груз", 20000);


        for (Transport transport: transportList){
            if (transport.getСapacity() >= cargo1.getWeight()){
                double time = transport.calculateTime(100);//бедный велосипедист
                System.out.println("Транспорт id:" + transport.getId() + " доставит " + cargo1.getName() + " за " + time + " часов");

            }
            if (transport.getСapacity() >= cargo2.getWeight()){
                double time = transport.calculateTime(100);//бедный велосипедист
                System.out.println("Транспорт id:" +  transport.getId() + " доставит " + cargo2.getName() + " за " + time + " часов");

            }
            if (transport.getСapacity() >= cargo2.getWeight()){
                double time = transport.calculateTime(100);//бедный велосипедист
                System.out.println("Транспорт id:" + transport.getId() + " доставит " + cargo2.getName() + " за " + time + " часов");

            }


            if (transport instanceof NeedFixInterface){
                NeedFixInterface needFixInterface = (NeedFixInterface) transport;
                needFixInterface.fix();
            }
            if (transport instanceof NeedOilInterface){
                NeedOilInterface needOilInterface = (NeedOilInterface) transport;
                needOilInterface.refuel();
            }
        }


    }
}