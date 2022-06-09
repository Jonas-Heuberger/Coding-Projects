using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace test.Models
{
    [Table("tbl_Schueler", Schema = "dbo")]
    public class Schueler
    {
        [Key]
        [ReadOnly(true)]
        public Guid rowguid { get; set; }
        public string Nachname { get; set; }
        public string Vorname { get; set; }
        public string Strasse { get; set; }
        public int? PLZ { get; set; } // ? = nullable
        public string Ort { get; set; }
    }
}