using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace uzduotis5_5_ciklas_
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Iveskite naturalu skaiciu:");
            int a = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine();
            int spaces = a - 1;

            for (int i = 1; i <= a; i++)
            {
                for (int k = 1; k <= spaces; k++)
                {
                    Console.Write(" ");
                }
                for (int j = 1; j <= i; j++)
                {
                    Console.Write($"{i} ");
                }
                spaces--;


                Console.WriteLine();

            }
            Console.ReadLine();
        }
    }
}
