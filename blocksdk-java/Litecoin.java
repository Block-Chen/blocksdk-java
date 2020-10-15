import java.util.*;
import java.lang.String;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;



public class Litecoin : Base
    {
        public Litecoin(string api_token) : base(api_token)
        {
        }

        public string getBlockChain()
        {
            return this.request("GET", "/ltc/block");
        }

        public string getBlock(Dictionary<string, string> request)
        {
            if (request == null)
            {
                request = new Dictionary<string, string>();
            }
            //Refine Values
            refineValues(request);

            return this.request("GET", "/ltc/block/" + request["block"],request);

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

            return this.request("GET", "/ltc/mempool", request);

            //Dictionary<string, string> req = new Dictionary<string, string>();
            //req.Add("block", "531421");
            //req.Add("rawtx", "true");
            //req.Add("offset", "0");
            //req.Add("limit", "10");
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

            return this.request("GET", "/ltc/block/" + request["address"], request);

            //Dictionary<string, string> req = new Dictionary<string, string>();
            //req.Add("block", "531421");
            //req.Add("rawtx", "true");
            //req.Add("offset", "0");
            //req.Add("limit", "10");
        }

        public string getAddressBalance(Dictionary<string, string> request)
        {
            return this.request("GET", "/ltc/address/" + request["address"]+"/balance", request);

            //Dictionary<string, string> req = new Dictionary<string, string>();
            //req.Add("address", "531421");
            
        }

        public string listWallet(Dictionary<string, string> request)
        {
            if (request == null)
            {
                request = new Dictionary<string, string>();
            }
            //Refine Values
            refineValues(request,false);

            return this.request("GET", "/ltc/wallet", request);

            //Dictionary<string, string> req = new Dictionary<string, string>();
            //req.Add("offset", "0");
            //req.Add("limit", "10");
        }

        public string createWallet(Dictionary<string, string> request)
        {
            if (request == null)
            {
                request = new Dictionary<string, string>();
            }

            if (!request.ContainsKey("name"))
            {
                request.Add("name", "false");
            }

            return this.request("POST", "/ltc/wallet", request);
        }

        public string loadWallet(Dictionary<string, string> request)
        {
            return this.request("POST", "/ltc/wallet/" + request["wallet_id"]+"/load", request);
        }

        public string unLoadWallet(Dictionary<string, string> request)
        {
            return this.request("POST", "/ltc/wallet/" + request["wallet_id"] + "/unload", request);
        }

        public string listWalletAddress(Dictionary<string, string> request)
        {
            if (request == null)
            {
                request = new Dictionary<string, string>();
            }

            if (!request.ContainsKey("address"))
            {
                request.Add("address", "false");
            }
            if (!request.ContainsKey("hdkeypath"))
            {
                request.Add("hdkeypath", "false");
            }

            refineValues(request, false);

            return this.request("GET", "/ltc/wallet/" + request["wallet_id"] + "/address");
        }

        public string createWalletAddress(Dictionary<string, string> request)
        {
            if (request == null)
            {
                request = new Dictionary<string, string>();
            }

            if (!request.ContainsKey("seed_wif"))
            {
                request.Add("seed_wif", "false");
            }
            if (!request.ContainsKey("password"))
            {
                request.Add("password", "false");
            }

            return this.request("POST", "/ltc/wallet/" + request["wallet_id"] + "/address", request);

        }

        public string getWalletBalance(Dictionary<string, string> request)
        {
            return this.request("GET", "/ltc/wallet/" + request["wallet_id"]+"/balance");
        }

        public string getWalletTransaction(Dictionary<string, string> request)
        {
            if (request == null)
            {
                request = new Dictionary<string, string>();
            }

            if (!request.ContainsKey("category"))
            {
                request.Add("category", "all");
            }
            if (!request.ContainsKey("order"))
            {
                request.Add("order", "desc");
            }

            refineValues(request, false);
            return this.request("GET", "/ltc/wallet/" + request["wallet_id"] + "/transaction", request);

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

            if (!request.ContainsKey("seed_wif"))
            {
                request.Add("seed_wif", "false");
            }
            if (!request.ContainsKey("password"))
            {
                request.Add("password", "false");
            }

            return this.request("POST", "/ltc/wallet/" + request["wallet_id"] + "/sendtoaddress", request);

        }

        public string sendMany(Dictionary<string, string> request)
        {
            if (request == null)
            {
                request = new Dictionary<string, string>();
            }

            if (!request.ContainsKey("seed_wif"))
            {
                request.Add("seed_wif", "false");
            }
            if (!request.ContainsKey("password"))
            {
                request.Add("password", "false");
            }

            return this.request("POST", "/ltc/wallet/" + request["wallet_id"] + "/sendmany", request);

        }

        public string sendTransaction(Dictionary<string, string> request)
        { 
             return this.request("POST", "/ltc/transaction/", request);
        }

        public string getTransaction(Dictionary<string, string> request)
        {
            return this.request("GET", "/ltc/transaction/" + request["hash"]);
        }
    }

