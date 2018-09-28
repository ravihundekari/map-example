package com.ravi.mapexample.util;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;

import com.ravi.mapexample.R;

public class DialogUtil {
    private static Dialog dialog;

    public static void showErrorDialog(Context context, String errorMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialogStyle);
        builder.setTitle(Constants.ERROR);
        builder.setMessage(errorMessage);
        AlertDialog alertDialog = builder.create();
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, Constants.OK, (dialogInterface, i) -> alertDialog.dismiss());
        alertDialog.show();
    }

    public static void showLoadingDialog(Context context, String text) {
        dialog = new Dialog(context, R.style.Theme_FullScreenDialog);
        dialog.setContentView(R.layout.dialog_loading);
        ((TextView) dialog.findViewById(R.id.tv_loading)).setText(text);
        dialog.setCancelable(false);
        dialog.show();
    }

    public static void stopLoadingDialog() {
        if (dialog != null && dialog.isShowing()) dialog.dismiss();
    }

}
