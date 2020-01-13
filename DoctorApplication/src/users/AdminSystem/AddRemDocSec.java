/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.AdminSystem;

import java.util.Objects;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import system.JsonDataHandler;

/**
 *
 * @author mhough
 */
public class AddRemDocSec {
    public static String createAcc(String type,String name, String address)
    {
        //instatiate/grab JSON data
        JSONObject data = (JSONObject) JsonDataHandler.getData();
        JSONArray group = (JSONArray) data.get(type);
        int count = group.size();
        char c = type.charAt(0);
        String userID = String.format(c + "%04d", count + 1);
        
        //create and populate new admin user.
        JSONObject newAcc = new JSONObject();
        newAcc.put("userID", userID);
        newAcc.put("name", name);
        newAcc.put("address", address);
        
        group.add(newAcc);
        System.out.println(group);
        data.put(type, group);
        
        JsonDataHandler.addData(data);
        return userID;
    }
    public static String createAcc(String type,String name, String address,String sex,String age)
    {
        //instatiate/grab JSON data
        JSONObject data = (JSONObject) JsonDataHandler.getData();
        JSONArray group = (JSONArray) data.get(type);
        int count = group.size();
        char c = type.charAt(0);
        String userID = String.format(c + "%04d", count + 1);
        type = "Patients";
        //create and populate new admin user.
        JSONObject newAcc = new JSONObject();
        newAcc.put("userID", userID);
        newAcc.put("name", name);
        newAcc.put("address", address);
        newAcc.put("sex", sex);
        newAcc.put("age", age);
        
        group.add(newAcc);
        System.out.println(group);
        data.put(type, group);
        
        JsonDataHandler.addData(data);
        return userID;
    }
    public static String RemoveAcc(String type,String name)
    {
        //instatiate/grab JSON data
        JSONObject data = (JSONObject) JsonDataHandler.getData();
        JSONObject currUser;
        JSONArray group = (JSONArray) data.get(type);
        
        for(int i = 0; i < group.size();i++)
        {
            currUser = (JSONObject) group.get(i);
            if(Objects.equals(currUser.get("userID"), name)){
                JSONObject newAcc = new JSONObject();
                newAcc.put("userID", "DELETED");
                newAcc.put("name", "DELETED");
                newAcc.put("address", "DELETED");
                group.remove(i);
                group.add(newAcc);
                data.put(type, group);
                break;
            }
        }
        int count = group.size();
        char c = type.charAt(0);
        String userID = String.format(c + "%04d", count + 1);
        
        
//        //create and populate new admin user.
//        JSONObject newAcc = new JSONObject();
//        newAcc.put("userID", "DELETED");
//        newAcc.put("name", "DELETED");
//        newAcc.put("address", "DELETED");
//        //group.remove(count)
//        //group.add(newAcc);
//        System.out.println(group);
//        data.put(type, group);
        
        JsonDataHandler.addData(data);
        return userID;
    }
}
