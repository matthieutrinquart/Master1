public abstract class AbstractDictionary implements IDictionary{

    protected Object[] key;
    protected Object[] values;

    public abstract int indexOf(Object key);
    //rend l’index auquel est range le nom key dans le dictionnaire receveur, si key n’est pas dans le receveur,
    //rend -1.
    public abstract int newIndexOf(Object key);
    //Cette methode est appelee uniquement si key N’EST PAS dans le dictionnaire. Cette methode prepare
    //l’insertion et rend l’index auquel la nouvelle cle, et la valeur correspondante, pourront etre inserees ;
    //elle n’effectue ces insertions.
    //S’il n’y a pas assez de place pour l’insertion dans le dictionnaire concerne, cette methode devra se
    //charger d’en faire, en remplacant les tableaux par d’autres plus grands, afin de rendre l’insertion
    //possible.


    public AbstractDictionary(int i) {
        this.key = new Object[i];
        this.values = new Object[i];
    }

    @Override
    public Object get(Object key) {
        int i = this.indexOf(key);
        if (i!=-1){
            return values[i];
        }
        else{
            return null;
        }
    }

    @Override
    public IDictionary put(Object key, Object value) {
        int indice = this.newIndexOf(key);
        this.key[indice] = key;
        this.values[indice] = value;
        return this;
    }

    @Override
    public boolean isEmpty() {
        return key.length == 0;
    }

    /*@Override
    public int size() {
        int i =0;
        for (Object o: this.key) {
            if(!o.equals(null)){
                i++;
            }
        }
        return i;
    }*/

    public abstract int size();

    @Override
    public boolean containsKey(Object key) {
        if (indexOf(key) != -1){
            return true;
        }
        return false;
    }
}
