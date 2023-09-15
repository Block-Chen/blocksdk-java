### 아발란체 V3 REST API 문서
[아발란체 개발자 문서 바로가기](https://documenter.getpostman.com/view/20292093/Uz5FKwxw#24d81559-cf32-4228-b4e6-2a9817110bae)
함수 호출에 필요한 매개변수 또는 반환되는 데이터에 대해서는 REST API 개발자 문서를 참고해 주시길 바랍니다.

### 클라이언트 생성 (테스트넷)
```java
Avalanche avaxClient = new Avalanche("YOU_TOKEN");
```

### 클라이언트 생성 (메인넷)
엔드 포인트를 지정해주지 않는경우 테스트넷으로 기본 설정되어 호출 됩니다 메인넷은 아래 예시와 같이 클라이언트 생성시 두번째 매개변수를 메인넷으로 지정해 주시길 바랍니다.
```java
Avalanche avaxClient = new Avalanche("YOU_TOKEN","https://mainnet-api.blocksdk.com");
```

### 블록체인 정보
```
GET /v3/avax/info
```
```java
Map<String, Object> result = avaxClient.GetBlockChainInfo().join();
```

### 블록 정보
```
GET /v3/avax/block/<block>
```
```java
Map<String, Object> data = new HashMap<>();
data.put("block", "blockNumber 또는 blockHash")

Map<String, Object> result = avaxClient.GetBlock(data).join();
```

### 주소 목록
```
GET /v3/avax/address
```
```java
Map<String, Object> data = new HashMap<>();
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetAddresses(data).join();
```

### 주소 정보
```
GET /v3/avax/address/<address>/info
```
```java
Map<String, Object> data = new HashMap<>();
data.put("address", "주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetAddressInfo(data).join();
```

### 주소 생성
```
POST /v3/avax/address
```
```java
Map<String, Object> data = new HashMap<>();
data.put("name", "test")

Map<String, Object> result = avaxClient.CreateAddress(data).join();
```

### 주소 잔액
```
GET /v3/avax/address/<address>/balance
```
```java
Map<String, Object> data = new HashMap<>();
data.put("address", "주소")

Map<String, Object> result = avaxClient.GetAddressBalance(data).join();
```

### 주소 거래 전송
```
POST /v3/avax/address/<from_address>/send
```
```java
Map<String, Object> data = new HashMap<>();
data.put("from", "주소")
data.put("to", "주소")
data.put("amount", "보낼 양")
data.put("private_key", "보내는 주소 키")

Map<String, Object> result = avaxClient.Send(data).join();
```

### 거래 전송
```
POST /v3/avax/transaction/send
```
```java
Map<String, Object> data = new HashMap<>();
data.put("hex", "서명된 트랜잭션 hex")

Map<String, Object> result = avaxClient.SendTransaction(data).join();
```

### 거래 조회
```
GET /v3/avax/transaction/<tx_hash>
```
```java
Map<String, Object> data = new HashMap<>();
data.put("hash", "트랜잭션 해쉬")

Map<String, Object> result = avaxClient.GetTransaction(data).join();
```

### ERC20 토큰 정보
```
GET /v3/avax/token/<contract_address>/info
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "ERC20 토큰 컨트렉트 주소")

Map<String, Object> result = avaxClient.GetTokenInfo(data).join();
```

### ERC20 토큰 잔액
```
GET /v3/avax/token/<contract_address>/<from_address>/balance
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "ERC20 토큰 컨트렉트 주소")
data.put("from_address", "잔액을 조회할 주소")

Map<String, Object> result = avaxClient.GetTokenBalance(data).join();
```

### ERC20 토큰 전송
```
POST /v3/avax/token/<contract_address>/<from_address>/transfer
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "ERC20 토큰 컨트렉트 주소")
data.put("from_address", "토큰을 전송할 주소")
data.put("to", "주소")
data.put("amount", "보낼 양")
data.put("private_key", "보내는 주소 키")

Map<String, Object> result = avaxClient.SendToken(data).join();
```

### ERC20 특정 주소 거래 조회
```
GET /v3/avax/token/<from_address>/transactions
```
```java
Map<String, Object> data = new HashMap<>();
data.put("from_address", "거래 내역을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetTokenTxs(data).join();
```

### ERC20 특정 컨트렉트 거래 조회
```
GET /v3/avax/token/<contract_address>/<from_address>/transactions
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "ERC20 토큰 컨트렉트 주소")
data.put("from_address", "거래 내역을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetTokenContractTxs(data).join();
```

### ERC20 소유내역 조회
```
GET /v3/avax/token/<from_address>/all-balance
```
```java
Map<String, Object> data = new HashMap<>();
data.put("from_address", "토큰 목록을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetTokenAllBalance(data).join();
```

### ERC721(NFT) 특정 컨트렉트 NFT 목록
```
GET /v3/avax/single-nft/<contract_address>/nfts
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "목록을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetSingleNfts(data).join();
```


### ERC721(NFT) 특정 월렛 소유중인 NFT 조회
```
GET /v3/avax/single-nft/<owner_address>/owner-nfts
```
```java
Map<String, Object> data = new HashMap<>();
data.put("owner_address", "목록을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetSingleOwnerNfts(data).join();
```


### ERC721(NFT) 특정 월렛 생성한 NFT 조회
```
GET /v3/avax/single-nft/<creator_address>/creator-nfts
```
```java
Map<String, Object> data = new HashMap<>();
data.put("creator_address", "목록을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetSingleCreatorNfts(data).join();
```

### ERC721(NFT) 특정 월렛 NFT 거래 조회
```
GET /v3/avax/single-nft/<from_address>/transactions
```
```java
Map<String, Object> data = new HashMap<>();
data.put("from_address", "토큰 목록을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetSingleTxs(data).join();
```


### ERC721(NFT) 특정 컨트렉트,월렛 의 소유중인 NFT 조회
```
GET /v3/avax/single-nft/<contract_address>/<owner_address>/owner-nfts
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "NFT 컨트렉트 주소")
data.put("owner_address", "토큰 목록을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetSingleNftOwnerNfts(data).join();
```


### ERC721(NFT) 특정 컨트렉트,월렛의 생성한 NFT 조회
```
GET /v3/avax/single-nft/<contract_address>/<creator_address>/creator-nfts
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "NFT 컨트렉트 주소")
data.put("creator_address", "토큰 목록을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetSingleNftCreatorNfts(data).join();
```


### ERC721(NFT) 특정 컨트렉트,월렛의 NFT 거래 조회
```
GET /v3/avax/single-nft/<contract_address>/<from_address>/from-transactions
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "NFT 컨트렉트 주소")
data.put("from_address", "목록을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetSingleNftTxs(data).join();
```


### ERC721(NFT) 특정 NFT 거래내역 조회
```
GET /v3/avax/single-nft/<contract_address>/<token_id>/nft-transactions
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "NFT 컨트렉트 주소")
data.put("token_id", "NFT 토큰 ID")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetSingleNftTokenTxs(data).join();
```


### ERC721(NFT) 특정 NFT 정보 조회
```
GET /v3/avax/single-nft/<contract_address>/<token_id>/info
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "NFT 컨트렉트 주소")
data.put("token_id", "NFT 토큰 ID")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetSingleNftInfo(data).join();
```


### ERC1155(NFT) 특정 컨트렉트 NFT 목록 조회
```
GET /v3/avax/multi-nft/<contract_address>/nfts
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "NFT 컨트렉트 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetMultiNfts(data).join();
```


### ERC1155(NFT) 특정 월렛 소유하고 있는 NFT 목록 조회
```
GET /v3/avax/multi-nft/<owner_address>/owner-nfts
```
```java
Map<String, Object> data = new HashMap<>();
data.put("owner_address", "목록을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetMultiOwnerNfts(data).join();
```


### ERC1155(NFT) 특정 월렛 생성한 NFT 목록 조회
```
GET /v3/avax/multi-nft/<creator_address>/creator-nfts
```
```java
Map<String, Object> data = new HashMap<>();
data.put("creator_address", "목록을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetMultiCreatorNfts(data).join();
```


### ERC1155(NFT) 특정 월렛 NFT 거래 내역 조회
```
GET /v3/avax/multi-nft/<from_address>/transactions
```
```java
Map<String, Object> data = new HashMap<>();
data.put("from_address", "목록을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetMultiTxs(data).join();
```


### ERC1155(NFT)  특정 컨트렉트,월렛이 소유한 NFT 목록 조회
```
GET /v3/avax/multi-nft/<contract_address>/<owner_address>/owner-nfts
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "NFT 컨트렉트 주소")
data.put("owner_address", "목록을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetMultiNftOwnerNfts(data).join();
```


### ERC1155(NFT) 특정 컨트렉트,월렛이 생성한 NFT 목록 조회
```
GET /v3/avax/multi-nft/<contract_address>/<creator_address>/creator-nfts
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "NFT 컨트렉트 주소")
data.put("creator_address", "목록을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetMultiNftCreatorNfts(data).join();
```


### ERC1155(NFT) 특정 컨트렉트,월렛의 NFT 거래 내역 조회
```
GET /v3/avax/multi-nft/<contract_address>/<from_address>/from-transactions
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "NFT 컨트렉트 주소")
data.put("from_address", "목록을 조회할 주소")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetMultiNftTxs(data).join();
```


### ERC1155(NFT) 특정 NFT 정보&소유자 조회
```
GET /v3/avax/multi-nft/<contract_address>/<token_id>/info
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "NFT 컨트렉트 주소")
data.put("token_id", "NFT 토큰 ID")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetMultiNftInfo(data).join();
```


### ERC1155(NFT) 특정 NFT 거래내역 조회
```
GET /v3/avax/multi-nft/<contract_address>/<token_id>/nft-transactions
```
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "NFT 컨트렉트 주소")
data.put("token_id", "NFT 토큰 ID")
data.put("offset", "0")
data.put("limit", "10")

Map<String, Object> result = avaxClient.GetMultiNftTokenTxs(data).join();
```


### 스마트 계약 함수호출(읽기)
```
POST /v3/avax/contract/<contract_address>/read
```
```java
Map<String, Object> request = new HashMap<>();
request.put("contract_address", "컨트렉트 주소");
request.put("method", "실행할 함수 명");
request.put("return_type", "반환 데이터 타입");
request.put("parameter_type", Arrays.asList("인풋 파라미터 타입"));
request.put("parameter_data", Arrays.asList("인풋 파라미터 데이터"));

Map<String, Object> result = avaxClient.ReadContract(data).join();
```


### 스마트 계약 함수호출(쓰기)
```
POST /v3/avax/contract/<contract_address>/write
```
```java
Map<String, Object> request = new HashMap<>();
request.put("contract_address", "컨트렉트 주소");
request.put("from", "트랜잭션을 생성할 주소");
request.put("private_key", "from 의 프라이빗키");
request.put("method", "실행할 함수 명");
request.put("parameter_type", Arrays.asList("인풋 파라미터 타입"));
request.put("parameter_data", Arrays.asList("인풋 파라미터 데이터"));

Map<String, Object> result = avaxClient.WriteContract(data).join();
```