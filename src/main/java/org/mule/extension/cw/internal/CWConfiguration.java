package org.mule.extension.cw.internal;

import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.values.OfValues;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;


/**
 * This class represents an extension configuration, values set in this class are commonly used across multiple
 * operations since they represent something core from the extension.
 */
@Operations(CWOperations.class)
@ConnectionProviders(CWConnectionProvider.class)
public class CWConfiguration {
/*
  @Parameter
  private String configId;

  public String getConfigId(){
    return configId;
  }
  */
  
/*  @Parameter
  @OfValues(CWTypeProvider.class)
  private String cwType;

  public String getCwType() {
	  return cwType;
  }
*/

@Parameter
@DisplayName("Encryption Key")
	private String encryptionKey;
	public String getEncryptionKey() {
		  return encryptionKey;
	}

	/**
		  * Optional Licence Key.
	*/
@Parameter
@DisplayName("License Key")
	private String licenseKey;
	public String getLicenseKey() {
		  return licenseKey;
	}

}
