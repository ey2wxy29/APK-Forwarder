# APK Forwarder

A minimal Android application that captures APK file intents and forwards them to the system package installer.

## Features

- **No UI**: The app runs silently without displaying any user interface
- **Intent Capturing**: Intercepts intents for APK files with the highest priority (999)
- **Automatic Forwarding**: Routes APK installations to the system installer
- **Modern Android Support**: Compatible with Android 5.0+ (API level 21+) through Android 14+

## Package Name

`com.nobo.apkforwarder`

## Requirements

- Android SDK 21 (Minimum)
- Android SDK 34 (Target/Compile)
- JDK 11 or higher

## Building

### Local Build

```bash
./gradlew assembleDebug
```

The debug APK will be generated at `app/build/outputs/apk/debug/app-debug.apk`

### Automatic Builds

Pushes to the repository automatically trigger GitHub Actions, which builds the debug APK and uploads it as an artifact.

## Permissions

The app requests the following permission:

- `android.permission.REQUEST_INSTALL_PACKAGES` - Required to forward APK installations to the system installer

## How It Works

1. The app registers for APK MIME type intents with the highest priority
2. When an APK file is opened/shared with the app, `MainActivity` is triggered
3. The intent data is extracted and a new intent is created for the system installer
4. The APK installation is forwarded to the system package manager
5. The activity finishes immediately without showing any UI
