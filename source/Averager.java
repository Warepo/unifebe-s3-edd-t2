public class Averager
{
    public int numero, quantidade;

    public Averager()
    {
        numero = 0;
        quantidade = 0;
    }

    public int fazMedia()
    {
        if (quantidade != 0)
            return numero/quantidade;
        else
            return 0;
    }
}
