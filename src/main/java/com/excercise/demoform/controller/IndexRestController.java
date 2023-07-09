package com.excercise.demoform.controller;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.excercise.demoform.model.UserData;
import com.excercise.demoform.repository.UserRepository;
@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class IndexRestController {
    
    @Autowired
    UserRepository userRepository;

     @PostMapping(value = "/registeruser",
            consumes = "application/json")
     public String registerUser(@RequestBody String payload){
        //System.out.println(payload);
        Object obj = JSONValue.parse(payload);
        JSONObject jsonObject = (JSONObject) obj;
        String userName = (String) jsonObject.get("username");
        String father_name = (String) jsonObject.get("fname");
        String dateOfBirth = (String) jsonObject.get("dob");
        String userAddress = (String) jsonObject.get("addressOfUser"); 
        String password = (String) jsonObject.get("password");
        
        UserData userData = new UserData();
        userData.setName(userName);
        userData.setFatherName(father_name);
        userData.setDate(dateOfBirth);
        userData.setAddress(userAddress);
        userData.setPassword(password);
        userRepository.save(userData);
        return "success";
     }
     /**
    * @return
    */
   @GetMapping("/getallusers")
     public ArrayList<UserData> getAllUsers(){
      ArrayList<UserData> arrayList = new ArrayList<>();
     userRepository.findAll().forEach((user)->{
      arrayList.add(user);
     });
     return arrayList;
     }
   @DeleteMapping("/deleteUser")
   public String deleteUserFromTable(@RequestParam Long id){
      userRepository.deleteById(id);
      return "Successfully Deleted";
   }
}
