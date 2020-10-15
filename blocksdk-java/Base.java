import java.util.*;
import java.lang.String;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Base 
{ 
    // Instance Variables 
    String api_token; 

    // Constructor Declaration of Class 
    public Base(String api_token) 
    { 
        this.api_token = api_token; 
    } 
  
    // method 1 
    public String getUsage(HashMap<String, String> request) 
    { 
        if (request.containsKey('start_date') == false){

            Date d = new Date();
            DateFormat df = new SimpleDateFormat("yy/MM/dd");
            Date date1 = format.parse(d);
            
            newD = date1.getTime() - 604800;

            request.put('start_date') = newD;
        }


        if(request.containsKey('end_date') == false){
            Date d = new Date();
            DateFormat df = new SimpleDateFormat("yy/MM/dd");
            Date date1 = format.parse(d);
            request.put('end_date') = d;

        }
        return this.request("GET","/usage",request.get('start_date'),request.get('end_date'));
    } 
  
    // method 2 
    public String listPrice(HashMap<String, String> request) 
    { 
        return this.request("GET","/price");
    } 
  
    // method 3 
    public String getHashType(HashMap<String, String> request) 
    { 

        return this.request("GET","/auto/" + request.get('hash') + "/type"); 
    } 
  
    // method 4 
    public String request(String method,String path,HashMap<String, String> data) 
    { 
        url = "https://api.blocksdk.com/v1" + path;

        if(method == "GET" && data.size() > 0){
            url += "?";

            for (Map.Entry<String, String> set : data.entrySet()){
                String value = data.getKey();
                if(value==true){
                    url += key + "=true&";
                }

                else if(value ==false){
                    url += key + "=false&";
                }

                else{
                     url += key+ "=" + str(value) + "&";
                }


            }
        }



        if(method == "POST"){

            StringBuilder response = new StringBuilder();

            String urlParameters  = this.api_token
            byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
            int    postDataLength = postData.length;
            URL    temp            = new URL( url );
            HttpURLConnection conn= (HttpURLConnection) temp.openConnection();           
            conn.setDoOutput( true );
            conn.setInstanceFollowRedirects( false );
            conn.setRequestMethod( "POST" );
            conn.setRequestProperty( "Content-Type", "application/json"); 
            conn.setRequestProperty( "charset", "utf-8");
            conn.setRequestProperty( "Content-Length", Integer.toString(postDataLength));
            conn.setUseCaches( false );
            try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
               wr.write( postData );
           }
            while ((line = wr.readLine()) != null) {
                     response.append(line);
            }
            wr.close()
       }
        else{
        StringBuilder response = new StringBuilder();
        URL temp = new URL(url); 
        String urlParameters  = this.api_token
        byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
        HttpURLConnection conn = (HttpURLConnection) temp.openConnection();           
        conn.setDoOutput(true); 
        conn.setInstanceFollowRedirects(false); 
        conn.setRequestMethod("GET"); 
        conn.setRequestProperty("Content-Type", "application/json"); 
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty( "Content-Length", Integer.toString(postDataLength));
        conn.connect();

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
             response.append(line);
          }
          rd.close();

        }



        try{
            Gson g = new Gson();
            body = g.toJson(response);
        }
        catch(Exception e){
            Map<String, String> Body = new HashMap<String, String>();
        }

        if(method=="POST"){
            try{
                body = response;
            }
            catch(Exception e){
                converted_json = response.replace(':','":');
                converted_json1 = converted_json.split('{\n');
                for(int i=0;i<converted_json.length();i++){
                    if(converted_json1[i] != ''){
                        json2 = converted_json1[i].split('":')[0].split(' ')[-1];
                        converted_json = converted_json.replace(json2,'"' + json2);
                    }
                }
                Gson g = new Gson();
                body = g.toJson(converted_json);
            }
        }

        if response.headers{
            headers = response.headers;
        }
        else{
            Map<String, String> headers = new HashMap<String, String>();
        }
        
        if response.status_code{
            status = response.status_code;
        }
        else{
            status = 0;
        }
        
        headers.update('statusCode') = status;
        try{
            body.update('HTTP_HEADER')= headers;
        }
        catch(Exception e){

            for(int i=0;i<body.length();i++){
            body = { i : body[i] for i in range(0, len(body) ) }
            body.update('HTTP_HEADER') = headers
    
        }
        return body
        
    } 
  
  
    public static void main(String[] args) 
    { 
        Dog tuffy = new Dog("tuffy","papillon", 5, "white"); 
        System.out.println(tuffy.toString()); 
    } 
} 