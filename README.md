# Selenium Test Automation Framework for ElastiqAI Assignment

A test automation framework built with Selenium WebDriver, TestNG, Log4j2 and Extent Reports for web application testing.

## 🛠 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Extent Reports
- Log4j
- WebDriverManager

## 📋 Prerequisites

- Java JDK 8 or higher
- Maven
- Chrome/Edge browser installed

## 🚀 Getting Started

### 1. Clone the repository
```bash
git clone <repository-url>
```

### 2. Configure the test environment
Update the `config/config.properties` file with your test configuration:
```properties
URL=https://www.lambdatest.com/selenium-playground/table-sort-search-demo
browser=chrome
```

### 3. Run the tests
```bash
mvn clean test
```

## 📁 Project Structure

```
├── src
│   ├── main
│   │   └── java
│   │       └── org
│   │           └── elastiqAI
│   │               └── Pages
│   │                   ├── BasePage.java
│   │                   └── TableSortSearchPage.java
│   └── test
│       ├── java
│       │   ├── org
│       │   │   └── elasticAI
│       │   │       ├── BaseTest.java
│       │   │       └── TableSortSearchTest.java
│       │   └── utils
│       │       ├── ExtentListener.java
│       │       └── ExtentReportManager.java
│       └── resources
│           └── log4j2.xml
├── config
│   └── config.properties
├── logs
│   └── automation.log
├── test-output
│   ├── screenshots
│   └── ExtentReport.html
├── pom.xml
├── testng.xml
└── README.md
```

The project follows a standard Maven structure:
- `src/main/java`: Contains core framework classes
  - `Pages/`: Page Object Model classes
    - `BasePage.java`: Base page with common web element operations
    - `TableSortSearchPage.java`: Page object for table sort/search functionality
- `src/test/java`: Contains test classes and utilities
  - `BaseTest.java`: Base test class with common setup and teardown
  - `TableSortSearchTest.java`: Test cases for table sorting and searching
  - `utils/`: Test utility classes
    - `ExtentListener.java`: TestNG listener for Extent reporting
    - `ExtentReportManager.java`: Extent Reports configuration
- `src/test/resources`: Contains configuration files
  - `log4j2.xml`: Logging configuration
- `config/`: Test configuration files
- `logs/`: Test execution logs
- `test-output/`: Generated test reports and screenshots

## ⚙️ Framework Features

- **Base Test Setup**: Automated WebDriver initialization and cleanup
- **Configuration Management**: External configuration through properties file
- **Reporting**: 
  - Extent Reports for detailed test execution reports
  - Log4j integration for logging
- **Cross-Browser Testing**: Support for Chrome and Edge browsers
- **WebDriver Management**: Automated driver setup using WebDriverManager

## 📊 Test Reports

- Extent Reports are generated after test execution
- Logs are generated using Log4j

## 🤝 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 👥 Authors

- Your Name - *Rohit Prasad*

## 🙏 Acknowledgments

- [Selenium](https://www.selenium.dev/)
- [TestNG](https://testng.org/)
- [Extent Reports](https://www.extentreports.com/)
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)
```

This README provides:
1. A clear overview of the project
2. The technology stack used
3. Setup instructions
4. Project structure
5. Framework features
6. Information about reports
7. Contributing guidelines
8. Author information
9. Acknowledgments
