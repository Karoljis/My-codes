using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace uzduotis5_4_ciklas_
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Iveskite naturalu skaiciu: ");
            int a = Convert.ToInt32(Console.ReadLine());
            for (int i = a + 1; i < a + 11; i++)
            {
                Console.WriteLine(i);
                for (int i2 = 1; i2 < i; i2++)
                {
                    Console.Write(i2);
                }
                Console.WriteLine();
            }

            Console.ReadLine();

        }
    }
}
