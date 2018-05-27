package org.gdpr.demo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.gdprcmplib.CmpActivityResult;
import org.gdprcmplib.GdprCmp;

public class MainActivityJava extends AppCompatActivity {
    static final int REQ_CODE = 10;
    Button copyToClipboard;
    ToggleButton toggleButton;
    TextView isSubjectToGDPR;
    TextView consentString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = findViewById(R.id.toggle_gdpr);
        isSubjectToGDPR = findViewById(R.id.subject_to_gdpr);
        consentString = findViewById(R.id.consent_string);
        copyToClipboard = findViewById(R.id.copy_to_clipboard);
    }

    private void updateUI() {
        if (GdprCmp.isSubjectToGDPR(this)) {
            isSubjectToGDPR.setText(R.string.is_subject_to_gdpr);
            toggleButton.setChecked(true);
        } else {
            isSubjectToGDPR.setText(R.string.is_not_subject_to_gdpr);
            toggleButton.setChecked(false);
        }
        if (GdprCmp.hasGDPRConsentString(this)) {
            copyToClipboard.setVisibility(View.VISIBLE);
            consentString.setText(GdprCmp.getGDPRConsentString(this));
        } else {
            copyToClipboard.setVisibility(View.GONE);
            consentString.setText(R.string.consent_string_not_set);
        }
    }

    public void onPrivacySettings(View view) {
        GdprCmp.startCmpActivityForResult(this, REQ_CODE, true, true);
    }

    public void onToggleGDPR(View view) {
        GdprCmp.setIsSubjectToGDPR(this,toggleButton.isChecked());
        updateUI();
    }

    public void onCopyToClipboard(View view) {
        ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        // Creates a new text clip to put on the clipboard
        ClipData clip = ClipData.newPlainText("simple text", ""+consentString.getText());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this, R.string.copied_to_clipboard, Toast.LENGTH_SHORT).show();
    }

    public void onClearSettings(View view) {
        GdprCmp.clearGDPRSettings(this);
        Toast.makeText(this, R.string.settings_cleared, Toast.LENGTH_SHORT).show();
        updateUI();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE) {
            if (resultCode == CmpActivityResult.RESULT_CONSENT_ALL) {
                Log.i("MainActivity","CmpActivityResult.RESULT_CONSENT_ALL");
            } else if (resultCode == CmpActivityResult.RESULT_CONSENT_CUSTOM_PARTIAL) {
                Log.i("MainActivity","CmpActivityResult.RESULT_CONSENT_CUSTOM_PARTIAL");
            } else if (resultCode == CmpActivityResult.RESULT_CONSENT_NONE) {
                Log.i("MainActivity","CmpActivityResult.RESULT_CONSENT_NONE");
            } else if (resultCode == CmpActivityResult.RESULT_CANCELED_CONSENT) {
                Log.i("MainActivity","CmpActivityResult.RESULT_CANCELED_CONSENT");
            } else if (resultCode == CmpActivityResult.RESULT_COULD_NOT_FETCH_VENDOR_LIST) {
                Log.i("MainActivity","CmpActivityResult.RESULT_COULD_NOT_FETCH_VENDOR_LIST");
            } else if (resultCode == CmpActivityResult.RESULT_FAILED_TO_WRITE_CONSENT_STRING) {
                Log.i("MainActivity","CmpActivityResult.RESULT_FAILED_TO_WRITE_CONSENT_STRING");
            }
            updateUI();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
