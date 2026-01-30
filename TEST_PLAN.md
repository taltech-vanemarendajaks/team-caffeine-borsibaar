## **Introduction**  
### **Project Overview**  
Börsibaar is a full-stack web application designed to support stock bar–themed events by providing dynamic drink pricing and transaction-based inventory management. The system combines a Spring Boot backend with a modern Next.js frontend to deliver both operational tools for event organizers and a public-facing interface for customers.  
The application enables users to manage drink inventory, record sales transactions, and automatically adjust prices based on activity, creating an experience similar to a real stock market. In addition, Börsibaar includes a public price board where participants can view current drink prices in real time, enhancing engagement during events.

### **Testing Focus and Business Risks**

Testing is essential to ensure the correctness and reliability of Börsibaar’s core business workflows. The most critical risks that must be mitigated through testing include:

* Dynamic pricing logic failures, which could result in incorrect or inconsistent drink price fluctuations  
* Inventory and transaction integrity issues, such as inaccurate stock levels or missing sales records  
* Authentication and authorization defects, potentially allowing unauthorized access to administrative functionality  
* Frontend–backend integration problems, which could prevent real-time price updates or disrupt user workflows  
* Data consistency and migration errors, especially when deploying new versions with Liquibase-managed schema changes

This test plan outlines the strategy and scope for validating Börsibaar across all layers of the system, ensuring stable operation, accurate pricing behavior, and a secure user experience before deployment.  

## **Börsibaar – Test Plan**

## **1\. Testing Objectives**

* Verify that all core features of the Börsibaar application function correctly across backend, frontend, and database layers.  
* Ensure that inventory management, transaction tracking, and price‑fluctuation logic behave as expected.  
* Validate that the public “stock‑market‑style” drink price page displays accurate, real‑time data.  
* Detect defects early and prevent regressions during development.  
* Confirm that integrations between Spring Boot backend, PostgreSQL, and Next.js frontend operate reliably.  
* Provide confidence that the system is stable and ready for deployment.

   
## **2\. Testing Levels**  
### **Unit Testing**

* Performed by developers.  
* Covers individual backend services, controllers, repositories, and frontend components.  
* Tools: JUnit (backend), Jest/React Testing Library (frontend).

   
### **Integration Testing**

* Validates interactions between backend modules (e.g., service, repository,  database).  
* Tests API endpoints and data flow between frontend and backend.  
* Includes OAuth2 login flow and JWT token handling.

   
### **System Testing**

* Tests the entire application end‑to‑end in a test environment.  
* Covers user flows such as:  
  * Logging in  
  * Viewing inventory  
  * Creating transactions  
  * Updating drink prices  
  * Viewing public price board

   
### **Acceptance Testing**

* Ensures the system meets business requirements.  
* Executed by the team or product owner.  
* Focuses on real‑world usage scenarios during stock‑bar events.

   
## **3\. Test Scope**  
**In Scope**

* Authentication and authorization (OAuth2 login, JWT validation).  
* Inventory CRUD operations.  
* Transaction creation and history.  
* Price calculation and dynamic price updates.  
* Public drink price board.  
* API communication between frontend and backend.  
* Database migrations via Liquibase.

   
**Out of Scope**

* Third‑party OAuth provider reliability.  
* Performance and load testing (unless explicitly required).  
* Penetration testing or advanced security audits.

   
## **4\. Test Approach**  
### **4.1 Functional Testing**

* Combination of manual and automated testing.  
* Critical backend logic covered by automated unit and integration tests.  
  * config  
    * JwtAuthenticationFilterTest

  * controller  
    * AccountControllerTest  
    * AuthControllerTest  
    * BarStationControllerTest  
    * CategoryControllerTest  
    * InventoryControllerTest  
    * OrganizationControllerTest  
    * ProductControllerTest  
    * SalesControllerTest  
    * UserControllerTest

  * service  
    * AuthServiceTest  
    * BarStationServiceTest  
    * CategoryServiceTest  
    * InventoryServiceTest  
    * JwtServiceTest  
    * OrganizationServiceTest  
    * ProductServiceTest  
    * SalesServiceTest

