package Pilha;

public class Array {
	private Object[] data;
	private int base;

	public Array(int tam, int lim) {
		data = new Object[tam];
		base = lim;
	}

	// Métodos de acesso (get)
	public Object[] getData() {
		return data;
	}

	public int getBase() {
		return base;
	}

	public int getLength() {
		return data.length;
	}

	// Construtores do Array
	public Array() {
		this(0, 0);
	}

	public Array(int tam) {
		this(tam, 0);
	}

	// Método assign
	public void assign(Array a) {
		if (a != this) {
			if (data.length != a.data.length)
				data = new Object[a.data.length];

			for (int i = 0; i < data.length; i++)
				data[i] = a.data[i];
			base = a.base;
		}
	}

	// Métodos de indexação de Array
	public Object getElemento(int posicao) {
		return data[posicao - base];
	}

	public void setElemento(int posicao, Object o) {
		data[posicao - base] = o;
	}

	public void setBase(int b) {
		base = b;
	}

	// Redimensionando um Array
	public void setLength(int newTam) {
		if (data.length != newTam) {
			Object[] newData = new Object[newTam];
			int min = Math.min(data.length, newTam);
			for (int i = 0; i < min; i++)
				newData[i] = data[i];
			data = newData;
		}
	}
}
