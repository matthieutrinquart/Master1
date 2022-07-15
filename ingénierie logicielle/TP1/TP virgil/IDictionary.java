public interface IDictionary {

    public Object get(Object key);
    //rend la valeur associee a key dans le receveur
    public IDictionary put(Object key, Object value);
    //entre une nouveau couple cle-valeur dans le receveur, rend le receveur
    public boolean isEmpty();
    //rend vrai si le receveur est vide, faux sinon
    public boolean containsKey(Object key);
    //rend vrai si la cle est connue dans le receveur, faux sinon
    public int size();
    //rend le nombre d’elements (donc le nombre de couples cle-valeur) contenus dans le receveur
}
