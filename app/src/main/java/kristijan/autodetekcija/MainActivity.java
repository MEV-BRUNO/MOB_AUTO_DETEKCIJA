package kristijan.autodetekcija;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void detekcijaKvara(View view){
        Intent intent = new Intent(this, detekcijaKvaraActivity.class);
        startActivity(intent);
    }

    public void provjeriSam(View view){
        Intent intent = new Intent(this, ProvjeriSamActivity.class);
        startActivity(intent);
    }

    public void pronadiServis(View view){
        Intent intent = new Intent(this, PronadiServisActivity.class);
        startActivity(intent);
    }

    public void akcije(View view){
        Intent intent = new Intent(this, AkcijeActivity.class);
        startActivity(intent);
    }
}
