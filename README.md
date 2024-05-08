# Automated Mobile App Testing with Kotlin and Appium

This repository contains automated tests written in Kotlin for a mobile application (theScore) using the Appium framework. The tests are set up and executed using IntelliJ IDEA and the Gradle build automation system.

## Environment Setup

Before running the automated tests, make sure to set up the development environment correctly. Follow the instructions below to configure your environment on a macOS system.

### Prerequisites
- [Java](https://www.oracle.com/ca-en/java/technologies/downloads/) (version 15.0.2) installed and environment variables configured.
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) installed.
- [Appium](http://appium.io/) (version 2.5.4) installed and configured.
- [Android Studio](https://developer.android.com/studio) installed and configured to use Android emulator or physical device.

### Project Setup

1. Clone this repository to your local machine.
2. Open the project in IntelliJ IDEA.
3. Install the Gradle dependencies.

## Download APK file
1. Please visit the following link: [APK - v24.7.0](https://drive.google.com/drive/folders/1FALACE0t-vbEyK7STeUPWrzOI60HYDQg?usp=drive_link)
2. Save the file in your preferred directory.
3. In IntelliJ IDEA, navigate to the config.properties.
4. Change the directory of the "apk_file_path" variable to the directory where the APK file was saved on your machine.

## Running the Tests

Before running the tests, ensure that Appium is running and the emulator or physical device is configured correctly. Follow the steps below to run the automated tests:

1. In IntelliJ IDEA, navigate to the SportsAppTest.kt.
2. Right-click on the test file and select "Run".
3. The tests will be executed on the configured emulator or physical device, and the results will be displayed in the IntelliJ console.

_If you prefer, run the './gradlew test' command directly from the terminal within IntelliJ OR from the macOS terminal._

## Test specification

- Please visit the following link: [Test specification](https://docs.google.com/spreadsheets/d/1LHwv5g6DPTJuFOnFn7rIBrgFBC5r9ogD7XhisVv9N00/edit?usp=sharing)

## Contributing

Contributions are welcome! If you find bugs, issues, or have suggestions for improvements, feel free to open an issue or submit a pull request.

