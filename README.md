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

## 5. GitHub & GitHub Actions
*   **GitHub:** The full Kotlin source is version controlled in this repository with regular commits and pushes (no zip or file uploads). The final submission is tagged `Final POE`.
*   **GitHub Actions:** `.github/workflows/android.yml` runs on every push and pull request to `master`. It sets up the JDK and Gradle, runs the unit tests (`./gradlew testDebugUnitTest`), builds the debug APK (`./gradlew assembleDebug`) and uploads it as a build artifact.

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
Add screenshots to `docs/screenshots/` and reference them with relative paths:

![Login Screen](docs/screenshots/login.png)
![Main Screen](docs/screenshots/main.png)
![Settings Screen](docs/screenshots/settings.png)

## 9. Release Notes (Final PoE)
*To be completed for the final submission:* list all updates since the prototype and the innovative features added in this version.

## 10. References
*To be completed:* list any borrowed code or resources using one consistent style (Harvard or IEEE).
