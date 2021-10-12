#Pre-requisites
Install:
- Java 11
- Maven
- allure
- docker

#Usage:
````
git clone git@github.com:ramandeep2008singh/weather-shop-project.git
cd weather-shop-project/
Goto src/main/java/com/weathershop/framework/config/GlobalConfig.properties
and change the following:
- Environment (can be run on local or on hub)
- SeleniumGridHub (replace the HUB url with your hub url)
- BrowserType (choose between chrome or firefox)
````

#How to run
##Please make sure to run the HUB either using the selenium-standalone-server like below:
// Using selenium-standalone-server
````
java -jar <path>/selenium-server-standalone-3.141.59.jar -role hub
java -jar <path>/selenium-server-standalone-3.141.59.jar -role node
````

## OR using Zalenium
// docker images
docker pull elgalu/selenium
docker pull dosel/zalenium

// Command to run zelanium server on MacOS:
docker run --rm -ti --name zalenium -p 4004:4004 \
      -e DOCKER=17.06.2-ce \
      -v /var/run/docker.sock:/var/run/docker.sock \
      -v /tmp/videos:/home/seluser/videos \
      --privileged dosel/zalenium start

// Command to run Zalenium server on Windows:
docker run --rm -ti --name zalenium -p 4444:4444 ^
      -v /var/run/docker.sock:/var/run/docker.sock ^
      -v /c/Users/your_user_name/temp/videos:/home/seluser/videos ^
      --privileged dosel/zalenium start

// Maven commands
mvn clean
mvn install
mvn verify

// Allure commands
allure generate allure-results --clean -o allure-report && allure open ./allure-report/

// Zalenium Hub URLs:
http://localhost:4444/grid/console
http://localhost:4444/grid/admin/live
http://localhost:4444/dashboard/#
