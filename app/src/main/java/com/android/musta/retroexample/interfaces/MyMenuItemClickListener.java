package com.android.musta.retroexample.interfaces;

import android.content.Context;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.android.musta.retroexample.R;

/**
 * Created by musta on 11/27/17.
 */

public class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
    private Context mContext;

    public MyMenuItemClickListener(Context context) {
        this.mContext = context;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_favorite: {
                Toast.makeText(mContext, "Add to fav", Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.action_remove_favorite: {
                Toast.makeText(mContext, "Remove from fav", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }
}
