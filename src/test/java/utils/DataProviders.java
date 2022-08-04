package utils;

import com.telran.contacts.models.Contact;
import com.telran.contacts.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Goga", "Olya", "12345678988", "oli@gm.com", "Hamburg", "goalkiper"});
        list.add(new Object[]{"Goga", "Olya", "12345678982", "oli1@gm.com", "Hamburg", "goalkiper"});
        list.add(new Object[]{"Goga", "Olya", "1234567892", "oli2@gm.com", "Hamburg", "goalkiper"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact2.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0])
                    .setSureName(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDiscription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> addNewContactFormCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/NegativeTestContacts .csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().setEmail(split[0])
                    .setPassword(split[1])
            });
            line = reader.readLine();
        }
        return list.iterator();
    }
}