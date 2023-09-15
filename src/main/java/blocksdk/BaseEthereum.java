package blocksdk;

import java.util.concurrent.CompletableFuture;
import java.util.Map;

public class BaseEthereum extends Base {

    public BaseEthereum(String chainName, String apiToken) {
        this(chainName, apiToken, "https://testnet-api.blocksdk.com", "v3");
    }

    public BaseEthereum(String chainName, String apiToken, String endpoint) {
        this(chainName, apiToken, endpoint, "v3");
    }

    public BaseEthereum(String chainName, String apiToken, String endpoint, String version) {
        super(chainName, apiToken, endpoint, version);
    }

    public CompletableFuture<Map<String, Object>> GetBlockchainInfo() {
        return this.request("GET", "/info");
    }

    public CompletableFuture<Map<String, Object>> GetBlock(Map<String, Object> request)
    {
        Object path = request.get("block");
        return this.request("GET", "/block/" + path, request);
    }

    public CompletableFuture<Map<String, Object>> GetAddresses(Map<String, Object> request)
    {
        return this.request("GET", "/address", request);
    }

    public CompletableFuture<Map<String, Object>> CreateAddress(Map<String, Object> request)
    {
        return this.request("POST", "/address", request);
    }

    public CompletableFuture<Map<String, Object>> GetAddressInfo(Map<String, Object> request)
    {
        Object address = request.get("address");
        return this.request("GET", "/address/"+address+"/info", request);
    }

    public CompletableFuture<Map<String, Object>> GetAddressBalance(Map<String, Object> request)
    {
        Object address = request.get("address");
        return this.request("GET", "/address/"+address+"/balance");
    }

    public CompletableFuture<Map<String, Object>> Send(Map<String, Object> request)
    {
        Object from_address = request.get("from_address");
        return this.request("POST", "/address/"+from_address+"/send", request);
    }

    public CompletableFuture<Map<String, Object>> SendTransaction(Map<String, Object> request)
    {
        return this.request("POST", "/transaction/send", request);
    }

    public CompletableFuture<Map<String, Object>> GetTransaction(Map<String, Object> request)
    {
        Object hash = request.get("hash");
        return this.request("GET", "/transaction/"+hash+"");
    }

    public CompletableFuture<Map<String, Object>> GetTokenInfo(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        return this.request("GET", "/token/"+contract_address+"/info");
    }

    public CompletableFuture<Map<String, Object>> SendToken(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object from_address = request.get("from_address");
        return this.request("POST", "/token/"+contract_address+"/"+from_address+"/transfer", request);
    }

    public CompletableFuture<Map<String, Object>> GetTokenBalance(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object from_address = request.get("from_address");
        return this.request("GET", "/token/"+contract_address+"/"+from_address+"/balance");
    }

    public CompletableFuture<Map<String, Object>> GetTokenTxs(Map<String, Object> request)
    {
        Object from_address = request.get("from_address");
        return this.request("GET", "/token/"+from_address+"/transactions", request);
    }

    public CompletableFuture<Map<String, Object>> GetTokenContractTxs(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object from_address = request.get("from_address");
        return this.request("GET", "/token/"+contract_address+"/"+from_address+"/transactions", request);
    }

    public CompletableFuture<Map<String, Object>> GetTokenAllBalance(Map<String, Object> request)
    {
        Object from_address = request.get("from_address");
        return this.request("GET", "/token/"+from_address+"/all-balance", request);
    }

    public CompletableFuture<Map<String, Object>> GetSingleNfts(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        return this.request("GET", "/single-nft/"+contract_address+"/nfts", request);
    }

    public CompletableFuture<Map<String, Object>> GetSingleOwnerNfts(Map<String, Object> request)
    {
        Object owner_address = request.get("owner_address");
        return this.request("GET", "/single-nft/"+owner_address+"/owner-nfts", request);
    }

    public CompletableFuture<Map<String, Object>> GetSingleCreatorNfts(Map<String, Object> request)
    {
        Object creator_address = request.get("creator_address");
        return this.request("GET", "/single-nft/"+creator_address+"/creator-nfts", request);
    }

    public CompletableFuture<Map<String, Object>> GetSingleTxs(Map<String, Object> request)
    {
        Object from_address = request.get("from_address");
        return this.request("GET", "/single-nft/"+from_address+"/transactions", request);
    }

