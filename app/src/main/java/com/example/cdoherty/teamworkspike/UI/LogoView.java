package com.example.cdoherty.teamworkspike.UI;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.cdoherty.teamworkspike.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by cdoherty on 31/12/2017.
 * Object to set the logo url received in the API
 */

public class LogoView extends LinearLayout {
    public static final String TAG = LogoView.class.getSimpleName();
    private CircleImageView imageView;
    private String url;
    private Context ctx;

    public LogoView(Context context) {
        super(context);
        ctx = context;
        setViews();
    }

    public LogoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
        setViews();
    }

    public LogoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ctx = context;
        setViews();
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * If there is a valid url within the json object set the imageview using the Picasso library
     * Otherwise set the imageview with the default drawable
     */
    public void setImageView() {
        if (url != null && url.length() > 0) {
            Picasso.with(ctx).load(url).into(imageView);
        } else {
            Log.d(TAG, "setImageView: ");
            imageView.setImageResource(R.drawable.folder);
        }
    }

    /**
     * Setup the logo view
     */
    private void setViews() {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.project_logo, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        imageView = findViewById(R.id.logo_image_view);
    }
}
