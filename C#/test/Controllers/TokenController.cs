using Microsoft.AspNetCore.Mvc;
using test.Models;
using Microsoft.AspNetCore.Authoritation;

namespace test.Controllers
{
 [ApiController]
    class TokenController : ControllerBase
    {
        private readonly IServiceProvider _serviceProvider;
        public TokenController(IService serviceProvider)
        {
            _serviceProvider = serviceProvider;
        }

    [AllowAnonymous]
    [HttpPost]
    [Route("token")]
    public async Task<JwtAuthResult> Token([FromForm] TokenRequest request)
    {
        if (string.IsNullOrEmpty(request.UserName) || string.IsNullOrEmpty(request.Password))
        
            throw new SecurityTokenException("Invalid username or password");
            
            // hier erfolgt die Username Passwort Verifikation
            var jwtAuthManager = _serviceProvider.GetRequiredService<IJwtAuthManager>(); 

            var now = DateTime.Now;
            var claims = new[] {
                new Claim(ClaimsTypes.Name, request.UserName),
                new Claim(ClaimsTypes.Role, "DummyRole"),
                
            };
            var url = $"{Request.Scheme}://{Request.Host}";
            var token = jwtAuthManager.GenerateToken(request.UserName, claims, now, url);
            return token;
        }

        [AllowAnonymous]
        [HttpPost]
        [Route("token")]
        public async Task<JwtAuthResult> Refresh([FromForm] RefreshRequest request)
        {
        if (string.IsNullOrEmpty(request.RefreshToken) || string.IsNullOrEmpty(request.AccessToken))
            throw new SecurityTokenException("Invalid Username or Password");

            var jwtAuthManager = _serviceProvider.GetRequiredService<IJwtAuthManager>(); 
            var now = DateTime.Now;
            var url = $"{Request.Scheme}://{Request.Host}";

            var token = jwtAuthManager.RefreshToken(request.RefreshToken, request.AccessToken, now, url);

            return token;

        }
    }
}
