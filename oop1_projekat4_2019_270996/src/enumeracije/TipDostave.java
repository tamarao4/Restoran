package enumeracije;

public enum TipDostave {
	KUCNA_ADRESA, //1
	DRUGA_ADRESA, //2
	BEZ_DOSTAVE; //3
	
	public static TipDostave intToTipDostave(int a) {
		switch (a) {
		case 1:
			return KUCNA_ADRESA;
		case 2:
			return DRUGA_ADRESA;
		default:
			return BEZ_DOSTAVE;
		}
	}
	
	public static int tipDostaveToInt(TipDostave t) {
		switch (t) {
		case KUCNA_ADRESA:
			return 1;
		case DRUGA_ADRESA:
			return 2;
		default:
			return 3;
		}
	}
}
