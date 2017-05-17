using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Arvore_Binaria
{
    class Program
    {
        static void Main(string[] args)
        {
            arvore arvore = new arvore();
            arvore.construir(null, 1, 0,0, 0);
            int key = 0;
            do
            {
                Console.Clear();
                Console.WriteLine(@"
                                    1 - Mostra Pré-Ordem/Direita 
                                    2 - Mostra Pré-Ordem/Esquerda 
                                    3 - Mostra Pos-Ordem/Direita
                                    4 - Mostra Pos-Ordem/Esquerda 
                                    5 - Verifica se Existe 
                                    6 - Informa matricula e da Idade 
                                    7 - Media das Idades 
                                    8 - Altura da Arvore 
                                    9 - Sair");

                key = Convert.ToInt32(Console.ReadLine());
                switch (key)
                {
                    case 1:
                        arvore.lista(arvore.raiz, 1, 1, 0);
                        Console.ReadKey();
                        break;
                    case 2:
                        arvore.lista(arvore.raiz, 0, 1, 0);
                        Console.ReadKey();
                        break;
                    case 3:
                        arvore.lista(arvore.raiz, 1, 0, 0);
                        Console.ReadKey();
                        break;
                    case 4:
                        arvore.lista(arvore.raiz, 0, 0, 0);
                        Console.ReadKey();
                        break;
                    case 5:
                        Console.WriteLine("Digite a matricula que deseja consultar:");                        
                        if (arvore.busca(arvore.raiz, Convert.ToInt32(Console.ReadLine())))                       
                            Console.WriteLine("achou");
                        else
                            Console.WriteLine("nao achou");
                        Console.ReadKey();
                        break;
                    case 6:
                        Console.WriteLine("Digite a matricula que deseja consultar a idade:");

                        Console.WriteLine("Idade é " + arvore.retornaIdadeDaMatricula(arvore.raiz, Convert.ToInt32(Console.ReadLine())));

                        Console.ReadKey();
                        
                        break;
                    case 7:
                        media fazMedia = new media();
                        fazMedia = arvore.arvoreMedia(arvore.raiz, fazMedia);
                        if (fazMedia != null)
                        {
                            Console.WriteLine("A média é:" + fazMedia.fazMedia());
                            Console.ReadKey();
                        }              
                        break;
                    case 8:
                        Console.WriteLine("Tamanho da arvore é " + arvore.tamanhoArvore(arvore.raiz,0));
                        Console.ReadLine();
                        break;
                }
            } while (key != 9 );

;
        }
    }
}
