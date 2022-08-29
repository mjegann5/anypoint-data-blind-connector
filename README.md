# mule-data-blind-connector
Mule 4 Data Blind Connector

How to use this connector:

1. Clone this repo
       git clone https://github.com/mjegann5/mule-data-blind-connector.git
2. In pom.xml replace ANYPOINT_ORG_ID by your Anypoint Org Id
       <groupId>ANYPOINT_ORG_ID</groupId> => <groupId>5tdfgceb5-fd1f-456d-aaa2-19cdsddcea</groupId>

3. mvn deploy -DskipTests -s .\settings.xml -Danypoint_username="******" -Danypoint_password="******"

4. Go to Anypoint Studio and pull the connector to your palette.

5. Drop the Encrypt / Decrypt operations in your flow

6. Add the following to the pom.xml

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

7. Add the following to the settings.xml. Contact Kavi Software to get the password

  <servers>
    <server>
    <id>cwrep</id>
    <username>~~~Token~~~</username>
    <password>*********************</password>
	</server>
  </servers>


Trouble shooting:

- If you get 401 error make sure user name password is correct and the user has Exchange_Contributor permission
- If you get a 409 error then you already has the this version of the Data-Blind connector. If you delete the current version in exchange, you will be able to upload this version again.