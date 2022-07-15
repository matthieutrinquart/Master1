public  class FastDictionnary extends AbstractDictionary{
	
	
	
	public FastDictionnary(){
		super();
	};

    public int size() {

        int c = 0;

        for(int i = 0 ; i < key.length;++i){
            if(key[i] != null){
                ++c;
            }


        }
        return c;
    }
    public boolean mustGrow(){
        if(this.key.length == 0)
            return true;
        else
            return (this.size()*0.75) <= key.length;
    }

    public void grow(){
        if(mustGrow()){
            if(key.length == 0){
            //    System.out.println("c'est moi " + key.length);
                Object[] newkey = new Object[this.key.length + 1];
                Object[] newvalue = new Object[this.key.length + 1];
    
                System.arraycopy(this.key, 0, newkey, 0, this.key.length);
                System.arraycopy(this.value, 0, newvalue, 0, this.value.length);
     
                this.key = newkey;
                this.value = newvalue;



            }else{


            Object[] newkey = new Object[key.length * 2];
            Object[] newvalue = new Object[key.length * 2];

            System.arraycopy(this.key, 0, newkey, 0, this.key.length);
			System.arraycopy(this.value, 0, newvalue, 0, this.value.length);
 
			this.key = newkey;
			this.value = newvalue;
            }

        }

    }
    public int indexOf(Object key){
    if(this.key.length == 0){
        return -1;
    }else{

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
    }
	public int newindexOf(Object key){

     //   System.out.println(key);
       // System.out.println("c'est moi " + this.key.length);
        if (!this.containsKey(key)) {
         //   System.out.println("c'est moi " + this.key.length);
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
		
		
		
		
		
	};

