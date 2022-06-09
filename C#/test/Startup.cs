using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using Microsoft.OData.Edm;
using Microsoft.OData.ModelBuilder;
using test.Helpers;
using test.Models;

namespace test
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;

        }

        public IConfiguration Configuration { get; }

        public void ConfigureServices(IServiceCollection services)
        {
            services.AddDbContext<DbApiContext>(
                options => options.UseSqlServer(Configuration.GetConnectionString("localhost")));

                var jwtTokenConfig = Configuration.GetSection("JwtToken").Get<JwtTokenConfig>();
                services.AddSingleton(jwtTokenConfig);
                services.AddAuthentication();
                
        services.AddRouting();
            services.AddMvc();

            services.AddControllers()
                .AddOData(opt => opt
                .Count().Filter().Expand().Select().OrderBy().SetMaxTop(null)
                .AddRouteComponents("", GetEdmModel())
                );
                services.AddHttpClient();
        }

        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            app.UseRouting();
            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllerRoute("default", "{controller=Home}/{action=Index}");
            });
        }

        private static IEdmModel GetEdmModel()
        {
            var builder = new ODataConventionModelBuilder();
            builder.EntitySet<Schueler>("Schueler");
            return builder.GetEdmModel();  
        }
    }
}
