package dma.zinseszinsberechnung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sebi on 22.05.15.
 */
public class ResultActivity extends Activity {

    String kapital, zins, jahre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        kapital = intent.getStringExtra("Kapital");
        zins = intent.getStringExtra(ZinsActivity.MESSAGE);
        jahre = intent.getStringExtra(YearsActivity.MESSAGE);

        TextView text = (TextView) findViewById(R.id.result);

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
            Toast.makeText(getApplicationContext(), "ungültige Eingabe", Toast.LENGTH_SHORT);
        }


    }
}
