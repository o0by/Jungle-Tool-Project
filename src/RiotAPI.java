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

    /*  Taking url as input
        returning string (raw JSON data from riot server)
     */    
    public String get(String url) throws Exception{
        //Building HTTP GET request, turning url into URI object, required API key in X-Riot-Token, then finalizing request
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("X-Riot-Token", apiKey).build();

        /*
        **Sending Request to client
        **response holds status code and the JSON body that riot will return 
        **then converts response into normal string
        */
        HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }



    
}
