package blocksdk;

public class BinanceSmart extends BaseEthereum {
    public BinanceSmart(String apiToken) {
        this(apiToken, "https://testnet-api.blocksdk.com");
    }
    public BinanceSmart(String apiToken, String endpoint) {
        super("bsc", apiToken, endpoint, "v3");
    }
}
