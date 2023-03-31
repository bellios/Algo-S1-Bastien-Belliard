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

    public int getHp() {
        return hp;
    }

    public abstract int getDefense();

    public String getName() {
        return name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPrecision() {
        return precision;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public abstract void attack(Character character, int power);
    //=================================================================================================================
    //  Effect method
    //=================================================================================================================
    public void decreaseTimeEffects(){
        try {
            for (Effect i : effect) {
                i.decreaseTime();
                if (i.getType() == Type.BLEEDING || i.getType() == Type.POISON) {
                    this.hp -= i.getPower();
                    System.out.println(this.name + " has taken" + i.getPower() + " damage from " + i.getType());
                }
                if (i.getTurn() <= 0)
                    effect.remove(i);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public boolean isEffect(Type type){
        for (Effect i: effect) {
            if(i.getType()==type)
                return true;
        }
        return false;
    }
    public Effect getEffect(Type type){
        for (Effect i: effect) {
            if(i.getType()==type)
                return i;
        }
        return null;
    }

    public boolean isRestrainOrSleep(){
        if (isEffect(Type.SLEEP)||(isEffect(Type.RESTRAIN)&&Math.random()*10<getEffect(Type.RESTRAIN).getPower()))
            return true;
        return false;
    }
    public float asEffect(Type type){
        if(isEffect(type))
            return getEffect(type).getPower();
        return 1;
    }
    public void clearEffect(){
        this.effect=new ArrayList<>();
    }


}
