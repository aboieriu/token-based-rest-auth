# token-based-rest-auth
This is a simple example of a token based authentication for a REST service. I have put together this example after following several articles found on the internet.

#Build
This is a simple maven project that uses jax-rs / spring for setting up a REST service. However, the auth part doesn't have anything to do with the jax-rs part. It is a simple use case of using spring security for deploying a token based auth system for a rest service.

For building the project , just use 
```
mvn install
```

#Deploy
Just deploy the /service/target/ws.1.0-SNAPSHOT/ into a tomcat or any other suitable container

#Usage
This example uses a hardcoded user 
```
{
  "username":"alex"
  , "password":"fishka"
}
```
There are also 2 endpoints available:
```
host:port/secure/authenticate/
```
This endpoint is obviosuly not secured (although the path says "/secure") . The /authenticate endpoint is actually used for authenticating a user

```
host:port/secure/user/
```
This endpoint is secured and should only work for an authenticated user


First , you have to make a POST request to 
```
host:port/secure/authenticate/
```
and provide user data in request body 
```
{
  "username":"alex"
  , "password":"fiska"
}
```

The request should succesfully authenticate the user and return something similar:

```
{
    "token": "alex:1447718688562:fba1fc4bd2cb0a30e12015a8b2766f99"
}
```

After this, you can use this token for authenticating further requests without the need for providing a user password. Future requests can either use add this toke using the header 'X-Auth-token' or add it as a request parameter. 
eg:
```
host:port/secure/user/?token=alex:1447718688562:fba1fc4bd2cb0a30e12015a8b2766f99
```

That should return a message like: 
```
You are logged in as: alex
```

The token has an expiry date set (also provided as part of the token) and although a logout function is not currently implemented, it should just be a simple token invalidation.
