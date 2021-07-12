# Testing Challenge 1

## Software:
- Java 8
- Maven 3.5

## Setup Project and run tests:
mvn clean install<br>
*Note: The first time this command is run it takes some time to complete, subsequent runs are faster.*

## Run test suites:
- mvn verify -Dcucumber.filter.tags="@SearchChallange"
- mvn verify -Dcucumber.filter.tags="@PositiveScenario"
- mvn verify -Dcucumber.filter.tags="@NegativeScenario"

## Cucumber execution report:
The test execution report is available at the location <ProjectDir>/target/cucumber-html-reports/report-feature_file-src-test-resources-features-search-feature.html
