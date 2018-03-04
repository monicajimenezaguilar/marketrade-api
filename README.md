# marketrade-api

This api expose an endpoint which can consume trade messages. Trade messages will be POST’d to this endpoint and 
will take the JSON form. 
Trades submitted via this API are processed and made available via a RESTFUL endpoint. 
No Authentication is requred by the client to access to this service. 
This service is intended to be public and function as the entry point in a microservice architecture

http://localhost:8081/api/trades 
