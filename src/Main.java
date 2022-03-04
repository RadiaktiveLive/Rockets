import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Rocket> rockets = createRockets();
        printRocketsInformation(rockets);
        throttleRockets(rockets, 3);
        printRocketsCurrentPower(rockets);
        brakeSingleRocket(findRocketById(rockets, "32WESSDS"), 5);
        throttleSingleRocket(findRocketById(rockets, "LDSFJA32"), 7);
        printRocketsCurrentPower(rockets);
        throttleRockets(rockets, 15);
        printRocketsCurrentPower(rockets);
    }

    private static List<Rocket> createRockets() throws Exception {
        List<Rocket> rockets = new ArrayList<>();
        rockets.add(new Rocket("32WESSDS", new ArrayList<Integer>(Arrays.asList(10, 30, 80))));
        rockets.add(new Rocket("LDSFJA32", new ArrayList<Integer>(Arrays.asList(30, 40, 50, 50, 30, 10))));
        return rockets;
    }

    private static void printRocketsInformation(List<Rocket> rockets) {
        System.out.println("Rocket info:");
        for (Rocket currentRocket : rockets) {
            System.out.println(currentRocket);
        }
    }

    private static void printRocketsCurrentPower(List<Rocket> rockets) {
        System.out.println("Rocket current power:");
        for (Rocket currentRocket : rockets) {
            System.out.println(currentRocket.getId() + ": " + currentRocket.currentPower());
        }
    }

    private static void throttleRockets(List<Rocket> rockets, int howManyTimes) {
        for (Rocket rocket : rockets) {
            throttleSingleRocket(rocket, howManyTimes);
        }
    }

    private static void throttleSingleRocket(Rocket rocket, int howManyTimes) {
        for (int i = 0; i < howManyTimes; i++) {
            rocket.throttlePropellers();
        }
    }

    private static void brakeSingleRocket(Rocket rocket, int howManyTimes) {
        for (int i = 0; i < howManyTimes; i++) {
            rocket.brakePropellers();
        }
    }

    public static Rocket findRocketById(List<Rocket> rockets, String rocketToFind) {
        return rockets.stream()
                .filter(rocket -> rocketToFind.equals(rocket.getId()))
                .findFirst()
                .orElse(null);
    }
}
