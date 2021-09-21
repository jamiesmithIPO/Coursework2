import static java.util.Objects.requireNonNull;

/**
 * Represents a message moving through a network. All fields are
 * immutable except hops, which should be incremented at each
 * network hop. */
public final class Message {

    private final String sourceIpAddress;
    private final String destinationIpAddress;
    private final byte[] data;
    private final int size;
    private int hops;

    /**
     * Constructs a message from sourceIpAddress to destinationIpAddress contain in the data
     * in the data byte array whose size is size.
     * @param sourceIpAddress the ip address of the sender
     * @param destinationIpAddress the ip address of the intended receiver
     * @param data the data contained within the message
     * @param size the size (in bytes) of the data array.
     */
    public Message(String sourceIpAddress, String destinationIpAddress, byte[] data, int size) {
        this.sourceIpAddress = requireNonNull(sourceIpAddress,
                "Must provide a non null sourceIpAddress");
        this.destinationIpAddress = requireNonNull(destinationIpAddress,
                "Must provide a non null destinationIpAddress");
        this.data = requireNonNull(data,
                "Must provide a non null array of byte data");
        this.size = size;
    }

    /**
     * Incremeents the number of hops this message has made
     */
    public void incrementHops() {
        hops++;
    }

    /**
     * Returns the number of hops this message has made.
     * @return the number of hops
     */
    public int getNumHops() {
        return hops;
    }

    /**
     * Returns the size of the data contained within this message.
     * @return the size of the data (in bytes)
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the data contained within this message
     * @return the data as bytes.
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Returns the source IP address of this message.
     * @return the source IP address.
     */
    public String getSource() {
        return sourceIpAddress;
    }

    /**
     * Returns the destination IP address of this message.
     * @return the destination IP address
     */
    public String getDestination() {
        return destinationIpAddress;
    }

    @Override
    public String toString() {

        String dataString = "";
        for (byte b : data) {
            dataString += String.format("%02X",b);
        }
        return String.format("Message (%d bytes) [%s -> %s] data = %s%n",
                size, sourceIpAddress, destinationIpAddress, dataString);
    }

    /**
     * Converts a String representation of some number of bytes into a byte
     * array. eg: "aa11" becomes {0xaa,0x11}
     * @param hexString The hexadecimal string representing byte data.
     * @return an array containing the byte equivalent of the String hexString
     */
    public static byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i+1), 16));
        }
        return data;
    }
}