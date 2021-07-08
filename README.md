# portfolio
### From Future @2021

#To lunch application run following command 
###mvn clean spring-boot:run

##To run mongo db community or similar for other OS
To have launchd start mongodb/brew/mongodb-community now and restart at login:
  brew services start mongodb/brew/mongodb-community
Or, if you don't want/need a background service you can just run:
  mongod --config /opt/homebrew/etc/mongod.conf


##REST TEST
ET
curl http://localhost:8080/person
POST
curl -H "Content-Type: application/json" --data @payload.json http://localhost:8080/person
DELETE
curl -H "Content-Type: text/html"  -X DELETE http://localhost:8080/person/3
UPDATE
curl -X PUT -H "Content-Type: application/json" -d @payload.json http://localhost:8080/person/update/2


