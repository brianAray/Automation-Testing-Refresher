# Steps to Follow

1. Create a Maven Project
2. Add Maven Dependencies:
   - ```xml
         <dependencies>
        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.10.0</version>
        </dependency>
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.4.1</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.10.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.platform</groupId>
            <artifactId>junit-platform-suite</artifactId>
            <version>1.10.0</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.13.0</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit-platform-engine -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit-platform-engine</artifactId>
            <version>7.13.0</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/ch.qos.logback/logback-classic -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.4.5</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
3. Create a folder "Features" under src/test/resources
4. Under features folder create a new feature file, with extension `.feature`
5. Download the Cucumber plugin for your IDE
6. Add contents to the feature file
7. Run it using the cucumber plugin
8. Add the Step Definitions in src/test/java
9. Add the glue code in src/test/java
   - ```java
     @Suite
     @IncludeEngines("cucumber")
     @SelectClasspathResource("src/test/resources/Features")
     @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.example.StepDefinition")
     public class CucumberTest {
     }