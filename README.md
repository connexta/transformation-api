# Transformation API
[![Dependabot Status](https://api.dependabot.com/badges/status?host=github&repo=connexta/ion-transformation-api)](https://dependabot.com)
[![Known Vulnerabilities](https://snyk.io//test/github/connexta/ion-transformation-api/badge.svg)](https://snyk.io//test/github/connexta/ion-transformation-api)
[![CircleCI](https://circleci.com/gh/connexta/ion-transformation-api.svg?style=svg)](https://circleci.com/gh/connexta/ion-transformation-api)
## Building
### What you need ###
* [Install Java SE 11](https://jdk.java.net/java-se-ri/11).
* Make sure that your JAVA\_HOME environment variable is set to the newly installed JDK location, and that your PATH includes %JAVA\_HOME%\bin (Windows) or $JAVA\_HOME$/bin (\*NIX).
* [Install Maven 3.5.2 \(or later\)](http://maven.apache.org/download.html). Make sure that your PATH includes the MVN\_HOME/bin directory.
* Set the MAVEN_OPTS variable with appropriate memory settings.

### How to build ###
Clone the ION Transformation API code repository.

```
git clone git@github.com:connexta/ion-transformation-api.git
```

Change to the root directory of the cloned ion-transformation-api repository. Run the following command:

```
mvn clean install
```

## Formatting
If during development the build fails for formatting violations:

You can check for formatting violations with the command:

```
mvn initialize spotless:check
```

You can fix formatting violations with the command:

```
mvn initialize spotless:apply
```