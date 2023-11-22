import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter Packet Weight:");
        Scanner scanner = new Scanner(System.in);
        double weight = scanner.nextDouble();
        Packet packet = new Packet(weight);
        while (packet.checkContinue()){
            System.out.println("Choose Command:\n1: Change Transport Mode\n2: Change Packet State\n3: Exit");
            int command = scanner.nextInt();
            int mode;
            switch (command){
                case 1:
                    System.out.println("Enter Transport Mode:\n1: Standard\n2: Express");
                    mode = scanner.nextInt();
                    switch (mode){
                        case 1:
                            packet.setTransportMode(new StandardTransportMode());
                            break;
                        case 2:
                            packet.setTransportMode(new ExpressTransportMode());
                            break;
                        default:
                            System.out.println("Nothing Changed");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Enter State:\n1: In-Transit\n2: Delivered");
                    mode = scanner.nextInt();
                    switch (mode){
                        case 1:
                            packet.setState(new InTransitState());
                            break;
                        case 2:
                            packet.setState(new DeliveredState());
                            break;
                        default:
                            System.out.println("Nothing Changed");
                            break;
                    }
                    break;
                case 3:
                    return;
            }
            System.out.println(packet.getData());
        }
    }

}
