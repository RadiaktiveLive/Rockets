import java.util.ArrayList;
import java.util.List;

public class Rocket {

    private String id;
    private List<Propeller> propellers = new ArrayList<>();

    public Rocket(String id, ArrayList<Integer> propellers) throws Exception {
        checkId(id);
        checkNumberOfPropellers(propellers);
        this.id = id;
        for (Integer current : propellers) {
            this.propellers.add(new Propeller(current));
        }
    }

    private void checkId(String id) throws Exception {
        if (!id.toUpperCase().matches("^[A-Z0-9]{8}$"))
            throw new Exception("El format del identificador no és vàlid");
    }

    private void checkNumberOfPropellers(List propellers) throws Exception {
        if (propellers.size() == 0) throw new Exception("El nombre de propulsors ha de ser superior a 0");
    }

    public String getId() {
        return id;
    }

    public void throttlePropellers() {
        for (Propeller propeller : propellers) {
            propeller.throttle();
        }
    }

    public void brakePropellers() {
        for (Propeller propeller : propellers) {
            propeller.brake();
        }
    }

    public int currentPower() {
        return propellers.stream()
                .mapToInt(Propeller::getCurrentPower)
                .sum();
    }

    @Override
    public String toString() {
        return id + ": " + propellers;
    }
}
