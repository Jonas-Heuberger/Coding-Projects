namespace ToDoManagement.Models
{
    public class ToDo
    {
        public int Id { get; set; }
        public string name { get; set; }
        public int priority { get; set; }
        public DateTime deadline { get; set; }
    }
}
