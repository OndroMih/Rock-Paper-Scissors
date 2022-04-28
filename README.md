# A demo Rock-Paper-Scissors application


## Quickstat

To build and run the demo quickly:

```
mvn -Pglassfish package cargo:run 
```

Then open http://localhost:8080/GF-Alot-Rock-Paper-Scissors/ in a browser.

## Run on GlassFish server

This application was developed against GlassFish 6.2.5 server, with standard Jakarta EE 9 features.

To run on an installed GlassFish server:

* Execute the following to build the application: `mvn package`
* Download GlassFish 6 from: https://glassfish.org/
* Install GlassFish 6 on your computer (unzip it)
* Execute the following to start GlassFish: 

```
bin/asadmin start-domain domain1
```


* Execute the following to deploy the application: 

```
bin/asadmin deploy --contextroot GF-Alot-Rock-Paper-Scissors <path/to/the/project>/target/GF-Alot-Rock-Paper-Scissors-1.0-SNAPSHOT.war
```

The open http://localhost:8080/GF-Alot-Rock-Paper-Scissors/ in a browser.