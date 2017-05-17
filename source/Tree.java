import java.util.Scanner;

public class Tree
{
    public Node root;

    public Tree()
    {
        this.root = null;
    }

    public void construir(Node parent, int lado, int num, int mat, int level)
    {
        // lado 0 - esquerda
        // lado 1 - direita

        int data = 0;
        int matricula = 0;
        Node aux = new Node(num, mat);

        String question = "Informe ";

        if (parent == null)
        {
            question += "a root";
        }
        else
        {
            question += (lado == 0 ? "o lado Esquerdo" : "o lado Direito") + " do " + num;
        }

        Scanner reader = new Scanner(System.in);

        System.out.println(question);
        matricula = Integer.parseInt(reader.next());

        System.out.println("Informe a Idade: ");
        data = Integer.parseInt(reader.next());

        if (data != 0)
        {
            aux = coloca(parent, data, matricula, lado);
            level++;
            if (level < 3)
            {
                if (parent == null)
                System.out.println("=======LADO DIREITO=======");

                construir(aux, 1, data, matricula, level);

                if (parent == null)
                System.out.println("=======LADO ESQUERDO=======");

                construir(aux, 0, data, matricula , level);
            }
            level--;
        }
    }

    Node coloca(Node atual, int quem, int matricula, int lado)
    {
        Node novo = new Node(quem, matricula);

        if (atual == null)
        {
            this.root = novo;
        }
        else
        {
            if (lado == 0)
            {
                atual.setSonLeft(novo);
            }
            else
            {
                atual.setSonRight(novo);
            }
        }

        return novo;
    }

    public void lista(Node parent, int lado, int sentido, int nivel)
    {
        if (parent != null)
        {
            String espaco = "";

            for (int i = 0; i < nivel; i++)
            {
                espaco += "     ";
            }

            // lado 0 - esquerda
            // lado 1 - direita
            // sentido 0 - cima pra baixo
            // sentido 1 - baixo pra cima

            if (sentido == 0)
            {
                System.out.println(espaco +=parent.getIndex());
            }

            nivel++;

            if (lado == 0)
            {
                lista(parent.getSonLeft(), 0, sentido, nivel);
                lista(parent.getSonRight(), 1, sentido, nivel);
            }
            else
            {
                lista(parent.getSonRight(), 0, sentido, nivel);
                lista(parent.getSonLeft(), 1, sentido, nivel);
            }

            nivel--;

            if (sentido == 1)
            {

                System.out.println(espaco + parent.getIndex());

            }

        }
    }

    public Boolean busca(Node parent, int data)
    {
        if (parent != null)
        {
            if (parent.getData() == data)
            {
                return true;
            }
            if (busca(parent.getSonLeft(), data))
            {
                return true;
            }
            if (busca(parent.getSonRight(), data))
            {
                return true;
            }
        }
        return false;
    }

    public int retornaIdadeDaMatricula(Node parent, int data)
    {
        int aux;
        if (parent != null)
        {
            if (parent.getData() == data)
            {
                return parent.getIndex();
            }

            aux = retornaIdadeDaMatricula(parent.getSonLeft(), data);

            if (aux != 0)
                return aux;

            aux = retornaIdadeDaMatricula(parent.getSonRight(), data);

            if (aux != 0)
                return aux;
        }
        return 0;
    }

    public int getLength(Node parent, int nivel)
    {
        if (parent != null)
        {
            int nivel1 = 0;
            nivel1 = nivel + 1;

            nivel = getLength(parent.getSonRight(), nivel1);

            if (nivel < nivel1)
            nivel1 = nivel;

            nivel = getLength(parent.getSonLeft(), nivel1);

            if (nivel < nivel1)
            nivel1 = nivel;

            return nivel;
        }
        return nivel;
    }

    public Averager getAverage(Node parent, Averager avg)
    {
        if (parent != null)
        {
            avg.sum += parent.getIndex();
            avg.qty++;
            avg = getAverage(parent.getSonLeft(), avg);
            avg = getAverage(parent.getSonRight(), avg);
        }
        return avg;
    }
}
