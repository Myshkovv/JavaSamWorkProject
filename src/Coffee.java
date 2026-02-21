public enum  Coffee {

    ESPRESSO("экспрессо"){
        @Override
        public String getFeature() {
            return "7г кофе, 30мл воды";
        }
    },
    AMERIKANO("американо"){
        @Override
        public String getFeature() {
            return "Эспрессо + 90мл горячей воды";
        }
    },
    CAPPUCHINO("капучино"){
        @Override
        public String getFeature() {
            return "Эспрессо + вспененное молоко (1:1)";
        }
    },
    LATTE("латте"){
        @Override
        public String getFeature() {
            return "Эспрессо + много молока (1:3)";
        }
    },
    MOCHA("мокко"){
        @Override
        public String getFeature() {
            return "Эспрессо + шоколад + молоко";
        }
    },
    RAF("раф"){
        @Override
        public String getFeature() {
            return "Эспрессо + сливки + ванильный сахар";
        }
    },
    GLACE("глясе"){
        @Override
        public String getFeature() {
            return "Эспрессо + мороженое";
        }
    };
    private String name;

    Coffee(String name){
        this.name = name;
    }

    public abstract String getFeature();
    public String getName(){
        return name;
    }
}
