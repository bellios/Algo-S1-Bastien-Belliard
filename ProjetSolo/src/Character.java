import java.util.ArrayList;
import java.util.Calendar;

public abstract class Character {
    protected String name;
    protected int attack;
    protected int defense;
    protected int maxHP;
    protected int hp;
    protected int precision;
    protected ArrayList<Effect> effect;
    //add stat

    public Character(String name, int attack, int defense, int health, int precision) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.hp = health;
        this.maxHP = health;
        this.precision = precision;
        this.effect=new ArrayList<>();
    }

    public int getAttack() {
        return attack;
    }

    public ArrayList<Effect> getEffect() {
        return effect;
    }

    public static void defend(int power) {

    }
    public int getHp() {
        return hp;
    }

    public int getDefense() {
        return defense;
    }

    public String getName() {
        return name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void decreaseTimeEffects(){
        for(Effect i: effect)
            i.decreaseTime();
    }

    public int getPrecision() {
        return precision;
    }

    public int getMaxHP() {
        return maxHP;
    }


    public abstract void attack(Character character, int power);
}
