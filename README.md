# mule-data-blind-connector
Mule 4 Data Blind Connector


1. Clone this repo
       git clone https://github.com/mjegann5/mule-data-blind-connector.git
2. In pom.xml replace ANYPOINT_ORG_ID by your Anypoint Org Id
       <groupId>ANYPOINT_ORG_ID</groupId> => <groupId>5tdfgceb5-fd1f-456d-aaa2-19cdsddcea</groupId>
       
3. mvn deploy -DskipTests -s .\settings.xml -Danypoint_username="******" -Danypoint_password="******"

Trouble shooting:

- If you get 401 error make sure user name password is correct and the user has Exchange_Contributor permission
- If you get a 409 error then you already has the this version of the Data-Blind connector. If you delete the current version in exchange, you will be able to upload this version again.