using System;

namespace ATM
{
	class Programm
	{
		static void Main(string[] args)
		{
			Console.WriteLine("Geben Sie eine zahl ein: ");
			int betrag = Abfrage();
			int[] Noten = berechnen(betrag);
			Ausgabe(Noten);
		}
		static int Abfrage()
		{
			int zahl = Convert.ToInt32(Console.ReadLine());
			return zahl;
		}
		static int[] berechnen(int betrag)
		{
			int[] Noten = new int[9];

			for (Noten[0] = 0; betrag >= 1000; Noten[0]++)
			{
				betrag = betrag - 1000;
			}

			for (Noten[1] = 0; betrag >= 200; Noten[1]++)
			{
				betrag = betrag - 200;
			}

			for (Noten[2] = 0; betrag >= 100; Noten[2]++)
			{
				betrag = betrag - 100;
			}

			for (Noten[3] = 0; betrag >= 50; Noten[3]++)
			{
				betrag = betrag - 50;
			}

			for (Noten[4] = 0; betrag >= 20; Noten[4]++)
			{
				betrag = betrag - 20;
			}

			for (Noten[5] = 0; betrag >= 10; Noten[5]++)
			{
				betrag = betrag - 10;
			}

			for (Noten[6] = 0; betrag >= 5; Noten[6]++)
			{
				betrag = betrag - 5;
			}

			for (Noten[7] = 0; betrag >= 2; Noten[7]++)
			{
				betrag = betrag - 2;
			}

			for (Noten[8] = 0; betrag >= 1; Noten[8]++)
			{
				betrag = betrag - 1;
			}
			return Noten;
		}
						static void Ausgabe(int[] Noten)
		{
			Console.WriteLine("Tausender: " + Noten[0]);
			Console.WriteLine("Zweihunderter: " + Noten[1]);
			Console.WriteLine("Hunderter: " + Noten[2]);
			Console.WriteLine("Fünfziger: " + Noten[3]);
			Console.WriteLine("Zwanziger: " + Noten[4]);
			Console.WriteLine("Zehner: " + Noten[5]);
			Console.WriteLine("Fünfer: " + Noten[6]);
			Console.WriteLine("Zweier:  " + Noten[7]);
			Console.WriteLine("Einer: " + Noten[8]);
		}
	}
}