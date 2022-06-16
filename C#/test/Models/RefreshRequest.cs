namespace test.Models
{
    public class RefreshRequest
    {
        [Required]
        [JsonPropertyName("refreshtoken")]
        public string RefreshToken { get; set; }

        [Required]
        [JsonPropertyName("accesstoken")]
        public string AccessToken { get; set; }
    }
}