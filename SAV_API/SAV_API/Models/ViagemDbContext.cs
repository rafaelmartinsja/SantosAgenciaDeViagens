using Microsoft.EntityFrameworkCore;

namespace SAV_API.Models
{
    public class ViagemDbContext : DbContext
    {
        public ViagemDbContext(DbContextOptions<ViagemDbContext> options)
          : base(options)
        { }



        public DbSet<Viagem> Viagens { get; set; }
    }
}
