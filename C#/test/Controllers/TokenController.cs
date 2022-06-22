using Microsoft.AspNetCore.Mvc;
using test.Models;
using Microsoft.AspNetCore.Authoritation;

namespace test.Controllers
{
 [ApiController]
    class TokenController : ControllerBase
    {
        private DbApiContext _dbApiContext;
        private readonly IServiceProvider _serviceProvider;
        public TokenController(IService serviceProvider, DbApiContext dbApiContext)
        {
            _serviceProvider = serviceProvider; 
            _dbApiContext = dbApiContext;
        }

    [AllowAnonymous]
    [HttpPost]
    [Route("token")]
    public async Task<JwtAuthResult> Token([FromForm] TokenRequest request)
    {
        if (string.IsNullOrEmpty(request.UserName) || string.IsNullOrEmpty(request.Password))
        
            throw new SecurityTokenException("Invalid username or password");

        if (!awaitCheckUser(request.UserName, request.Password))
        {
            throw new SecurityTokenException("Invalid username or password");
        }
            
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

        private async Task<bool> CheckUser(string username, string password){
             if (string.IsNullOrEmpty(username) || string.IsNullOrEmpty(password)) return false;

             var param = new List<SqlParameter>();
             param.Add(new SqlParameter("@UserName", username));
             param.Add(new SqlParameter("@Password", password));

            var sParams = Ims.GetSqlParameterStringFromList(param);
             var sql = "exec usp.CheckUser  "+ sParams;
             var result = await _dbApiContext.User.FromSqlRaw(sql, param.ToArray()).IgnoreFilters.ToListAsync();

             if (result.Count > 1) return true; 
             return false;
        }
    }
}
