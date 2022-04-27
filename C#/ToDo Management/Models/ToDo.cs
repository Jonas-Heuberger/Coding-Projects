namespace ToDo_Management.Models
{
    public class ToDo
    {
        public int idToDo { get; set; }
        public string name { get; set; }
        public int priority { get; set; }
        public DateTime deadline { get; set; }
    }
}
