import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Rocket> rockets = createRockets();
        printRocketsInformation(rockets);

    }

    private static void printRocketsInformation(List<Rocket> rockets) {
        for (Rocket currentRocket : rockets) {
            System.out.println(currentRocket);
        }
    }

    private static List<Rocket> createRockets() throws Exception {
        List<Rocket> rockets = new ArrayList<>();
        rockets.add(new Rocket("32WESSDS", new ArrayList<Integer>(Arrays.asList(10, 30, 80))));
        rockets.add(new Rocket("LDSFJA32", new ArrayList<Integer>(Arrays.asList(30, 40, 50, 50, 30, 10))));
        return rockets;
    }
}
