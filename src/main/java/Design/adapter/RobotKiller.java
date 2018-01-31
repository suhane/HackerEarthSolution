package Design.adapter;

public class RobotKiller implements Robot{

    int steps=0;
    public void walk(int steps) {
        System.out.println("Walking "+steps+" forward");
        this.steps+=steps;
    }

    public void kill(int n) {
        System.out.println("Kill "+n+" enemies");
    }

    public void walkBack() {
        System.out.println("Talking back "+this.steps +" steps");
    }
}
