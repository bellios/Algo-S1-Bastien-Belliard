import java.util.Calendar;

public abstract class Character {
    protected String name;
    protected int attack;
    protected int defense;
    protected int maxHP;
    protected int hp;
    protected int precision;
    //add stat



    public Character(String name, int attack, int defense, int health, int precision) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.hp = health;
        this.maxHP = health;
        this.precision = precision;
    }

    public static void attack(Character character){

    }

    public static void defend() {

    }
    public int getHp() {
        return hp;
    }

}
