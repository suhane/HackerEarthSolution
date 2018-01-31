package Design.coupling;

class NormalReport implements Report{

    public boolean loadFromFile(String fileName) {
        return false;
    }

    public boolean saveToFile(String fileName) {
        return false;
    }
}


class Printer

{

    public static void print(Report report){
        //some code here
    }

}

interface  Report {

     boolean loadFromFile(String fileName);

     boolean saveToFile(String fileName);

}

public class LooseCoupling

{

    public static void main(String args[])

    {

        Report myReport = new NormalReport();

        myReport.loadFromFile("DailyReport.xml");

        Printer.print(myReport);

    }

}
