public class Node<T extends Comparable<T>> {
    private T valor;
    private Node<T> filho_esq, filho_dir;

    public Node(T v) {
        valor = v;
        filho_esq = null;
        filho_dir = null;
    }

    public Node(T v, Node<T> NoEsq, Node<T> NoDir) {
        valor = v;
        filho_esq = NoEsq;
        filho_dir = NoDir;
    }

    public T getValor() {
        return valor;
    }

    public Node<T> getFilho_Esq() {
        return filho_esq;
    }

    public Node<T> getFilho_Dir() {
        return filho_dir;
    }

    public void setValor(T v) {
        valor = v;
    }

    public void setFilho_esq(Node<T> f_esq) {
        filho_esq = f_esq;
    }

    public void setFilho_dir(Node<T> f_dir) {
        filho_dir = f_dir;
    }

    public boolean inserirOrdenado(T v) {
        if (v.toString().compareTo(this.getValor().toString()) < 0) {
            // o valor deve ser inserido à esquerda do nó atual
            if (this.getFilho_Esq() != null)
                return this.getFilho_Esq().inserirOrdenado(v); // continua navegando na árvore até encontrar uma folha
            else {
                Node<T> n = new Node<T>((v));
                this.setFilho_esq(n); // se for nulo, adiciona o nó na folha
                return true;
            }
        } else {
            // o valor deve ser inserido à direita do nó atual
            if (this.getFilho_Dir() != null)
                return this.getFilho_Dir().inserirOrdenado(v);
            else {
                Node<T> n = new Node<T>((v));
                this.setFilho_dir(n);
                return true;
            }
        }
    }

    protected boolean removerNode(T v, Node<T> nodepai){
		 
        int comparacao = v.toString().compareTo(this.getValor().toString());
        boolean resultado=false;
        
        if (comparacao<0){ 
           if (this.getFilho_Esq()!=null)
           return this.getFilho_Esq().removerNode(v,this); // o nó a ser removido ta na subarvore esquerda
            else resultado=false;//o valor nao ta na subarvoreesquerda  
        }
        else if (comparacao>0) {
          if (this.getFilho_Dir()!=null)
              return this.getFilho_Dir().removerNode(v,this); // o valor pode estah na subarvore direita
              else resultado=false;//valor nao foi encontrado
         }
         else //o no a ser removido é o atual.
         {
             if ((this.getFilho_Esq()==null)&&(this.getFilho_Dir()==null)){
                  //este node é folha, pois os dois filhos sao nulos
                  this.setFilhoNode(nodepai,null);//setar o filho de pai como nulo
                  resultado = true;
                }
                else if ((this.getFilho_Esq()!=null)&&(this.getFilho_Dir()==null)){
                  //o node tem o filho da esquerda diferente de nulo e o da direita eh nulo
                  this.setFilhoNode(nodepai,this.getFilho_Esq()); //seta o pai o node atual com o filho da esquerda do nodeatual  
                  resultado = true;
                }
                else if ((this.getFilho_Esq()==null)&&(this.getFilho_Dir()!=null)){
                  //o node tem o filho da direita diferente de nulo e o da esquerda eh nulo
                  this.setFilhoNode(nodepai,this.getFilho_Dir()); //seta o pai do node atual com o filho da direita do nodeatual
                  resultado = true;  
                }
                else if ((this.getFilho_Esq()!=null)&&(this.getFilho_Dir()!=null)){
                  //podemos pegar um dos dois nodes a seguir, tanto faz.
                  //Node<String> nEsq = NodeComMaiorValor(nodeatual.getFilho_esq()); //pega o node com maior valor da subarvore esquerda
                  
                    Node<T> menorNodeDir = this.getFilho_Dir().NodeComMenorValor(); //pega o node com menor valor da subarvore da direita
                    Node<T> paiMenorNodeDir;
                    if (menorNodeDir !=this.getFilho_Dir()) { //verifica se o proprio node raiz da subarvore direita eh ou nao o menor valor
                        paiMenorNodeDir = this.getFilho_Dir().acharPai(menorNodeDir);
                    }
                    else paiMenorNodeDir=this;
                    
                    this.setValor(menorNodeDir.getValor());//coloca o novo valor no nodeatual.
                    /*
                     * Se menorNodeDir eh o menor valor da subarvore direita, entao menorNodeDir nao tem filhos a esquerda porque
                     * o menor valor de uma arvore eh o node mais a esquerda dessa arvore
                     * sendo assim, eu já sei que o menorNodeDir tem no maximo um filho a direita
                     * ou ele eh um node folha. 
                     * Sendo assim posso setar diretamente o filho (direita) do paiMenorNoDir com o filho da direita do menorNodeDir
                     */
                    menorNodeDir.setFilhoNode(paiMenorNodeDir,menorNodeDir.getFilho_Dir()); //seta o pai do menorNode com o filho da direita 				    
                    resultado = true;
                    }
                  
                }
     
        return resultado;
    }
 

