class Tree
{
    public Node root;
    
    public Tree()
    {
        root = null;
    }

    public void construir(Node pai,int lado,int num,int mat,int level)
    {
        int numero = 0,matricula = 0;
        // lado 0 - esquerda...1 - direita
        Node aux = new Node(num,mat);
        if (pai == null)
        {
        System.out.println("Informe a root");
        matricula = Integer.parseInt(reader.next());
        System.out.println("Informe a Idade");
        numero = Integer.parseInt(reader.next());
        }
        else
        {
        if (lado == 0)
        {
            System.out.println("Informe o lado Esquedo do " + num);
            matricula = Integer.parseInt(reader.next());
            System.out.println("Informe a Idade");
            numero = Integer.parseInt(reader.next());
        }
        else
        {
            System.out.println("Informe o lado Direito do " + num);
            matricula = Integer.parseInt(reader.next());
            System.out.println("Informe a Idade");
            numero = Integer.parseInt(reader.next());
        }
        

        }
        if (numero != 0)
        {
        aux = coloca(pai, numero, matricula, lado);
        level++;
        if (level < 3)
        {
            if (pai == null)
            System.out.println("=======LADO DIREITO=======");
            construir(aux, 1, numero,matricula, level);
            if (pai == null)
            System.out.println("=======LADO ESQUERDO=======");
            construir(aux, 0, numero,matricula , level);
        }
        level--;

        }

    }
    Node coloca(Node atual,int quem,int matricula,int lado)
    {
        Node novo = new Node(quem,matricula);
        if (atual == null)
        {
        root = novo;
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
    public void  lista(Node pai,int lado,int sentido,int nivel)
    {
        if (pai != null)
        {
        string espaco = "";
        for (int i = 0; i < nivel; i++)
        {
            espaco += "     ";
        }
        /*==legenda==*/
        //lado 0 - esquerda...1 - direita
        //sentido 0 - de cima pra baixo...1 - de baixo pra cima
        if (sentido == 0)
        {
            System.out.println(espaco +=pai.getNum());
        }

        nivel++;
        if (lado == 0)
        {            
            lista(pai.getFilE(), 0, sentido,nivel);

            lista(pai.getFilD(), 1, sentido,nivel);

        }
        else
        {
            lista(pai.getFilD(), 0, sentido, nivel);

            lista(pai.getFilE(), 1, sentido, nivel);

        }
        nivel--;
        if (sentido == 1)
        {
            
            System.out.println(espaco + pai.getNum());
            
        }

        }
    }
    public Boolean busca(Node pai,int numero)
    {
        if (pai != null)
        {
        if (pai.getData() == numero)
        {
            return true;
        }
        if (busca(pai.getFilE(), numero))
        {
            return true;
        }
        if (busca(pai.getFilD(), numero))
        {
            return true;
        }                
        }
        return false;
    }
    public int retornaIdadeDaMatricula(Node pai, int numero)
    {
        int aux;
        if (pai != null)
        {
        if (pai.getData() == numero)
        {
            return pai.getNum();
        }
        aux = retornaIdadeDaMatricula(pai.getFilE(), numero);
        if (aux != 0)
            return aux;
        aux = retornaIdadeDaMatricula(pai.getFilD(), numero);
        if (aux != 0)
            return aux;
        }
        return 0;
    }
    public int tamanhoTree(Node pai,int nivel)
    {
        if (pai != null)
        {
        int nivel1 = 0;
        nivel1 = nivel + 1; ;

        nivel = tamanhoTree(pai.getFilD(), nivel1);
        if (nivel < nivel1)
            nivel1 = nivel;

        nivel = tamanhoTree(pai.getFilE(), nivel1);
        if (nivel < nivel1)
            nivel1 = nivel;
        return nivel;
        }
        return nivel;
    }

    public Averager TreeMedia(Node pai, Averager media)
    {
        if (pai != null)
        {
            media.numero += pai.getNum();
            media.quantidade++;
            media = TreeMedia(pai.getFilE(), media);
            media = TreeMedia(pai.getFilD(), media);
            return media;
        }
        return media;
    }
}
