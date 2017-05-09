package com.Quang.Tin.homework05;

import android.view.View;

/**
 * Created by Quang on 4/27/17.
 */

public interface ClickListener {
    public abstract void onClick(View view, int position);

    public abstract void onLongClick(View view, int position);
}
