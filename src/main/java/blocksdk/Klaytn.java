package blocksdk;

public class Klaytn extends BaseEthereum {
    public Klaytn(String apiToken) {
        this(apiToken, "https://testnet-api.blocksdk.com");
    }
    public Klaytn(String apiToken, String endpoint) {
        super("klay", apiToken, endpoint, "v3");
    }
}
