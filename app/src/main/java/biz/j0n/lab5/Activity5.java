package biz.j0n.lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity5 extends AppCompatActivity {
    private boolean returnHit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
    }

    @Override
    public void finish() {
        Intent i = new Intent();
        i.putExtra("ACT5", "Dave. I'm afraid I can't do that.");
        setResult(RESULT_OK, i);
        super.finish();
    }
}