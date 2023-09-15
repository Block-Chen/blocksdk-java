### 바이낸스 스마트 체인 V3 REST API 문서
[바이낸스 스마트 체인 개발자 문서 바로가기](https://documenter.getpostman.com/view/20292093/Uz5FKwxw#f6ddeb8a-8e34-4900-9706-9aea7c18fbe9)
함수 호출에 필요한 매개변수 또는 반환되는 데이터에 대해서는 REST API 개발자 문서를 참고해 주시길 바랍니다.

### 클라이언트 생성 (테스트넷)
```cs
using BlockSDK;
var bscClient = new BlockSDK.BinanceSmart("YOU_TOKEN");
```

### 클라이언트 생성 (메인넷)
엔드 포인트를 지정해주지 않는경우 테스트넷으로 기본 설정되어 호출 됩니다 메인넷은 아래 예시와 같이 클라이언트 생성시 두번째 매개변수를 메인넷으로 지정해 주시길 바랍니다.
```cs
using BlockSDK;
var bscClient = new BlockSDK.BinanceSmart("YOU_TOKEN","https://mainnet-api.blocksdk.com");
```

### 블록체인 정보
```
GET /v3/bsc/info
```
```cs
var result = await bscClient.GetBlockChainInfo();
```

### 블록 정보
```
GET /v3/bsc/block/<block>
```
```cs
var result = await bscClient.GetBlock(new Dictionary<string, object>{
    {"block", "blockNumber 또는 blockHash"}
});
```

### 주소 목록
```
GET /v3/bsc/address
```
```cs
var result = await bscClient.GetAddresses(new Dictionary<string, object>{
    {"offset", 0},
    {"limit", 10}
});
```

### 주소 정보
```
GET /v3/bsc/address/<address>/info
```
```cs
var result = await bscClient.GetAddressInfo(new Dictionary<string, object>{
    {"address", "주소"},
    {"offset", 0},
    {"limit", 10}
});
```

### 주소 생성
```
POST /v3/bsc/address
```
```cs
var result = await bscClient.CreateAddress(new Dictionary<string, object>{
    {"name", "test"}
});
```

### 주소 잔액
```
GET /v3/bsc/address/<address>/balance
```
```cs
var result = await bscClient.GetAddressBalance(new Dictionary<string, object>{
    {"address", "주소"}
});
```

### 주소 거래 전송
```
POST /v3/bsc/address/<from_address>/send
```
```cs
var result = await bscClient.Send(new Dictionary<string, object>{
    {"from", "주소"},
    {"to", "주소"},
    {"amount", "보낼 양"},
    {"private_key", "보내는 주소 키"}
});
```

### 거래 전송
```
POST /v3/bsc/transaction/send
```
```cs
var result = await bscClient.SendTransaction(new Dictionary<string, object>{
    {"hex", "서명된 트랜잭션 hex"}
});
```

### 거래 조회
```
GET /v3/bsc/transaction/<tx_hash>
```
```cs
var result = await bscClient.GetTransaction(new Dictionary<string, object>{
    {"hash", "트랜잭션 해쉬"}
});
```

### ERC20 토큰 정보
```
GET /v3/bsc/token/<contract_address>/info
```
```cs
var result = await bscClient.GetTokenInfo(new Dictionary<string, object>{
    {"contract_address", "ERC20 토큰 컨트렉트 주소"}
});
```

### ERC20 토큰 잔액
```
GET /v3/bsc/token/<contract_address>/<from_address>/balance
```
```cs
var result = await bscClient.GetTokenBalance(new Dictionary<string, object>{
    {"contract_address", "ERC20 토큰 컨트렉트 주소"},
    {"from_address", "잔액을 조회할 주소"}
});
```

### ERC20 토큰 전송
```
POST /v3/bsc/token/<contract_address>/<from_address>/transfer
```
```cs
var result = await bscClient.SendToken(new Dictionary<string, object>{
    {"contract_address", "ERC20 토큰 컨트렉트 주소"},
    {"from_address", "토큰을 전송할 주소"},
    {"to", "주소"},
    {"amount", "보낼 양"},
    {"private_key", "보내는 주소 키"}
});
```

### ERC20 특정 주소 거래 조회
```
GET /v3/bsc/token/<from_address>/transactions
```
```cs
var result = await bscClient.GetTokenTxs(new Dictionary<string, object>{
    {"from_address", "거래 내역을 조회할 주소"},
    {"offset", 0},
    {"limit", 10}
});
```

### ERC20 특정 컨트렉트 거래 조회
```
GET /v3/bsc/token/<contract_address>/<from_address>/transactions
```
```cs
var result = await bscClient.GetTokenContractTxs(new Dictionary<string, object>{
    {"contract_address", "ERC20 토큰 컨트렉트 주소"},
    {"from_address", "거래 내역을 조회할 주소"},
    {"offset", 0},
    {"limit", 10}
});
```

### ERC20 소유내역 조회
```
GET /v3/bsc/token/<from_address>/all-balance
```
```cs
var result = await bscClient.GetTokenAllBalance(new Dictionary<string, object>{
    {"from_address", "토큰 목록을 조회할 주소"},
    {"offset", 0},
    {"limit", 10}
});
```

### ERC721(NFT) 특정 컨트렉트 NFT 목록
```
GET /v3/bsc/single-nft/<contract_address>/nfts
```
```cs
var result = await bscClient.GetSingleNfts(new Dictionary<string, object>{
    {"contract_address", "목록을 조회할 주소"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC721(NFT) 특정 월렛 소유중인 NFT 조회
```
GET /v3/bsc/single-nft/<owner_address>/owner-nfts
```
```cs
var result = await bscClient.GetSingleOwnerNfts(new Dictionary<string, object>{
    {"owner_address", "목록을 조회할 주소"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC721(NFT) 특정 월렛 생성한 NFT 조회
```
GET /v3/bsc/single-nft/<creator_address>/creator-nfts
```
```cs
var result = await bscClient.GetSingleCreatorNfts(new Dictionary<string, object>{
    {"creator_address", "목록을 조회할 주소"},
    {"offset", 0},
    {"limit", 10}
});
```

### ERC721(NFT) 특정 월렛 NFT 거래 조회
```
GET /v3/bsc/single-nft/<from_address>/transactions
```
```cs
var result = await bscClient.GetSingleTxs(new Dictionary<string, object>{
    {"from_address", "토큰 목록을 조회할 주소"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC721(NFT) 특정 컨트렉트,월렛 의 소유중인 NFT 조회
```
GET /v3/bsc/single-nft/<contract_address>/<owner_address>/owner-nfts
```
```cs
var result = await bscClient.GetSingleNftOwnerNfts(new Dictionary<string, object>{
    {"contract_address", "컨트렉트 주소"},
    {"owner_address", "월렛 주소"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC721(NFT) 특정 컨트렉트,월렛의 생성한 NFT 조회
```
GET /v3/bsc/single-nft/<contract_address>/<creator_address>/creator-nfts
```
```cs
var result = await bscClient.GetSingleNftCreatorNfts(new Dictionary<string, object>{
    {"contract_address", "NFT 컨트렉트 주소"},
    {"creator_address", "토큰 목록을 조회할 주소"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC721(NFT) 특정 컨트렉트,월렛의 NFT 거래 조회
```
GET /v3/bsc/single-nft/<contract_address>/<from_address>/from-transactions
```
```cs
var result = await bscClient.GetSingleNftTxs(new Dictionary<string, object>{
    {"contract_address", "NFT 컨트렉트 주소"},
    {"from_address", "목록을 조회할 주소"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC721(NFT) 특정 NFT 거래내역 조회
```
GET /v3/bsc/single-nft/<contract_address>/<token_id>/nft-transactions
```
```cs
var result = await bscClient.GetSingleNftTokenTxs(new Dictionary<string, object>{
    {"contract_address",  "NFT 컨트렉트 주소"},
    {"token_id",  "NFT 토큰 ID"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC721(NFT) 특정 NFT 정보 조회
```
GET /v3/bsc/single-nft/<contract_address>/<token_id>/info
```
```cs
var result = await bscClient.GetSingleNftInfo(new Dictionary<string, object>{
    {"contract_address", "NFT 컨트렉트 주소"},
    {"token_id",  "NFT 토큰 ID"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC1155(NFT) 특정 컨트렉트 NFT 목록 조회
```
GET /v3/bsc/multi-nft/<contract_address>/nfts
```
```cs
var result = await bscClient.GetMultiNfts(new Dictionary<string, object>{
    {"contract_address" :"NFT 컨트렉트 주소"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC1155(NFT) 특정 월렛 소유하고 있는 NFT 목록 조회
```
GET /v3/bsc/multi-nft/<owner_address>/owner-nfts
```
```cs
var result = await bscClient.GetMultiOwnerNfts(new Dictionary<string, object>{
    {"owner_address", "목록을 조회할 주소"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC1155(NFT) 특정 월렛 생성한 NFT 목록 조회
```
GET /v3/bsc/multi-nft/<creator_address>/creator-nfts
```
```cs
var result = await bscClient.GetMultiCreatorNfts(new Dictionary<string, object>{
    {"creator_address", "목록을 조회할 주소"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC1155(NFT) 특정 월렛 NFT 거래 내역 조회
```
GET /v3/bsc/multi-nft/<from_address>/transactions
```
```cs
var result = await bscClient.GetMultiTxs(new Dictionary<string, object>{
    {"from_address", "목록을 조회할 주소"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC1155(NFT)  특정 컨트렉트,월렛이 소유한 NFT 목록 조회
```
GET /v3/bsc/multi-nft/<contract_address>/<owner_address>/owner-nfts
```
```cs
var result = await bscClient.GetMultiNftOwnerNfts(new Dictionary<string, object>{
    {"contract_address", "NFT 컨트렉트 주소"},
    {"owner_address", "목록을 조회할 주소"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC1155(NFT) 특정 컨트렉트,월렛이 생성한 NFT 목록 조회
```
GET /v3/bsc/multi-nft/<contract_address>/<creator_address>/creator-nfts
```
```cs
var result = await bscClient.GetMultiNftCreatorNfts(new Dictionary<string, object>{
    {"contract_address", "NFT 컨트렉트 주소"},
    {"creator_address", "목록을 조회할 주소"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC1155(NFT) 특정 컨트렉트,월렛의 NFT 거래 내역 조회
```
GET /v3/bsc/multi-nft/<contract_address>/<from_address>/from-transactions
```
```cs
var result = await bscClient.GetMultiNftTxs(new Dictionary<string, object>{
    {"contract_address", "NFT 컨트렉트 주소"},
    {"from_address", "목록을 조회할 주소"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC1155(NFT) 특정 NFT 정보&소유자 조회
```
GET /v3/bsc/multi-nft/<contract_address>/<token_id>/info
```
```cs
var result = await bscClient.GetMultiNftInfo(new Dictionary<string, object>{
    {"contract_address", "NFT 컨트렉트 주소"},
    {"token_id", "NFT 토큰 ID"},
    {"offset", 0},
    {"limit", 10}
});
```


### ERC1155(NFT) 특정 NFT 거래내역 조회
```
GET /v3/bsc/multi-nft/<contract_address>/<token_id>/nft-transactions
```
```cs
var result = await bscClient.GetMultiNftTokenTxs(new Dictionary<string, object>{
    {"contract_address", "NFT 컨트렉트 주소"},
    {"token_id", "NFT 토큰 ID"},
    {"offset", 0},
    {"limit", 10}
});
```


### 스마트 계약 함수호출(읽기)
```
POST /v3/bsc/contract/<contract_address>/read
```
```cs
var result = await bscClient.ReadContract(new Dictionary<string, object>{
    {"contract_address", "컨트렉트 주소"},
    {"method", "실행할 함수 명"},
    {"return_type", "반환 데이터 타입"},
    {"parameter_type", new List<T> {"인풋 파라미터 타입"}},
    {"parameter_data", new List<T> {"인풋 파라미터 데이터"}}
});
```


### 스마트 계약 함수호출(쓰기)
```
POST /v3/bsc/contract/<contract_address>/write
```
```cs
var result = await bscClient.WriteContract(new Dictionary<string, object>{
    {"contract_address", "컨트렉트 주소"},
    {"from", "트랜잭션을 생성할 주소"},
    {"private_key", "from 의 프라이빗키"},
    {"method", "실행할 함수 명"},
    "{parameter_type", new List<T> {"인풋 파라미터 타입"}},
    {"parameter_data", new List<T> {"인풋 파라미터 데이터"}}
});
```