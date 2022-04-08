using System;

namespace HelloWorld
{
	public class main
	{
		static void Main(string[] args)
		{
			Cat cat = new Cat(12, 50, 60, "Albert", "tiger");
			Console.WriteLine(cat.Name); 
			Console.WriteLine(cat.Age);
			Console.WriteLine(cat.Race);
			Console.WriteLine(cat.Height);
			Console.WriteLine(cat.Weight);
			

		}
	}

	public class Cat
	{
		private int Age {get; set;}
		public double Height { get { return Height; } set { Height = value; }}
		public double Weight { get { return Weight; } set { Weight = value; }}
		public string Name { get { return Name; } set { Name = value; }}
		public string Race { get { return Race; } set { Race = value; }}

		public Cat(int Age, double Height, double Weight, string Name, string Race)
		{
			this.Age = Age;
			this.Height = Height;
			this.Weight = Weight;
			this.Name = Name;
			this.Race = Race;
		}
	}
}