package Design.adapter;

public class EnemyKillerAdapter implements EnemyKiller{

    Robot robot;
    public EnemyKillerAdapter(Robot newRobot){
        this.robot=newRobot;
    }

    public void moveForward(int steps) {
        robot.walk(steps);
    }

    public void fire() {
        robot.kill(2);
    }

    public void retreat() {
        robot.walkBack();

    }
}
