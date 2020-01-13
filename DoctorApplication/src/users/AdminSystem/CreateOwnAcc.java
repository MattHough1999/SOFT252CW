/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.AdminSystem;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import system.JsonDataHandler;

/**
 *
 * @author mhough
 */
public class CreateOwnAcc {
    
    public static String createAcc(String name, String address)
    {
        //instatiate/grab JSON data
        JSONObject data = (JSONObject) JsonDataHandler.getData();
        JSONArray admins = (JSONArray) data.get("Admins");
        int count = admins.size();
        String userID = String.format("A" + "%04d", count + 1);
        
        //create and populate new admin user.
        JSONObject newAdmin = new JSONObject();
        newAdmin.put("userID", userID);
        newAdmin.put("name", name);
        newAdmin.put("address", address);
        admins.add(newAdmin);
        System.out.println(admins);
        data.put("Admins", admins);
        
        JsonDataHandler.addData(data);
        return userID;
    }
}
