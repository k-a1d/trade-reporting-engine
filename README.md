# Trade Reporting Engine

A simple trade reporting engine built with Java & Spring Boot. Starting the application parses local trade reports and
stores them into an in-memory database (H2). These trade reports can be retrieved via an API endpoint.

## Running locally

### Start application

Run the following command to start the app (runs on port 8080 by default):

`./gradlew bootRun`

### Access database console

- Access this URL: http://localhost:8080/h2-console
- Fill in the H2 config details using the values from _application.properties_

### Access API

- Send a GET request to the endpoint /v1/trade/reports
- Example command from terminal:

```commandline
curl -H "Accept: application/json" -X GET "http://localhost:8080/v1/trade/reports?buyerParty=EMU_BANK&sellerParty=BISON_BANK&amount=600&currency=USD"`
```

- Alternatively, use a browser to send a request by entering a URL in the same structure as the one above