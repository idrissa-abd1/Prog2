package Lab14;

public class LinkedList <E>
{

    class Node<E>
    {
        private E data;
        private Node<E> link;

        public Node ()
        {
            link = null;
            data = null;
        }

        public Node(E newData, Node<E> linkValue)
        {
            data = newData;
            link = linkValue;
        }
    }


    private Node<E> head;

    public LinkedList ()
    {
        head = null;
    }

    public void addANodeToStart (E addData)
    {
        head = new Node<E>(addData, head);
    }


    public void deleteHeadNode ()
    {
        if (head != null)
            head = head.link;
        else
        {
            System.out.println ("Deleting from an empty list.");
            System.exit (0);
        }
    }

    public boolean contains (E target)
    {
        return find (target) != null;
    }


    public Node<E> find (E target)
    {
        boolean found = false;
        Node<E> position = head;
        while ((position != null) && !found)
        {
            E dataAtPosition = position.data;
            if (dataAtPosition.equals (target))
                found = true;
            else
                position = position.link;
        }
        return position;
    }

    public void addAfter(Node node, E newData){
        Node newNode = new Node(newData, node.link);
        node.link = newNode;
    }

    private void removeAfter(Node node){
        Node<E> temp = node.link;
        node.link = temp.link;
        temp.link = null;
    }

    public Node getNode(int i){
        Node<E> temp = head;
        for(int j = 0; j < i; j++){
            temp = temp.link;
        }
        return temp;
    }

    public E get(int i){
        Node<E> temp = getNode(i);
        return temp.data;
    }

    public void add(int i, E newData){
        Node<E> temp = getNode(i-1);
         addAfter(temp,newData);
    }

    public E remove(int i){
        Node<E> temp = getNode(i-1);
        E removedData = temp.data;
        removeAfter(temp);
        return removedData;
    }

    public void outputList ()
    {
        Node<E> position = head;
        while (position != null)
        {
            System.out.println (position.data);
            position = position.link;
        }
    }

    public void clip(int start, int end){
        if(start > 0 && end >= start) {
            Node before = getNode(start - 1);
            Node after = getNode(end);
            before.link = after.link;
            after.link = null;
        }
    }


}
