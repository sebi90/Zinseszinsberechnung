package dma.zinseszinsberechnung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Sebi on 22.05.15.
 */
public class ZinsActivity extends Activity {

    public static final String MESSAGE = "Zins";
    String kapital;

    public void clicked(View view)
    {
        EditText editText = (EditText) findViewById(R.id.zins);
        String zins = editText.getText().toString();
        Intent intent = new Intent(this, YearsActivity.class);
        intent.putExtra(MESSAGE, zins);
        intent.putExtra("Kapital", kapital);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zins);
        Intent intent = getIntent();
        kapital = intent.getStringExtra(MainActivity.MESSAGE);

    }
}
