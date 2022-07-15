import java.util.Arrays;

public class OrderedDictionary extends AbstractDictionary{


    public OrderedDictionary() {
        super(0);
    }

    @Override
    public int indexOf(Object key) {
        for (int i = 0; i < this.size(); i++){
            if(key.equals(this.key[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int newIndexOf(Object key) {
        if (!this.containsKey(key)) {
            if (this.size() == this.key.length) {
                Object[] keyTemp = new Object[this.key.length + 1];
                Object[] valuesTemp = new Object[this.key.length + 1];

                System.arraycopy(this.key, 0, keyTemp, 0, this.key.length);
                System.arraycopy(this.values, 0, valuesTemp, 0, this.values.length);

                this.key = keyTemp;
                this.values = valuesTemp;

                return this.key.length - 1;
            } else {
                return this.size() - 1;
            }
        }
        else{
            return indexOf(key);
        }
    }

    @Override
    public int size() {
        return this.key.length;
    }

    @Override
    public String toString() {
        return "OrderedDictionary{" +
                "key=" + Arrays.toString(key) +
                ", values=" + Arrays.toString(values) +
                '}';
    }


}
