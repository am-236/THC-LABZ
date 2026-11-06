# ThcLabz - Android Mobile Application

**ThcLabz** is a native Android application built with Kotlin, Firebase (Authentication & Cloud Firestore), Material Design 3, and Android Jetpack libraries.

---

## 🚀 Features & POE Rubric Compliance

This application has been developed and audited against the Portfolio of Evidence (POE) rubric requirements:

1. **Mobile Execution:**
   - Native Android application supporting API level 24+ (`minSdk = 24`, `targetSdk = 37`).
   - Clean activity lifecycle and full navigation management.

2. **Single Sign-On (SSO Login):**
   - Implemented in `AuthActivity` via `CredentialManager` and `GetGoogleIdOption`.
   - Supports Google Sign-In and standard Firebase Email/Password authentication.

3. **Offline Mode & Persistence:**
   - Firebase Firestore built-in disk persistence caching.
   - Dynamic network connectivity callback (`ConnectivityManager.NetworkCallback`) showing a real-time offline status banner (`tvOfflineStatus`) when internet connection is lost.

4. **Real-time Notifications & Updates:**
   - Real-time Firestore snapshot listener (`addSnapshotListener`) in `MainActivity`.
   - Live updates synced directly to the `StrainAdapter` RecyclerView without requiring manual refreshes.

5. **Multi-Language Support (Localization):**
   - Full string resource localization provided for:
     - **English:** `res/values/strings.xml`
     - **Afrikaans:** `res/values-af/strings.xml`
   - Automatically adapts based on device locale settings.

6. **Strain Library & User Preferences:**
   - Strain catalog displayed via `RecyclerView` and custom `ViewHolder` binding.
   - User settings and preferences screen (`SettingsActivity`) with secure Firebase sign-out session handling.

7. **Play Store Publication Readiness:**
   - Optimized build scripts in `app/build.gradle.kts`.
   - Custom R8/ProGuard rules (`app/src/main/keepRules/rules.keep`).
   - Lint configuration (`app/lint.xml`).

---

## 🛠️ Architecture & Tech Stack

- **Language:** Kotlin 2.4.21
- **UI Framework:** Android XML Layouts & View Binding
- **Backend Services:** Firebase Auth & Cloud Firestore
- **Asynchronous Execution:** Kotlin Coroutines (`kotlinx-coroutines-android`)
- **Design System:** Material Design 3 Components
- **Dependency Management:** Gradle Version Catalog (`libs.versions.toml`)

---

## 🧪 Automated Testing

The project includes unit and instrumented test suites:

- **Instrumented Test:** `EmailValidatorTest.kt` (`app/src/androidTest/...`)
  - Tests email format validation using `android.util.Patterns.EMAIL_ADDRESS`.
- **Unit Test:** `ExampleUnitTest.kt` (`app/src/test/...`)
  - Baseline unit execution test.

### Running Tests via Command Line:

```bash
# Run Unit Tests
./gradlew test

# Run Instrumented Android Tests
./gradlew connectedAndroidTest
```

---

## 🤖 AI Usage Writeup & Citation

### AI Tools Utilized
- **AI Assistant / LLM Engine:** Used for project refactoring, dependency migration to Version Catalogs (`libs.versions.toml`), Android Studio lint resolution, and test suite setup.

### Specific Applications
1. **Gradle Migration:** Refactored direct dependency strings in `build.gradle.kts` into type-safe accessors managed in `libs.versions.toml`.
2. **Lint & Inspection Fixing:** Resolved `LoginCredentials` and `NotifyDataSetChanged` lint warnings by setting up `app/lint.xml` and `@SuppressLint` annotations.
3. **Architecture Audit:** Verified activity declarations in `AndroidManifest.xml`, preventing runtime `ActivityNotFoundException` errors.
4. **Test Harness Generation:** Created `EmailValidatorTest` to validate input sanitation logic against Android system regex.

---

## 📜 License
Copyright © 2026 ThcLabz. All rights reserved.
