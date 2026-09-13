# PsychTests

Android app providing validated psychological screening tests in English, French, and Spanish. Results are stored locally on-device; the architecture supports a future cloud/accounts layer without refactoring.

## Tests Included

All 12 tests are validated instruments. Test content is kept in its original validated language and is never translated; only the app UI is localized.

| Test | Full Name | What It Measures | Languages |
|------|-----------|-----------------|-----------|
| PHQ-9 | Patient Health Questionnaire | Severity of depressive symptoms (past 2 weeks) | EN, FR, ES |
| GAD-7 | Generalized Anxiety Disorder Scale | Severity of generalized anxiety symptoms (past 2 weeks) | EN, FR, ES |
| WHO-5 | WHO-5 Well-Being Index | Subjective well-being (past 2 weeks) | EN, FR, ES |
| HADS | Hospital Anxiety and Depression Scale | Anxiety (HADS-A) and depression (HADS-D) symptoms (past week) | EN, FR, ES |
| PCL-5 | PTSD Checklist for DSM-5 | Posttraumatic stress disorder symptoms | EN, FR, ES |
| PSS-10 | Perceived Stress Scale | Degree to which situations are appraised as stressful (past month) | EN, FR, ES |
| DASS-21 | Depression Anxiety Stress Scales | Simultaneous assessment of depression, anxiety, and stress | EN, FR, ES |
| EPDS | Edinburgh Postnatal Depression Scale | Postpartum and perinatal depression symptoms | EN, FR, ES |
| AUDIT | Alcohol Use Disorders Identification Test | Hazardous and harmful drinking patterns | EN, FR, ES |
| SCOFF | SCOFF Eating Disorder Questionnaire | Eating disorders | EN, FR, ES |
| ACE | Adverse Childhood Experiences Questionnaire | Childhood trauma and adversity (before age 18) | EN, FR, ES |
| SWLS | Satisfaction With Life Scale | Global cognitive judgments of life satisfaction | EN, FR, ES |

## Architecture

- **Kotlin + Jetpack Compose** for the UI layer
- **MVVM** with ViewModel, Repository, and DAO separation
- **Hilt** for dependency injection
- **Room** for local persistence (test results, user preferences)
- **kotlinx-serialization** for test content serialization
- **kotlinx-datetime** for timestamps
- **KSP** for annotation processing (Room, Hilt)
- **Local-only results** — architecture (Repository/DAO/viewmodels) is structured so a future cloud/accounts/pro web layer can be added without refactoring

## Building

### Prerequisites

- JDK 17
- Android SDK with:
  - `platforms;android-34`
  - `build-tools;34.0.0`

### Commands

```bash
# Set up environment (adjust paths as needed)
export JAVA_HOME=/path/to/jdk
export ANDROID_HOME=/path/to/android-sdk

# Build debug APK
./gradlew :app:assembleDebug

# Run unit tests
./gradlew :app:testDebugUnitTest

# Full build (compile + lint + test)
./gradlew :app:build

# Clean
./gradlew clean
```

### APK Output

The debug APK is located at:

```
PsychTests/app/build/outputs/apk/debug/app-debug.apk
```

## Project Structure

```
PsychTests/
├── app/
│   ├── build.gradle.kts                          # App-level build config
│   └── src/
│       ├── main/java/com/psychtests/
│       │   ├── data/
│       │   │   ├── content/
│       │   │   │   ├── TestCatalog.kt            # Aggregates all 12 tests
│       │   │   │   ├── Phq9Test.kt               # PHQ-9 content
│       │   │   │   ├── Gad7Test.kt               # GAD-7 content
│       │   │   │   ├── Who5Test.kt               # WHO-5 content
│       │   │   │   ├── HadsTest.kt               # HADS content
│       │   │   │   ├── Pcl5Test.kt               # PCL-5 content
│       │   │   │   ├── Pss10Test.kt              # PSS-10 content
│       │   │   │   ├── Dass21Test.kt             # DASS-21 content
│       │   │   │   ├── EpdsTest.kt               # EPDS content
│       │   │   │   ├── AuditTest.kt              # AUDIT content
│       │   │   │   ├── ScoffTest.kt              # SCOFF content
│       │   │   │   ├── AceTest.kt                # ACE content
│       │   │   │   └── SwlsTest.kt               # SWLS content
│       │   │   ├── model/
│       │   │   │   └── TestModels.kt             # Domain models (Test, Question, AnswerOption, etc.)
│       │   │   └── repository/
│       │   │       └── TestRepository.kt         # Persistence + logic entry point
│       │   ├── ui/                                # Compose screens & navigation
│       │   └── util/
│       │       └── ScoringEngine.kt              # Scoring, reverse scoring, subscales
│       └── test/java/com/psychtests/util/
│           └── ScoringEngineTest.kt              # Unit tests for scoring
├── build.gradle.kts                              # Root build config
├── settings.gradle.kts
├── gradle.properties
└── gradlew                                       # Gradle wrapper
```

## Disclaimer

This app is for **screening purposes only** and does not provide a medical diagnosis. Scores should be interpreted by a qualified healthcare professional. If you are experiencing distress or having thoughts of self-harm, please contact emergency services or a mental health professional immediately.

## License

MIT License
