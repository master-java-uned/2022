package es.uned.master.java.models;

public enum ECategoria {
	HARRY_POTTER,
	STAR_WARS,
	NARNIA,
	SEÑOR_ANILLOS,
	MARVEL,
	DISNEY,
	DADO;
	
	private static ECategoria[] cachedValues = null;

    public static ECategoria fromId(int id) {
    	if(ECategoria.cachedValues == null) {
    		ECategoria.cachedValues = ECategoria.values();
        }
        return ECategoria.cachedValues[id];
    }
}
