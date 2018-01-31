package Design.dispatch;

abstract class Employee {

    int id;
    String name;
    int age;
    boolean available;
    protected Rank rank;

    public Rank getRank() {
        return rank;
    }

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        available = true;
    }

    public void getCall(Call call) {
        available=false;
        call.reply("Hi My name is "+ this.name+".How can I help you?");
    }

    public boolean isAvailable() {
        return available;
    }

}
