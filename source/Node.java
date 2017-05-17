public class Node
{
    int index, data;
    Node sonRight, sonLeft;

    public Node(int id, int data)
    {
        this.setIndex(id);
        this.setData(data);
        this.setSonRight(null);
        this.setSonLeft(null);
    }

    public void setSonRight(Node son)
    {
        this.sonRight = son;
    }

    public void setSonLeft(Node son)
    {
        this.sonLeft = son;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    public Node getSonRight()
    {
        return this.sonRight;
    }

    public Node getSonLeft()
    {
        return this.sonLeft;
    }

    public int getIndex()
    {
        return this.index;
    }

    public int getData()
    {
        return this.data;
    }
}
