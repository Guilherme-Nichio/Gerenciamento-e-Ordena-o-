// lista encadeada circular de processos 

class NoProcesso {
    int id;
    int prioridade;
    String descricao;
    NoProcesso proximo;

    public NoProcesso(int id, int prioridade, String descricao) {
        this.id = id;
        this.prioridade = prioridade;
        this.descricao = descricao;
        this.proximo = null;
    }
}


class ListaCircularDeProcessos {
    private NoProcesso head = null;

    public void inserirProcesso(int id, int prioridade, String descricao) {
        NoProcesso novo = new NoProcesso(id, prioridade, descricao);
        if (head == null) {
            head = novo;
            head.proximo = head;
        } else {
            NoProcesso atual = head;
            while (atual.proximo != head) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
            novo.proximo = head;
        }
    }

    public void removerProcesso(int id) {
        if (head == null) return;

        NoProcesso atual = head;
        NoProcesso anterior = null;

        do {
            if (atual.id == id) {
                if (anterior != null) {
                    anterior.proximo = atual.proximo;
                    if (atual == head) head = atual.proximo;
                } else {
                    // Removendo o head
                    if (head.proximo == head) {
                        head = null;
                    } else {
                        NoProcesso ultimo = head;
                        while (ultimo.proximo != head) {
                            ultimo = ultimo.proximo;
                        }
                        head = head.proximo;
                        ultimo.proximo = head;
                    }
                }
                return;
            }
            anterior = atual;
            atual = atual.proximo;
        } while (atual != head);
    }

    public void percorrerEImprimir() {
        if (head == null) {
            System.out.println("Lista vazia.");
            return;
        }

        NoProcesso atual = head;
        do {
            System.out.println("ID: " + atual.id + ", Prioridade: " + atual.prioridade + ", Descrição: " + atual.descricao);
            atual = atual.proximo;
        } while (atual != head);
    }

    // Parte 2: Ordenação com Merge Sort
    public void ordenarPorPrioridade() {
        if (head == null || head.proximo == head) return;

        // Quebrar a circularidade
        NoProcesso ultimo = head;
        while (ultimo.proximo != head) {
            ultimo = ultimo.proximo;
        }
        ultimo.proximo = null;

        head = mergeSort(head);

        // Restaurar a circularidade
        NoProcesso atual = head;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        atual.proximo = head;
    }

    private NoProcesso mergeSort(NoProcesso h) {
        if (h == null || h.proximo == null) return h;

        NoProcesso meio = dividirLista(h);
        NoProcesso metade2 = meio.proximo;
        meio.proximo = null;

        NoProcesso esquerda = mergeSort(h);
        NoProcesso direita = mergeSort(metade2);

        return merge(esquerda, direita);
    }

    private NoProcesso dividirLista(NoProcesso head) {
        NoProcesso lento = head;
        NoProcesso rapido = head.proximo;

        while (rapido != null && rapido.proximo != null) {
            lento = lento.proximo;
            rapido = rapido.proximo.proximo;
        }

        return lento;
    }

    private NoProcesso merge(NoProcesso l1, NoProcesso l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        NoProcesso resultado;

        if (l1.prioridade < l2.prioridade) {
            resultado = l1;
            resultado.proximo = merge(l1.proximo, l2);
        } else {
            resultado = l2;
            resultado.proximo = merge(l1, l2.proximo);
        }

        return resultado;
    }
}


//Função principal - main

public class Main {
    public static void main(String[] args) {
        ListaCircularDeProcessos lista = new ListaCircularDeProcessos();

        lista.inserirProcesso(1, 3, "executar calculadora");
        lista.inserirProcesso(2, 1, "executar navegador Chrome");
        lista.inserirProcesso(3, 5, "executar programa em Java");
        lista.inserirProcesso(4, 2, "executar o Word");

        System.out.println("Antes da ordenação:");
        lista.percorrerEImprimir();

        lista.ordenarPorPrioridade();

        System.out.println("\nApós ordenação por prioridade:");
        lista.percorrerEImprimir();

        lista.removerProcesso(3);

        System.out.println("\nApós remoção do processo com ID 3:");
        lista.percorrerEImprimir();
    }
}
