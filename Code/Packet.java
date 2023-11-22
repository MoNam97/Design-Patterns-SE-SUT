public class Packet implements State {
    private double weight;
    private State state;
    private TransportMode transportMode;

    public Packet (double weight){
        this.weight = weight;
        this.state = new InTransitState();
        this.transportMode = new StandardTransportMode();
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return this.state;
    }

    public double calcCost(){
        return transportMode.calcCost(weight);
    }

    public void setTransportMode(TransportMode transportMode){
        this.transportMode = transportMode;
    }

    public TransportMode getTransportMode(){
        return this.transportMode;
    }

    public String getData(){
        return "The Packet With State " + state.toString() + " is in " + transportMode.toString() + " mode.\nIt costs " + Double.toString(calcCost());
    }

    @Override
    public boolean checkContinue() {
        return state.checkContinue();
    }
}
