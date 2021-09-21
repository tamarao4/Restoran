package enumeracije;

public enum TipPica {
	GAZIRANO, //1
	NEGAZIRANO, //2
	ALKOHOLNO, //3
	HLADJENO, //4
	NEHLADJENO; // 5
	
	public static TipPica intToTipPica(int a) {
		switch (a) {
		case 1:
			return GAZIRANO;
		case 2:
			return NEGAZIRANO;
		case 3:
			return ALKOHOLNO;
		case 4:
			return HLADJENO;
		default:
			return NEHLADJENO;
		}
	}
	
	public static int tipPicaToInt(TipPica s) {
		switch (s) {
		case GAZIRANO:
			return 1;
		case NEGAZIRANO:
			return 2;
		case ALKOHOLNO:
			return 3;
		case HLADJENO:
			return 4;
		default:
			return 5;
		}
	}

}
