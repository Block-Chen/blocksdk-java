import java.util.*;
import java.lang.String;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Webhook : Base
    {
        public Webhook(string api_token) : base(api_token)
        {
        }

        public string create(Dictionary<string,string> request)
        {
            return this.request("POST", "/hook",request);
        }

        public string list(Dictionary<string, string> request=null)  
        {

            if (request == null)
            {
                request = new Dictionary<string, string>();
            }

            refineValues(request, false);
            return this.request("GET", "/hook", request);
        }

        public string get(Dictionary<string, string> request)
        {
            return this.request("GET", "/hook/"+request["hook_id"]);
        }

        public string delete(Dictionary<string, string> request)
        {
            return this.request("POST", "/hook/" + request["hook_id"]+"/delete");
        }


        public string listResponse(Dictionary<string, string> request=null)
        {

            if (request == null)
            {
                request = new Dictionary<string, string>();
            }

            refineValues(request, false);
            return this.request("GET", "/hook/response", request);
        }

        public string getResponse(Dictionary<string, string> request)
        {

            if (request == null)
            {
                request = new Dictionary<string, string>();
            }

            refineValues(request, false);
            return this.request("GET", "/hook/" + request["hook_id"] + "/response");
        }
    }

