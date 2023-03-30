import java.util.ArrayList;
import java.util.Scanner;

public class EnemyLevel {
    private ArrayList<AbstractEnemy> bossEnemy;

    public EnemyLevel(ArrayList<AbstractEnemy> bossEnemy) {
        this.bossEnemy = new ArrayList<>(bossEnemy);
    }
    public EnemyLevel(EnemyLevel level) {
        this.bossEnemy = level.getBossEnemy();
    }

    public ArrayList<AbstractEnemy> getBossEnemy() {
        return bossEnemy;
    }

    public boolean areDead(){
        for(int i=0;i<=bossEnemy.size()-1;i++) {
            if (bossEnemy.get(i).getHp() <= 0) {
                this.bossEnemy.remove(bossEnemy.get(i));
                System.out.println("test");
            }else
                return false;
        }
        return true;
    }
    public void printMob(){
        for(int i=0;i<= this.bossEnemy.size()-1;i++)
            System.out.println(i+" : "+this.bossEnemy.get(i).getName()+" - "+this.bossEnemy.get(i).getHp()+" HP.");

    }
    public Character chooseMob(){
        printMob();
        int index;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the number of the mob, you want to target");
            index = scanner.nextInt();
        } while (index<0||index>this.bossEnemy.size()-1);
        return this.bossEnemy.get(index);
    }
    public void mobTurn(Wizard player) {   // Add effect Defense of player in consideration
        for (int i = 0; i <= this.bossEnemy.size() - 1; i++) {
            this.bossEnemy.get(i).enemyTurn(player);
        }
    }
}
