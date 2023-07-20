# Authenticating with GitHub user on Keycloak in a Spring Boot application

## Spring Boot
* Spring Boot version 2.7.13.
  
## Keycloak 
* Keycloak OpenJDK version [22.0.0](https://github.com/keycloak/keycloak/releases/download/22.0.0/keycloak-22.0.0.zip).
* [Getting Started](https://www.keycloak.org/getting-started/getting-started-zip).

## Configure project
### GitHub
* Configure a [OAuth app](https://docs.github.com/es/apps/oauth-apps/building-oauth-apps/creating-an-oauth-app) in GitHub.

### Spring and Keycloak
* [Baeldung tutorial](https://www.baeldung.com/spring-boot-keycloak).

### Running app
* http://localhost:8084 -> Welcome world!
* http://localhost:8084/secure -> Logging needed
* http://localhost:8084/logout -> default Spring logout
