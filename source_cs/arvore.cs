using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Arvore_Binaria
{
    class arvore
    {
        public Nodo raiz;
        public arvore()
        {
            raiz = null;
        }

        public void construir(Nodo pai,int lado,int num,int mat,int level)
        {
            int numero = 0,matricula = 0;
            //lado 0 - esquerda...1 - direita
            Nodo aux = new Nodo(num,mat);
            if (pai == null)
            {
                Console.WriteLine("Informe a Raiz");
                matricula = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine("Informe a Idade");
                numero = Convert.ToInt32(Console.ReadLine());
            }
            else
            {
                if (lado == 0)
                {
                    Console.WriteLine("Informe o lado Esquedo do " + num);
                    matricula = Convert.ToInt32(Console.ReadLine());
                    Console.WriteLine("Informe a Idade");
                    numero = Convert.ToInt32(Console.ReadLine());
                }
                else
                {
                    Console.WriteLine("Informe o lado Direito do " + num);
                    matricula = Convert.ToInt32(Console.ReadLine());
                    Console.WriteLine("Informe a Idade");
                    numero = Convert.ToInt32(Console.ReadLine());
                }
                

            }
            if (numero != 0)
            {
                aux = coloca(pai, numero, matricula, lado);
                level++;
                if (level < 3)
                {
                    if (pai == null)
                        Console.WriteLine("=======LADO DIREITO=======");
                    construir(aux, 1, numero,matricula, level);
                    if (pai == null)
                        Console.WriteLine("=======LADO ESQUERDO=======");
                    construir(aux, 0, numero,matricula , level);
                }
                level--;

            }

        }
        Nodo coloca(Nodo atual,int quem,int matricula,int lado)
        {
            Nodo novo = new Nodo(quem,matricula);
            if (atual == null)
            {
                raiz = novo;
            }
            else
            {
                if (lado == 0)
                {
                    atual.setFilE(novo);
                }
                else
                {
                    atual.setFilD(novo);
                }
            }
            return novo;
        }
        public void  lista(Nodo pai,int lado,int sentido,int nivel)
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
                    Console.WriteLine(espaco +=pai.getNum());
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
                    
                    Console.WriteLine(espaco + pai.getNum());
                    
                }

            }
        }
        public Boolean busca(Nodo pai,int numero)
        {
            if (pai != null)
            {
                if (pai.getmat() == numero)
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
        public int retornaIdadeDaMatricula(Nodo pai, int numero)
        {
            int aux;
            if (pai != null)
            {
                if (pai.getmat() == numero)
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
        public int tamanhoArvore(Nodo pai,int nivel)
        {
            if (pai != null)
            {
                int nivel1 = 0;
                nivel1 = nivel + 1; ;

                nivel = tamanhoArvore(pai.getFilD(), nivel1);
                if (nivel < nivel1)
                    nivel1 = nivel;

                nivel = tamanhoArvore(pai.getFilE(), nivel1);
                if (nivel < nivel1)
                    nivel1 = nivel;
                return nivel;
            }
            return nivel;
        }
        
        public media arvoreMedia(Nodo pai, media media)
        {
            if (pai != null)
            {
                media.numero += pai.getNum();
                media.quantidade++;
                media = arvoreMedia(pai.getFilE(), media);
                media = arvoreMedia(pai.getFilD(), media);
                return media;
            }
            return media;
        }
    }
}
