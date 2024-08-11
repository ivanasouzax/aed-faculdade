public class NodeN<T> {

    private NodeN<T> p[]; /* Referências para sub-árvores. */
    private T k[];   /* Valores armazenado no node. */
    private int n_atual;// diz o tamanho do vetor k
   
   
      public NodeN(int n){
           
            n_atual=0;
            p = new NodeN[n]; //vetor de n ponteiros
            k = (T[]) new Object[n-1];//tamnho do vetor de valores
           
        }
       
        public void inserir (T valor) {
          int index;
          if (this.estahCheio()){
            //se o node tiver menos de 100 elementos usa a busca sequencial  
            if (p.length < 100) {  
                index = IndiceNodeNPonteiro(valor);
            }
            else {//usa a busca binaria
                index = IndiceNodeNPonteiroB(valor);
            }                
             
            if (p[index]!=null) { //verifica se existe ponteiro
                p[index].inserir(valor);//chama o mesmo algoritmo recursivamente    
            }
            else {//cria um novo nodeN e apontado pelo ponteiro
                p[index] = new NodeN(this.p.length);
                p[index].insereOrdenadoNOVetor(valor);
            }
          }
          else {
            insereOrdenadoNOVetor(valor);
          }
        }
       
        public void remover (T valor) {
            NodeN<T> noden = this.pesquisar(valor);
            if (noden!=null) {
                 
            }
            else {
               
            }            
        }
       
        protected NodeN<T> pesquisar(T valor) {
             //encontra o local onde deveria esta o valor a ser pesquisado
            int index = this.buscaBinariaP(valor, 0, this.n_atual-1);
            //resolver o bug pesquisa um valor maior de todos em um vetor nao cheio
            if (k[index]==valor) {
                return this;
            }
            else {
               if (p[index]!=null) {
                   return p[index].pesquisar(valor);
               }
               else return null;//o valor nao se encontra na minha arvore
            }
        }
       
        protected boolean estahCheio() {            
            return (k.length == n_atual);
        }
       
        //retorna o indice do ponteiro baseado no valor
        private int IndiceNodeNPonteiro(T valor) {            
            int i=0;
            int comparacao;    
            while (i<k.length) {
                //compara o valor a pesquisar com cada valor do vetor de conteudo
              comparacao = valor.toString().compareTo(k[i].toString());
              if (comparacao<0) {
                  return i;//i eh o ponteiro a seguir            
              }
              else {
                  i++;//verifica o proximo indice                  
              }                  
            }//fim do while
            return i;//retorna o ultimo ponteiro            
        }
       
       
      //retorna o indice do ponteiro baseado no valor
        private int IndiceNodeNPonteiroB(T valor) {            
            return this.buscaBinariaP(valor, 0, p.length-1);            
        }
       
        private int buscaBinariaP(T valor_aprocurar, int minvetor,int maxvetor) {        
         
            if(minvetor > maxvetor)
                return minvetor;//return minvetor
            int meiovetor = (minvetor + maxvetor) / 2;
            int comparacao = valor_aprocurar.toString().compareTo(k[meiovetor].toString());
           
            if(comparacao>0)//o valor estah a direita
                return this.buscaBinariaP(valor_aprocurar,meiovetor+1,maxvetor);
            else if(comparacao<0)//o valor estah a esquerda
                return this.buscaBinariaP(valor_aprocurar,minvetor,meiovetor-1);
            else
                return meiovetor+1;//o ponteiro ta sempre a direita.
               
        }

       
        private void insereOrdenadoNOVetor(T valor){
            //encontra o local onde deveria esta o valor a ser inserido
            int index = this.buscaBinariaP(valor, 0, this.n_atual-1);
            //insere no local
            int i = this.n_atual;
            while(i>index) {
                  k[i] = k[i-1];
                  i--;
            }
            k[index] = valor;//inclui o novo valor
            this.n_atual++;
        }
    }