package listaEncadeada2;

public class ListaEncadeada {

    No inicio = null;
    int tamanho;

    public void inserirInicio(String info) {
        No no = new No();
        no.info = info;
        no.proximo = inicio;
        inicio = no;
        tamanho++;
    }

    public String retirarInicio() {
        if (inicio == null) {
            return null;
        }
        String info = inicio.info;
        inicio = inicio.proximo;
        tamanho--;
        return info;
    }

    public void inserirFim(String info) {
        No no = new No();
        no.info = info;
        if (inicio == null) {
            no.proximo = null;
            inicio = no;
        } else {
            No local = inicio;
            while (local.proximo != null) {
                local = local.proximo;
            }
            local.proximo = no;
            no.proximo = null;
        }
        tamanho++;
    }

    public String retirarFim() {
        if(inicio == null){
            return null;
        }
        No local = inicio;
        while (local.proximo != null) {
            No aux = local;
            local = local.proximo;
            if (local.proximo == null) {
                aux.proximo = null;
                tamanho--;
                return local.info;
            }
        }
        inicio = null;
        tamanho--;
        return local.info;
    }

    @Override
    public String toString() {
        String str = "(" + tamanho + ") ";
        No local = inicio;
        while (local != null) {
            str += local.info + " ";
            local = local.proximo;
        }
        return str;
    }
    
    public static void main(String[] args) {
        ListaEncadeada l = new ListaEncadeada();
        System.out.println(l);
        l.inserirFim(("a"));
        System.out.println(l);
        l.inserirFim(("b"));
        l.inserirFim(("c"));
        System.out.println(l);
        l.retirarFim();
        System.out.println(l);
    }
}
