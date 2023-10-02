package jasonTest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class JsonTest {
    public static void main(String[] args) {
        HashMap<String, Object> userMap = new HashMap<>();
        JSONArray userJsons = new JSONArray();

        JSONObject userJson = null;
        userMap.put("id", "hds");
        userMap.put("password", "1234");
        userMap.put("name", "한동석");
        userMap.put("age", 20);

//        userJson.put("phoneNumber","01057862039");
        userJson = new JSONObject(userMap);
        userJsons.add(userJson);
//        System.out.println(userJson.toJSONString());
        System.out.println(userJsons);

        userMap.put("id", "jdm");
        userMap.put("password", "0224");
        userMap.put("name", "장동민");
        userMap.put("age", 27);
        userJson = new JSONObject(userMap);
        userJsons.add(userJson);
        System.out.println(userJsons);
    }
}
