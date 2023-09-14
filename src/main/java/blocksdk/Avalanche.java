package blocksdk;

public class Avalanche extends BaseEthereum {
    public Avalanche(String apiToken) {
        this(apiToken, "https://testnet-api.blocksdk.com");
    }
    public Avalanche(String apiToken, String endpoint) {
        super("avax", apiToken, endpoint, "v3");
    }
}
