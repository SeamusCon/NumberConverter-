
package com.mycompany.numeralconverter;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam; 
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//localhost:49000/api/conversion/numeraltoroman/2012


@Path("/conversion") 
public class NumberConverter {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/numeraltoroman/{param}")
    public Response numberToRomanText(@PathParam("param") int number) { 
       
        String converted = numeralToRoman(number);
        String output = "Number -" + number + "- converted into Roman, gives: " + converted + "!";
        
        return Response.status(200).entity(output).build();
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    @Path("/numeraltoroman/{param}")
    public String numberToRomanXML(@PathParam("param") int number) { 
        
        String converted = numeralToRoman(number);
        String output = "Number -" + number + "- converted into Roman, gives: " + converted + "!";
        
        return "<?xml version=\"1.0\"?>" + "<conversion>" + output + "</conversion>";
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/numeraltoroman/{param}")
    public String numberToRomanHTML(@PathParam("param") int number) { 
        
        String converted = numeralToRoman(number);
        String output = "Number -" + number + "- converted into Roman, gives: " + converted + "!";
        
        return "<html>" + "<title>" + "NumberToRoman" + "</title>" + "<body><h1>" + output + "</body></h1>" + "</html>";
    }
    
    public static String numeralToRoman(int number) {
        
        String[] romanValues = new String[]{"M","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] numeralValues = new int[]{ 1000, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}; 
        
        String roman = new String();
        
         for (int i = 0; i < 12; i++) {
            while (number - numeralValues[i] >= 0) {
                roman = roman.concat(romanValues[i]);
                number = number - numeralValues[i];
            }
        }
        return roman;
    }
}
