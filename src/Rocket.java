public class Rocket {

    private String id;
    private int numberOfPropellers;

    public Rocket(String id, int numberOfPropellers) throws Exception {
        checkId(id);
        checkNumberOfPropellers(numberOfPropellers);
        this.id = id;
        this.numberOfPropellers = numberOfPropellers;
    }

    private void checkId(String id) throws Exception {
        if (!id.toUpperCase().matches("^[A-Za-z0-9 -]{8}$"))
            throw new Exception("El format del identificador no és vàlid");
    }

    private void checkNumberOfPropellers(int numberOfPropellers) throws Exception {
        if (numberOfPropellers <= 0) throw new Exception("El nombre de propulsors ha de ser superior a 0");
    }

    @Override
    public String toString() {
        return id + ": " + numberOfPropellers + " propulsors";
    }
}
