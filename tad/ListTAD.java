package br.pucrs.adt;
import java.util.*;

public class ListaEncadeada<T> {

    No inicio = null;
    int tamanho;

    public void inserirInicio(T info) {
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

    public void inserirFim(T info) {
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
        if (inicio == null) {
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

    public void inserirIndice(int indice, String info) {
        if (indice <= 0) {
            inserirInicio(info);
        } else if (indice >= tamanho) {
            inserirFim(info);
        } else {
            No local = inicio;
            for (int i = 0; i < indice - 1; i++) {
                local = local.proximo;
            }
            No no = new No();
            no.info = info;
            no.proximo = local.proximo;
            local.proximo = no;
            tamanho++;
        }
    }

    public String retirarPorIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            return null;
        } else if (indice == 0) {
            return retirarInicio();
        } else if (indice == tamanho - 1) {
            return retirarFim();
        }
        No local = inicio;
        for (int i = 0; i < indice - 1; i++) {
            local = local.proximo;
        }
        String info = local.proximo.info;
        local.proximo = local.proximo.proximo;
        tamanho--;
        return info;
    }

    public static void main(String[] args) {
        ListaEncadeada l = new ListaEncadeada();
        System.out.println(l);
        l.inserirFim(("a"));
        System.out.println(l);
        l.inserirFim(("b"));
        l.inserirFim(("c"));
        System.out.println(l);
        l.inserirIndice(2, "k");
        System.out.println(l);
        l.retirarPorIndice(1);
        System.out.println(l);
    }
}