package AggregationVsComposition;

class Book
{

    private String title;
    private String author;


    Book(String title, String author )
    {

        this.title = title;
        this.author = author;
    }
}

class Publication{

    private Book book;

    Publication(){
        this.book=new Book("DesignAnd Algo","Coreman");
    }

}