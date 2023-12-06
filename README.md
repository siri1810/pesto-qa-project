# Maven Project Setup and Execution

## Overview
This project is set up using Maven, a software project management and comprehension tool. Maven can manage a project's build, reporting, and documentation from a central piece of information.

## Prerequisites
- Java JDK 8 or higher installed
- Maven installed (version 3.3 or higher recommended)

## Project Structure
The project follows the standard Maven project structure:
- `src/test/java`: Test source code
- `pom.xml`: Maven Project Object Model file that contains configuration and project metadata

## Setting Up the Project
1. Clone the repository to your local machine.
2. Navigate to the project directory.

## Running Tests
To run the tests, execute the following command in the terminal from the root directory of the project:
```bash
mvn clean test -Dtest=Runner
