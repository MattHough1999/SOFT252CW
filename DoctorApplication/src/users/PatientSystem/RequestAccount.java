/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.PatientSystem;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import system.JsonDataHandler;

/**
 *
 * @author Matthew
 */
public class RequestAccount {
    public static boolean ReqAcc(String name, String address,String age,String sex)
    {
        //instatiate/grab JSON data
        JSONObject data = (JSONObject) JsonDataHandler.getData();
        JSONObject temp = (JSONObject) JsonDataHandler.getTempData();
        JSONArray patients = (JSONArray) data.get("Patients");
        JSONArray tempPatients = (JSONArray) temp.get("Patients");
        int count = patients.size() + tempPatients.size();
        String userID = String.format("P" + "%04d", count + 1);
        
        //create and populate new temp user.
        JSONObject newPatient = new JSONObject();
        newPatient.put("userID", userID);
        newPatient.put("name", name);
        newPatient.put("address", address);
        tempPatients.add(newPatient);
        
        temp.put("Patients", tempPatients);
        
        JsonDataHandler.addTempData(temp);
        return false;
    }
}
