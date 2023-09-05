package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{
  
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String weightstr = request.getParameter("weight").trim(); 
        String heightstr = request.getParameter("height").trim();

        //TODO: calculate bmi
         double weight = Double.parseDouble(weightstr); 
         double height = Double.parseDouble(heightstr); 

         double bmi = Math.round(weight/(height*height)); 
          

        //TODO: determine the built from BMI
        String buildType;
         if(bmi< 18.5){
            buildType = "underweight"; 
         } else if(bmi >= 18.5 && bmi < 25){
            buildType = "normal"; 
         } else if(bmi >= 25 && bmi <30){
            buildType = "overweight"; 
         } else if(bmi >= 30 && bmi <35){
            buildType = "obese"; 
         } else {
            buildType = "extremely obese"; 
         }
        //TODO: add bmi and built to the request's attribute
           request.setAttribute("bmi",bmi); 
           request.setAttribute("buildType",buildType); 

        //TODO: forward to jsp
           request.getRequestDispatcher("bmi_result.jsp").forward(request,response); 
    }
    
}
