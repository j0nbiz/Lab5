package biz.j0n.lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    private boolean returnHit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    public void returnData(View view){
        Button btn = (Button) findViewById(view.getId());
        Intent i = new Intent();
        i.putExtra("ACT2", btn.getText().toString());
        setResult(RESULT_OK, i);
        returnHit = true;
        finish();
    }

    @Override
    public void finish() {
        if (!returnHit) {
            Intent i = new Intent();
            i.putExtra("ACT2", "Data dropped, back button was hit!");
            setResult(RESULT_CANCELED, i);
        }
        super.finish();
    }
}
