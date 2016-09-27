package biz.j0n.lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Activity4 extends AppCompatActivity {
    private boolean returnHit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
    }

    public void returnData(View view){
        EditText in_text = (EditText)findViewById(R.id.in_text);
        String input = in_text.getText().toString();

        if(Objects.equals(input, "")){
            Toast.makeText(Activity4.this, "Input cannot be empty!", Toast.LENGTH_SHORT).show();
        }
        else{
            Button btn = (Button) findViewById(view.getId());
            Intent i = new Intent();
            i.putExtra("ACT4", input);
            setResult(RESULT_OK, i);
            returnHit = true;
            finish();
        }
    }

    @Override
    public void finish() {
        if (!returnHit) {
            Intent i = new Intent();
            i.putExtra("ACT4", "Data dropped, back button was hit!");
            setResult(RESULT_CANCELED, i);
        }
        super.finish();
    }
}
