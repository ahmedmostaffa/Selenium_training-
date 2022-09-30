package Ejada.seleniumCloud;

import java.util.HashMap;
import java.util.Map;

public class Tutorial {
    public static void main(String[] args) {
        Map<String ,Object> hashmap=new HashMap<>();
        hashmap.put("id",2);
        hashmap.put("name","ahmed");
        hashmap.put("data",new String[]{"FR","AR","EN"});

        for(String key: hashmap.keySet()){
            System.out.println(hashmap.get(key));
            if(hashmap.get(key).getClass().isArray()){
                String[] arr= (String[]) hashmap.get(key);
                System.out.println(arr[0]);
            }
        }
    }

}
