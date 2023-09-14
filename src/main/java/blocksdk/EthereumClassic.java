package blocksdk;

public class EthereumClassic extends BaseEthereum {
    public EthereumClassic(String apiToken) {
        this(apiToken, "https://testnet-api.blocksdk.com");
    }
    public EthereumClassic(String apiToken, String endpoint) {
        super("etc", apiToken, endpoint, "v3");
    }
}
