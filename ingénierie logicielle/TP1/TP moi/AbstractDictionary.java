
public abstract class AbstractDictionary implements IDICTIONARY{
	
	protected Object value[];
	protected Object key[];

	public abstract int size();
    public abstract int indexOf(Object key);
    //rend l’index auquel est range le nom key dans le dictionnaire receveur, si key n’est pas dans le receveur,
    //rend -1.
    public abstract int newindexOf(Object key);
    //Cette methode est appelee uniquement si key N’EST PAS dans le dictionnaire. Cette methode prepare
    //l’insertion et rend l’index auquel la nouvelle cle, et la valeur correspondante, pourront etre inserees ;
    //elle n’effectue ces insertions.
    //S’il n’y a pas assez de place pour l’insertion dans le dictionnaire concerne, cette methode devra se
    //charger d’en faire, en remplacant les tableaux par d’autres plus grands, afin de rendre l’insertion
    //possible.

	public AbstractDictionary(){
		
		
		this.key = new Object[0];
		this.value = new Object[0];
		
	}
	
	
	public IDICTIONARY put(Object key,Object value){
        int indice = this.newindexOf(key);
		//System.out.println(indice);
        this.key[indice] = key;
        this.value[indice] = value;
        return this;
	}
	
	public Object get(Object key){
		
		int i = this.indexOf(key);
		
		if(i != -1)
			return value[i];
		else{
			System.out.println("la cles n'existe pas");
			return null;
		}
		

	};
	
	public boolean isEmpty(){
		
		
		return key.length==0;
	};
	
	public boolean containsKey(Object key){
		
		if (indexOf(key) != -1){
            return true;
        }
        return false;
	};
	/*
	public int size(){
		
		return key.length;
	};*/
	
	
	
	
}