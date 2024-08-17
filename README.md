### Running the Application

Start Kafka: Ensure Kafka is running on localhost:9092 or adjust the address in application.yml.
Run the Application


### REST API for Producing Messages

This project includes a REST API to produce messages to Kafka for testing purposes.

#### Endpoint: /produce
#### Method: GET
#### Query Parameter: batchSize (Number of messages to produce)

### Example Request
```bash
curl "http://localhost:8080/produce?batchSize=500"
```
This request will produce 500 messages to the Kafka topic specified in the configuration.