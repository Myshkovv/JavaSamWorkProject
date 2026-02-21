
public class People {

    private String name;
    private int year;

    public People(String name, int year){
        this.name = name;
        this.year = year;
    }


    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString(){
        return (getName() + ", год рождения - " + getYear());
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof People)) return false;

        People p = (People) object;
        return (name.equals(getName())) && (p.year == year);
    }

    @Override
    public int hashCode(){
        return this.name.hashCode() * 10;
    }

}
