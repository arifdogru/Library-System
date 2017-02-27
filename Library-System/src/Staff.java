/**
 * Created by Arif on 22.02.2017.
 */
public class Staff extends AbstractUser{
    //private static final int isStaff = 1;
    public Staff() {
        setName("Unknown staffName");
        setSurname("Unknown staffSurname");
        setTcId(-1);
        setTypeOfUser(-1);
    }
    public Staff(String name, String surname, Integer tc){
        setName(name);
        setSurname(surname);
        setTcId(tc);
        setTypeOfUser(-1);
    }
    /*public int getIsStaff(){
        return isStaff;
    }*/

    @Override
    public boolean barrowBook(Book book) throws NoSuchMethodException {
        throw new NoSuchMethodException();
    }

    @Override
    public boolean returnBook(Book book) throws NoSuchMethodException {
        throw new NoSuchMethodException();
    }

    public boolean addUserToLibrary(User user) {
        try {
            if(!getUserArrayList().contains(user))
                return getUserArrayList().add(user);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addStaff(Staff stf){
        boolean flag = false;
        if(stf != null) {
            try {
                if (!getStaffArrayList().contains(stf)) {
                    getStaffArrayList().add(stf);
                    flag = true;
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Staff)){
            return false;
        }

        Staff staff = (Staff) obj;
        return this.toString() == staff.toString();
    }

}