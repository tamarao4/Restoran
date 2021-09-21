package enumeracije;

public enum TipJela {
	GLAVNO, //1
	PREDJELO, //2
	SALATA, //3
	DEZERT; //4
	
	public static TipJela intToTipJela(int a) {
		switch (a) {
		case 1:
			return GLAVNO;
		case 2:
			return PREDJELO;
		case 3:
			return SALATA;
		default:
			return DEZERT;
		}
	}
	
	public static int tipJelaToInt(TipJela s) {
		switch (s) {
		case GLAVNO:
			return 1;
		case PREDJELO:
			return 2;
		case SALATA:
			return 3;
		default:
			return 4;
		}
	}

}
