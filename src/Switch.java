
import java.util.HashMap;
import java.util.Objects;

public class Switch extends NetworkDevice {

    private Integer numberOfPorts;
    private HashMap<String, NetworkDevice> myMap = new HashMap<>();

    public Switch(String ID, String manufacturer, Integer linkSpeed, Integer numberOfPorts) {
        super(ID, manufacturer, linkSpeed);
        this.numberOfPorts = numberOfPorts;
        myMap = new HashMap<>();
    }

    public Switch(String ID) {
        super(ID);
    }

    public Integer getNumberOfPorts() {
        return numberOfPorts;
    }

    public void setNumberOfPorts(Integer numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
    }

    //PART B
    public void addRoute(String iPAddress, NetworkDevice networkDevice) {
    this.myMap.put(iPAddress, networkDevice);
    }

    @Override
    public String toString() {
         return String.format("\n%s Number of Ports: %s",
                super.toString(),
                numberOfPorts);
    }
}