package dma.zinseszinsberechnung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sebi on 22.05.15.
 */
public class ResultActivity extends ActionBarActivity {

    String kapital, zins, jahre;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        kapital = intent.getStringExtra(MainActivity.MESSAGE);
        zins = intent.getStringExtra(ZinsActivity.MESSAGE);
        jahre = intent.getStringExtra(YearsActivity.MESSAGE);
        Toast.makeText(getApplicationContext(), kapital + " " +zins +" "+ jahre, Toast.LENGTH_SHORT).show();

        text = (TextView) findViewById(R.id.result);

        try {
            int kapitalInt = Integer.parseInt(kapital);
            double zinsInt = Double.parseDouble(zins);
            int jahrInt = Integer.parseInt(jahre);

            double result = kapitalInt;
            zinsInt = (zinsInt/100) + 1;
            for(int i = 0; i < jahrInt; i++)
            {
                result *= zinsInt;
            }

            text.setText(result + "");
        }catch (IllegalArgumentException e)
        {
            Toast.makeText(getApplicationContext(), "ungültige Eingabe", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("DISPLAY_TEXT", text.getText().toString());

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        text.setText(savedInstanceState.getString("DISPLAY_TEXT"));
    }
}
