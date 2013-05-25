
package org.dummi.secretninja;

import java.io.IOException;

public class Utils {

    //
    // private final static String DEFAULT_SHELL = "/system/bin/sh";
    //
    // private final static String ALTERNATIVE_ROOT = "/system/xbin/su";

    private final static String DEFAULT_ROOT = "/system/bin/su";

    public static void startService() {
        // TODO: replace whoami to start service
        String[] prog = {
                DEFAULT_ROOT, "--preserve-environment", "-c", "/system/bin/whoami"
        };
        try {
            Runtime.getRuntime().exec(prog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stopService() {
        // TODO: replace whoami to stop service
        String[] prog = {
                DEFAULT_ROOT, "--preserve-environment", "-c", "/system/bin/whoami"
        };
        try {
            Runtime.getRuntime().exec(prog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
