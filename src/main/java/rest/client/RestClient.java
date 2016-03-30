package rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * Created by smile on 13-Mar-16.
 */

public class RestClient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        MainWindow window = new MainWindow(client);
    }
}
