public class Potion {
    String name;
    String description;
    float power;
    int yearOfCraft;
    Type type;

    public Potion(String name, String description, Type type, float power, int yearOfCraft) {
        this.name = name;
        this.description = description;
        this.type=type;
        this.power=power;
        this.yearOfCraft=yearOfCraft;
    }

    public int getYearOfCraft() {
        return yearOfCraft;
    }
    public String toString() {
        return name+" : "+description+". Craftable in the "+yearOfCraft+" year";
    }
    public String getName() {
        return name;
    }

    public void use (){
        switch (this.type){
            case REGENERATE :
                break;
            case BOOST :
                break;
            case RESTRAIN :
                break;
            case CURE :
                break;
            case POISON :
                break;
            case SLEEP :
                break;
        }
    }
}
