public class Spell extends AbstractSpell{
    private int yearOfStudy;
    public Spell(String name,String description, Type type, int power,int yearOfStudy) {
        super(name,description, type, power);
        this.yearOfStudy=yearOfStudy;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    @Override
    public String toString() {
        return  name + " : "+ description + " This " + type+" type spell is learned in the " + yearOfStudy+" year";
    }

    //1 year Windgardium, saucisson
    //2 year expelliarmus, Accio
    //3 year Expectro pratronum
    //4 year repulso, protego
    //5 year Stupefix
    //6 year Sectumsempra

}
