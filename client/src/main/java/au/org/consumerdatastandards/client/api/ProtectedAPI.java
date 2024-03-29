package au.org.consumerdatastandards.client.api;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ProtectedAPI extends UnprotectedAPI {

    protected void addCdsProtectedApiHeaders(Map<String, String> headers) {
        headers.put("x-fapi-customer-ip-address", getIpAddress());
        headers.put("x-fapi-auth-date", DateTimeFormatter.RFC_1123_DATE_TIME.format(ZonedDateTime.now(ZoneOffset.UTC)));
    }

    private String getIpAddress() {
        String ipAddress = "unknown";
        try {
            final DatagramSocket socket = new DatagramSocket();
            socket.connect(InetAddress.getByName("203.98.87.18"), 53); // ns1.internet.net.au.
            ipAddress = socket.getLocalAddress().getHostAddress();
            socket.disconnect();
        } catch (SocketException | UnknownHostException e) {
            // ignored
        }
        return ipAddress;
    }
}
