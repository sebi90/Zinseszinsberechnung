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
public class YearsActivity extends ActionBarActivity {

    public static final String MESSAGE = "Jahre";
    private String kapital, zins;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_years);
        Intent intent = getIntent();
        kapital = intent.getStringExtra("Kapital");
        zins = intent.getStringExtra(ZinsActivity.MESSAGE);
        editText = (EditText) findViewById(R.id.years);
    }

    public void clicked(View view)
    {

        String input = editText.getText().toString();
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(MESSAGE, input);
        intent.putExtra("Kapital", kapital);
        intent.putExtra("Zins", zins);
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
