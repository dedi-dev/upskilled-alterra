# a. GET /v1/messages :

pada end point GET /v1/messages bisa kita lihat pada file HelloWorldController.java
ada method public getHelloWorld yang memberikan return "Get Hello World".
pada method ini di berikan annotation @GetMapping maka method ini menjadi return ketika
client hit end point dengan method GET {base_url}/v1/messages.
![1](./screenshoot/Screenshot%20from%202022-07-28%2006-41-43.png)

# b. POST /v1/messages :

pada end point POST /v1/messages bisa kita lihat pada file HelloWorldController.java
ada method public postHelloWorld yang memberikan return "Post Hello World".
pada method ini di berikan annotation @PostMapping maka method ini menjadi return ketika
client hit end point dengan method POST {base_url}/v1/messages.
![1](./screenshoot/Screenshot%20from%202022-07-28%2006-41-58.png)

# c. DELETE /v1/messages :

pada end point DELETE /v1/messages bisa kita lihat pada file HelloWorldController.java
ada method public deleteHelloWorld yang memberikan return "Delete Hello World".
pada method ini di berikan annotation @DeleteMapping maka method ini menjadi return ketika
client hit end point dengan method DELETE {base_url}/v1/messages.
![1](./screenshoot/Screenshot%20from%202022-07-28%2006-42-13.png)
