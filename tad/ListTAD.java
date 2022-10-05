package br.pucrs.adt;
import java.util.*;

/*********
 * Interface para o T.A.D. Lista.
 * @author Michael da Costa Móra
 * @param <E> Tipo dos dados armazenados na lista.
 */
public interface ListTAD<E> {
	/**********
	 * Adiciona um elemento na última posição da lista.
	 * @param element Elemento a ser adicionado. 
	 * @return true se a operação funcionou, false caso contrário.
	 */
	public boolean add(E element){
        if (inicio == null) {
            element.proximo = null;
            inicio = element;
        	tamanho++;
			return true
        } else {
            No local = inicio;
            while (local.proximo != null) {
                local = local.proximo;
            }
            local.proximo = element;
            element.proximo = null;
        	tamanho++;
			return true
        }
		return false
	}
	
	
	/**********
	 * Adiciona o elemento fornecido em uma dada posição da lista.
	 * @param index Posição da lista.
	 * @param element Elemento a ser adicionado. 
	 * @return true se a operação funcionou, false caso contrário.
	 */
	public void add(int indice, E element){
		 if (indice <= 0) {
            inserirInicio(info);
        } else if (indice >= tamanho) {
            inserirFim(info);
        } else {
            No local = inicio;
            for (int i = 0; i < indice - 1; i++) {
                local = local.proximo;
            }
            local.proximo = element;
            tamanho++;
        }
	}
	
	
	/**********
	 * Remove o elemento armazenado na posição fornecida da lista.
	 * @param pos Posição da lista. 
	 */
	public E remove(int pos){
		if (pos < 0 || pos >= tamanho) {
            return null;
        } else if (pos == 0) {
            return retirarInicio();
        } else if (pos == tamanho - 1) {
            return retirarFim();
        }
        No local = inicio;
        for (int i = 0; i < pos - 1; i++) {
            local = local.proximo;
        }
        String info = local.proximo.info;
        local.proximo = local.proximo.proximo;
        tamanho--;
        return info;
	}

	
	/**********
	 * Remove a primeira ocorrência de um dado elemento da lista.
	 * @param element Elemento a ser adicionado. 
	 */
	public E remove(E element);
	
	
	/**********
	 * Recupera o elemento armazenado em uma dada posição da lista.
	 * @param pos Posição do elemento na lista.
	 * @return Elemento armazenado na lista. 
	 */	
	public E get(int pos);
	
	
	/**********
	 * Atualiza a posição fornecida da lista, com o elemento fornecido.
	 * @param index Posição da lista.
	 * @param element Elemento a ser armazenado na lista.
	 * @return true se a operação funcionou, false caso contrário. 
	 */	
	public void set(int index, E element);
	
	
	/**********
	 * Procura um elemento na lista, e retorna sua ocorrência.
	 * @param element Elemento a ser procurado.
	 * @return referência para o elemento armazenado na lista. 
	 */	
	public E search(E element);
	
	
	/**********
	 * Verifica se a lista está vazia.
	 * @return true se a lista está vazia, false caso contrário. 
	 */		
	public boolean isEmpty();
	
	
	/**********
	 * Recupera a quantidade de elementos armazenados na lista.
	 * @return Quantidade de elementos. 
	 */			
	public int size(); 
	
	
	/********
	 * Conta quantas ocorrências de um dado elemento estão armazenadas na lista.
	 * @return A quantidade de ocorrências do elemento fornecido.
	 */	
	public int count(E element);
	
	
	/**********
	 * Remove todos os elementos da lista.
	 */				
	public void clean();
	
	
	/**********
	 * Retorna uma representação textual do conteúdo da lista.
	 * @return Um String com o conteúdo da lista. 
	 */		
	public String toString(){
		String str = "(" + tamanho + ") ";
        No local = inicio;
        while (local != null) {
            str += local.info + " ";
            local = local.proximo;
        }
        return str;
	}

	
	/**********
	 * Métodos adicionais, para fins didáticos. 
	 *********/
	
	
	/********
	 * Adiciona um elemento na primeira posição da lista.
	 * @param element Elemento a ser adicionado.
	 * @return true se a operação funcionou, false caso contrário.	
	 */
	public void addFirst(E element);

	
	/**********
	 * Adiciona um elemento na última posição da lista.
	 * @param element Elemento a ser adicionado. 
	 * @return true se a operação funcionou, false caso contrário.
	 */
	public void addLast(E element);
	
	
	/********
	 * Remove o elemento armazenado na primeira posição da lista.
	 * @return Elemento removido da lista.
	 */
	public E removeFirst(){
		 if (inicio == null) {
            return null;
        }
        String info = inicio.info;
        inicio = inicio.proximo;
        tamanho--;
        return info;
	}

	
	/********
	 * Remove o elemento armazenado na última posição da lista.
	 * @return Elemento removido da lista.
	 */
	public E removeLast(){
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

	
	/********
	 * Recupera o elemento armazenado na primeira posição da lista.
	 * @return Elemento armazenado na lista.
	 */
	public E getFirst();

	
	/********
	 * Recupera o elemento armazenado na última posição da lista.
	 * @return Elemento armazenado na lista.
	 */
	public E getLast();	
}
