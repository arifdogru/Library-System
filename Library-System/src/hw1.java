import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Arif on 25.02.2017.
 */
public class hw1 {
    public static void main(String args[]) throws NoSuchMethodException{
        LibrarySystem system = new LibrarySystem();
        Staff admin = new Staff("arif","dogru",222);
        admin.setTypeOfUser(-1);
        try {
            admin.loadAllUsers("dataBase/allUsers.csv");
            system.initializeDataBase("dataBase/books.csv");
        } catch (IOException e) {
            System.out.println("initialize error! Program will end");
            System.exit(0);
        }
        try {
            system.updateGivenBooksDatabase("dataBase/givenBooks.csv");
        } catch (IOException e) {
            System.out.println("Update given book error");
        }


        //admin.addStaff(admin);


        System.out.println("not: açılışta kayıtlı kullanıcılardan birinin tc idsi girilmelidir.\n" +
                "Bu işlem için allUsers dosyasından bir tc numarası girebilirsiniz");
        System.out.println("**********************************");
        System.out.println("***** Welcome To GIT Library *****");
        System.out.println("**********************************");
        Scanner reader = new Scanner(System.in);

            System.out.println("Please Enter Your Tc ID:");
            Integer inpTc = reader.nextInt();
            String choose;
            if(!reader.hasNextInt()) {
                System.out.println("Invalid input!");
                System.out.print("Enter an integer: ");
                //reader.next();

            }
            if (system.isStaff(inpTc)) {
                System.out.println("Enter your name: ");
                String userName = reader.next();
                System.out.println("Enter your surname: ");
                String userSurname = reader.next();
                Staff staff = new Staff(userName, userSurname, inpTc);
                admin.addStaff(staff);
                System.out.println("---------------------------");
                System.out.println("-- Staff Operation Panel --");
                System.out.println("   1. Add User                 ");
                System.out.println("   2. Add Book                 ");
                System.out.println("   3. Remove Book              ");
                System.out.println("   4. List Available Books     ");
                System.out.println("   5. List Given Books Before  ");
                System.out.println("   6. Exit                     ");
                System.out.println("-------------------------------");
                System.out.println("Choose your operation from the list(Enter integer) :");
                choose = reader.next();
                int choice = Integer.parseInt(choose);
                if (choice == 1) {
                    System.out.println("Enter Name: ");
                    String name = reader.nextLine();
                    System.out.println("Enter Surname: ");
                    String surname = reader.nextLine();
                    System.out.println("Enter Tc:");
                    int tcid = reader.nextInt();
                    User user1 = new User(name, surname, tcid);
                    if (staff.addUserToLibrary(user1))
                        System.out.println(name + " " + surname + " " + tcid + " - is Added Library System");
                    else
                        System.out.println(name + " " + surname + " " + tcid + " - is already exist");
                } else if (choice == 2) {
                    System.out.println("Enter Book Name: ");
                    String bookName = reader.nextLine();
                    System.out.println("Enter Author Name: ");
                    String authorName = reader.nextLine();
                    System.out.println("Enter Boook Id: ");
                    int bId = reader.nextInt();
                    Book book = new Book(bookName, authorName, bId);
                    if (staff.addBook(book))
                        System.out.println(book.toString() + " - is Added Book List");
                    else
                        System.out.println(book.toString() + " - is already exist");
                } else if (choice == 3) {
                    System.out.println("Enter Book Name: ");
                    String bookName = reader.nextLine();
                    System.out.println("Enter Author Name: ");
                    String authorName = reader.nextLine();
                    System.out.println("Enter Boook Id: ");
                    int bId = reader.nextInt();
                    Book book = new Book(bookName, authorName, bId);
                    if (staff.removeBook(book))
                        System.out.println(book.toString() + " - is Removed From Book List");
                    else
                        System.out.println(book.toString() + " - is not found to remove");
                } else if (choice == 4) {
                    staff.showAllBooks();
                } else if (choice == 5) {
                    staff.showAllGivenBooks();
                } else if (choice == 6) {
                    System.exit(1);
                } else {
                    System.out.println("Choose your operation from the list(Enter integer) :");
                    choice = Integer.parseInt(choose);
                }
            } else if (system.isUser(inpTc)) {
                System.out.println("Enter your name: ");
                String userName = reader.next();
                System.out.println("Enter your surname: ");
                String userSurname = reader.next();
                User user = new User(userName, userSurname, inpTc);
                admin.addUserToLibrary(user);
                System.out.println("---------------------------");
                System.out.println("-- User Operation Panel --");
                System.out.println("   1. Barrow Book               ");
                System.out.println("   2. Return Book               ");
                System.out.println("   3. List Available Books      ");
                System.out.println("   4. List Given Books Before   ");
                System.out.println("   5. Exit                      ");
                System.out.println("--------------------------------");
                System.out.println("Choose your operation from the list(Enter integer) :");
                choose = reader.next();
                int choice = Integer.parseInt(choose);

                if (choice == 1) {
                    user.showAllBooks();
                    System.out.println("Enter Boook Id: ");
                    int bId = reader.nextInt();
                    Book book = new Book(bId);
                    if (user.barrowBook(book))
                        System.out.println(" Borrow Successful..");
                    else
                        System.out.println(book.toString() + "--> is already given or not found");
                } else if (choice == 2) {
                    user.showAllGivenBooks();
                    System.out.println("Enter Book Name: ");
                    String bookName = reader.nextLine();
                    System.out.println("Enter Author Name: ");
                    String authorName = reader.nextLine();
                    System.out.println("Enter Boook Id: ");
                    int bId = reader.nextInt();
                    Book book = new Book(bookName, authorName, bId);
                    if (user.returnBook(book)) {
                        System.out.println(book.toString() + " --> Return Book Successful");
                    }

                    } else if (choice == 3) {
                        user.showAllBooks();
                    } else if (choice == 4) {
                        user.showAllGivenBooks();
                    } else if (choice == 5)
                        System.exit(1);
                    else {
                        while (true) {
                            System.out.println("Please enter number between [1-6]");

                        }
                    }

            } else
                System.out.println("This user is not registered yet");


        try {
            system.updateAllUser("dataBase/allUsers.csv");
            admin.updateGivenBooksDatabase("dataBase/givenBooks.csv");
            admin.updateDatabase("dataBase/books.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}