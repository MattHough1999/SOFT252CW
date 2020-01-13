/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
/**
 *
 * @author Matthew
 */
public class JsonDataHandler {
    public static void main(String[] args) {
        // TODO code application logic here
       JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("./testJSON.json"))
        {
            //Read JSON file
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            
            JSONArray users = (JSONArray) obj.get("Patients");
            for(int i = 0; i<users.size();i++)
            {
                JSONObject currentPatient = (JSONObject) users.get(i);
                
                for(int j = 0; j<currentPatient.size();j++){
                String LogID = (String) currentPatient.get("userID");
                
                
                if(Objects.equals(LogID, "P0001")){
                
                String ID = (String) currentPatient.get("userID");
                String Name = (String) currentPatient.get("name");
                String Address = (String) currentPatient.get("address");
                
                System.out.println(ID);
                System.out.println(Name);
                System.out.println(Address);
                break;
                }
                
                }
            }
            
            
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static JSONObject getData()
    {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("./testJSON.json"))
        {
            //Read JSON file
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            return obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void addData(JSONObject newData)
    {
        JSONParser jsonParser = new JSONParser();
        try (FileWriter file = new FileWriter("./testJSON.json")) {
 
            file.write(newData.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
}
