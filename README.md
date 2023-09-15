# JAVA REST API SDK for BLOCKSDK V3
[![@BLOCKSDK on Facebook](https://img.shields.io/badge/facebook-%40BLOCKSDK-blue.svg)](https://www.facebook.com/blocksdk)
![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)

__BlockSDK JAVA__에 오신 것을 환영합니다. 이 저장소에는 BlockSDK의 JAVA SDK와 REST API용 샘플이 포함되어 있습니다.

## 지원중인 블록체인 네트워크
비트코인 , 라이트코인 , 비트코인 캐시 , 웹후크 는 V2버전 에서 지원되고 있습니다.
```
1.이더리움
2.클레이튼  
3.바이낸스 스마트 체인
4.폴리곤
5.아발란체
6.이더리움 클래식
```
## 개발자 문서
* [BlockSDK REST API V3 문서](https://documenter.getpostman.com/view/20292093/Uz5FKwxw)
* [BlockSDK REST API V2 문서](https://dojava-v2.blocksdk.com/ko/#fa255f0ccc)
* [BLOCKSDK JAVA SDK V3 문서](https://github.com/Block-Chen/blocksdk-java/wiki)

## 시작하기

### Maven
```xml
<dependency>
    <groupId>io.github.block-chen</groupId>
    <artifactId>blocksdk-java</artifactId>
    <version>3.0.0</version>
</dependency>
```
### Gradle
```groovy
implementation 'io.github.block-chen:blocksdk-java:3.0.0'
```

## 코드 샘플

### 이더리움 테스트넷 클라이언트 생성
```java
Ethereum Client = new Ethereum("YOU_TLKEN");
```

### 이더리움 메인넷 클라이언트 생성
```java
Ethereum Client = new Ethereum("YOU_TLKEN", "https://mainnet-api.blocksdk.com");
```

### 이더리움 블록체인 정보 가져오기
```java
Map<String, Object> data = Client.GetBlockchainInfo().join();
System.out.println(data);
```

### 이더리움 특정 컨트렉트 NFT 목록 가져오기
```java
Map<String, Object> data = new HashMap<>();
data.put("contract_address", "0xf5de760f2e916647fd766b4ad9e85ff943ce3a2b");
data.put("offset", "0");
data.put("limit", "10");

Map<String, Object> result = Client.GetSingleNfts(data).join();
System.out.println(result);
```
