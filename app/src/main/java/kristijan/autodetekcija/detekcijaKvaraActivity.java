package kristijan.autodetekcija;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class detekcijaKvaraActivity extends AppCompatActivity {

    boolean[] checkedItems = {false, false, false, false, false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detekcija_kvara);
    }

    public void dodatni(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Odaberite opisne kvarove:");
        String[] opisni_kvarovi = getResources().getStringArray(R.array.opisne_greske);
        builder.setMultiChoiceItems(opisni_kvarovi, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                checkedItems[indexSelected] = isChecked;
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Cancel", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void pokreni(View view){
        boolean[] greske =new boolean[31];
        String name = getPackageName();
        for(int x = 1;x<=31;x++){
            ToggleButton button = findViewById(getResources().getIdentifier("i"+x, "id", this.getPackageName()));
            greske[x-1]= button.isChecked();
        }
        Intent intent = new Intent(this,RezultatAnalize.class);
        intent.putExtra("opisneGreske",checkedItems);
        intent.putExtra("greske",greske);
        startActivity(intent);
    }
}
