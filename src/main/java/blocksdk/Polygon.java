package blocksdk;

public class Polygon extends BaseEthereum {
    public Polygon(String apiToken) {
        this(apiToken, "https://testnet-api.blocksdk.com");
    }
    public Polygon(String apiToken, String endpoint) {
        super("matic", apiToken, endpoint, "v3");
    }
}
