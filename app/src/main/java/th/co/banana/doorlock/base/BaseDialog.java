package th.co.banana.doorlock.base;

import android.content.Context;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseDialog {
    private final Context context;
    private final ViewGroup parent;
    private AlertDialog dialog;
    private int themeResId;
    private boolean changeTheme;
    private int dialogLayout;

    public BaseDialog(Context context) {
        this(context, null);
    }

    public BaseDialog(Context context, ViewGroup parent) {
        this.context = context;
        this.parent = parent;
    }

    public Context getContext() {
        return context;
    }

    private AlertDialog.Builder returnDialog() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View baseDialog = inflater.inflate(getDialogLayout(), parent, false);

        ButterKnife.bind(this, baseDialog);

        if (changeTheme) {
            return new AlertDialog.Builder(context, themeResId)
                    .setView(baseDialog)
                    .setCancelable(true);
        } else {
            return new AlertDialog.Builder(context)
                    .setView(baseDialog)
                    .setCancelable(true);
        }
    }

    public void show(){
        dialog = returnDialog().show();
    }

    public void disMiss(){
        dialog.dismiss();
    }

    public void setTheme(@StyleRes int themeResId){
        this.themeResId = themeResId;
        changeTheme = true;
    }

    abstract protected int getDialogLayout();
}
