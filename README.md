# Appium Mobile Automation Project

This is a mobile automation project built using **Java**, **TestNG** framework, and the **Page Object Model (POM)** design pattern with **Data-Driven Testing**.  
The project demonstrates automation of common mobile app workflows using **OOPs concepts** in Java.

## 📌 Tech Stack
- **Java** (with Object-Oriented Programming concepts)
- **Appium**
- **TestNG** (for test execution and reporting)
- **Page Object Model** (for maintainable and reusable code)
- **Data-Driven Testing** (for flexible input handling)
- **Extent Reports** (for detailed test execution reports)

## 📝 Automated Test Scenarios

### **TC-01**: Fill and Submit Form
- Open initial form page
- Enter **Name**
- Select **Country** from dropdown
- Select **Gender** via radio button
- Submit form to navigate to the next page

### **TC-02**: Add Products and Validate Cart Total
- Perform steps from **TC-01**
- On the next page:
  - Select **two products**
  - Add them to cart
  - Calculate the sum of selected products
  - Match calculated sum with displayed **total**
  - Proceed to checkout

### **TC-03**: Validate Mandatory Field
- On the form page:
  - Attempt to submit without entering the **Name**
  - Verify that an **error toast message** is displayed

## 📊 Reporting
- Uses **Extent Reports** for visual and detailed test results

## 🚀 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/DilipLohani/Appium_MobileAutomation.git
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA or Eclipse)
3. Install required dependencies via Maven
4. Run tests using:
   ```bash
   mvn test
   
## 📂 Project Structure
src/main/java → Page Objects & Utilities

src/test/java → Test Cases

testng.xml → TestNG Suite Configuration

reports/ → Extent Report output
