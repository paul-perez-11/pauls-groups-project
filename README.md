# Calista Real Estate and Acquisition Management System (CREAMS)

A project in Object-oriented Programming (CSS122P) developed for the School of Information Technology at Mapúa University. 

**Team Members:**
* Euan Gerard A. Ridulme
* Brent T. Victorio
* Darrell Abdiel M. Capa
* Paul Joel D. Perez
* Yousef B. Alnamarneh

## Project Context
CREAMS is a Java Swing-based desktop application engineered to process complex lot inventories, buyer specifications, and financial conditions for residential developments like Sabella Village in General Trias, Cavite. The system centralizes data to prevent administrative bottlenecks and double-selling.

## Prerequisites
* **Java Development Kit (JDK):** Version 8 or higher.
* **IDE:** Apache NetBeans (Required for `.form` GUI builder files).
* **Dependencies:** iText7 (PDF generation) and SLF4J (pre-packaged in `src/jarLib`).

## Installation & Setup
1. Extract the repository ZIP file.
2. Open **Apache NetBeans**.
3. Navigate to `File` > `Open Project`.
4. Select the `Paul's Group's Project` directory.
5. Ensure the libraries in `src/jarLib` are correctly mapped in your project properties.

## Running the Application
1. In NetBeans, right-click the project root and select **Run** (or press `F6`).
2. The application initializes via the `gui.StartingPage` main class.
3. Default `.csv` databases generate automatically in the `Mock Data For Later` directory upon first boot.

## Default Access & Roles
Create new accounts directly from the Starting Page via the **Register** button.

| Role | Access Level | Responsibilities |
| :--- | :--- | :--- |
| **Admin** | Global | Lot status overrides, global finance configuration (12 parameters), global report generation. |
| **Agent** | Block-Specific | Lot management, transaction approval/rejection, agent-specific reporting. |
| **Buyer** | Client | Lot browsing, transaction history viewing, purchase/reservation requests. |

## Core Features
* **Polymorphic User Management:** Unified authentication mapping across three user roles.
* **Dynamic Amortization Calculator:** Real-time computation of Net Disposable Income (NDI) and amortizations based on dynamic Admin rates (Bank, Pag-IBIG, In-House).
* **CSV Database Integration:** Persistent local storage without an external SQL server.
* **Audit Logging:** Automated tracking of system mutations mapped by user roles.
* **Report Generation:** Automated compilation of transaction data exported to `.txt`, `.csv`, and `.pdf`.
