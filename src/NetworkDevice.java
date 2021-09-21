
class NetworkDevice {

    private static final String NO_DEVICE_FOUND = "Error - No Device Detected";
    private String deviceID;
    private String manufacturer;
    private Integer linkSpeed;


    public NetworkDevice(String ID, String manufacturer, Integer linkSpeed) {
        this.deviceID = ID;
        this.manufacturer = manufacturer;
        this.linkSpeed = linkSpeed;
    }

    public NetworkDevice(String ID) {
        this.deviceID = ID;
    }

    public NetworkDevice() {

    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getLinkSpeed() {
        return linkSpeed;
    }

    public void setLinkSpeed(Integer linkSpeed) {
        this.linkSpeed = linkSpeed;
    }

    @Override
    public String toString() {
        return String.format("\n%s | ID: %s | Manufacturer: %s | Link Speed: %s |",
                getClass(),
                deviceID == null ? NO_DEVICE_FOUND : deviceID,
                manufacturer == null ? NO_DEVICE_FOUND : manufacturer,
                linkSpeed == null ? NO_DEVICE_FOUND : linkSpeed);
    }
}