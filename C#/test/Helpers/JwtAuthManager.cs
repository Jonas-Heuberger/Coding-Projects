namespace test.Helpers
{
    public class JwtAuthManager
    {
       private readonly JwtTokenConfig jwtTokenConfig;
       private readonly byte[] _secret;

       private readonly ConcurrentDictionary<string, RefreshToken> _userRefreshToken;

         public JwtAuthManager(JwtTokenConfig jwtTokenConfig)
         {
             _jwtTokenConfig = jwtTokenConfig;
             _userRefreshToken = new ConcurrentDictionary<string, RefreshToken>(); 
             _secret = Encoding.ASCII.GetBytes(jwtTokenConfig.Secret);
              
         }

         public void RemoveExpireRefreshTokens(DateTime, now)
         {
             var expiredTokens = _userRefreshTokens.Where(x => x.Value.ExpireAt < now).ToList();
             foreach (var token in expiredTokens)
             {
                 _userRefreshTokens.TryRemove(expiredToken.Key, out _);
             }
         }

          public void RemoveRefreshTokenByUserName(string, userName)
         {
             var expiredTokens = _userRefreshTokens.Where(x => x.Value.UserName == userName).ToList();
             foreach (var expiredToken in expiredTokens)
             {
                 _userRefreshTokens.TryRemove(expiredToken.Key, out _);
             }
         }

         public JwtAuthResult GenerateToken(string username, Claim[] claims, DateTime now, string url)
         {
            var shouldAddAudienceClaim = 
            string.IsNullOrWhiteSpace(
                claims?.FirstOrDefault(
                    x => x.Type == JwtRegisteredClaimNames.Aud)?.Value);
         }

         var jwtToken = new JwtSecurityToken(
             _jwtTokenConfig.Issuer,
             shouldAddAudienceClaim ? _jwtTokenConfig.Audience : String.Empty,
             claims,
             expires: now.AddMinutes(_jwtTokenConfig.AccessTokenExpiration),
            signingCredentials: new SigningCredentials(
                 new SymmetricSecurityKey(_secret),
                 SecurityAlgorithms.HmacSha256Signature));

                 var accessToken = new JwtSecurityTokenHandler().WriteToken(jwtToken);

                 var refreshToken = new RefreshToken {
                     UserName = username,
                     TokenString = GenerateRefreshTokenString(),
                     ExpireAt = now.AddMinutes(_jwtTokenConfig.RefreshTokenExpiration),
                     Url = url + "refresh"
                 };

                 private static string GenerateRefreshTokenString()
                 {
                     var randomNumber = new byte[32];
                     using (var randomNumberGenerator = RandomNumberGenerator.Create())
                     {
                         randomNumberGenerator.GetBytes(randomNumber);
                         return Convert.ToBase64String(randomNumber);
                     }
                 }
}