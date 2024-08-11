public class Array {
    private Object[] data;
    private int base;

    public Array(int tam, int lim) {
        data = new Object[tam];
        base = lim;
    }

    public Array() {
        this(10, 1); // Inicializa com um tamanho padrão e base
    }

    public Array(int tam) {
        this(tam, 1); // Inicializa com o tamanho e base fornecidos
    }

    public Object[] getData() {
        return data;
    }

    public int getBase() {
        return base;
    }

    public int getLength() {
        return data.length;
    }

    public void assign(Array a) {
        if (a != this) {
            if (data.length != a.data.length)
                data = new Object[a.data.length];

            System.arraycopy(a.data, 0, data, 0, a.data.length);
            base = a.base;
        }
    }

    public Object getElemento(int posicao) {
		return data[posicao - base];
	}

    public void setElemento(int posicao, Object o) {
		data[posicao - base] = o;
	}

    public void setBase(int b) {
        base = b;
    }

    public void setLength(int newTam) {
        if (data.length != newTam) {
            Object[] newData = new Object[newTam];
            int min = Math.min(data.length, newTam);
            System.arraycopy(data, 0, newData, 0, min);
            data = newData;
        }
    }
}
