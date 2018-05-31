package com.prabu.myrestfulapi.utility;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomJsonDateDeserializer extends JsonDeserializer<Date>
{
    @Override
    public Date deserialize(JsonParser jsonparser,
            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = jsonparser.getText();
        try {
            return format.parse(date);
        } catch (ParseException e) {
        	// return null so that the not null contrasint kicks in and shows the message. 
        	// Advantage is all the fields will be validated without blocking for date exception. 
          return null; 
        }

    }
    
    
  /*  
   *  If this method is used the parse exception will be handled at handleHttpMessageNotReadable.
   * @Override
	public Date deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
			throws IOException, JsonProcessingException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = jsonparser.getText();
		LocalDate localDate = LocalDate.parse(date, formatter);
		return java.sql.Date.valueOf(localDate);
	}
*/
}
