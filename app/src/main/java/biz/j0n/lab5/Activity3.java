package biz.j0n.lab5;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity3 extends AppCompatActivity {
    private final int REQ_ACT4 = 1;
    private final int REQ_ACT5 = 2;

    private boolean returnHit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    protected void onActivityResult(int request, int result, Intent i) {

        switch (result) {
            case RESULT_OK:
                checkExtras(request, i);
                break;
            case RESULT_CANCELED:
            default:
                this.getIntent().putExtra("ACT3",R.string.err_cancel);
        }
    }


    public void launchAct4(View view) {
        Intent i = new Intent(this, Activity4.class);

        startActivityForResult(i, REQ_ACT4);
    }

    public void launchAct5(View view) {
        Intent i = new Intent(this, Activity5.class);

        startActivityForResult(i, REQ_ACT5);
    }

    void checkExtras(int request, Intent i) {
        String data;
        if (i == null) {
            this.getIntent().putExtra("ACT3", R.string.err_missing_intent);
        } else {
            switch (request) {
                case REQ_ACT4:
                    if (i.hasExtra("ACT4")) {
                        data = i.getExtras().getString("ACT4");
                        Log.d("DATA", data);
                        if (data == null)
                            this.getIntent().putExtra("ACT3", R.string.err_missing_data);
                        else
                            this.getIntent().putExtra("ACT3", data);
                    } else {
                        this.getIntent().putExtra("ACT3", R.string.err_missing_extra);
                    }
                    break;
                case REQ_ACT5:
                    if (i.hasExtra("ACT5")) {
                        data = i.getExtras().getString("ACT5");
                        Log.d("DATA", data);
                        if (data == null)
                            this.getIntent().putExtra("ACT3", R.string.err_missing_data);
                        else
                            this.getIntent().putExtra("ACT3", data);
                    } else {
                        this.getIntent().putExtra("ACT3",R.string.err_missing_extra);
                    }
                    break;
                default:
                    this.getIntent().putExtra("ACT3", R.string.err_unknown_req);
            }
        }
    }

    public void returnData(View view){
        setResult(RESULT_OK, this.getIntent());
        returnHit = true;
        finish();
    }

    @Override
    public void finish() {
        if (!returnHit) {
            Intent i = new Intent();
            i.putExtra("ACT3", "Data dropped, back button was hit!");
            setResult(RESULT_CANCELED, i);
        }
        super.finish();
    }
}
