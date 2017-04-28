package islamicdawahkuwait.a4adipadaigal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class C7Activity extends AppCompatActivity {

    TextView textView;
    SharedPreferences sharedPreferences;

    int fontSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c7);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow1);

        textView = (TextView) findViewById(R.id.textView_c7);

        sharedPreferences = getSharedPreferences("SAMPLE_PREFERENCE", MODE_PRIVATE);

    }

    @Override
    public void onResume(){
        super.onResume();

        fontSize = sharedPreferences.getInt("FONT_SIZE", 20);
        textView.setTextSize((float) fontSize);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
