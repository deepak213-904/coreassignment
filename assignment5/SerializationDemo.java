import java.io.*;
import java.util.*;

class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    private String city, state, nation;
    private int postalCode;

    public Location(String city, String state, int postalCode, String nation) {
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.nation = nation;
    }

    public String toString() {
        return city + ", " + state + " - " + postalCode + ", " + nation;
    }
}

class Learner implements Serializable {
    private static final long serialVersionUID = 2L;
    private String name;
    private String birthDate;
    private Location location;

    public Learner(String name, String birthDate, Location location) {
        this.name = name;
        this.birthDate = birthDate;
        this.location = location;
    }

    public String toString() {
        return "Learner{name='" + name + "', birthDate='" + birthDate + "', location=" + location + "}";
    }
}

public class SerializationDemo {
    public static void main(String[] args) throws IOException {
        List<Learner> learners = Arrays.asList(
            new Learner("Rohan", "2001-07-22", new Location("Kolkata", "WB", 700001, "India")),
            new Learner("Sohini", "2000-11-05", new Location("Bangalore", "KA", 560001, "India"))
        );
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("learners.ser"))) {
            oos.writeObject(learners);
        }
        System.out.println("Serialization completed successfully.");
    }
}

class DeserializationDemo {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("learners.ser"))) {
            List<Learner> learners = (List<Learner>) ois.readObject();
            learners.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
