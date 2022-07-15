import java.util.Arrays;

public class FastDictionary extends AbstractDictionary {

    public FastDictionary(int i) {
        super(i);
    }

    @Override
    public int size() {
        int i =0;
        for (Object o: this.key) {
            if(o != null){
                i++;
            }
        }
        return i;
    }

    public boolean mustGrow(){
        return (this.key.length*0.75) <= (this.size());
    }

    public void grow(){
        if (this.mustGrow()){
            Object[] keyTemp = new Object[this.key.length * 2];
            Object[] valuesTemp = new Object[this.key.length * 2];

            System.arraycopy(this.key, 0, keyTemp, 0, this.key.length);
            System.arraycopy(this.values, 0, valuesTemp, 0, this.values.length);

            this.key = keyTemp;
            this.values = valuesTemp;
        }
    }

    @Override
    public int indexOf(Object key) {
        int hash = key.hashCode()%this.key.length;
        int hashPosInit = hash;
        while(this.key[hash]!= key){
            hash = (hash + 1)% this.key.length;
            if (hashPosInit == hash){
                return -1;
            }
        }
        return hash;
    }

    @Override
    public int newIndexOf(Object key) {
        if (!this.containsKey(key)) {
            if (mustGrow()) {
                grow();
            }
            int hash = key.hashCode()%this.key.length;
            while (this.key[hash] != null){
                hash = (hash + 1)% this.key.length;
            }
            return hash;
        }
        else{
            return indexOf(key);
        }
    }

    @Override
    public String toString() {
        return "FastDictionary{" +
                "key=" + Arrays.toString(key) +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
