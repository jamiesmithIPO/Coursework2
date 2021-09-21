import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<NetworkDevice> networkDevices = new ArrayList<>();
    public static ArrayList<Message> messages = new ArrayList<>();

    public static void main(String[] args) throws IOException {


        readData();
//        sendAllMessages();
//        printNetworkDevices();
//        getNetworkDeviceById("1");
    }

    public static NetworkDevice getNetworkDeviceById(String deviceID) {

        for (NetworkDevice networkDevice : networkDevices) {
            if (deviceID.equals(networkDevice.getDeviceID())) {
                System.out.println(networkDevice);
                return networkDevice;
            }
        }
        return null;
    }

    // PART D
    public static void printNetworkDevices() {
        for (NetworkDevice networkDevice : networkDevices) {
            System.out.println(networkDevice);
        }
    }
    //TODO VERIFY AND TEST
    public void send(Message message) {

        receive(message);
    }
    //TODO VERIFY AND TEST
    public void receive(Message message) {
        send(message);
    }
    //TODO VERIFY AND TEST
    public static void sendAllMessages() {
        for (Message message : messages) {
            message.getSource();
            message.getDestination();
            System.out.println(message);


        }
    }

    public static void readData() throws IOException {
        File file = new File("SimplestData.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] parts = line.split(",");
            line.split("\\.");

            String iD1;
            String iD2;
            String typeOfDevice;
            String manufacturer;
            Integer linkSpeed;
            String type;
            String iPAddress;
            String sourceIPAddress;
            String destinationAddress;
            Integer numberOfPorts;
            int size;
            byte[] data;

            if (parts[1].equals("C")) {
                type = parts[0];
                typeOfDevice = parts[1];
                iD2 = parts[2];
                manufacturer = parts[3];
                linkSpeed = Integer.parseInt(parts[4]);
                iPAddress = parts[5];
                NetworkDevice computer = new Computer(iD2, manufacturer, linkSpeed, iPAddress);
                networkDevices.add(computer);
            }

            if (parts[1].equals("S")) {
                type = parts[0];
                typeOfDevice = parts[1];
                iD2 = parts[2];
                manufacturer = parts[3];
                linkSpeed = Integer.parseInt(parts[4]);
                numberOfPorts = Integer.parseInt(parts[5]);
                NetworkDevice switch1 = new Switch(iD2, manufacturer, linkSpeed, numberOfPorts);
                networkDevices.add(switch1);
            }

            if (parts[0].equals("CONNECTION") && line.length ()==3){
                type = parts[0];
                iD1 = parts[1];
                iD2 = parts[2];

                NetworkDevice computerID =  getNetworkDeviceById(iD1);

                computerID.setDeviceID(iD1);
                ((Computer) computerID).setConnectedTo(getNetworkDeviceById(iD2));

                System.out.println ( "test" );
            }

            if (parts[0].equals("CONNECTION") && line.contains ( "." )) {
                type = parts[0];
                iD1 = parts[1];
                iD2 = parts[2];
                iPAddress = parts[3];

                NetworkDevice switchID = getNetworkDeviceById(iD1);
                ((Switch) switchID).addRoute(iPAddress, switchID);

//                System.out.println ( networkDevices);
            }
            if (parts[0].equals("MESSAGE")) {
                type = parts[0];
                sourceIPAddress = parts[1];
                destinationAddress = parts[2];
                data = parts[3].getBytes();
                size = Integer.parseInt(parts[4]);

                Message message = new Message(sourceIPAddress, destinationAddress, data, size);
                messages.add(message);

            }
        }
    }
}
