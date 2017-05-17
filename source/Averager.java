public class Averager
{
    public int sum, qty;

    public Averager()
    {
        this.sum = 0;
        this.qty = 0;
    }

    public int calc()
    {
        return this.qty != 0 ? (this.sum / this.qty) : 0;
    }
}
