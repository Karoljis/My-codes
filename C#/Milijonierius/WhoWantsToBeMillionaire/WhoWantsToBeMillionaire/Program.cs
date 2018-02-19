using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WhoWantsToBeMillionaire
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> klausimai = new List<string>() { "1. Daugiausia taškų Europos čempionatuose pelnęs žaidėjas?", "2. Koks yra mažiausias atstumas tarp Rusijos ir JAV?", "3. Kiek % miestų yra šiauriniame pusrutulyje?", "4. Kiek vidutiniškai kartų per metus įkvepia ir iškvepia žmogus?", "5. Daugiausia taškų pelnęs krepšininkas, atstovavęs Lietuvos krepšinio rinktinę?" };
            List<int> verte = new List<int>() { 100, 900, 9000, 90000, 900000 };
            string[,] atsakymai = new string[,]
            {
                {"A) Jonas Mačiulis", "B) Tony Parker", "C) Pau Gasol", "D) Dirk Nowitzki" },
                {"A) 100 km", "B) 96 km", "C) 51 km", "D) 4 km" },
                {"A) 75 %", "B) 50 %", "C) 60 %", "D) 45 %" },
                {"A) 2 milijardus", "B) 500 milijonų", "C) 5 milijonus", "D) 345 tūkstančius" },
                {"A) Artūras Karnišovas", "B) Saulius Štombergas", "C) Šarūnas Jasikevičius", "D) Arvydas Sabonis" }
            };
            List<string> teisingiAts = new List<string>() { "C", "D", "A", "C", "A" };
            int suma = 0;
            string kartojimas = null;
            Console.WriteLine("Sveiki atvykę į žaidimą: KAS TAPS MILIJONIERIUMI");
            Console.WriteLine("Žaidimą sudaro 5 klausimai: 1 klausimo vertė 100, 2 - 900, 3 - 9000, 4 - 90000 ir paskutinio 900000.");
            Console.WriteLine("Po kiekvieno klausimo galėsite nutraukti žaidimą įvedę žodį PINIGAI ir pasiimti laimėtus pinigus. ");
            Console.WriteLine("Jei esate pasiruošę, spauskite ENTER ir tapkite milijonieriumi!");
            Console.ReadLine();
            while (kartojimas != "NE")
            {
                 for (int i = 0; i < klausimai.Count; i++)
                 {
                  Console.Clear();
                        suma = suma + verte[i];
                        Console.WriteLine($"Klausimas kurio vertė yra:  {verte[i]}");
                  Console.WriteLine(klausimai[i]);
                  Console.WriteLine();
                      for (int j = 0; j < atsakymai.GetLength(1); j++)
                      {
                       Console.WriteLine(atsakymai[i, j]);
                      }
                 Console.WriteLine();
                 Console.WriteLine("Jusu spejimas (A/B/C/D): ");
                 string spejimas = Console.ReadLine().ToUpper();
                 if (spejimas == teisingiAts[i])
                 {
                 Console.WriteLine();
                 Console.WriteLine($"Jūsų atsakymas TEISINGAS!");
                            if (i==klausimai.Count-1)
                            {
                            Console.Clear();
                            Console.WriteLine($"Jūs atsakėte į visus klausimus teisingai ir laimėjote {suma} Pinigų !");
                            Console.WriteLine("Ar norite zaisti dar karta? (TAIP/NE)");
                            suma = 0;
                            kartojimas = Console.ReadLine().ToUpper();
                          
                        }
                            else
                            {
                            Console.WriteLine($"Jūs teisingai atsakėte į klausimą, kurio vertė yra {verte[i]} ir iš viso jau turite {suma}");
                            Console.WriteLine($"Jei norite nutraukti žaidimą ir pasiimti laimėtus {suma} rašykite: PINIGAI , o jei norite tęsti žaidimą spauskite ENTER ");
                            string piniguPaemimas = Console.ReadLine().ToUpper();
                            if (piniguPaemimas=="PINIGAI")
                            {
                                Console.Clear();
                                Console.WriteLine("Dėkojame už žaidimą");
                                Console.WriteLine($"Jūsų laimėta suma yra {suma}");
                                Console.ReadLine();
                                Environment.Exit(0);
                            }
                            }
                        }
                 else 
                 {
                    Console.WriteLine("Jūsų atsakymas neteisingas");
                        Console.WriteLine("Ar norite žaisti dar kartą? TAIP/NE");
                        string kartoti = Console.ReadLine().ToUpper();
                        if (kartoti == "TAIP")
                        {
                                suma = 0;
                                break;
                        }
                        else
                        {
                            Environment.Exit(0);
                        }
                        Console.ReadLine();
                 }
             }
            }
           
        }
    }
}