* Frontend UI tested with component tests and manual exploratory testing.  
* End‑to‑end tests executed in a test environment to simulate production.  
* Black‑box testing for user‑facing features.  
* Each pull request must pass automated tests before merging.

### **4.2. Non‑Functional Testing**

#### **4.2.1 Basic Security Testing**

Validates that the application protects data and prevents unauthorized access.

Scope:

* OAuth2 authentication flow  
* JWT validation and expiration handling  
* Role‑based access control (admin vs. regular user)  
* Input validation to prevent SQL injection, XSS, CSRF  
* Secure storage of sensitive data in PostgreSQL

#### **4.2.2 Usability Testing**

Ensures the application is intuitive and easy to use.

Scope:

* Clarity of UI components (Shadcn UI)  
* Navigation flow in the Next.js frontend  
* Accessibility considerations (contrast, keyboard navigation)  
* Ease of understanding the public price board

#### **4.2.3 Compatibility Testing**

Checks that the system works across different environments.

Scope:

* Browsers: Chrome, Firefox  
* Devices: desktop, laptop, tablet  
* Operating systems: Windows 11, Linux (CI environment)  
* Docker‑based development environment consistency

#### **4.2.4 Reliability & Stability Testing**

Ensures the system runs consistently over time without failures.

Scope:

* Long‑running backend service stability  
* Database connection reliability  
* Price update scheduler consistency

#### **4.2.5 Scalability Testing**

Evaluates the system’s ability to grow with increased demand.

Scope:

* Adding more concurrent users  
* Increasing inventory size  
* Handling larger transaction histories  
* The system scales horizontally or vertically without major redesign.

   
## **5\. Test Environment**

* **Backend:** Spring Boot 3.5.5 running in Docker.  
* **Frontend:** Next.js dev server or Docker container.  
* **Database:** PostgreSQL test instance with Liquibase migrations applied.  
* **Authentication:** OAuth2 provider (test credentials).  
* **Browsers:** Chrome, Firefox.  
* **OS:** Windows 11 (local), Linux (CI).  
* **CI/CD:** GitHub Actions for automated test execution.

   
## **6\. Entry Criteria**

* User stories or requirements are defined and covered by testers.  
* Code for the feature is implemented and builds successfully.  
* Test environment is available.  
* Dependencies (database, OAuth provider) are running.  
* No open blockers.

   
## **7\. Exit Criteria**

* All planned test cases executed.  
* All critical and high‑severity defects resolved.  
* No open blockers or unresolved regressions.  
* Test report completed.  
* Product owner accepts the feature.

   
## **8\. Roles and Responsibilities**


| Role | Responsibilities |
| :---- | :---- |
| Developers | Write unit tests, fix defects, support integration testing |
| QA Team Lead | Approve test plan, prioritize defects, coordinate testing |
| Tester | Execute test cases, report defects, debug defects |
| Product Owner | Write system requirements, validate acceptance criteria, approve releases |
| Stakeholders | Provide input on user needs, create non-system requirements |

## **9\. Risks and Assumptions**  
   
**Risks**

* External OAuth provider downtime may block login tests.  
* Liquibase migration errors may break test environments.  
* Dynamic pricing logic may produce inconsistent results if test data is unstable.  
* Test environment differences may cause inconsistent behavior.

   
**Assumptions**

* All team members follow the Git workflow and code review process.  
* Test data is stable and reproducible.  
* Test environment mirrors production closely enough for reliable results.  
* Requirements remain stable during the testing cycle.

   
## **10\. Test Deliverables**

* Test Plan (this document)  
* Test Cases / Test Scenarios  
* Test Execution Report  
* Bug Reports  
* Automated Test Logs (JUnit, Jest)  
* Release Test Summary