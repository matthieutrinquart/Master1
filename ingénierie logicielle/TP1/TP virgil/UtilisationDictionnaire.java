public class UtilisationDictionnaire {
    public static void main(String[] args) {
        System.out.println("-------------------ORDERED DICTIONARY-------------------");

        IDictionary dic = new OrderedDictionary();
        dic = dic.put ("Lavoisier", "Chimiste francais ...");
        dic = dic.put ("Lavoisier2", "Chimiste francais ...2");
        dic = dic.put ("Lavoisier", "Chimiste francais ...3");
        dic = dic.put ("Lavoisier4", "Chimiste francais ...4");
        dic = dic.put ("Lavoisier5", "Chimiste francais ...5");
        System.out.println(dic);
        System.out.println(dic.size());
        Object j = dic.get("Lavoisier2");
        System.out.println(j);
        /*String[] test = new String[0];
        System.out.println(test.length);*/

        System.out.println("-------------------FAST DICTIONARY-------------------");

        IDictionary dic2 = new FastDictionary(10);
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

        System.out.println(dic2.get("Fast3"));

    }
}
