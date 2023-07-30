package com.doctor.doctorportal.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.doctor.doctorportal.dto.LoginResponseDTO;

@Controller
public class MyController {

    @GetMapping("/display-data")
    public String displayData(Model model) {
        // Call the API and get the response using RestTemplate or other methods
        String apiUrl = "http://localhost:8080/login/Hrishi@gmail/qwer"; // Replace with your API URL
        RestTemplate restTemplate = new RestTemplate();
        LoginResponseDTO apiResponse = restTemplate.getForObject(apiUrl, LoginResponseDTO.class);

        // Add the API response data to the model
        model.addAttribute("apiResponse", apiResponse);

        // Return the name of the JSP file (without .jsp extension) that will display the data
        return "displayData";
    }
}