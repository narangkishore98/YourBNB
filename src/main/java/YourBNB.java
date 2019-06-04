
import com.yourbnb.datastore.DataStore;
import com.yourbnb.properties.Property;
import com.yourbnb.users.User;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class YourBNB
{
    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
        List<User> users = DataStore.getUsersFromJSON("C:\\Users\\naran\\IdeaProjects\\YourBNB\\src\\main\\java\\com\\yourbnb\\data.json");
        System.out.println("---------------------------------YOUR BNB-------------------------------------");
        Iterator userIterator = users.iterator();

        while(userIterator.hasNext())
        {

            User u = (User) userIterator.next();
            System.out.println(u.display());
            System.out.println("==========PROPERTIES OWNED===========");
            List<Property> ownedProperties = u.getOwnerProperties();
            Iterator ownedPropertiesIterator = ownedProperties.iterator();
            if(!ownedPropertiesIterator.hasNext())
            {
                System.out.println(">>No Properties Owned<<");
            }
            else
            {
                while (ownedPropertiesIterator.hasNext())
                {
                    Property p = (Property) ownedPropertiesIterator.next();
                    System.out.println(p.display());
                    System.out.println("----------------------------------");

                }
            }
            System.out.println("======================================");
            System.out.println("============PROPERTIES RENTED=========");
            List<User.CustomerProperties> rentedProperties = u.getCustomerProperties();
            Iterator rentedPropertiesIterator = rentedProperties.iterator();
            if(!rentedPropertiesIterator.hasNext())
            {
                System.out.println(">>No Rented Properties<<");
            }
            else
            {
                while (rentedPropertiesIterator.hasNext())
                {
                    User.CustomerProperties cp = (User.CustomerProperties) rentedPropertiesIterator.next();
                    System.out.println(cp.getProperty().display());
                    System.out.println("Booking Date: "+cp.getBookingDate());
                    System.out.println("CheckIn Date: "+cp.getCheckinDate());
                    System.out.println("CheckOut Date: "+cp.getCheckoutDate());
                    System.out.println("------------------------------------------");
                }
            }
            System.out.println("===============================================");
        }
        System.out.println("------------------------------------------------------------------------------");
    }
}
