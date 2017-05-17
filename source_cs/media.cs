using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Arvore_Binaria
{
    public class media
    {
        public int numero, quantidade;
        public media()
        {
            numero = 0;quantidade = 0;
        }
        public int fazMedia()
        {
            if (quantidade != 0)
                return numero / quantidade;
            else
                return 0;
        }
    }

}
