
package com.mycompany.numeralconverter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam; 
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


//localhost:49000/api/conversion/romantonumeral/MMXII

@Path("/conversion") 
public class RomanConverter {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/romantonumeral/{param}")
    public Response romanToNumberText(@PathParam("param") String roman) { 
        
        int converted = romanToNumeral(roman);
        String output = "Roman -" + roman + "- converted into numeral gives: " + converted + "!";
        
        return Response.status(200).entity(output).build();
    }
    
    @GET
    @Produces(MediaType.TEXT_XML)
    @Path("/romantonumeral/{param}")
    public String romanToNumberXML(@PathParam("param") String roman) { 
        
        int converted = romanToNumeral(roman);
        String output = "Roman -" + roman + "- converted into numeral gives: " + converted + "!";
        
        return "<?xml version=\"1.0\"?>" + "<conversion>" + output + "</conversion>";
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/romantonumeral/{param}")
    public String romanToNumberHTML(@PathParam("param") String roman) { 
        
        int converted = romanToNumeral(roman);
        String output = "Roman -" + roman + "- converted into numeral gives: " + converted + "!";
        
        return "<html>" + "<title>" + "RomanToNumeral" + "</title>" + "<body><h1>" + output + "</body></h1>" + "</html>";
    }
    
     public static int romanToNumeral(String roman) {
        
        String[] romanValues = new String[]{"M","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] numeralValues = new int[]{ 1000, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}; 
        
        int num = 0;
        
         for (int i = 0; i < 12; i++) {
            while (roman.contains(romanValues[i]) && !roman.isEmpty()) {
                num = num + numeralValues[i];
                roman = roman.substring(1, roman.length());
            }
        }
        return num;
    }
}
