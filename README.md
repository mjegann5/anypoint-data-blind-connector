# Anypoint 4 Data Blind Connector

## How to Publish this connector to your Exchange

1. Clone this repo
```
       git clone https://github.com/mjegann5/mule-data-blind-connector.git
```
2. In pom.xml replace ANYPOINT_ORG_ID by your Anypoint Org Id
```
       <groupId>ANYPOINT_ORG_ID</groupId> => <groupId>5tdfgceb5-fd1f-456d-aaa2-19cdsddcea</groupId>
```
3. Run the maven command to deploy data blind to your exchange. (anypoint_username and anypoint_password are your anypoint platform credentials)

```
       mvn deploy -DskipTests -s .\settings.xml -Danypoint_username="******" -Danypoint_password="******"
       
```
## How to use this connector in your Anypoint Application

4. Go to Anypoint Studio and pull the connector to your palette.

5. Drop the Encrypt / Decrypt operations in your flow

6. Add the following to the pom.xml.  

      ```
      <plugins>
                        ...
                        ...
                        ...
			<plugin>
				<groupId>org.mule.tools.maven</groupId>
				<artifactId>mule-maven-plugin</artifactId>
				<version>${mule.maven.plugin.version}</version>
				<extensions>true</extensions>
				<configuration>
					<additionalPluginDependencies>
						<plugin>
							<groupId>${project.groupId}</groupId>
							<artifactId>cwconnector</artifactId>
							<additionalDependencies>
								<dependency>
									<groupId>io.cipherworks</groupId>
									<artifactId>cwdatacrypt</artifactId>
									<version>2.0.0</version>
								</dependency>
							</additionalDependencies>
						</plugin>
					</additionalPluginDependencies>
				</configuration>
			</plugin>
                        ...
                        ...
                        ...
      </plugins>
      <repositories>
                ...
                ...
                ...
		<repository>
			<id>cwrepo</id>
			<name>GitHub OWNER Apache Maven Packages</name>
			<url>https://maven.pkg.github.com/mjegann5/Securebort</url>
		</repository>
                ...
                ...
                ...
     </repositories>
     ```

7. Add the following to the settings.xml. Contact Kavi Software to get the token for 'cwrep' repository 

  ```
  <servers>
    <server>
    <id>cwrepo</id>
    <username>~~~Token~~~</username>
    <password>*********************</password>
	</server>
  </servers>
  ```


# Example

![Concept](/assets/DataBlind-EncryptConcept1.jpg)

## Input JSON

```
{
	    "legal" : 
 		[   
 			{ 
 			"firstName" : "John",  
 			"lastName"  : "Doe",
 			"age"       : 23 
 			},
			{
			"firstName" : "Mary",  
 			"lastName"  : "Smith",
 			"age"      : 32 
 			}
 		],                           
	    "marketing": 
		[ 
  			{ 
  			"firstName" : "Sally",
  			"lastName"  : "Green",
  			"age"      : 27 
 			}, 
  			{ 
  			"firstName" : "Jim", 
  			"lastName"  : "Galley",
  			"age"       : 41 
  			}
  		],
  	    "companyName" : "True Value Corporation",
  	    "address" : "123 First Street, Newyork, NY, USA",
  	    "contactNumber" : "123456789"
}
 ```
## Sensitive Fields
```
{
        "legal.firstName" : "AES:CBC",       /* legal.firstName will be encrypted using AES CBC Algorithm */
	"legal.lastName" : "FE:PersonName",  /* legal.lastName will be encrypted as a Format Preserved PERSON-NAME field */
        "legal.age" : "MASK:#",              /* legal.age will be masked as ######## */
        "contactNumber" : "FE:PhoneNumber"   /* contactNumber will be encrypted as a Format Preserved PHONE-NUMBER field */
}
```
## Output JSON
```
{
    "legal": [
        {
            "firstName": "ooQ9OqV3wIZeG+MkEk1KFw==",
            "lastName": "Ees",
            "age": "#######################"
        },
        {
            "firstName": "/bbIa8Bzy76zsfqnUKWt7A==",
            "lastName": "Edmgy",
            "age": "#######################"
        }
    ],
    "marketing": [
        {
            "firstName": "Sally",
            "lastName": "Green",
            "age": 27
        },
        {
            "firstName": "Jim",
            "lastName": "Galley",
            "age": 41
        }
    ],
    "companyName": "True Value  Corporation",
    "address": "123 First Street, Newyork, NY, USA",
    "contactNumber": "128388658"
}
```
## Trouble shooting

- If you get 401 error in 'maven deploy', verify the anypoint user name and password and ensure that the user has Exchange_Contributor permission
- If you get a 409 error in 'maven deploy' then you already has the this version this connector in your exchange. 


## How to Use this connector in mulesoft flow

Refer to anypoint-data-blind-demo application. You can clone the repo and import into Anypoint studio and try this application. You would need key for cwrepo to run this demo. Please contact Kavi Software for the trail key.


## How Data is Encrypted 
NIST Publication 800-38G, FPE FF1. 

## Encryptable Data Types 

- Date
- DateTime
- IP Address
- GPS
- UPC-A
- Credit Card Number
- SSN
- Street Address
- Currency Amount
- Phone Number
- Person Name
- Email Address
- JPEG, GIF, TIFF, PNG  Images
- JSON Containing any of the above


## How to Override the encryption for specific users
The Connector provides operations for creating over-ride token. A passphrase and expiration period is required for creating an over-ride token. 

Over-ride tokens only work when:
- Correct passphrase is provided
- Token has not expired



