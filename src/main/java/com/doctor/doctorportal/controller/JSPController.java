package com.doctor.doctorportal.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.doctor.doctorport.modal.LoginData;
import com.doctor.doctorportal.dto.LoginResponseDTO;
import com.doctor.doctorportal.dto.PatientDTO;

@Controller
public class JSPController {

    @RequestMapping("login")
    public String loginPage() {
        return "login"; // The JSP page name without the .jsp extension
    }
    
    @GetMapping("patient1")
    public String getPatient(@ModelAttribute("loginData") LoginData loginData,Model model)
    {
        String apiUrl = "http://localhost:8080/login/"+loginData.getEmail()+"/" +loginData.getPassword(); // Replace with your API URL
        RestTemplate restTemplate = new RestTemplate();
        LoginResponseDTO apiResponse = restTemplate.getForObject(apiUrl, LoginResponseDTO.class);

        // Add the API response data to the model
        model.addAttribute("apiResponse", apiResponse);

        // Return the name of the JSP file (without .jsp extension) that will display the data
        return "displayData";
    }
    
    @RequestMapping("register")
    public String patientRegister()
    {
    	return "registration";
    }

    @RequestMapping("patientregister")
    @ResponseBody
    public String submitRegistrationForm(@ModelAttribute("patientDTO") PatientDTO patientDTO,Model model)
    {
    	try {
			System.out.println(patientDTO);
			String apiUrl = "http://localhost:8080/register/patient"; 
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			// Set up the RestTemplate
			RestTemplate restTemplate = new RestTemplate();
			
			HttpEntity<PatientDTO> requestEntity = new HttpEntity<>(patientDTO, headers);

			ResponseEntity<String> responseEntity = restTemplate.postForEntity(apiUrl, requestEntity, String.class);
			if (responseEntity.getStatusCode().is2xxSuccessful()) {
			    String responseBody = responseEntity.getBody();
			    return "Registration Success";
			} else {
			    // Handle error response
				return "Registration Failed";
			}
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Registration Failed";
		}

    }
    
    
}
