/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import users.AdminUser;
import users.Doctor;
import users.PatientUser;
import users.SecretaryUser;

/**
 *
 * @author Matthew
 */
public class LoginSys {

    public static Boolean login(String UName, String PWord) {
        JSONObject obj = (JSONObject) JsonDataHandler.getData();
        
        if (UName.charAt(0) == 'P') {
            
            JSONArray users = (JSONArray) obj.get("Patients");
            for (int i = 0; i < users.size(); i++) {
                JSONObject currentPatient = (JSONObject) users.get(i);

                for (int j = 0; j < currentPatient.size(); j++) {
                    String LogID = (String) currentPatient.get("userID");

                    if (Objects.equals(LogID, UName)) {
                        String ID = currentPatient.get("userID").toString();
                        String Name = currentPatient.get("name").toString();
                        String Address = currentPatient.get("address").toString();
                        String sex = currentPatient.get("sex").toString();
                        int age = Integer.parseInt(currentPatient.get("age").toString());
                        
                        PatientUser patient = new PatientUser(ID,Name,Address,sex,age);
                        return true;
                    }

                }
            }
            return false;
            
        }
        else if (UName.charAt(0) == 'D') {
            
            JSONArray users = (JSONArray) obj.get("Doctors");
            for (int i = 0; i < users.size(); i++) {
                JSONObject currentPatient = (JSONObject) users.get(i);

                for (int j = 0; j < currentPatient.size(); j++) {
                    String LogID = (String) currentPatient.get("userID");

                    if (Objects.equals(LogID, UName)) {
                        String ID = currentPatient.get("userID").toString();
                        String Name = currentPatient.get("name").toString();
                        String Address = currentPatient.get("address").toString();
                        Doctor doctor = new Doctor(ID,Name,Address);
                        
                        return true;
                    }

                }
            }
            return false;
            //if(Objects.equals(UName, ""))
        }
        else if (UName.charAt(0) == 'A') {
            
            JSONArray users = (JSONArray) obj.get("Admins");
            for (int i = 0; i < users.size(); i++) {
                JSONObject currentPatient = (JSONObject) users.get(i);

                for (int j = 0; j < currentPatient.size(); j++) {
                    String LogID = (String) currentPatient.get("userID");

                    if (Objects.equals(LogID, UName)) {
                        String ID = currentPatient.get("userID").toString();
                        String Name = currentPatient.get("name").toString();
                        String Address = currentPatient.get("address").toString();
                        AdminUser admin = new AdminUser(ID,Name,Address);
                        
                        return true;
                    }

                }
            }
            return false;
            
        }
        else if (UName.charAt(0) == 'S') {
            
            JSONArray users = (JSONArray) obj.get("Secretaries");
            for (int i = 0; i < users.size(); i++) {
                JSONObject currentPatient = (JSONObject) users.get(i);

                for (int j = 0; j < currentPatient.size(); j++) {
                    String LogID = (String) currentPatient.get("userID");

                    if (Objects.equals(LogID, UName)) {
                        String ID = currentPatient.get("userID").toString();
                        String Name = currentPatient.get("name").toString();
                        String Address = currentPatient.get("address").toString();
                        
                        SecretaryUser secretary = new SecretaryUser(ID,Name,Address);
                        return true;
                    }

                }
            }
            return false;
            
        }
        return false;
    }
    
}
