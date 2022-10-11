public class QueueSimpleLinked<T extends Comparable<T>> implements QueueTAD<T>, Serializable {
    private ListTAD<T> list = new ListTAD<T>();

    public void enqueue(T dado) {
        list.inserirFim(dado);
    }

    public void outqueue() {
        list.retirarFim()
    }

    public 
}