package TwoPointerAlgorithm.CodeForces;

/**
 * Created by suhane on 12/5/16.
 */
public class InstanceCounter {

    private  int numInstances = 0;

    protected  int getCount() {
        return numInstances;
    }

    private  void addInstance() {
        numInstances++;
    }

    InstanceCounter() {
        this.addInstance();
    }

    public static void main(String[] arguments) {
        InstanceCounter ins= new InstanceCounter();
        System.out.println("Starting with " + ins.getCount() + " instances");

        for (int i = 0; i < 500; ++i) {
            new InstanceCounter();
        }
        System.out.println("Created " + ins.getCount() + " instances");
    }
}
