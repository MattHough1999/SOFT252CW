/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.AdminSystem;

import java.util.ArrayList;
import java.util.Objects;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import system.JsonDataHandler;

/**
 *
 * @author mhough
 */
public class ReadRatings {
    public static String getFeedback(String DoctorID)
    {
        String output = null;
        JSONObject data = (JSONObject) JsonDataHandler.getData();
        JSONArray ratings = (JSONArray) data.get("Ratings");
        JSONObject currRating;
        for(int i = 0; i < ratings.size();i++)
        {
            currRating = (JSONObject) ratings.get(i);
            if(Objects.equals(currRating.get("doctorID"), DoctorID)){
            output = output + ", " + currRating.get("feedback");
            }
        }
        
        return output;
    }
    public static ArrayList<String> getDoctorIDs()
    {
        JSONObject data = (JSONObject) JsonDataHandler.getData();
        JSONArray doctors = (JSONArray) data.get("Doctors");
        JSONObject currentDoctor;
        
        ArrayList<String> doctorIDs = new ArrayList<String>();
        
        for(int i = 0; i < doctors.size();i++)
        {   
            currentDoctor = (JSONObject) doctors.get(i);
            doctorIDs.add(currentDoctor.get("userID").toString());
            
        }
        return doctorIDs;
    }
}
