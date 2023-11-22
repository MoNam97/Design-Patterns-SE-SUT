public class ExpressTransportMode implements TransportMode {
    @Override
    public double calcCost(double weight) {
        return 3.5 * weight;
    }

    @Override
    public String toString(){
        return "Express";
    }
}
