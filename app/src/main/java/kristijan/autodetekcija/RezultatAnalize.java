package kristijan.autodetekcija;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RezultatAnalize extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultat_analize);
        boolean[] greske = getIntent().getBooleanArrayExtra("greske");
        boolean[] opisne = getIntent().getBooleanArrayExtra("opisneGreske");
        String[] greskePoruka = getResources().getStringArray(R.array.greske_poruka);
        String[] opisneGreskePoruka= getResources().getStringArray(R.array.opisne_greske_poruka);

        LinearLayout rl =(LinearLayout) findViewById(R.id.layoutaa);

        for (int x = 0;x<greske.length;x++){
            if (greske[x]){
                TextView tv = new TextView(this);
                tv.setText(String.valueOf(greskePoruka[x]));
                rl.addView(tv);
            }
        }
        for (int x = 0;x<opisne.length;x++){
            if (opisne[x]){
                TextView tv = new TextView(this);
                tv.setText(String.valueOf(opisneGreskePoruka[x]));
                rl.addView(tv);
            }
        }
    }
}
