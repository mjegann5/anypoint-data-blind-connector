package org.mule.extension.cw.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;
import org.mule.runtime.extension.api.annotation.values.OfValues;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.values.OfValues;

import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.api.meta.ExpressionSupport;
import io.cipherworks.cwdatacrypt.*;



/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class CWOperations {

  /**
   * Example of an operation that uses the configuration and a connection instance to perform some action.
   */
/*  @MediaType(value = ANY, strict = false)
  public String retrieveInfo(@Config CWConfiguration configuration, @Connection CWConnection connection){
    return "Using Configuration ["  + "] with Connection id [" + connection.getId() + "]";
  }
*/
  /**
   * Example of a simple operation that receives a string parameter and returns a new string message that will be set on the payload.
   */
 /* @Parameter
  @DisplayName("Data Type")
  @OfValues(CWTypeProvider.class)
  private String cwType;
    
  @Parameter
  @Alias("Value")
  @Expression(org.mule.runtime.api.meta.ExpressionSupport.SUPPORTED)
  private String plainText;

  @Parameter
  @Alias("Tweak")
  @Expression(org.mule.runtime.api.meta.ExpressionSupport.SUPPORTED)
  private String tweak;*/

  @MediaType(value = ANY, strict = false)
  @Alias("Encrypt")
  public String encrypt(@Config CWConfiguration configuration,
		  @OfValues(CWTypeProvider.class) String dataType,
		  @Expression(ExpressionSupport.SUPPORTED) String value,
		  @Expression(ExpressionSupport.SUPPORTED) String tweak) {
    //return plainText.toUpperCase() + cwType + ":" + configuration.getEncryptionKey() + ":" + configuration.getLicenseKey();
    String response = "OperationFailed";
    try {
    KeyContext kc = new KeyContext("CipherWorks", "Admin", "1.0", configuration.getEncryptionKey().getBytes());
    if ( dataType.contentEquals("Phone Number") ) {
    	    PhoneNumber ph = new PhoneNumber(kc);
    		response = ph.encrypt(value, tweak);
  	} else if ( dataType.contentEquals("Person Name") ) {
  	    	PersonNameNice phn = new PersonNameNice(kc);
  			response = phn.encrypt(value, tweak);
  	} else if ( dataType.contentEquals("Street Address") ) {
  			StreetAddress sa = new StreetAddress(kc);
			response = sa.encrypt(value, tweak);
  	} else if ( dataType.contentEquals("Street Address Nice") ) {
  	    	StreetAddressNice san = new StreetAddressNice(kc);
			response = san.encrypt(value, tweak);
  	} else if ( dataType.contentEquals("Date (MM/dd/yyyy)") ) {
  			DateNice dtNice = new DateNice(kc);
			response = dtNice.encrypt(value, tweak);
  	} else if ( dataType.contentEquals("DateTime (MM/dd/yyyy HH:mm:ss)") ) {
  	    	DateTimeNice dtmNice = new DateTimeNice(kc);
			response = dtmNice.encrypt(value, tweak);
  	} else if ( dataType.contentEquals("IP Address (v4)") ) {
  	    	IPAddress ip = new IPAddress(kc);
			response = ip.encrypt(value, tweak);
  	} else if ( dataType.contentEquals("GPS") ) {
  			GPSCoordinate gps = new GPSCoordinate(kc);
			response = gps.encrypt(value, tweak);
  	} else if ( dataType.contentEquals("UPC-A") ) {
  	    	UPC upc = new UPC(kc);
			response = upc.encrypt(value, tweak);
  	} else if ( dataType.contentEquals("Credit Card Number") ) {
  			CreditCardNumber ccn = new CreditCardNumber(kc);
			response = ccn.encrypt(value, tweak);
 	} else if ( dataType.contentEquals("SSN") ) {
 	    	SSN ssn = new SSN(kc);
 	    	response = ssn.encrypt(value, tweak);
 	} else if ( dataType.contentEquals("Currency Amount") ) {
 	    CurrencyAmount amount = new CurrencyAmount(kc);
	    	response = amount.encrypt(value, tweak);
 	} else if ( dataType.contentEquals("Email Address") ) {
 	    	EmailAddress ea = new EmailAddress(kc);
	    	response = ea.encrypt(value, tweak);
	} else {
		response = "ERROR::Unknown Type";
	}
    }
    catch (Exception e) {
    	System.out.println("Excception in Connector " + e);
    	e.printStackTrace();
    }
    return response;
  }

  @MediaType(value = ANY, strict = false)
  @Alias("decrypt")
  public String decrypt(@Config CWConfiguration configuration,
		  @OfValues(CWTypeProvider.class) String dataType,
		  @Expression(ExpressionSupport.SUPPORTED) String mockValue,
		  @Expression(ExpressionSupport.SUPPORTED) String tweak) {
    //return mockValue.toUpperCase() + dataType + ":" + configuration.getdecryptionKey() + ":" + configuration.getLicenseKey();
    String response = "OperationFailed";
    try {
    KeyContext kc = new KeyContext("CipherWorks", "Admin", "1.0", configuration.getEncryptionKey().getBytes());
    if ( dataType.contentEquals("Phone Number") ) {
    	    PhoneNumber ph = new PhoneNumber(kc);
    		response = ph.decrypt(mockValue, tweak);
  	} else if ( dataType.contentEquals("Person Name") ) {
  	    	PersonNameNice phn = new PersonNameNice(kc);
  			response = phn.decrypt(mockValue, tweak);
  	} else if ( dataType.contentEquals("Street Address") ) {
  			StreetAddress sa = new StreetAddress(kc);
			response = sa.decrypt(mockValue, tweak);
  	} else if ( dataType.contentEquals("Street Address Nice") ) {
  	    	StreetAddressNice san = new StreetAddressNice(kc);
			response = san.decrypt(mockValue, tweak);
  	} else if ( dataType.contentEquals("Date (MM/dd/yyyy)") ) {
  			DateNice dtNice = new DateNice(kc);
			response = dtNice.decrypt(mockValue, tweak);
  	} else if ( dataType.contentEquals("DateTime (MM/dd/yyyy HH:mm:ss)") ) {
  	    	DateTimeNice dtmNice = new DateTimeNice(kc);
			response = dtmNice.decrypt(mockValue, tweak);
  	} else if ( dataType.contentEquals("IP Address (v4)") ) {
  	    	IPAddress ip = new IPAddress(kc);
			response = ip.decrypt(mockValue, tweak);
  	} else if ( dataType.contentEquals("GPS") ) {
  			GPSCoordinate gps = new GPSCoordinate(kc);
			response = gps.decrypt(mockValue, tweak);
  	} else if ( dataType.contentEquals("UPC-A") ) {
  	    	UPC upc = new UPC(kc);
			response = upc.decrypt(mockValue, tweak);
  	} else if ( dataType.contentEquals("Credit Card Number") ) {
  			CreditCardNumber ccn = new CreditCardNumber(kc);
			response = ccn.decrypt(mockValue, tweak);
 	} else if ( dataType.contentEquals("SSN") ) {
 	    	SSN ssn = new SSN(kc);
 	    	response = ssn.decrypt(mockValue, tweak);
 	} else if ( dataType.contentEquals("Currency Amount") ) {
 	    CurrencyAmount amount = new CurrencyAmount(kc);
	    	response = amount.decrypt(mockValue, tweak);
 	} else if ( dataType.contentEquals("Email Address") ) {
 	    	EmailAddress ea = new EmailAddress(kc);
	    	response = ea.decrypt(mockValue, tweak);
	} else {
		response = "ERROR::Unknown Type";
	}
    }
    catch (Exception e) {
    	System.out.println("Excception in Connector " + e);
    	e.printStackTrace();    	
    }
    return response;
  }
}
