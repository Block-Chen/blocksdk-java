import java.util.*;
import java.lang.String;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class BlockSDK : Base
    {

        public BlockSDK(string api_token) : base(api_token)
        {
        }

        //Static Generators

        public static Dash createDash(string api_token)
        {
            return new Dash(api_token);
        }

        public static Bitcoin createBitcoin(string api_token)
        {
            return new Bitcoin(api_token);
        }

        public static Ethereum createEthereum(string api_token)
        {
            return new Ethereum(api_token);
        }

        public static Monero createMonero(string api_token)
        {
            return new Monero(api_token);
        }

        public static BitcoinCash createBitcoinCash(string api_token)
        {
            return new BitcoinCash(api_token);
        }

        public static Litecoin createLitecoin(string api_token)
        {
            return new Litecoin(api_token);
        }

        public static Webhook createWebHOOK(string api_token)
        {
            return new Webhook(api_token);
        }

        //Instance Methods

        public Dash createDash()
        {
            return new Dash(api_token);
        }

        public Bitcoin createBitcoin()
        {
            return new Bitcoin(api_token);
        }

        public Ethereum createEthereum()
        {
            return new Ethereum(api_token);
        }

        public Monero createMonero()
        {
            return new Monero(api_token);
        }

        public BitcoinCash createBitcoinCash()
        {
            return new BitcoinCash(api_token);
        }

        public Litecoin createLitecoin()
        {
            return new Litecoin(api_token);
        }

        public Webhook createWebHOOK()
        {
            return new Webhook(api_token);
        }




    }
