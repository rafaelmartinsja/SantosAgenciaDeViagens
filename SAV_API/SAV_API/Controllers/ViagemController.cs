using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using SAV_API.Models;

namespace SAV_API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ViagemController : ControllerBase
    {
        private readonly ViagemDbContext _context;

        public ViagemController(ViagemDbContext context)
        {
            _context = context;
        }

        // GET: api/Viagem - LISTA TODOS as Viagems
        [HttpGet]
        public IEnumerable<Viagem> GetViagens()
        {
            return _context.Viagens;
        }

        // GET: api/Viagem/id - LISTA Viagens POR ID
        [HttpGet("{id}")]
        public IActionResult GetViagemPorId(int id)
        {
            Viagem viagem = _context.Viagens.SingleOrDefault(modelo => modelo.id == id);
            if (viagem == null)
            {
                return NotFound();
            }
            return new ObjectResult(viagem);
        }

        // CRIA uma nova Viagem
        [HttpPost]
        public IActionResult CriarViagem(Viagem item)
        {
            if (item == null)
            {
                return BadRequest();
            }



            _context.Viagens.Add(item);
            _context.SaveChanges();
            return new ObjectResult(item);

        }

        // ATUALIZA UMa Viagem EXISTENTE
        [HttpPut("{id}")]
        public IActionResult AtualizaViagem(int id, Viagem item)
        {
            if (id != item.id)
            {
                return BadRequest();
            }
            _context.Entry(item).State = EntityState.Modified;
            _context.SaveChanges();



            return new NoContentResult();
        }

        // APAGA UMa Viagem POR ID
        [HttpDelete("{id}")]
        public IActionResult DeletaViagem(int id)
        {
            var viagem = _context.Viagens.SingleOrDefault(m => m.id == id);



            if (viagem == null)
            {
                return BadRequest();
            }



            _context.Viagens.Remove(viagem);
            _context.SaveChanges();
            return Ok(viagem);
        }
    }
}
