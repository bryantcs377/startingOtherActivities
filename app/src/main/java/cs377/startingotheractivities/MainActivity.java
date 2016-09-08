package cs377.startingotheractivities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    protected void sendSMS(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        String input = ((EditText) findViewById(R.id.userInput)).getText().toString();
        intent.putExtra(Intent.EXTRA_TEXT, input);

        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (activities.size() > 0) {
            startActivity(intent);
        }
    };
  /*
    protected void makecall(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        String input = ((EditText) findViewById(R.id.userInput)).getText().toString();
        intent.putExtra(Intent.EXTRA_TEXT, input);

        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (activities.size() > 0) {
            startActivity(intent);
        };
    }
*/


    protected void openWeb(View view) {

        String input = ((EditText) findViewById(R.id.userInput)).getText().toString();

        Uri webpage = Uri.parse(input);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(webIntent,PackageManager.MATCH_DEFAULT_ONLY);
        if (activities.size()>0){
            startActivity(webIntent);
        };

    }


    protected void openMap(View view) {


        String input = ((EditText) findViewById(R.id.userInput)).getText().toString();;
        Uri location = Uri.parse("geo:0,0?q=" + input);
// Or map point based on latitude/longitude
// Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);


        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(mapIntent,PackageManager.MATCH_DEFAULT_ONLY);
        if (activities.size()>0){
            startActivity(mapIntent);
        }

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://cs377.startingotheractivities/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://cs377.startingotheractivities/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
