
# Gerenciamento e Ordenação de Fila Circular de Processos

**Aluno:** Guilherme Nicchio Barbosa  
**RA:** 52318847

## Descrição do Projeto
Este projeto implementa uma lista encadeada circular em Java para simular o gerenciamento de processos em um sistema operacional simplificado. Os processos são armazenados em uma estrutura circular e podem ser ordenados por prioridade utilizando o algoritmo Merge Sort.

## Funcionalidades
- Inserção de processos com ID, prioridade e descrição.
- Remoção de processos por ID.
- Impressão da lista circular de processos.
- Ordenação dos processos por prioridade (menor valor = maior prioridade).

## Estrutura do Código
- `NoProcesso.java`: Representa um nó da lista com os dados do processo.
- `ListaCircularDeProcessos.java`: Implementa a lógica da lista circular e o algoritmo de ordenação.
- `Main.java`: Classe principal para testar as funcionalidades.

## Execução
1. Compile os arquivos `.java` com `javac`.
2. Execute a classe `Main` para ver a inserção, ordenação e remoção de processos.

## Exemplo de Processos
- (1, 3, "executar calculadora")
- (2, 1, "executar navegador Chrome")
- (3, 5, "executar programa em Java")
- (4, 2, "executar o Word")

## Resultado Esperado
Antes da ordenação:
- Ordem de inserção dos processos.

Após ordenação:
- Ordem crescente de prioridade.

Após remoção:
- Lista atualizada sem o processo removido.

---
Trabalho prático para disciplina de Sistemas Operacionais.
