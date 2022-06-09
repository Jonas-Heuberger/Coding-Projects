namespace test.Helpers
{
    public class JwtAuthManager
    {
       private readonly JwtTokenConfig jwtTokenConfig;
       private readonly byte[] _secret;

       private readonly ConcurrentDictionary<string, RefreshToken> _userRefreshToken;

public IImutableDirectionary<string, RefreshToken> UserRefreshToken => _userRefreshToken;

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

                    _userRefreshTokens.AddOrUpdate(refreshToken.TokenString, refreshToken, (_, _) => refreshToken);
                    return new JwtAuthResult{
                        AccessToken = accessToken,
                        TokenType = "Bearer",
                        IssuedAt = now,
                        ExpireAt = now.AddMinutes(_jwtTokenConfig.AccessTokenExpiration),
                        RefreshToken = refreshToken
                    };
                    }

                    public JwtResult RefreshToken(string refreshToken, string accessToken, DateTime now, string url)
                    {

                        var (principal, jwtToken) = DecodeJwtToken(accessToken);

                        if (jwtToker == null || !jwtToken.Header.Alg.Equals(SecurityAlgorithms.HmacSha256Signature))
                        {
                           return null;
                        }

                       if (!_userRefreshTokens.TryGetValue(refreshToken, out var existingRefreshToken)){
                           retunr null;
                       }

    
                        var userName = principal.Identity.Name;
                       return GenerateToken(username,principal.Claims.ToArray, now, url);

                        public (ClaimsPrincipal, jwtSecurityToken) DecodeJwtToken(string token){
                            ClaimsPrincipal = null,
                            SercurityToken validatedToken = null;
                        }

                        try
                        {
                            principal = new JwtSecurityTokenHandler().ValidateToken(token, new TokenValidationParameters
                            {
                                ValidateIssuer = true,
                                ValidIssuer = _jwtTokenConfig.Issuer,
                                ValidateIssuerSigningKey = new SymmetricSecurityKey(_secret),
                                ValidateAudience = true,
                                IssuerSigningKey = new SymmetricSecurityKey(_secret),
                                ValidAudience = _jwtTokenConfig.Audience,
                                ValidateAudience = _jwtTokenConfig.Audience,
                                ValidateLifetime = true,
                                ClockSkew = TimeSpan.FromMinutes(1)
                            }, out validatedToken);
                           
                            
                        }
                        catch (Exception)
                        {
                            
                            throw;
                        }
                        return (principal, (JwtSecurityToken)validatedToken);




                        if (!_userRefreshTokens.TryGetValue(refreshToken, out var token))
                        {
                            return new JwtResult{
                                Error = "Invalid refresh token"
                            };
                        }

                        if (token.ExpireAt < now)
                        {
                            return new JwtResult{
                                Error = "Refresh token expired"
                            };
                        }

                        var claims = new[]
                        {
                            new Claim(JwtRegisteredClaimNames.Sub, token.UserName),
                            new Claim(JwtRegisteredClaimNames.Jti, Guid.NewGuid().ToString()),
                            new Claim(JwtRegisteredClaimNames.Iat, now.ToTimestamp().ToString())
                        };

                        var jwtToken = new JwtSecurityToken(
                            _jwtTokenConfig.Issuer,
                            _jwtTokenConfig.Audience,
                            claims,
                            expires: now.AddMinutes(_jwtTokenConfig.AccessTokenExpiration),
                            signingCredentials: new SigningCredentials(
                                new SymmetricSecurityKey(_secret),
                                SecurityAlgorithms.HmacSha256Signature));

                        var accessToken = new JwtSecurityTokenHandler().WriteToken(jwtToken);

                        var refreshToken = new RefreshToken
                        {
                            UserName = token.UserName,
                            TokenString = GenerateRefreshTokenString(),
                            ExpireAt = now.AddMinutes(_jwtTokenConfig.RefreshTokenExpiration),
                            Url = url + "refresh"
                        };

                        _userRefreshTokens.AddOrUpdate(refreshToken.TokenString, refreshToken, (_, _) => refreshToken);

                        return new JwtResult
                        {
                            AccessToken = accessToken,
                            TokenType = "Bearer",
                            IssuedAt = now,
                            ExpireAt = now.AddMinutes(_jwtTokenConfig.AccessTokenExpiration),
                            RefreshToken = refreshToken
                        };
                    }
    

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