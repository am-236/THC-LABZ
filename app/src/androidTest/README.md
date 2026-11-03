# THC LABZ - South African Cannabis Companion

## 1. Project Overview & Purpose
THC LABZ is an Android application designed as a comprehensive companion for cannabis enthusiasts in South Africa. Based on the design principles of leading apps like WeedWise and Leafly, THC LABZ aims to serve as a verified directory of dispensaries, a library for strain reviews, and an educational hub.

**Important Note:** This is an educational platform. No sales are conducted through this app.

## 2. Features
*   **User Authentication:** Secure registration and login using Firebase Authentication (Passwords are encrypted).
*   **REST API Integration:** Fetches live strain data (Name, Type, THC%) from a Cloud Firestore database.
*   **Strain Library:** A RecyclerView displaying detailed strain information.
*   **User Settings:** Allows users to change preferences and logout securely.
*   **Educational Content:** Designed to host 75+ articles (content deferred to final PoE).

## 3. Design Considerations
*   **UI/UX:** The app utilizes Material Design components, a dark theme (mimicking the aesthetics of the provided design examples), and a user-friendly interface. Invalid inputs (e.g., empty login fields) are handled gracefully with `Toast` messages to prevent crashing.
*   **Architecture:** Built using Kotlin, adhering to MVVM (Model-View-ViewModel) principles (simplified for prototype).
*   **Data Handling:** Utilizes Kotlin Coroutines for asynchronous data fetching to ensure a smooth UI.

## 4. Technology Stack
*   **Language:** Kotlin
*   **IDE:** Android Studio
*   **Backend/Database:** Firebase (Authentication & Cloud Firestore)
*   **Networking:** Firebase SDK (RESTful API calls under the hood)
*   **Version Control:** Git & GitHub

## 5. GitHub Actions (Automated Testing)
This repository is configured with GitHub Actions (`.github/workflows/android.yml`). Every push to the `main` branch triggers an automated build and unit test run to ensure code integrity.

## 6. Demo Video
[Link to your Unlisted YouTube Video Here]
*The video demonstrates: User Registration/Login, Password Encryption, Connecting to the REST API to fetch data, and changing User Settings.*

## 7. AI Tool Usage Disclosure
*This section is required by the assignment brief (max 500 words).*
During the development of this prototype, AI tools (specifically ChatGPT) were utilized in the following manner:
*   **Code Generation:** AI was used to generate the boilerplate code for Firebase Authentication and Firestore RecyclerView adapters. This accelerated the development process, allowing focus on UI design and logic flow.
*   **Debugging:** AI assisted in resolving Gradle sync issues and dependency conflicts.
*   **Formatting:** AI was used to format the README file and structure the project documentation.

## 8. Screenshots
*(Insert screenshots of your Login Screen, Main Dashboard, and Settings Screen here)*
<img alt="Login Screen" src="C:\Users\AHHH\Pictures\Screenshots\Screenshot%202026-09-24%20023041.png"/>
<img alt="Main Screen" src="C:\Users\AHHH\Pictures\Screenshots\Screenshot%202026-09-24%20023128.png"/>
<img alt="Settings Screen" src="C:\Users\AHHH\Pictures\Screenshots\Screenshot%202026-09-24%20023236.png"/>