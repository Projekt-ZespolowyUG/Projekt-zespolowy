package com.pgs.soft.visit.validation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pgs.soft.visit.domain.Outpost;

@Component
public class OutpostValidator implements Validator {
	 @Override
	    public boolean supports(Class<?> paramClass) {
	        return Outpost.class.equals(paramClass);
	    }
	  @Override
	    public void validate(Object obj, Errors errors) {
		  Outpost outpost = (Outpost) obj;


		  
		  if(outpost.getName().length() == 0 )
		  	{
	            errors.rejectValue("name", "empty");
		  	}
	            else if(outpost.getName().length() < 2 || outpost.getName().length() > 40)
		  	{
	            errors.rejectValue("name", "name");
	        }
		  if(outpost.getAdress().length()  == 0 )
		  	{
	            errors.rejectValue("adress", "empty");
	        }

	         else  if(outpost.getAdress().length() < 2 || outpost.getAdress().length() > 40)
		  	{
	            errors.rejectValue("adress", "adress");
	        }
		  if(outpost.getPostcode().length() ==0 )
		  	{
	            errors.rejectValue("postcode", "empty");
	        }
	         else if(outpost.getPostcode().length() < 2 || outpost.getPostcode().length() > 10)
		  	{
	            errors.rejectValue("postcode", "postcode");
	        }
	          if(outpost.getTown().length() == 0 )
			  	{
		            errors.rejectValue("town", "empty");
		        }
	         else if(outpost.getTown().length() < 2 || outpost.getTown().length() > 40)
		  	{
	            errors.rejectValue("town", "town");
	        }
	          if(outpost.getCountry().length() == 0)
			  	{
		            errors.rejectValue("country", "empty");
		        }
	         else if(outpost.getCountry().length() < 2 || outpost.getCountry().length() > 40)
		  	{
	            errors.rejectValue("country", "country");
	        }
	  }
}
