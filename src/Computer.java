import java.util.Objects;

public class Computer extends NetworkDevice {

    private static final String NULL_MESSAGE = "*disconnected*";

    private String iPAddress;
    private NetworkDevice connectedTo;

    public Computer(String ID, String manufacturer, int linkSpeed, String iPAddress) {
        super(ID, manufacturer, linkSpeed);
        this.iPAddress = iPAddress;
    }

    public Computer(String ID) {
        super(ID);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer)) return false;
        Computer computer = (Computer) o;
        return Objects.equals(getIPAddress(), computer.getIPAddress()) && Objects.equals(getConnectedTo(),
                computer.getConnectedTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIPAddress(), getConnectedTo());
    }

    public String getIPAddress() {
        return iPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.iPAddress = IPAddress;
    }

    public NetworkDevice getConnectedTo() {
       return connectedTo;
    }

    public void setConnectedTo(NetworkDevice connectedTo) {
        this.connectedTo = connectedTo;
    }

    @Override
    public String toString() {
        return String.format("\n%s IP Address: %s | Connected to:  %s",
                super.toString(),
                iPAddress,
                connectedTo == null ? NULL_MESSAGE : connectedTo);
    }
}
