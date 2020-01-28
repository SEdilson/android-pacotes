package com.example.aluraviagens.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class DrawableUtil {

    public static Drawable retornaDrawable(Context context, String drawableString) {
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(drawableString,
                "drawable", context.getPackageName());
        return resources.getDrawable(idDrawable);
    }
}
