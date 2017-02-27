import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Arif on 22.02.2017.
 */
public class User extends AbstractUser{
    //private static final int isUser = -1;

    /**
     * Constructer
     * @param name user name
     * @param surname user surname
     * @param tc user id
     */
    public User(String name, String surname, Integer tc) {
        setName(name);
        setSurname(surname);
        setTcId(tc);
        setTypeOfUser(0);

    }

    /**
     *  no parameter constructer
     */
    public User(){

        setName( "Unknown userName");
        setSurname( "Unknown userSurname");
        setTcId(-1);
        setTypeOfUser(0);
    }

    /**
     *
     * @return user can not reach all users this method
     * created for Staff
     * @throws NoSuchMethodException if there is not method
     */
    @Override
    public ArrayList<User> getUserArrayList() throws NoSuchMethodException {
        throw new NoSuchMethodException();
    }

    /**
     *
     * @return user can not reach all staff this method
     * created for Staff
     * @throws NoSuchMethodException if there is not method
     */
    @Override
    public ArrayList<Staff> getStaffArrayList() throws NoSuchMethodException {
        throw new NoSuchMethodException();
    }

    /**
     * user can not initialize database this method
     * created for Staff
     * @param fileName database file name
     * @throws IOException file not found
     * @throws NoSuchMethodException if there is not method
     */
    @Override
    public void initializeDataBase(String fileName) throws IOException, NoSuchMethodException {
        throw new NoSuchMethodException();
    }

    /**
     * user can not update database this method
     * created for Staff
     * @param fileName database filename
     * @throws IOException file not found
     * @throws NoSuchMethodException if there is not method
     */
    @Override
    public void updateDatabase(String fileName) throws IOException, NoSuchMethodException {
        throw new NoSuchMethodException();
    }

    /**
     * user can not update given books database this method
     * created for Staff
     * @param fileName database file name
     * @throws IOException if file not found
     * @throws NoSuchMethodException if there is not method
     */
    @Override
    public void updateGivenBooksDatabase(String fileName) throws IOException, NoSuchMethodException {
        throw new NoSuchMethodException();
    }


   /* public int getIsUser(){
        return isUser;
    }*/

    /**
     *  user can not add book to library this method
     * created for Staff
     * @param book  book which wanted to add
     * @return exception
     * @throws NoSuchMethodException if there is not method
     */
    @Override
    public boolean addBook(Book book) throws NoSuchMethodException {
        throw new NoSuchMethodException();
    }

    /**
     * user can not remove book from library this method
     * created for Staff
     * @param book book whch wanted to remove
     * @return exception
     * @throws NoSuchMethodException if there is not method
     */
    @Override
    public boolean removeBook(Book book) throws NoSuchMethodException {
        throw new NoSuchMethodException();
    }

    /**
     *  check equality two users
     * @param obj an object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof User)){
            return false;
        }

        User user = (User) obj;
        return tc_ID == user.getTcId();
    }

}
