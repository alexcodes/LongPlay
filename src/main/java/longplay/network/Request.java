package longplay.network;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Request {
    public static String loadPage(String url) {
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource.accept("*/*")
                .get(ClientResponse.class);
        return response.getEntity(String.class);
    }
}
