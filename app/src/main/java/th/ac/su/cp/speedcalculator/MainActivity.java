package th.ac.su.cp.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText Enterdistance,Entertime ;
    private TextView result;
    private Button calculate;
    private Button cear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Enterdistance  = findViewById(R.id.Enterdistance);
                String distance = Enterdistance.getText().toString();
                Entertime = findViewById(R.id.Entertime);
                String time = Entertime.getText().toString();
                if(distance.equals("") || time.equals("")){
                    Toast.makeText(MainActivity.this, R.string.Distance,Toast.LENGTH_LONG).show();
                }else if(!distance.equals("") & !time.equals("") & time.equals("0")){
                    Toast.makeText(MainActivity.this, R.string.speed,Toast.LENGTH_LONG).show();
                }else{
                    double speed = ((Double.parseDouble(distance)/Double.parseDouble(time))*3600/1000);
                    String str = String.format(Locale.getDefault(), "%.2f", speed);
                    result = findViewById(R.id.result);
                    result.setText(str);
                    if(speed > 80){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("SPEED CALCULATOR").setMessage("Speed is over limit").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();

                    }
                }

            }
        });
        cear = findViewById(R.id.cear);
        cear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Enterdistance.setText("");
                Entertime.setText("");
            }
        });
    }

}