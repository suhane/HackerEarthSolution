package Design.adapter;

public class EnemyKillerTank implements EnemyKiller{


    int steps=0;

    public void moveForward(int stepsForward) {

        System.out.println("Moving "+stepsForward+" steps forward");
        this.steps+=stepsForward;


    }

    public void fire() {
        System.out.println("Firing at the enemy camp");
    }

    public void retreat() {
        System.out.println("Moving "+this.steps+" backwards");
        this.steps=0;
    }
}
