public class Enemy extends AbstractEnemy{
    public Enemy(String name, int attack, int defense, int health, int precision) {
        super(name, attack, defense, health, precision);
    }


    public Enemy(Enemy enemy) {
        super(enemy.getName(),enemy.getAttack(), enemy.getDefense(), enemy.getMaxHP(), enemy.getPrecision());
    }
}
