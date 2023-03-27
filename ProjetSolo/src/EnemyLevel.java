import java.util.Scanner;

public class EnemyLevel {
    private Boss boss[];
    private Enemy enemies[];

    public EnemyLevel(Boss[] boss, Enemy[] enemies) {
        this.boss = boss;
        this.enemies = enemies;
    }
    public EnemyLevel(EnemyLevel level) {
        this.boss = level.getBoss();
        this.enemies = level.getEnemies();
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
    public void printMob(){
        for(int i=0;i<= this.boss.length-1;i++)
            System.out.println(i+" : "+this.boss[i].getName()+" - "+this.boss[i].getHp()+" HP.");
        for(int i=this.boss.length;i<= this.enemies.length+this.boss.length-1;i++)
            System.out.println(i+" : "+this.enemies[i-this.boss.length].getName()+" - "+this.enemies[i-this.boss.length].getHp()+" HP.");

    }
    public Character chooseMob(){
        printMob();
        int index;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the number of the mob, you want to target");
            index = scanner.nextInt();
        } while (index<0||index>this.enemies.length+this.boss.length-1);
        if(index<this.boss.length-1)
            return this.boss[index];
        else
            return this.enemies[index-this.enemies.length];
    }
}
