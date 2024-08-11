public class MeuHash {
    private ListaEncadeada tabelaHash[];
    private int m; // m deve ser primo

    public MeuHash(int m) {
        tabelaHash = new ListaEncadeada[m];
        this.m = m;
    }

    public void inserir(String strk) {
        int entradahash = funcaohash(strk);
        if (tabelaHash[entradahash] == null) {
            tabelaHash[entradahash] = new ListaEncadeada();
        }
        tabelaHash[entradahash].inserirFim(strk);
    }

    public boolean remover(String strk) {
        int entradahash = funcaohash(strk);
        boolean resultado = false;
        if (tabelaHash[entradahash] == null) {
            return resultado;
        } else {
            try {
                tabelaHash[entradahash].extrair(strk);
                resultado = true;
            } catch (ObjetoNaoEncontradoException e) {
                // Handle exception
            }
            return resultado;
        }
    }

    public void alterarValor(String strKVelho, String strkNovo) {
        if (this.remover(strKVelho)) {
            this.inserir(strkNovo);
        }
    }

    private int funcaohash(String chave) {
        int soma = 0;
        int comp = chave.length();

        for (int i = 0; i < comp; i++) {
            soma += (chave.charAt(i) * (i + 1));
        }
        return (soma % m);
    }

    public void imprimir() {
        for (int i = 0; i < m; i++) {
            if (tabelaHash[i] != null) {
                System.out.println(tabelaHash[i].toString());
            } else {
                System.out.println("-------");
            }
        }
    }

    public static void main(String[] args) {

        MeuHash hF = new MeuHash(15);
        hF.inserir("Helio");
        hF.inserir("jose");
        hF.inserir("Jose");
        hF.inserir("Antonio");
        hF.inserir("Roberto");
        hF.inserir("Hugo");

        for (int i = 0; i< hF.m; i++) {
            if (hF.tabelaHash[i]!=null) {
                System.out.println(hF.tabelaHash[i].StringK());
            }
            else
                System.out.println("-------");
        }
    }
}
