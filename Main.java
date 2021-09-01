import java.util.Random;
class No {
  int dado;
  No prox;
}

class ListaLigadaSimples{
  No primeiro;
  int qtde;

  ListaLigadaSimples (){
    this.qtde = 0;
    this.primeiro = null;
  }

  void inserirNoComeco (int dado){
    No novo = new No();
    novo.dado = dado;
    novo.prox = this.primeiro;
    this.primeiro = novo;
    this.qtde++;
  }

  void exibirLista(){
    No aux = this.primeiro;
    while (aux != null){
      System.out.printf ("%d ", aux.dado);
      aux = aux.prox;
    }
  }

  int obter (int indice){
    if (indice >= this.qtde) return -1;
    No aux = this.primeiro;
    for (int i = 0; i < indice; i++, aux = aux.prox);
    return aux.dado;
  }

  boolean estaVazia (){
    return this.qtde <= 0;
  }


  void inserirNoFinal (int dado){
    if (estaVazia()) 
      inserirNoComeco(dado);
    else{
      No novo = new No();
      novo.dado = dado;
      novo.prox = null;
      No aux = this.primeiro;
      while (aux.prox != null)
        aux = aux.prox;
      aux.prox = novo;
      this.qtde++;
    }
  }

}




class Main {
  public static void main(String[] args) {
    Random gerador = new Random();
    ListaLigadaSimples l = new ListaLigadaSimples();
    for (int i = 0; i < 100; i++){
      int dado = gerador.nextInt(20) + 1;
      //l.inserirNoComeco(dado);
      l.inserirNoFinal(dado);
      l.exibirLista();
      System.out.println(); 
      int posicaoDesejada = gerador.nextInt(l.qtde);
      System.out.printf("lista[%d]: %d", posicaoDesejada, l.obter(posicaoDesejada));
      System.out.println();
    }
  }
}