- Test NG
- Selenium-java
- WebDriverManager
- Allure TestNG

Pre:
Install:
- Java 11
- docker
- Maven
- allure



// Old selenium-standalone-server
java -jar /Users/rsinghnagi/Documents/code/vinted_web_functional_tests/resources/selenium-server-standalone-3.141.59.jar -role hub
java -jar /Users/rsinghnagi/Documents/code/vinted_web_functional_tests/resources/selenium-server-standalone-3.141.59.jar -role node

// docker images
docker pull elgalu/selenium
docker pull dosel/zalenium

// Command to run zelanium server
docker run --rm -ti --name zalenium -p 4004:4004 \
      -e DOCKER=17.06.2-ce \
      -v /var/run/docker.sock:/var/run/docker.sock \
      -v /tmp/videos:/home/seluser/videos \
      --privileged dosel/zalenium start

// Maven commands
mvn clean
mvn install
mvn verify

// Allure commands
brew install allure
allure generate allure-results --clean -o allure-report && allure open ./allure-report/

// Hub
http://localhost:4444/grid/console
http://localhost:4444/grid/admin/live
http://localhost:4444/dashboard/#
