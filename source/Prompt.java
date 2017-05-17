import java.util.Scanner;

public class Prompt
{

    public static void main (String[] args)
    {
        Scanner reader = new Scanner(System.in);
        Tree arvore = new Tree();
        int key;

        arvore.construir(null, 1, 0, 0, 0);

        do
        {
            System.out.println(
            "1 - Mostra Pré-Ordem/Direita\n" +
            "2 - Mostra Pré-Ordem/Esquerda\n" +
            "3 - Mostra Pós-Ordem/Direita\n" +
            "4 - Mostra Pós-Ordem/Esquerda\n" +
            "5 - Verifica se Existe\n" +
            "6 - Informa matrícula e idade\n" +
            "7 - Média das idades\n" +
            "8 - Altura da árvore\n" +
            "9 - Sair"
            );

            key = Integer.parseInt(reader.next());

            switch (key)
            {
                case 1:
                arvore.lista(arvore.root, 1, 1, 0);
                break;

                case 2:
                arvore.lista(arvore.root, 0, 1, 0);
                break;

                case 3:
                arvore.lista(arvore.root, 1, 0, 0);
                break;

                case 4:
                arvore.lista(arvore.root, 0, 0, 0);
                break;

                case 5:
                System.out.println("Digite a matrícula que deseja consultar:");

                if (arvore.busca(arvore.root, Integer.parseInt(reader.next())))
                System.out.println("achou");
                else
                System.out.println("nao achou");

                break;

                case 6:
                System.out.println("Digite a matrícula que deseja consultar a idade:");
                System.out.println("Idade é " + arvore.retornaIdadeDaMatricula(arvore.root, Integer.parseInt(reader.next())));
                break;

                case 7:

                Averager doAvg = new Averager();

                doAvg = arvore.getAverage(arvore.root, doAvg);

                if (doAvg != null)
                System.out.println("A média é:" + doAvg.calc());

                break;

                case 8:
                System.out.println("Tamanho da arvore é " + arvore.getLength(arvore.root,0));
                break;

                case 9:
                System.out.println("Bye! bye!");
                break;
            }
        } while (key != 9);
    }

}
