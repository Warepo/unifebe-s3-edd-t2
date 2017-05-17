class Node
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
    
    public void setIndex(int id)
    {
        this.index = id;
    }
    
    public void setData(int data)
    {
        this.data = data;
    }
    
    public Node getSonRight()
    {
        return sonRight;
    }
    
    public Node getSonLeft()
    {
        return sonLeft;
    }
    
    public int getIndex()
    {
        return index;
    }
    
    public int getData()
    {
        return data;
    }
}
