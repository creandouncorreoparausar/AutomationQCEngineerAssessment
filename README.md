

# Automation QC Engineer Assessment

This repository contains the solutions for the Automation QC Engineer Assessment. The assessment is divided into two parts:
- **Main Task**: Automated UI testing of OrangeHRM using Selenium with Cucumber and the Page Object Model (POM) design pattern.
- **Bonus Task**: API automation for adding and deleting candidates using Rest Assured.

---

## Technologies Used
- **Java**: The programming language used for both tasks.
- **Selenium**: Web automation tool for the main task.
- **Cucumber**: BDD framework for the main task, enabling the use of feature files.
- **Rest Assured**: API automation tool for the bonus task.
- **Maven**: Build management tool for dependency management and test execution.

---

## Project Structure
Below is an overview of the project folder structure:

---

## Main Task: UI Automation with Selenium and Cucumber
**Objective**: Automate the following workflow on OrangeHRM:
1. Navigate to the [OrangeHRM login page](https://opensource-demo.orangehrmlive.com/).
2. Log in using:
   - **Username**: Admin
   - **Password**: admin123
3. Navigate to the "Admin" tab.
4. Get the number of records.
5. Add a new user with:
   - **User Role**: Admin
   - **Employee Name**: Ranga Akunuri
   - **Status**: Enabled
   - **Username**: asmaa
   - **Password**: Test@123
6. Verify the record count has increased by 1.
7. Search for the new user and delete it.
8. Verify the record count has decreased by 1.

**Highlights**:
- Implements the Page Object Model (POM) for maintainable and reusable code.
- Uses feature files for behavior-driven development (BDD) with Cucumber.

---

## Bonus Task: API Automation with Rest Assured
**Objective**:
- Automate the process of adding and deleting candidates via the OrangeHRM API.

### API Workflow
1. **Add Candidate**:
   - Endpoint: `/web/index.php/admin/saveSystemUser`
   - Payload:
     ```json
     {
       "userRole": "Admin",
       "employeeName": "Ranga Akunuri",
       "status": "Enabled",
       "username": "asmaatask",
       "password": "asmaa123",
       "confirmPassword": "asmaa123"
     }
     ```

2. **Delete Candidate**:
   - Endpoint: `/web/index.php/admin/saveSystemUser`
   - Query Parameter: `username=asmaatask`

### Test Files
- `AddUserTest.java`: Automates adding a user via the API.
- `DeleteUserTest.java`: Automates deleting the user by username.

---

## How to Run
1. **Clone the repository**:
   ```bash
   git clone https://github.com/creandouncorreoparausar/AutomationQCEngineerAssessment.git
2. Build the project:
Navigate to the project folder and run:
mvn clean install
3. Run the Selenium Tests:
Execute the TestRunner.java to run Cucumber tests for the main task.
4. Run the API Tests:
Use your IDE's test runner or Maven to run AddUserTest.java and DeleteUserTest.java.

Notes:
- The project adheres to best practices for maintainability and design (e.g., POM for Selenium).
- The repository includes both the feature files and the test files for easy execution.
