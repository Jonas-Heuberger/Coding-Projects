namespace test.Models{


public class TokenRequest
    {
        [Required]
        [JsonPropertyName("username")]
        public string UserName { get; set; }
        
        [Required]
        [JsonPropertyName("password")]
        public string Password { get; set; }
    }
}