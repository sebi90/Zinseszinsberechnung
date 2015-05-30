package dma.zinseszinsberechnung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Sebi on 22.05.15.
 */
public class ZinsActivity extends ActionBarActivity {

    public static final String MESSAGE = "Zins";
    private String kapital;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zins);
        Intent intent = getIntent();
        kapital = intent.getStringExtra(MainActivity.MESSAGE);
        editText = (EditText) findViewById(R.id.zins);

    }

    public void clicked(View view)
    {

        String zins = editText.getText().toString();
        Intent intent = new Intent(this, YearsActivity.class);
        intent.putExtra(MESSAGE, zins);
        intent.putExtra("Kapital", kapital);
        startActivity(intent);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("DISPLAY_TEXT", editText.getText().toString());

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        editText.setText(savedInstanceState.getString("DISPLAY_TEXT"));
    }
}
