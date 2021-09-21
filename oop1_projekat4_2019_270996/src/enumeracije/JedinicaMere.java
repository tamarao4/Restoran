package enumeracije;

public enum JedinicaMere {
	KOMAD,  //1
	LITAR,  //2
	MILILITAR,  //3
	KILOGRAM,  //4
	GRAM;  //5
	
	public static JedinicaMere intToJedinicaMere(int a) {
		switch (a) {
		case 1:
			return KOMAD;
		case 2:
			return LITAR;
		case 3:
			return MILILITAR;
		case 4:
			return KILOGRAM;
		default:
			return GRAM;
		}
	}
	
	public static int jedinicaMereToInt(JedinicaMere t) {
		switch (t) {
		case KOMAD:
			return 1;
		case LITAR:
			return 2;
		case MILILITAR:
			return 3;
		case KILOGRAM:
			return 4;
		default:
			return 5;
		}
	}
	
	
	
}
