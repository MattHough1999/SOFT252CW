/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.PatientSystem;

import java.util.Objects;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import system.JsonDataHandler;

/**
 *
 * @author mhough
 */
public class ReadAppointment {
    public static String getAppointments(String PatientID)
    {
        System.out.println(PatientID);
        String output = null;
        JSONObject data = (JSONObject) JsonDataHandler.getData();
        JSONArray appointments = (JSONArray) data.get("Appointments");
        JSONObject currAppointment;
        for(int i = 0; i < appointments.size();i++)
        {
            currAppointment = (JSONObject) appointments.get(i);
            output = output + ", ";
            if(Objects.equals(currAppointment.get("patID"), PatientID)){
            output = output + ", " + currAppointment.get("date");
            }
        }
        
        return output;
    }
}
