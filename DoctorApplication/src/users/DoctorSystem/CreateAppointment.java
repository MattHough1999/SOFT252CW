/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.DoctorSystem;

import java.util.Objects;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import system.JsonDataHandler;

/**
 *
 * @author mhough
 */
public class CreateAppointment {
    public static String createApp(String date,String patID, String docID)
    {
        //instatiate/grab JSON data
        JSONObject data = (JSONObject) JsonDataHandler.getData();
        JSONArray group = (JSONArray) data.get("Appointments");
        int count = group.size();
        
        
        //create and populate new appointment.
        JSONObject newApp = new JSONObject();
        newApp.put("date", date);
        newApp.put("patID", patID);
        newApp.put("docID", docID);
        
        group.add(newApp);
        System.out.println(group);
        data.put("Appointments", group);
        
        JsonDataHandler.addData(data);
        String userID = date;
        return userID;
    }
//    public static String RemoveApp(String date,String patID, String docID)
//    {
//        //instatiate/grab JSON data
//        JSONObject data = (JSONObject) JsonDataHandler.getData();
//        JSONObject currUser;
//        JSONArray group = (JSONArray) data.get("Appointments");
//        
//        
//        for(int i = 0; i < group.size();i++)
//        {
//            currUser = (JSONObject) group.get(i);
//            if(Objects.equals(currUser.get("userID"), name)){
//                
//                group.remove(i);
//                //group.add(newApp);
//                data.put("Appointments", group);
//                JsonDataHandler.addData(data);
//                return "Account Deleted Successfully";
//                
//            }
//        }
//        return null;
        
    }

