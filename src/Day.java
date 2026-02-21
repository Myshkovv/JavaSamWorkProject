public enum Day {
    MONDAY("Понедельник"){
        @Override
        public String getProverb() {
            return "день бездельник";
        }
    },
    TUESDAY("Вторник") {
        @Override
        public String getProverb() {
            return "повторник";
        }
    },
    WEDNESDAY("Среда") {
        @Override
        public String getProverb() {
            return "не мила";
        }
    },
    THURSDAY("Четверг") {
        @Override
        public String getProverb() {
            return "работу я отверг";
        }
    },
    FRIDAY("Пятница") {
        @Override
        public String getProverb() {
            return "пьяница";
        }
    },
    SATURDAY("Суббота") {
        @Override
        public String getProverb() {
            return "не работа";
        }
    },
    SUNDAY("Воскресение") {
        @Override
        public String getProverb() {
            return "наконецто можно отдохнуть";
        }
    };

    private String name;

    Day(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract String getProverb();
}
