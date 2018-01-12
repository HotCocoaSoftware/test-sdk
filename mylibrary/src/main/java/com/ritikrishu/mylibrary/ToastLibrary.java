package com.ritikrishu.mylibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ritikrishu on 12/01/18.
 */

public class ToastLibrary {
    public static void builder(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
