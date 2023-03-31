public class Boss extends AbstractEnemy{
    public Boss(String name, int attack, int defense, int health, int precision) {
        super(name, attack, defense, health, precision);
    }
    public Boss(Boss enemy) {
        super(enemy.getName(),enemy.getAttack(), enemy.getDefense(), enemy.getMaxHP(), enemy.getPrecision());
    }

}
