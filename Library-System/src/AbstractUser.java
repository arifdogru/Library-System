import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Created by Arif on 21.02.2017.
 */
public abstract class AbstractUser extends LibrarySystem implements IUser {

    protected String name;
    protected String surname;
    protected int tc_ID;
    private int typeOfUser;


    /**
     *  Set the user type for staf or user
     * @param typeOfUser type of user
     */
    public void setTypeOfUser(int typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    /**
     *
     * @return type of user
     */
    public int getTypeOfUser() {
        return typeOfUser;

    }

    /**
     *
     * @return user name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @return user surname
     */
    @Override
    public String getSurname() {
        return surname;
    }


    /**
     *
     * @return user tc
     */
    @Override
    public Integer getTcId(){ return tc_ID;}

    /**
     *  set to user name
     * @param name user name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }


    /**
     * set to user surname
     * @param surName user surname
     */
    @Override
    public void setSurname(String surName) {
        this.surname = surName;
    }

    /**
     * set to user tc
     * @param id user id
     */
    @Override
    public void setTcId(Integer id) { tc_ID = id; }

    /**
     *  add the given book to library
     * @param book book object
     * @return boolean
     * @throws NoSuchMethodException if there is not method
     */
    @Override
    public boolean addBook(Book book) throws NoSuchMethodException {
        if(getBookArrayList().contains(book))
            return false;
        else
            return getBookArrayList().add(book);
    }

    /**
     *  remove the given book from the library
     * @param book book object
     * @return boolean
     * @throws NoSuchMethodException if there is not method
     */
    @Override
    public boolean removeBook(Book book) throws NoSuchMethodException {
        if(!getBookArrayList().contains(book))
            return false;
        else
            return getBookArrayList().remove(book);
    }

    /**
     *  User can barrow book from the library by this method
     * @param book book object
     * @return boolean
     * @throws NoSuchMethodException if there is not method
     */
    @Override
    public boolean barrowBook(Book book) throws NoSuchMethodException {
        boolean flag = false;
        for(int i=0; i<getBookArrayList().size(); ++i){
            if(getBookArrayList().get(i).getBook_ID().equals(book.getBook_ID())) {
                getBookArrayList().remove(book);
                getGivenBookArrayList().add(book);
                flag = true;
            }
        }
        return flag;
    }

    /**
     * user can return the book to library by this method
     * @param book book object
     * @return boolean
     * @throws NoSuchMethodException if there is not method
     */
    @Override
    public boolean returnBook(Book book) throws NoSuchMethodException {
        boolean flag = false;

        for(int i=0; i<getGivenBookArrayList().size(); ++i){
            if(getGivenBookArrayList().get(i).getBook_ID().equals(book.getBook_ID())){
                getGivenBookArrayList().remove(book);
                getBookArrayList().add(book);
                flag =true;
            }
        }
        return flag;
    }

    /**
     * Show all available books
     */
    public void showAllBooks(){
        System.out.println("-----------------------------------");
        System.out.println("     Available Books Listing...");
        System.out.println("-----------------------------------");
        for(int i=0; i<getBookArrayList().size(); ++i){
                System.out.println(i+1+") "+getBookArrayList().get(i).toString());
        }
    }

    /**
     * Show all given books before
     */
    public void showAllGivenBooks(){
        System.out.println("---------------------------------------");
        System.out.println("     Already Given Books Listing...");
        System.out.println("---------------------------------------");
        for(int i=0; i<givenBookArrayList.size(); ++i){
            System.out.println(givenBookArrayList.get(i).toString());
        }
    }

}