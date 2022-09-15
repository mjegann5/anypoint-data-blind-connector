# Mule 4 Data Blind Connector

## How to Publish this connector to your Exchange?:

1. Clone this repo
```
       git clone https://github.com/mjegann5/mule-data-blind-connector.git
```
2. In pom.xml replace ANYPOINT_ORG_ID by your Anypoint Org Id
```
       <groupId>ANYPOINT_ORG_ID</groupId> => <groupId>5tdfgceb5-fd1f-456d-aaa2-19cdsddcea</groupId>
```
3. mvn deploy -DskipTests -s .\settings.xml -Danypoint_username="******" -Danypoint_password="******"

4. Go to Anypoint Studio and pull the connector to your palette.

5. Drop the Encrypt / Decrypt operations in your flow

6. Add the following to the pom.xml

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
									<version>0.0.1</version>
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

7. Add the following to the settings.xml. Contact Kavi Software to get the password

  ```
  <servers>
    <server>
    <id>cwrep</id>
    <username>~~~Token~~~</username>
    <password>*********************</password>
	</server>
  </servers>
  ```


## Trouble shooting:

- If you get 401 error make sure user name password is correct and the user has Exchange_Contributor permission
- If you get a 409 error then you already has the this version of the Data-Blind connector. If you delete the current version in exchange, you will be able to upload this version again.


## How to Use this connector to mulesoft flow:

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

# Example:

## Input JSON:

	    "accounting" : 
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
	    "sales": 
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
  	    "companyName" : "First & Best Corporation",
  	    "address" : "Street1, City, State, Country",
  	    "phoneNumber" : "123456789"
    }


## Output JSON:

    "accounting": [
        {
            "firstName": "ooQ9OqV3wIZeG+MkEk1KFw==",
            "lastName": "Ees",
            "age": "***************************"
        },
        {
            "firstName": "/bbIa8Bzy76zsfqnUKWt7A==",
            "lastName": "Edmgy",
            "age": "***************************"
        }
    ],
    "sales": [
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
    "companyName": "First & Best Corporation",
    "address": "Street1, City, State, Country",
    "phoneNumber": "128388658"
    }
