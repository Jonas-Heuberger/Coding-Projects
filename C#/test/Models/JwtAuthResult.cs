namespace JwtAuthResult
{
    public class JwtAuthResult
    {
    [JsonPropertyName("access_token")]]    
    public string AccessToken { get; set; }

    [JsonPropertyName("token_type")]
    public string TokenType { get; set; }

    [JsonPropertyName("issued")]
    public DateTime IssuedAt { get; set; }

    [JsonPropertyName("expires")]
    public DateTime ExpireAt { get; set; }

    [JsonPropertyName("refresh_token")]
    public RefreshToken RefreshToken { get; set; }

    
    }
}