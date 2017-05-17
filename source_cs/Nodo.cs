using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Arvore_Binaria
{
    class Nodo
    {
        int num;
        int matricula;
        Nodo filhoDir;
        Nodo filhoEsq;

        public Nodo(int numero,int matricula)
        {
            setNum(numero);
            setMat(matricula);
            setFilD(null);
            setFilE(null);
        }
        public void setFilD(Nodo fil)
        {
            filhoDir = fil;
        }
        public void setFilE(Nodo fil)
        {
            filhoEsq = fil;
        }
        public void setNum(int numero)
        {
            num = numero;
        }
        public void setMat(int numero)
        {
            matricula = numero;
        }
        public Nodo getFilD()
        {
            return filhoDir;
        }
        public Nodo getFilE()
        {
            return filhoEsq;
        }
        public int getNum()
        {
            return num;
        }
        public int getmat()
        {
            return matricula;
        }

    }
}
