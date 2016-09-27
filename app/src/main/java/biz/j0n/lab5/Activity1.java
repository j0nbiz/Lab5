package biz.j0n.lab5;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Activity1 extends AppCompatActivity {
    private final int REQ_ACT2 = 1;
    private final int REQ_ACT3 = 2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        result = (TextView) findViewById(R.id.lbl_result);
    }

    protected void onActivityResult(int request, int result, Intent i) {

        switch (result) {
            case RESULT_OK:
                updateUI(request, i);
                break;
            case RESULT_CANCELED:
            default:
                this.result.setText(R.string.err_cancel);
                this.result.setTextColor(Color.RED);
        }
    }

    public void launchAct2(View view) {
        Intent i = new Intent(this, Activity2.class);

        startActivityForResult(i, REQ_ACT2);
    }

    public void launchAct3(View view) {
        Intent i = new Intent(this, Activity3.class);

        startActivityForResult(i, REQ_ACT3);
    }

    public void showMap(View v) {
        Uri geoLocation = Uri.parse("geo:0,0?q=");

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showWeb(View v) {
        Uri webBrowser = Uri.parse("http://www.google.com");

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(webBrowser);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    void updateUI(int request, Intent i) {
        String data;
        if (i == null) {
            result.setText(R.string.err_missing_intent);
        } else {
            switch (request) {
                case REQ_ACT2:
                    if (i.hasExtra("ACT2")) {
                        data = i.getExtras().getString("ACT2");
                        Log.d("DATA", data);
                        if (data == null)
                            result.setText(R.string.err_missing_data);
                        else
                            result.setText(data);
                    } else {
                        result.setText(R.string.err_missing_extra);
                    }
                    break;
                case REQ_ACT3:
                    if (i.hasExtra("ACT3")) {
                        data = i.getExtras().getString("ACT3");
                        Log.d("DATA", data);
                        if (data == null)
                            result.setText(R.string.err_missing_data);
                        else
                            result.setText(data);
                    } else {
                        result.setText(R.string.err_missing_extra);
                    }
                    break;
                default:
                    result.setText(R.string.err_unknown_req);
            }
        }
    }
}
