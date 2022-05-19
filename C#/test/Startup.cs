﻿using Microsoft.AspNetCore.OData;
using Microsoft.EntityFrameworkCore;
using Microsoft.OData.Edm;
using Microsoft.OData.ModelBuilder;
using test.Helpers;

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
        services.AddRouting();
            services.AddMvc();

            services.AddControllers()
                .AddOData(opt => opt
                .Count().Filter().Expand().Select().OrderBy().SetMaxTop(null)
                .AddRouteComponents("", GetEdmModel())
                );
        }

        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {

        }

        private static IEdmModel GetEdmModel()
        {
            var builder = new ODataConventionModelBuilder();
            return builder.GetEdmModel();  
        }
    }
}