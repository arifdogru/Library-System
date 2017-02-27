/**
 * Created by Arif on 21.02.2017.
 */

public interface IUser {


    Integer getTcId();
    String getName();
    String getSurname();
    void setName(String name);
    void setSurname(String surname);
    void setTcId(Integer id);
    boolean addBook(Book book) throws NoSuchMethodException;
    boolean removeBook(Book book) throws NoSuchMethodException;
    boolean barrowBook(Book book) throws NoSuchMethodException;
    boolean returnBook(Book book) throws NoSuchMethodException;

}