package com.nobo.apkforwarder;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Capture the APK file data from the intent
        Intent intent = getIntent();
        Uri apkUri = intent.getData();

        if (apkUri != null) {
            // Create the forwarding intent to the system installer
            Intent forwardIntent = new Intent(Intent.ACTION_VIEW);
            forwardIntent.setDataAndType(apkUri, "application/vnd.android.package-archive");
            
            // Flags to ensure it works on modern Android (11+)
            forwardIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            forwardIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            try {
                startActivity(forwardIntent);
            } catch (Exception e) {
                // If it fails, we just let it die quietly
            }
        }

        // Kill the activity immediately so no UI stays on screen
        finish();
    }
}
