package hr.unidu.oop.p06.funkcijskas;

public enum Kategorija {
	DO_55 (0,55),
	OD_55_DO_70 (50,70),
	OD_70_DO_100 (70,100),
	OD_100_DO_130 (100,130),
	PREKO_130 (130,9999);
	
	private final int sod;
	private final int sdo;
	
	Kategorija(int i, int j) {
		sod = i;
		sdo = j;
	}

	public int getSod() {
		return sod;
	}

	public int getSdo() {
		return sdo;
	}
    public String toString() {
    	return String.format("OD: %d DO: %d", sod, sdo);
    }
    
}
	
