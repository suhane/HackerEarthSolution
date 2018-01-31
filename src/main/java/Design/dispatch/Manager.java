package Design.dispatch;

public class Manager extends Employee {

    public Manager(int id,String name, int age ){
        super(id,name,age);
        rank=Rank.MANAGER;
    }


}
