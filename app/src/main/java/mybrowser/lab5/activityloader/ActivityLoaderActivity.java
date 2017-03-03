package mybrowser.lab5.activityloader;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;

public class ActivityLoaderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        Button makeCall = (Button) findViewById(R.id.call);
        makeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                makeCall();
            }
        });

        Button browse = (Button) findViewById(R.id.browser);
        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openBrowser();
            }
        });
    }

            public void makeCall(){

                String myData = "tel:555-1234";
                Intent myActivity2 = new Intent(Intent.ACTION_DIAL, Uri.parse(myData));

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling

                    return;
                }
                startActivity(myActivity2);

            }

            public void openBrowser(){

                // TODO - Create a base intent for viewing a URL
                // (HINT:  second parameter uses Uri.parse())Uri webpage = Uri.parse("http://www.android.com");
                Uri webpage = Uri.parse("http://www.amazon.com");
                Intent baseIntent = new Intent(Intent.ACTION_VIEW, webpage);

                // TODO - Create a chooser intent, for choosing which Activity
                // will carry out the baseIntent
                // (HINT: Use the Intent class' createChooser() method)
                Intent chooserIntent = Intent.createChooser(baseIntent, "Select App");
                Log.i("Lab-Intents","Chooser Intent Action:" + chooserIntent.getAction());
                startActivity(chooserIntent);

                // TODO - Start the chooser Activity, using the chooser intent
                if (baseIntent.resolveActivity(getPackageManager()) != null) {

                }

            }
}
