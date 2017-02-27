import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;

import java.util.Objects;

/**
 * Created by Arif on 22.02.2017.
 */
public class Book {

    private String name;
    private String author;
    private int book_ID;

    /**
     * Constructer
     * @param name book name
     * @param authorName author name
     * @param id book id
     */
    public Book(String name,String authorName, int id) {
        this.name = name;
        author = authorName;
        this.book_ID = id;
    }

    /**
     * Constructer
     * no parameter constructer
     */
    public  Book(){
        name = "temp";
        author = "Unknown author";
        book_ID = -1;
    }

    /**
     *  Constructer one parameter  constructer
     * @param id book id
     */
    public Book(int id){
        book_ID = id;
    }

    /**
     * set to book name
     * @param name book name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ser to author
     * @param authorName author mame
     */
    public void setAuthor(String authorName){ author = authorName; }

    /**
     * set to book id
     * @param book_ID book id
     */
    public void setBook_ID(Integer book_ID) {
        this.book_ID = book_ID;
    }

    /**
     *
     * @return book id
     */
    public Integer getBook_ID() {
        return book_ID;
    }

    /**
     *
     * @return book name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return author name
     */
    public String getAuthor(){
        return author;
    }

    /**
     *
     * @return book name author name book id
     */
    @Override
    public String toString(){
        return "Book Name:"+name +", Author Name:"+ author+", Book Id:"+book_ID;
    }

    /**
     *
     * @param o an object
     * @return boolean
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Book)){
            return false;
        }

        Book book = (Book) o;
        return book_ID == book.getBook_ID();

    }
}