public  class OrderedDictionary extends AbstractDictionary{
	
	
	
	public OrderedDictionary(){
		super();
	};
	@Override
	public int indexOf(Object key){
		
		
		for(int i = 0; i < this.size(); ++i) {
			if (this.key[i].equals(key))
				return i;

		}
		return -1;
	}
	
	
	;
	public int newindexOf(Object key){
		
		int size = this.size();

		if (size == this.key.length) {
			Object[] newKeys = new Object[this.key.length + 1];
			Object[] newValues = new Object[this.key.length + 1];
 
			System.arraycopy(this.key, 0, newKeys, 0, this.key.length);
			System.arraycopy(this.value, 0, newValues, 0, this.value.length);
 
			this.key = newKeys;
			value = newValues;

			return this.key.length-1 ;}
		else return size-1;
			
			
		}
		public int size() {
			return this.key.length;
		}
		
		
		
		
		
		
		
	}

