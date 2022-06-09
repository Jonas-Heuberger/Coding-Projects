namespace test.Models
{
    public class RefreshToken{

        [JsonPropertyName("token_string")]
        public string TokenString { get; set; }

        [JsonPropertyName("username")]
        public string UserName { get; set; }

        [JsonPropertyName("expires")]
        public DateTime ExpireAt { get; set; }
        
        [JsonPropertyName("url")]
        public string Url { get; set; }

    }
}
