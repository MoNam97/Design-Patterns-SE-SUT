public class InTransitState implements State {
    @Override
    public boolean checkContinue() {
        return true;
    }

    @Override
    public String toString(){
        return "In-Transit";
    }
}
