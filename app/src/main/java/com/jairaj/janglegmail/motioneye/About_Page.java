package com.jairaj.janglegmail.motioneye;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import java.util.Objects;

public class About_Page extends AppCompatActivity
{
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__page);

        toolbar = findViewById(R.id.about_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("About");

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Button send_fb = findViewById(R.id.send_feedb);
        Button join_dev = findViewById(R.id.join_dev);
        Button view_steps = findViewById(R.id.button_install_steps);

        TextView app_version = findViewById(R.id.app_version_text);

        TextView credits_showcase = findViewById(R.id.Credit_ShowCase);
        TextView apache_1 = findViewById(R.id.Apache_1);

        TextView apache_2 = findViewById(R.id.Apache_2);

        String appversion = BuildConfig.VERSION_NAME;

        String AppVersion_Text = "App Version: " + appversion;

        app_version.setText(AppVersion_Text);

        send_fb.setText(Html.fromHtml("<a href=\"mailto:systems.sentinel@gmail.com \">Send Feedback</a>"));
        send_fb.setMovementMethod(LinkMovementMethod.getInstance());

        credits_showcase.setText(Html.fromHtml("<a href= 'https://github.com/sjwall/MaterialTapTargetPrompt'> MaterialTapTargetPrompt</a>"));
        credits_showcase.setMovementMethod(LinkMovementMethod.getInstance());

        join_dev.setText(Html.fromHtml("<a href= 'https://github.com/JairajJangle/motionEye_app_HomeSurveillanceSystem'> Be a Dev</a>"));
        join_dev.setMovementMethod(LinkMovementMethod.getInstance());

        apache_1.setText(Html.fromHtml("<a href= 'https://github.com/sjwall/MaterialTapTargetPrompt/blob/master/LICENSE'> Apache License</a>"));
        apache_1.setMovementMethod(LinkMovementMethod.getInstance());

        apache_2.setText(Html.fromHtml("<a href= 'http://www.apache.org/licenses/LICENSE-2.0.txt'> Apache License</a>"));
        apache_2.setMovementMethod(LinkMovementMethod.getInstance());

        view_steps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String motion_eye_steps = "https://github.com/ccrisan/motioneye/wiki/Installation";
                open_in_chrome(motion_eye_steps);
            }
        });
    }

    public void open_in_chrome(String url)
    {
        try
        {
            Intent i = new Intent("android.intent.action.MAIN");
            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
            i.addCategory("android.intent.category.LAUNCHER");
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        catch(ActivityNotFoundException e)
        {
            // Chrome is not installed
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
