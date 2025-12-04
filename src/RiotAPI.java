package src;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RiotAPI {
    private final String apiKey;
    private final HttpClient client; 
    
    public RiotAPI(String apiKey){
        this.apiKey = apiKey;
        this.client = HttpClient.newHttpClient();
    }

    public String get(String url) throws Exception{
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("X-Riot-Token", apiKey).build();

        HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }



    
}
