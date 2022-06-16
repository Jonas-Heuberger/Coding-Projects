namespace test.Helpers
{
    public class JwtRefreshTokenCache : HostedService, IDispoable{

        private Timer _timer;
        private readonly IJwtAuthManager _jwtAuthManager;
        public JwtRefreshTokenCache(IJwtAuthManager jwtAuthManager)
        {
            _jwtAuthManager = jwtAuthManager;
        }
        public Task StarAsync(CancellationToken stoppingToken)
        {
            _timer = new Timer(DoWork, null, TimeSpan.Zero, TimeSpan.FromMinutes(1));
            return Task.CompletedTask;
        }
        private void DoWork(object state)
        {
            _jwtAuthManager.RemoveExpiredRefreshTokens(DateTime.Now);
        }
    } 
    
}