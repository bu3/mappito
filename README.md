# REST application

Spring boot application con un controller con tre operazioni:

* POST "/things"
* GET "/things/{id}"
* GET "/things/alt/{id}"


## POST Things
```
curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{ "content":"stuff1" }' 'http://localhost:8080/things'

```

## GET Thing 1
```
curl -X GET -H "Cache-Control: no-cache" 'http://localhost:8080/things/2'

```

## GET Thing 2
```
curl -X GET -H "Cache-Control: no-cache" 'http://localhost:8080/things/alt/2'

```
Diversa dalla precendente GET nella gestione del HTTP status code (Vedi it.mappito.thing.ThingController)