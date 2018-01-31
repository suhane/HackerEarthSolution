package Design.dispatch;

public class Call {

    private Caller caller;
    private Employee handler;

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    private Rank rank;

    public void setHandler(Employee handler) {
        this.handler = handler;
    }

    public Call(Caller c){
        this.caller=c;
        rank=Rank.RESPONDENT;
    }

    public void reply(String message){
        System.out.println(message);

    }

    public Rank incrementRank(){
        return  Rank.getRankFromValue(rank.value++);
    }

    public void disconnect(){
        handler.available=true;
    }
}
