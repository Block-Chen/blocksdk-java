import java.util.*;
import java.lang.String;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;



public class Ethereum : Base
    {
        public Ethereum(string api_token) : base(api_token)
        {
        }

        public string getBlockChain()
        {
            return this.request("GET", "/eth/block");
        }

        public string getBlock(Dictionary<string, string> request)
        {
            if (request == null)
            {
                request = new Dictionary<string, string>();
            }
            //Refine Values
            refineValues(request);

            return this.request("GET", "/eth/block/" + request["block"],request);

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

            return this.request("GET", "/eth/mempool", request);

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
            refineValues(request,false);
            return this.request("GET", "/eth/address", request);
        }

        public string loadAddress(Dictionary<string, string> request)
        {
            return this.request("GET", "/eth/address/" + request["address"] + "/load", request);
        }

        public string unLoadAddress(Dictionary<string, string> request)
        {
            return this.request("GET", "/eth/address/" + request["address"] + "/unload", request);
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

            return this.request("POST", "/eth/address/", request);
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

            return this.request("GET", "/eth/block/" + request["address"], request);

            //Dictionary<string, string> req = new Dictionary<string, string>();
            //req.Add("block", "531421");
            //req.Add("rawtx", "true");
            //req.Add("offset", "0");
            //req.Add("limit", "10");
        }

        public string getAddressBalance(Dictionary<string, string> request)
        {
            return this.request("GET", "/eth/address/" + request["address"]+"/balance", request);

            //Dictionary<string, string> req = new Dictionary<string, string>();
            //req.Add("address", "531421");
            
        }

        
        public string sendToAddress(Dictionary<string, string> request)
        {
            if (request == null)
            {
                request = new Dictionary<string, string>();
            }

            if (!request.ContainsKey("gwei"))
            {
                var blockChain = this.getBlockChain();
                JObject jobj = JObject.Parse(blockChain);
                request.Add("gwei", (string)jobj["medium_gwei"]);
            }

            if (!request.ContainsKey("private_key"))
            {
                request.Add("private_key", "false");
            }
            if (!request.ContainsKey("password"))
            {
                request.Add("password", "false");
            }

            return this.request("POST", "/eth/wallet/" + request["wallet_id"] + "/sendtoaddress", request);

        }

        public string sendTransaction(Dictionary<string, string> request)
        { 
             return this.request("POST", "/eth/transaction/", request);
        }

        public string getTransaction(Dictionary<string, string> request)
        {
            return this.request("GET", "/eth/transaction/" + request["hash"]);
        }

    }
