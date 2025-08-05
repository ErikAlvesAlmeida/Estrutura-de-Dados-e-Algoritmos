import java.util.Objects;

// Classe Pair simples
class Pair {
    Integer key;
    String value;

    public Pair(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

// Enum para os tipos de probing
enum ProbingStrategy {
    LINEAR,
    QUADRATIC,
    DOUBLE_HASHING
}

public class HashTableAberta {
    private Pair[] tabela;
    private int capacidade;
    private int tamanho;
    private double loadFactor = 0.75;

    private final Pair DELETED = new Pair(null, null);
    private final ProbingStrategy estrategia;

    public HashTableAberta(int capacidadeInicial, ProbingStrategy estrategia) {
        this.capacidade = capacidadeInicial;
        this.estrategia = estrategia;
        this.tabela = new Pair[capacidadeInicial];
        this.tamanho = 0;
    }

    // Função hash principal
    private int hash(int chave) {
        return chave % capacidade;
    }

    // Hash secundário (usado no double hashing)
    private int hash2(int chave) {
        // Deve ser diferente de zero e coprimo com capacidade
        return 1 + (chave % (capacidade - 1));
    }

    // Função de sondagem genérica
    private int probe(int hash, int i, int chave) {
        switch (estrategia) {
            case LINEAR:
                return (hash + i) % capacidade;
            case QUADRATIC:
                return (hash + i * i) % capacidade;
            case DOUBLE_HASHING:
                return (hash + i * hash2(chave)) % capacidade;
            default:
                return -1; // Nunca deve ocorrer
        }
    }

    // PUT: insere ou atualiza um par (key, value)
    public void put(Integer key, String value) {
        if ((double) tamanho / capacidade >= loadFactor) {
            rehash();
        }

        int hash = hash(key);
        int i = 0;

        while (true) {
            int pos = probe(hash, i, key);
            if (tabela[pos] == null || tabela[pos] == DELETED) {
                tabela[pos] = new Pair(key, value);
                tamanho++;
                return;
            } else if (Objects.equals(tabela[pos].key, key)) {
                tabela[pos].value = value;
                return;
            }
            i++;
            if (i == capacidade) break; // tabela cheia
        }
    }

    // GET: retorna o valor associado à chave
    public String get(Integer key) {
        int hash = hash(key);
        int i = 0;

        while (true) {
            int pos = probe(hash, i, key);
            if (tabela[pos] == null) break;
            if (tabela[pos] != DELETED && Objects.equals(tabela[pos].key, key)) {
                return tabela[pos].value;
            }
            i++;
            if (i == capacidade) break;
        }

        return null;
    }

    // REMOVE: remove a chave da tabela
    public void remove(Integer key) {
        int hash = hash(key);
        int i = 0;

        while (true) {
            int pos = probe(hash, i, key);
            if (tabela[pos] == null) break;
            if (tabela[pos] != DELETED && Objects.equals(tabela[pos].key, key)) {
                tabela[pos] = DELETED;
                tamanho--;
                return;
            }
            i++;
            if (i == capacidade) break;
        }
    }

    // containsKey: verifica se a chave existe
    public boolean containsKey(Integer key) {
        return get(key) != null;
    }

    // containsValue: verifica se o valor existe (O(n))
    public boolean containsValue(String value) {
        for (Pair p : tabela) {
            if (p != null && p != DELETED && p.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    // Rehash: dobra a capacidade e reinserir os elementos
    private void rehash() {
        Pair[] oldTable = tabela;
        capacidade = proximoPrimo(capacidade*2);
        tabela = new Pair[capacidade];
        tamanho = 0;

        for (Pair p : oldTable) {
            if (p != null && p != DELETED) {
                put(p.key, p.value);
            }
        }
    }

    // Debug
    public void printTable() {
        for (int i = 0; i < capacidade; i++) {
            System.out.println(i + ": " + (tabela[i] == null ? "null" : tabela[i]));
        }
    }

    // Verifica se um número é primo
    private boolean isPrimo(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        int raiz = (int)Math.sqrt(n);
        for (int i = 3; i <= raiz; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Retorna o próximo número primo maior ou igual a n
    private int proximoPrimo(int n) {
        while (!isPrimo(n)) {
            n++;
        }
        return n;
    }

}

