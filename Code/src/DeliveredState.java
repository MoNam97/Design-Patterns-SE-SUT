public class DeliveredState implements State {
    @Override
    public boolean checkContinue() {
        return false;
    }

    @Override
    public String toString(){
        return "Delivered";
    }
}
