public abstract class AbstractEnemy extends Character{
    public AbstractEnemy(String name, int attack, int defense, int health, int precision) {
        super(name, attack, defense, health, precision);
    }
    @Override
    public void attack(Character character,int power){
        int hpLost=this.attack- (character.getDefense());
        character.setHp(character.getHp()-hpLost);
        System.out.println(character.getName()+" as taken "+hpLost+" damage from "+this.name);
    }

    public void enemyTurn(Wizard player){
        if(Math.random()*100<=precision) {
            if(Math.random()*10<3){
                effect.add(new Effect(Type.DEFENSE, 1.5F, 1));
            }else{
                attack(player,0);
            }
        }else System.out.println(name+" as missed");
    }

}
