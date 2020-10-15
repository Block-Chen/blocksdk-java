import java.util.*;
import java.lang.String;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class Monero : Base
    {
        public Monero(string api_token) : base(api_token)
        {
        }

        public string getBlockChain()
        {
            return this.request("GET", "/xmr/block");
        }

        public string getBlock(Dictionary<string, string> request)
        {
            if (request == null)
            {
                request = new Dictionary<string, string>();
            }
            //Refine Values
            refineValues(request);

            return this.request("GET", "/xmr/block/" + request["block"],request);

            //Dictionary<string, string> req = new Dictionary<string, string>();
            //req.Add("block", "531421");
            //req.Add("rawtx", "true");
            //req.Add("offset", "0");
            //req.Add("limit", "10");
        }

        public string getMemPool(Dictionary<string, string> request)
        {
            if (request == null)
            {
                request = new Dictionary<string, string>();
            }
            //Refine Values
            refineValues(request);

            return this.request("GET", "/xmr/mempool", request);

            //Dictionary<string, string> req = new Dictionary<string, string>();
            //req.Add("block", "531421");
            //req.Add("rawtx", "true");
            //req.Add("offset", "0");
            //req.Add("limit", "10");
        }

        public string listAddress(Dictionary<string, string> request)
        {
            if (request == null)
            {
                request = new Dictionary<string, string>();
            }
            //Refine Values
            refineValues(request, false);
            return this.request("GET", "/xmr/address", request);
        }

        public string createAddress(Dictionary<string, string> request)
        {
            if (request == null)
            {
                request = new Dictionary<string, string>();
            }

            if (!request.ContainsKey("name"))
            {
                request.Add("name", "false");
            }

            return this.request("POST", "/xmr/address/", request);
        }

        public string getAddressInfo(Dictionary<string, string> request)
        {
            if (request == null)
            {
                request = new Dictionary<string, string>();
            }

            if (!request.ContainsKey("reverse"))
            {
                request.Add("reverse", "false");
            }

            //Refine Values
            refineValues(request);

            return this.request("GET", "/xmr/block/" + request["address_id"], request);

            //Dictionary<string, string> req = new Dictionary<string, string>();
            //req.Add("block", "531421");
            //req.Add("rawtx", "true");
            //req.Add("offset", "0");
            //req.Add("limit", "10");
        }

        public string getAddressBalance(Dictionary<string, string> request)
        {
            return this.request("GET", "/xmr/address/" + request["address_id"] +"/balance", request);

            //Dictionary<string, string> req = new Dictionary<string, string>();
            //req.Add("address", "531421");
            
        }

         public string loadAddress(Dictionary<string, string> request)
        {
            return this.request("POST", "/xmr/address/" + request["address_id"] +"/load", request);
        }

        public string unLoadAddress(Dictionary<string, string> request)
        {
            return this.request("POST", "/xmr/address/" + request["address_id"] + "/unload", request);
        }

        
        public string sendToAddress(Dictionary<string, string> request)
        {
            if (request == null)
            {
                request = new Dictionary<string, string>();
            }

            if (!request.ContainsKey("kbfee"))
            {
                var blockChain = this.getBlockChain();
                JObject jobj = JObject.Parse(blockChain);
                request.Add("kbfree", (string)jobj["medium_fee_per_kb"]);
            }

            if (!request.ContainsKey("private_spend_key"))
            {
                request.Add("private_spend_key", "false");
            }
            if (!request.ContainsKey("password"))
            {
                request.Add("password", "false");
            }

            return this.request("POST", "/xmr/address/" + request["address_id"] + "/sendtoaddress", request);

        }

        public string getTransaction(Dictionary<string, string> request)
        {
            return this.request("GET", "/xmr/transaction/" + request["hash"]);
        }
    }

