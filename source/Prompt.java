import java.util.Scanner;

public class Prompt {

    public static void main (String[] args)
    {
            Scanner reader = new Scanner(System.in);
            Tree arvore = new Tree();
            int key = 0;

            arvore.construir(null, 1, 0,0, 0);

            do
            {
                System.out.println("" + 
                             + "1 - Mostra Pré-Ordem/Direita " + 
                             + "2 - Mostra Pré-Ordem/Esquerda " + 
                             + "3 - Mostra Pos-Ordem/Direita" + 
                             + "4 - Mostra Pos-Ordem/Esquerda " + 
                             + "5 - Verifica se Existe " + 
                             + "6 - Informa matricula e da Idade " + 
                             + "7 - Media das Idades " + 
                             + " 8 - Altura da arvore " + 
                             + "9 - Sair");

                key = Integer.parseInt(reader.next());

                switch (key)
                {
                    case 1:
                        arvore.lista(arvore.root, 1, 1, 0);
                        Console.ReadKey();
                        break;
                    case 2:
                        arvore.lista(arvore.root, 0, 1, 0);
                        Console.ReadKey();
                        break;
                    case 3:
                        arvore.lista(arvore.root, 1, 0, 0);
                        Console.ReadKey();
                        break;
                    case 4:
                        arvore.lista(arvore.root, 0, 0, 0);
                        Console.ReadKey();
                        break;
                    case 5:
                        System.out.println("Digite a matricula que deseja consultar:");     

                        if (arvore.busca(arvore.root, Integer.parseInt(reader.next())))                       
                            System.out.println("achou");
                        else
                            System.out.println("nao achou");

                        Console.ReadKey();
                        break;
                    case 6:
                        System.out.println("Digite a matricula que deseja consultar a idade:");

                        System.out.println("Idade é " + arvore.retornaIdadeDaMatricula(arvore.root, Integer.parseInt(reader.next())));

                        Console.ReadKey();
                        
                        break;
                    case 7:

                        Averager fazMedia = new Averager();
                        
                        fazMedia = arvore.arvoreMedia(arvore.root, fazMedia);

                        if (fazMedia != null)
                        {
                            System.out.println("A média é:" + fazMedia.fazMedia());
                            Console.ReadKey();
                        }              
                        break;
                    case 8:
                        System.out.println("Tamanho da arvore é " + arvore.tamanhoarvore(arvore.root,0));
                        reader.next();
                        break;
                }
            } while (key != 9 );

;
        }
    }