    protected void setFilhoNode(Node<T> nodePai, Node<T> novoNode) {
        if (nodePai!=null) {
          if (nodePai.getFilho_Esq()==this) { 
                nodePai.setFilho_esq(novoNode);}
          else
          if (nodePai.getFilho_Dir()==this) {	 
              nodePai.setFilho_dir(novoNode);}
        }
      }

    protected Node<T> NodeComMenorValor(){
        if(this.getFilho_Esq() != null){
            return this.getFilho_Esq().NodeComMenorValor();
        }
        else{
            return this;
        }
    }

    protected Node<T> acharPai(Node<T> nofilho){
        if(this.getFilho_Esq() == nofilho || this.getFilho_Dir() == nofilho){
            return this;
        }
        else if(nofilho.getValor().toString().compareTo(this.getValor().toString()) > 0){
            if(this.getFilho_Esq() != null){
                return this.getFilho_Esq().acharPai(nofilho);
            }
            else{
                return null;
            }
        }
        else{
            if(this.getFilho_Dir() != null){
                return this.getFilho_Dir().acharPai(nofilho);
            }
            else{
                return null;
            }
        }
    }

    protected Node<T> pesquisarValor(T v) {
        if (v.compareTo(this.getValor()) == 0) {
            return this;
        } else if (v.compareTo(this.getValor()) < 0) {
            if (this.getFilho_Esq() != null) {
                return this.getFilho_Esq().pesquisarValor(v);
            } else {
                return null;
            }
        } else {
            if (this.getFilho_Dir() != null) {
                return this.getFilho_Dir().pesquisarValor(v);
            } else {
                return null;
            }
        }
    }

    protected void imprimePreOrdem() {
        System.out.print(this.valor + " ");
        if (this.getFilho_Esq() != null) {
            this.getFilho_Esq().imprimePreOrdem();
        }
        if (this.getFilho_Dir() != null) {
            this.getFilho_Dir().imprimePreOrdem();
        }
    }

    protected void imprimeInOrdem() {
        if (this.getFilho_Esq() != null) {
            this.getFilho_Esq().imprimeInOrdem();
        }
        System.out.print(this.valor + " ");
        if (this.getFilho_Dir() != null) {
            this.getFilho_Dir().imprimeInOrdem();
        }
    }

    protected void imprimePosOrdem() {
        if (this.getFilho_Esq() != null) {
            this.getFilho_Esq().imprimePosOrdem();
        }
        if (this.getFilho_Dir() != null) {
            this.getFilho_Dir().imprimePosOrdem();
        }
        System.out.print(this.valor + " ");
    }

    protected void imprimeEmLargura() {
        FilaEncadeada<Node<T>> f = new FilaEncadeada<>();
        f.enfileira(this);
        while (!f.vazia()) {
            Node<T> no = f.desenfileira();
            System.out.print(no.getValor() + " ");
            if (no.getFilho_Esq() != null) {
                f.enfileira(no.getFilho_Esq());
            }
            if (no.getFilho_Dir() != null) {
                f.enfileira(no.getFilho_Dir());
            }
        }
    }
}