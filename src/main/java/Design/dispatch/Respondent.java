package Design.dispatch;

public class Respondent extends Employee {

    public Respondent(int id,String name, int age ){
        super(id,name,age);
        rank = Rank.RESPONDENT;
    }


}
