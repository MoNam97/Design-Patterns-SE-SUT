public class StandardTransportMode implements TransportMode {
    @Override
    public double calcCost(double weight) {
        return 2.5 * weight;
    }

    @Override
    public String toString(){
        return "Standard";
    }
}
