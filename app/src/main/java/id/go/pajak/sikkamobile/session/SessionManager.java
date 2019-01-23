package id.go.pajak.sikkamobile.session;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by TTKI on 19-Jul-17.
 */

public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int mode = 0;

    private static final String pref_name = "crudpref";
    private static final String is_login = "islogin";
    private static final String nip = "nip";
    private static final String nm_peg = "nmpeg";
}
