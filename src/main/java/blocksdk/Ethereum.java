package blocksdk;

public class Ethereum extends BaseEthereum {
        public Ethereum(String apiToken) {
                this(apiToken, "https://testnet-api.blocksdk.com");
        }
        public Ethereum(String apiToken, String endpoint) {
                super("eth", apiToken, endpoint, "v3");
        }
}
