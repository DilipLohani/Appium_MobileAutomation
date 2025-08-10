# 📱 Appium Mobile Automation Project

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-%23FF6F00.svg?style=for-the-badge&logo=testng&logoColor=white)
![Appium](https://img.shields.io/badge/Appium-472A91?style=for-the-badge&logo=appium&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

This project automates mobile app testing using **Java**, **Appium**, and **TestNG** with the **Page Object Model (POM)** design pattern and **Data-Driven Testing**.  
It showcases end-to-end mobile workflows with **OOP concepts** and generates detailed HTML reports using **Extent Reports**.

---

## 📌 Tech Stack
- **Java** (with Object-Oriented Programming concepts)
- **Appium** (Mobile Automation)
- **TestNG** (Test execution & reporting)
- **Page Object Model** (Maintainable test design)
- **Data-Driven Testing** (Flexible input handling)
- **Extent Reports** (Visual reporting)
- **Maven** (Dependency management & build tool)

---

## 📝 Automated Test Scenarios

### **TC-01**: Fill and Submit Form
- Launch app and open form page
- Enter **Name**
- Select **Country** from dropdown
- Select **Gender** via radio button
- Submit form to navigate to next page

### **TC-02**: Add Products and Validate Cart Total
- Perform steps from **TC-01**
- On next page:
  - Select **two products**
  - Add to cart
  - Calculate sum of selected products
  - Compare calculated sum with displayed **total**
  - Proceed to checkout

### **TC-03**: Validate Mandatory Field
- On the form page:
  - Attempt submission without **Name**
  - Verify **error toast message** appears

---

## 📊 Reporting
- Generates **Extent Reports** for each execution
- Reports include:
  - Pass/Fail test status
  - Execution time
  - Screenshots for failures

---

## 🚀 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/DilipLohani/Appium_MobileAutomation.git
2. Open in IntelliJ IDEA or Eclipse
3. Install dependencies via Maven
4. Connect mobile device or start emulator
5. Run tests:
   ```bash
   mvn test
   
---
   
