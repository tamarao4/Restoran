package csv;

import java.text.ParseException;

// interfejs sa metodama za serijalizaciju i deserijalizaciu

public interface PodaciCSV<T> {
	public String uCSV();
	public T izCSV(String csv) throws ParseException; 
	// tip T koji se vraca ce biti "stara" vrednost (instanaca)
	// objekta nad kojim je pozvana metoda
}
