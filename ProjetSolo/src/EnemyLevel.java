public class EnemyLevel {
    private Boss boss[];
    private Enemy enemies[];

    public EnemyLevel(Boss[] boss, Enemy[] enemies) {
        this.boss = boss;
        this.enemies = enemies;
    }

    public Boss[] getBoss() {
        return boss;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }
    public boolean areDead(){
        for(Boss i: this.boss)
            if(i.getHp()>0)
                return false;
        for(Enemy i: this.enemies)
            if(i.getHp()>0)
                return false;
        return true;
    }
}