    public CompletableFuture<Map<String, Object>> GetSingleNftOwnerNfts(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object owner_address = request.get("owner_address");
        return this.request("GET", "/single-nft/"+contract_address+"/"+owner_address+"/owner-nfts", request);
    }

    public CompletableFuture<Map<String, Object>> GetSingleNftCreatorNfts(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object creator_address = request.get("creator_address");
        return this.request("GET", "/single-nft/"+contract_address+"/"+creator_address+"/creator-nfts", request);
    }

    public CompletableFuture<Map<String, Object>> GetSingleNftTxs(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object from_address = request.get("from_address");
        return this.request("GET", "/single-nft/"+contract_address+"/"+from_address+"/from-transactions", request);
    }

    public CompletableFuture<Map<String, Object>> GetSingleNftInfo(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object token_id = request.get("token_id");
        return this.request("GET", "/single-nft/"+contract_address+"/"+token_id+"/info", request);
    }

    public CompletableFuture<Map<String, Object>> GetSingleNftTokenTxs(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object token_id = request.get("token_id");
        return this.request("GET", "/single-nft/"+contract_address+"/"+token_id+"/nft-transactions", request);
    }

    public CompletableFuture<Map<String, Object>> GetSingleNftAuctionNfts(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        return this.request("GET", "/single-nft/"+contract_address+"/auction-nfts", request);
    }

    public CompletableFuture<Map<String, Object>> GetSingleNftSellerNfts(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object seller_address = request.get("seller_address");
        return this.request("GET", "/single-nft/"+contract_address+"/"+seller_address+"/seller-nfts", request);
    }

    public CompletableFuture<Map<String, Object>> GetSingleNftTokenBids(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object token_id = request.get("token_id");
        return this.request("GET", "/single-nft/"+contract_address+"/"+token_id+"/nft-bids", request);
    }

    public CompletableFuture<Map<String, Object>> GetMultiNfts(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        return this.request("GET", "/multi-nft/"+contract_address+"/nfts", request);
    }

    public CompletableFuture<Map<String, Object>> GetMultiOwnerNfts(Map<String, Object> request)
    {
        Object owner_address = request.get("owner_address");
        return this.request("GET", "/multi-nft/"+owner_address+"/owner-nfts", request);
    }

    public CompletableFuture<Map<String, Object>> GetMultiCreatorNfts(Map<String, Object> request)
    {
        Object creator_address = request.get("creator_address");
        return this.request("GET", "/multi-nft/"+creator_address+"/creator-nfts", request);
    }

    public CompletableFuture<Map<String, Object>> GetMultiTxs(Map<String, Object> request)
    {
        Object from_address = request.get("from_address");
        return this.request("GET", "/multi-nft/"+from_address+"/transactions", request);
    }

    public CompletableFuture<Map<String, Object>> GetMultiNftOwnerNfts(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object owner_address = request.get("owner_address");
        return this.request("GET", "/multi-nft/"+contract_address+"/"+owner_address+"/owner-nfts", request);
    }

    public CompletableFuture<Map<String, Object>> GetMultiNftCreatorNfts(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object creator_address = request.get("creator_address");
        return this.request("GET", "/multi-nft/"+contract_address+"/"+creator_address+"/creator-nfts", request);
    }

    public CompletableFuture<Map<String, Object>> GetMultiNftTxs(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object from_address = request.get("from_address");
        return this.request("GET", "/multi-nft/"+contract_address+"/"+from_address+"/from-transactions", request);
    }

    public CompletableFuture<Map<String, Object>> GetMultiNftInfo(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object token_id = request.get("token_id");
        return this.request("GET", "/multi-nft/"+contract_address+"/"+token_id+"/info", request);
    }

    public CompletableFuture<Map<String, Object>> GetMultiNftTokenTxs(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object token_id = request.get("token_id");
        return this.request("GET", "/multi-nft/"+contract_address+"/"+token_id+"/nft-transactions", request);
    }

    public CompletableFuture<Map<String, Object>> GetMultiNftSellerNfts(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        Object seller_address = request.get("seller_address");
        return this.request("GET", "/multi-nft/"+contract_address+"/"+seller_address+"/seller-nfts", request);
    }

    public CompletableFuture<Map<String, Object>> ReadContract(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        return this.request("POST", "/contract/"+contract_address+"/read", request);
    }

    public CompletableFuture<Map<String, Object>> WriteContract(Map<String, Object> request)
    {
        Object contract_address = request.get("contract_address");
        return this.request("POST", "/contract/"+contract_address+"/write", request);
    }
}