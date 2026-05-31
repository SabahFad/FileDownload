# File Download Simulator
**CSCI 2108 – Programming III Lab**  
Islamic University of Gaza  
Instructor: Aya N. Alharazin

---

## Project Structure

```
FileDownloadSimulator/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   ├── module-info.java
        │   └── com/download/
        │       ├── MainApp.java          ← JavaFX entry point
        │       ├── MainController.java   ← FXML controller (starts threads)
        │       └── DownloadTask.java     ← Runnable for each file thread
        └── resources/
            └── com/download/
                ├── main.fxml             ← Scene Builder layout
                └── styles.css            ← Dark theme styling
```

---

## How It Works

| Class | Role |
|---|---|
| `MainApp` | Launches the JavaFX stage, loads FXML |
| `MainController` | Handles button actions, creates 3 individual `Thread` objects |
| `DownloadTask` | `Runnable` that loops 0→100, updates `ProgressBar` via `Platform.runLater()` |

- Each file runs on its **own individual Thread** (no ExecutorService / thread pool)
- UI updates are dispatched safely with `Platform.runLater()`
- Three files download **simultaneously** at different speeds

---

## How to Run

### Option 1 – IntelliJ IDEA (Recommended)
1. Open IntelliJ → **File → Open** → select the `FileDownloadSimulator` folder
2. IntelliJ detects `pom.xml` and imports Maven dependencies automatically
3. Run `MainApp.java`

### Option 2 – Maven CLI
```bash
mvn javafx:run
```

### Requirements
- JDK 17 or higher
- JavaFX 21 (pulled automatically by Maven)

---

## Opening in Scene Builder
1. Open Scene Builder
2. File → Open → navigate to `src/main/resources/com/download/main.fxml`
3. The layout will load with all components visible

---

## Features
- ✅ 3 simultaneous file downloads
- ✅ Individual `Thread` per file (no thread pool)
- ✅ Progress bars updating in real time
- ✅ Status labels: Waiting → Downloading → ✔ Complete
- ✅ Percentage counter per file
- ✅ Start / Reset buttons
- ✅ Dark modern UI with colored progress bars
