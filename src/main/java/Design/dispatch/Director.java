package Design.dispatch;

public class Director extends Employee {

    public Director(int id,String name, int age ){
        super(id,name,age);
        rank=Rank.DIRECTOR;
    }

}
