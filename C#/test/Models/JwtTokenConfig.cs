namespace test.Models
{
    public class JwtTokenConfig{
        [JsonPropertyName("secret")]
        public string Secret { get; set; }
        
        [JsonPropertyName("issuer")]
        public string Issuer { get; set; }

        [JsonPropertyName("audience")]
        public string Audience { get; set; }
        
        [JsonPropertyName("accsessTokenExpiration")]
        public int AccessTokenExpiration { get; set; }

        [JsonPropertyName("refreshTokenExpiration")]
        public int RefreshTokenExpiration { get; set; }
    }
}