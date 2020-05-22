/**
 * Codigo que avalia se uma equacao esta bem formada, ou seja,
 * se todos os parenteses abertos foram fechados, para a
 * execucao desta tarefa, foi definido na Atividade utilizar-se de
 * metodos pop e push da Classe Pilha
 * @author: RA 21434418 - Alexandre Roberto
 */

class No {
    char dado;
    No proximoNo;
    //Construtor da classe, recebe char
    public No(char dado) {
        this.dado = dado;
        this.proximoNo = null;
    }
}
class Pilha {
    No topo;
    //Construtor da classe
    public Pilha() {
        topo = null;
    }
    //Realiza o empilhamento
    public void push(char dado) {
        No novoNo = new No(dado);
        novoNo.proximoNo = topo;
        this.topo = novoNo;
    }
    //Realiza o desempilhamento
    public char pop() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        }
        No aux = this.topo;
        topo = aux.proximoNo;
        return aux.dado;
    }
    //Analisa se ha ou nao itens
    boolean isEmpty() {
        return (topo == null);
    }
    //Metodo para impressao
    void print() {
        if (isEmpty()) {
            System.out.println("Sem itens, pilha vazia");
        } else {
            No aux = this.topo;
            while (aux != null) {
                System.out.println(aux.dado);
                aux = aux.proximoNo;
            }
        }
    }
    //    Metodo utiliza pop e push da Classe Pilha
    //   analisa os parenteses e imprime no console
    //   a string e o resultado dos parenteses
    void push_pop_print(String equacao) {
        //Instancias necessarias para execucao

        int  contadorFechados = 0;
        int  contadorAbertos = 0;

        //realizando o empilhamento atraves de PUSH
        for(int i = 0 ; i < equacao.length() ; i++) {
            this.push(equacao.charAt(i));
        }
        //realizando a contagem dos parenteses atraves do POP
        while(!this.isEmpty()) {
            char procurado =  this.pop();
            if( procurado == '(') {
                contadorFechados++;
            }
            if(procurado == ')') {
                contadorAbertos++;
            }
        }
        //exibindo mensagem com retorno da avaliacao
        if(contadorAbertos == contadorFechados) {
            System.out.println("Equacao BEM formada:  " + equacao);
        } else {
            System.out.println("Equacao MAL formada:  " + equacao);
        }
    }
}
//Classe que contem o metodo principal
public class Test_Atividade_Pilha_Fila {
    public static void main(String[] args) {
        //Instancia necessaria para execucao
        Pilha pilha = new Pilha();


        //Declaracao das equacoes propostas pela Atividade
        String equacao = "2 + 3 * (8 - 7) + 2";
        String equacao2 = "2 * 3 + (2 - 3) * (3 - 9 + 2 - 1";
        String equacao3 = "5 - 2 + ( 9 - (3 - 9) + 2) - 1) + 2";
        String equacao4 = "2 + 3 * (2 - 1)";

        //inovacao do metodo que empilha, desempilha e imprime da Classe Pilha
        pilha.push_pop_print(equacao);
        pilha.push_pop_print(equacao2);
        pilha.push_pop_print(equacao3);
        pilha.push_pop_print(equacao4);

    }
}







