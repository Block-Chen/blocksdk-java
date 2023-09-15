package blocksdk;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public class Base {
    private String chainName;
    private String apiToken;
    private String endpoint;
    private String version;

    public Base(String chainName, String apiToken, String endpoint, String version) {
        this.chainName = chainName;
        this.apiToken = apiToken;
        this.endpoint = endpoint;
        this.version = version;
    }

    public CompletableFuture<Map<String, Object>> request(String method, String path) {
        return request(method, path, Collections.<String, Object>emptyMap());
    }

    public CompletableFuture<Map<String, Object>> request(String method, String path, Map<String, Object> data) {
        CompletableFuture<Map<String, Object>> future = CompletableFuture.supplyAsync(() -> {
            String url = this.endpoint + "/" + this.version + "/" + this.chainName + path;
            StringBuffer response = new StringBuffer();
            Map<String, Object> result = new HashMap<>();

            try {
                if ("GET".equals(method)) {
                    StringBuilder query = new StringBuilder();
                    for (Map.Entry<String, Object> entry : data.entrySet()) {
                        query.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                        query.append("=");
                        query.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));  // Object를 문자열로 변환
                        query.append("&");
                    }
                    if (query.length() > 0) {
                        url += "?" + query.toString();
                    }
                }

                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod(method);
                con.setRequestProperty("x-api-token", this.apiToken);

                if ("POST".equals(method)) {
                    con.setRequestProperty("Content-Type", "application/json");
                    con.setDoOutput(true);
                    OutputStream os = con.getOutputStream();
                    JSONObject json = new JSONObject(data); // Map을 JSON으로 변환
                    os.write(json.toString().getBytes());
                    os.flush();
                    os.close();
                }

                int responseCode = con.getResponseCode();
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // 응답을 JSONObject로 변환
                JSONObject jsonResponse = new JSONObject(response.toString());

                // JSONObject를 Map<String, Object>로 변환
                Map<String, Object> resultMap = jsonResponse.toMap();

                return resultMap;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });

        return future;
    }
}