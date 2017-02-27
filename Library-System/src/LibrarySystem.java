import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Arif on 21.02.2017.
 */
public class LibrarySystem {

    protected static ArrayList<Book>  bookArrayList = new ArrayList<Book>();
    protected static ArrayList<Book> givenBookArrayList = new ArrayList<Book>();
    protected static ArrayList<User> userArrayList = new ArrayList<User>();
    protected static ArrayList<Staff> staffArrayList = new ArrayList<Staff>();

    /**
     * Reach the available book list by this method
     * @return Available Book List
     */
    public ArrayList<Book> getBookArrayList(){
        return bookArrayList;
    }

    /**
     * Reach the given book list by this method
     * @return given book list
     */
    public ArrayList<Book> getGivenBookArrayList(){
        return givenBookArrayList;
    }

    /**
     * reach the all users
     * @return all users list
     * @throws NoSuchMethodException if there is not method
     */
    public ArrayList<User> getUserArrayList() throws NoSuchMethodException {
        return userArrayList;
    }

    /**
     * reach the all staff
     * @return staff list
     * @throws NoSuchMethodException if there is not method
     */
    public ArrayList<Staff> getStaffArrayList() throws NoSuchMethodException {
        return staffArrayList;
    }

    /**
     * initialize the program book database from the csv file
     * @param fileName database file name
     * @throws IOException file not found
     * @throws NoSuchMethodException if there is not method
     */
    public void initializeDataBase(String fileName ) throws IOException, NoSuchMethodException {

        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));

        if(!file.canRead())
            throw new FileNotFoundException();
        String line;
        while ((line = br.readLine()) != null) {

            StringTokenizer lineTokens = new StringTokenizer(line,";");
            String bookName = lineTokens.nextToken();
            String authorName = lineTokens.nextToken();
            Integer bookID = Integer.parseInt(lineTokens.nextToken());
            bookArrayList.add(new Book(bookName,authorName,bookID));
        }
        br.close();
    }

    /**
     * initialize the given book database from the csv file
     * @param fileName database file name
     * @throws FileNotFoundException if there is not method
     */
    public void initializeGivenBooksDatabase(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        if(!file.canRead())
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        String line;
        try {
            while ((line = br.readLine()) != null) {
                StringTokenizer lineTokens = new StringTokenizer(line, ";");
                String bookName = lineTokens.nextToken();
                String authorName = lineTokens.nextToken();
                Integer bookID = Integer.parseInt(lineTokens.nextToken());
                getGivenBookArrayList().add(new Book(bookName, authorName, bookID));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Load all users from the csv file
     * @param fileName database file name for user
     * @throws NoSuchMethodException if there is not method
     * @throws IOException if file not found
     */
    public void loadAllUsers(String fileName) throws NoSuchMethodException, IOException {

        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));

        if(!file.canRead())
            throw new FileNotFoundException();
        String line;
        while ((line = br.readLine()) != null) {
            // process the line.
            StringTokenizer lineTokens = new StringTokenizer(line,";");
            String userName = lineTokens.nextToken();
            String surname = lineTokens.nextToken();
            Integer tcID = Integer.parseInt(lineTokens.nextToken());
            Integer type = Integer.parseInt(lineTokens.nextToken());
            if(type == -1)
                getStaffArrayList().add(new Staff(userName,surname,tcID));
            else
                getUserArrayList().add(new User(userName,surname,tcID));
        }
        br.close();
    }

    /**
     * update all users
     * @param fileName database file name for user
     * @throws IOException file not found
     * @throws NoSuchMethodException if there is not method
     */
    public void updateAllUser(String fileName) throws IOException, NoSuchMethodException {
        File file = new File(fileName);
        FileWriter writer ;
        writer = new FileWriter(file, false);
        PrintWriter printWriter = new PrintWriter(writer);
        for(int i=0; i<getStaffArrayList().size(); ++i) {
            printWriter.println(getStaffArrayList().get(i).getName()+";"+getStaffArrayList().get(i).getSurname()+";"+
                    getStaffArrayList().get(i).getTcId()+";-1");
        }
        for (int i=0; i<getUserArrayList().size(); ++i){
            printWriter.println(getUserArrayList().get(i).getName()+";"+getUserArrayList().get(i).getSurname()+";"+
                    getUserArrayList().get(i).getTcId()+";0");
        }



        printWriter.close();
    }

    /**
     * update book database
     * @param fileName database file name for book
     * @throws IOException file not found
     * @throws NoSuchMethodException if there is not method
     */
    public void updateDatabase(String fileName) throws IOException, NoSuchMethodException {
        File file = new File(fileName);
        FileWriter writer ;
        writer = new FileWriter(file, false);
        PrintWriter printWriter = new PrintWriter(writer);
        for(int i=0; i<getBookArrayList().size(); ++i) {
            printWriter.println(getBookArrayList().get(i).getName()+";"+getBookArrayList().get(i).getAuthor()+";"+
                    getBookArrayList().get(i).getBook_ID());
        }
        printWriter.close();
    }

    /**
     * update given book database
     * @param fileName given book database file name
     * @throws IOException if there is not exist file
     * @throws NoSuchMethodException if there is not method
     */
    public void updateGivenBooksDatabase(String fileName) throws IOException, NoSuchMethodException {
        File file = new File(fileName);
        FileWriter writer ;
        writer = new FileWriter(file, false);
        PrintWriter printWriter = new PrintWriter(writer);
        for(int i=0; i<getGivenBookArrayList().size(); ++i) {
            printWriter.println(getGivenBookArrayList().get(i).getName()+";"+getGivenBookArrayList().get(i).getAuthor()+";"+
                    getGivenBookArrayList().get(i).getBook_ID());
        }
        printWriter.close();
    }

    /**
     * check user is staff or not
     * @param tc staff tc id
     * @return boolean
     * @throws NoSuchMethodException  if there is not method
     */
    public boolean isStaff(int tc) throws NoSuchMethodException {
        boolean flag=false;
        for (int i=0; i<getStaffArrayList().size(); ++i){
            if(getStaffArrayList().get(i).getTcId().equals(tc)){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * check user is user or not
     * @param tc user tc id
     * @return boolean
     * @throws NoSuchMethodException if there is not method
     */
    public boolean isUser(int tc) throws NoSuchMethodException {
        boolean flag=false;
        for (int i=0; i<getUserArrayList().size(); ++i){
            if(getUserArrayList().get(i).getTcId().equals(tc)){
                flag = true;
            }
        }
        return flag;
    }

}
