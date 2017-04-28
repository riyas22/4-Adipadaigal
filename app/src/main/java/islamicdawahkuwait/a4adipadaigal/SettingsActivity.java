package islamicdawahkuwait.a4adipadaigal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textProgress;
    private TextView textParagraph;

    private static final int progress = 15;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow1);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textProgress = (TextView) findViewById(R.id.progress);
        textParagraph = (TextView) findViewById(R.id.textParagraph);

        sharedPreferences = getSharedPreferences("SAMPLE_PREFERENCE", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        updateView(progress);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                updateView(progress + i);

                editor.putInt("FONT_SIZE", progress + i);
                editor.commit();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void updateView(int fontSize) {
        textProgress.setText(String.valueOf(fontSize));
        textParagraph.setTextSize((float) fontSize);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

