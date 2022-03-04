import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Rocket> rockets = createRockets();
        printRocketsInformation(rockets);

    }

    private static void printRocketsInformation(List<Rocket> rockets) {
        for (Rocket currentRocket : rockets) {
            System.out.println(currentRocket.toString());
        }
    }

    private static List<Rocket> createRockets() throws Exception {
        List<Rocket> rockets = new ArrayList<>();
        rockets.add(new Rocket("32WESSDS", 3));
        rockets.add(new Rocket("LDSFJA32", 6));
        return rockets;
    }
}
