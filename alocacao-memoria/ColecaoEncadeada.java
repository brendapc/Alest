/**
 * ColecaoEncadeada
 * 
 * Construa uma classe ColecaoEncadeada que implementa uma coleção
 * sequencial de elementos do tipo String usando estruturas encadaedas,
 * e que permite as seguintes operações:
 * Inserir um elemento na coleção, sendo este colocado sempre na primeira
 * posição da coleção
 * * boolean addFirst(T item)
 * 
 * Recuperar um elemento armazenado na posicão pos (sendo a primeira posição da
 * coleção a posição 0)
 * * T get(int pos)
 */

public class ColecaoEncadeada {

    private class Node {
        private Node refNext;
        private String item;
        private String element;
        
        public void setElement(String e) {

        }
        
        public String getElement() {

        }
        
        public void setNext(Nodo n){
        }
        
        public Nodo getNext() {

        }
        
        public Node(String e){

        }
    }

    private Node refHead = null;
    // private Node refTail = null;
    private int qtdElem = 0;

    public void addFirst(String d) {
        Node novo = new Node(d);
        novo.setNext(refHead);
        refHead = novo;
        qtdElem++;
    }

}