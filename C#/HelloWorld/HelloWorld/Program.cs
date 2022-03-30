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
			

		}
	}

	public class Cat
    {
		public int Age;
		public double Height;
		public double Weight;
		public string Name;
		public string Race;

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