package org.mule.extension.cw.internal;

import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.api.connection.PoolingConnectionProvider;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.connection.CachedConnectionProvider;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.values.OfValues;
import org.mule.runtime.extension.api.annotation.ExternalLib;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
@ExternalLib(name = "CW Datacrypt Library",
description = "CW Datacrypt Library which implements the encryption for various data types",
nameRegexpMatcher = "(.*)\\.jar",
requiredClassName = "com.cipherworks.datacrypt.PersonName",
coordinates = "securebort:datacrypt:0.0.1",
type = org.mule.runtime.api.meta.ExternalLibraryType.DEPENDENCY)

@ExternalLib(name = "CW Common Library",
description = "CW Common used by the CW Datacrypt Library",
nameRegexpMatcher = "(.*)\\.jar",
requiredClassName = "com.cipherworks.cwcommon.Logger",
coordinates = "com.cipherworks:cwcommon:0.0.1",
type = org.mule.runtime.api.meta.ExternalLibraryType.DEPENDENCY)
*/
/**
 * This class (as it's name implies) provides connection instances and the funcionality to disconnect and validate those
 * connections.
 * <p>
 * All connection related parameters (values required in order to create a connection) must be
 * declared in the connection providers.
 * <p>
 * This particular example is a {@link PoolingConnectionProvider} which declares that connections resolved by this provider
 * will be pooled and reused. There are other implementations like {@link CachedConnectionProvider} which lazily creates and
 * caches connections or simply {@link ConnectionProvider} if you want a new connection each time something requires one.
 */
public class CWConnectionProvider implements PoolingConnectionProvider<CWConnection> {

  private final Logger LOGGER = LoggerFactory.getLogger(CWConnectionProvider.class);

  /**
	* Encryption Key with default.
*/
/*
@DisplayName("Encryption Key")
@Parameter
private String encryptionKey;
public String getEncryptionKey() {
	  return encryptionKey;
}

/**
	  * Optional Licence Key.
*/
/*@DisplayName("License Key")
@Parameter
private String licenseKey;
public String getLicenseKey() {
	  return licenseKey;
}
*/  
  @Override
  public CWConnection connect() throws ConnectionException {
    return new CWConnection("Test");
  }

  @Override
  public void disconnect(CWConnection connection) {
    try {
      connection.invalidate();
    } catch (Exception e) {
      LOGGER.error("Error while disconnecting [" + connection.getId() + "]: " + e.getMessage(), e);
    }
  }

  @Override
  public ConnectionValidationResult validate(CWConnection connection) {
    return ConnectionValidationResult.success();
  }
}
