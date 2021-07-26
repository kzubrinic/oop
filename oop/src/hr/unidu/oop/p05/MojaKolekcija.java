package hr.unidu.oop.p05;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MojaKolekcija<T> implements Iterable<T> {	
	private T[] elementi; //
	private int index;
	public MojaKolekcija(int count){
		elementi = (T[]) new Object[count]; //new T[count] nije moguće u Javi
		index = -1;
	}
	public MojaKolekcija(T[] elementi){
		elementi = (T[]) new Object[elementi.length];
		for(int i=0; i < elementi.length ; i++){
			elementi[i] = elementi[i];
			index = i;
		}
	}
	public void add(T element) {
		elementi[++index] = element;
	}
	public int getSize() {
		return elementi.length;
	}
	
	public T getElement(int i) {		
		return elementi[i];
	}

	public void setElement(int i, T value) {		
		elementi[i] = value;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new CollectionIterator<>();
		
	}
	private class CollectionIterator<T> implements Iterator<T>{
		private int index = 0;
		@Override
		public boolean hasNext() {
			if (index < elementi.length) return true;
			return false;
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException("Došli smo do kraja kolekcije.");
			} 
			return (T)elementi[index++];
		}
	}
}
