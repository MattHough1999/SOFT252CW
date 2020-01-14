/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.SecretarySystem;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import system.JsonDataHandler;

/**
 *
 * @author mhough
 */
public class ApprovePatientAcc {
    public static boolean ApprAcc()
    {
        //instatiate/grab JSON data
        JSONObject data = (JSONObject) JsonDataHandler.getData();
        JSONObject temp = (JSONObject) JsonDataHandler.getTempData();
        JSONArray patients = (JSONArray) data.get("Patients");
        JSONArray tempPatients = (JSONArray) temp.get("Patients");
        

        JSONObject newPatient = new JSONObject();
        for(int i = 0;i<tempPatients.size();i++)
        {
            newPatient = (JSONObject)tempPatients.get(i);
            patients.add(newPatient);
            tempPatients.remove(tempPatients.get(i));
            
            
        }
        temp.put("Patients", tempPatients);
        data.put("Patients", patients);
        JsonDataHandler.addData(data);
        return false;
    }
}
