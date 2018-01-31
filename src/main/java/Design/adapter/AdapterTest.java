package Design.adapter;

public class AdapterTest {

    public static void main(String args[]){

        EnemyKiller enemykillertank= new EnemyKillerTank();
        enemykillertank.moveForward(3);
        enemykillertank.fire();
        enemykillertank.retreat();

        EnemyKiller enemyKillerRobot=new EnemyKillerAdapter(new RobotKiller());
        enemyKillerRobot.moveForward(3);
        enemyKillerRobot.fire();
        enemyKillerRobot.retreat();

    }
}
