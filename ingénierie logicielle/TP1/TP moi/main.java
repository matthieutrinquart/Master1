

public class main {

	public static void main(String[] args) {
		
		
		
		IDICTIONARY test = new OrderedDictionary();
		
		String valeur = "je suis un object";

		test.put(1,"premier");

		test.put(2, "deuxieme");


		test.put(3, "troisieme");


		test.put(4,"quatrieme");
	
		test.put(5, "cinquieme");
		System.out.println(test.get(5 ));
		
		
		System.out.println("-------------------FAST DICTIONARY-------------------");

        IDICTIONARY dic2 = new FastDictionnary();
        dic2.put("Fast1", "1");
        dic2.put("Fast2", "2");
        dic2.put("Fast3", "3");
        dic2.put("Fast4", "4");
        dic2.put("Fast5", "5");
        dic2.put("Fast6", "6");
        dic2.put("Fast7", "7");
        dic2.put("Fast8", "8");
        dic2.put("Fast9", "9");
        dic2.put("Fast10", "10");
        dic2.put("Fast11", "11");

        System.out.println(dic2);
        System.out.println(dic2.size());

        System.out.println("dic2.get("Fast3"));
	}
	
}

