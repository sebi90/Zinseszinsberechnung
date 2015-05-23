package dma.zinseszinsberechnung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Sebi on 22.05.15.
 */
public class YearsActivity extends Activity {

    public static final String MESSAGE = "Jahre";
    String kapital, zins;

    public void clicked(View view)
    {
        EditText editText = (EditText) findViewById(R.id.years);
        String input = editText.getText().toString();
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(MESSAGE, input);
        intent.putExtra("Kapital", kapital);
        intent.putExtra("Zins", zins);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_years);
        Intent intent = getIntent();
        kapital = intent.getStringExtra("Kapital");
        zins = intent.getStringExtra(ZinsActivity.MESSAGE);
    }
}
