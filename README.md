# quarkus api with mongodb

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Configs

MongoDB runs on default port provided in application.properties.

Run mongodb on docker by using this command:

```
docker run -ti --rm -p 27017:27017 mongo:4.0
```

The project exposes two api GET AND POST.

#### Request body example for POST request:

```
{
    "id" : "1",
    "name" : "whatevername"
}
```
