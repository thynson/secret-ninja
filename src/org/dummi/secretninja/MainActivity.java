
package org.dummi.secretninja;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class MainActivity extends PreferenceActivity {

    CheckBoxPreference mSwitcher;

    EditTextPreference mServer;

    SharedPreferences mSharedPreferences;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.addPreferencesFromResource(R.xml.preference);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        mSwitcher = (CheckBoxPreference)this.findPreference("status");
        mServer = (EditTextPreference)this.findPreference("server");

        mSwitcher.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Boolean enabled = (Boolean)newValue;
                String server = mSharedPreferences.getString("server", "");

                if (server == "")
                    return false;

                if (enabled)
                    Utils.startService();
                else
                    Utils.stopService();
                return true;
            }
        });

        mServer.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                String server = (String)newValue;
                if (server == null || server == "")
                    return false;

                return true;
            }
        });
    }
}
