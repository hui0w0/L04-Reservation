package sg.edu.rp.c346.id21016163.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText pax;
    EditText numb;
    DatePicker dp;
    TimePicker tp;
    RadioGroup smokeArea;
    RadioButton smoke;
    RadioButton nonsmoke;
    Button cmfreserve;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextName);
        pax = findViewById(R.id.editTextGrpSize);
        numb = findViewById(R.id.editTextPhone);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        smokeArea = findViewById(R.id.rgSmokeArea);
        smoke = findViewById(R.id.radioButtonSmoke);
        nonsmoke = findViewById(R.id.radioButtonNoSmoke);
        cmfreserve = findViewById(R.id.buttonReservation);
        reset = findViewById(R.id.buttonReset);

        cmfreserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedRadioId = smokeArea.getCheckedRadioButtonId();
                if (name.getText().toString().trim().length()!=0 && pax.getText().toString().trim().length()!=0 &&
                        numb.getText().toString().trim().length()!=0 && checkedRadioId == R.id.radioButtonSmoke && ((dp.getMonth() >= 5 && dp.getDayOfMonth() > 1 && dp.getYear() >= 2020) || ( dp.getYear() > 2020))){
                    Toast.makeText(MainActivity.this,"Successfully Reserved\nName: " + name.getText()
                            + "\nSize of Group: " + pax.getText()
                            + "\nMobile Number: " + numb.getText()
                            + "\nTime: " + tp.getCurrentHour() + ":" + tp.getCurrentMinute()
                            + "\nDate: " + dp.getMonth() + "/" + dp.getDayOfMonth() + "/" + dp.getYear()
                            + "\nDining Area: Smoking Area" ,Toast.LENGTH_LONG).show();
                }
                else if(name.getText().toString().trim().length()!=0 && pax.getText().toString().trim().length()!=0 &&
                        numb.getText().toString().trim().length()!=0 && checkedRadioId == R.id.radioButtonNoSmoke && ((dp.getMonth() >= 5 && dp.getDayOfMonth() > 1 && dp.getYear() >= 2020) || ( dp.getYear() > 2020))){
                    Toast.makeText(MainActivity.this,"Successfully Reserved\nName: " + name.getText()
                            + "\nSize of Group: " + pax.getText()
                            + "\nMobile Number: " + numb.getText()
                            + "\nTime: " + tp.getCurrentHour() + ":" + tp.getCurrentMinute()
                            + "\nDate: " + dp.getMonth() + "/" + dp.getDayOfMonth() + "/" + dp.getYear()
                            + "\nDining Area: Non-Smoking Area" ,Toast.LENGTH_LONG).show();
                }
                else if(name.getText().toString().trim().length()==0 && pax.getText().toString().trim().length()!=0 &&
                        numb.getText().toString().trim().length()!=0 && (checkedRadioId == R.id.radioButtonNoSmoke || checkedRadioId == R.id.radioButtonSmoke) && ((dp.getMonth() >= 5 && dp.getDayOfMonth() > 1 && dp.getYear() >= 2020) || ( dp.getYear() > 2020))){
                    Toast.makeText(MainActivity.this,"Failed to Reserve. Please enter name.", Toast.LENGTH_LONG).show();
                }
                else if(name.getText().toString().trim().length()!=0 && pax.getText().toString().trim().length()==0 &&
                        numb.getText().toString().trim().length()!=0 && (checkedRadioId == R.id.radioButtonNoSmoke || checkedRadioId == R.id.radioButtonSmoke) && ((dp.getMonth() >= 5 && dp.getDayOfMonth() > 1 && dp.getYear() >= 2020) || ( dp.getYear() > 2020))){
                    Toast.makeText(MainActivity.this,"Failed to Reserve. Please enter size of group.", Toast.LENGTH_LONG).show();
                }
                else if(name.getText().toString().trim().length()!=0 && pax.getText().toString().trim().length()!=0 &&
                        numb.getText().toString().trim().length()==0 && (checkedRadioId == R.id.radioButtonNoSmoke || checkedRadioId == R.id.radioButtonSmoke) && ((dp.getMonth() >= 5 && dp.getDayOfMonth() > 1 && dp.getYear() >= 2020) || ( dp.getYear() > 2020))){
                    Toast.makeText(MainActivity.this,"Failed to Reserve. Please enter mobile number.", Toast.LENGTH_LONG).show();

                }else if(name.getText().toString().trim().length()!=0 && pax.getText().toString().trim().length()!=0 &&
                        numb.getText().toString().trim().length()!=0 && !(checkedRadioId == R.id.radioButtonNoSmoke || checkedRadioId == R.id.radioButtonSmoke) && ((dp.getMonth() >= 5 && dp.getDayOfMonth() > 1 && dp.getYear() >= 2020) || ( dp.getYear() > 2020))){
                    Toast.makeText(MainActivity.this,"Failed to Reserve. Please select dining area.", Toast.LENGTH_LONG).show();
                }
                else if(name.getText().toString().trim().length()==0 || pax.getText().toString().trim().length()==0 ||
                        numb.getText().toString().trim().length()==0 || !(checkedRadioId == R.id.radioButtonNoSmoke || checkedRadioId == R.id.radioButtonSmoke) && ((dp.getMonth() >= 5 && dp.getDayOfMonth() > 1 && dp.getYear() >= 2020) || ( dp.getYear() > 2020))){
                    Toast.makeText(MainActivity.this,"Failed to Reserve. Please enter all fields.",Toast.LENGTH_LONG).show();
                }
        }});
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker v, int hourOfDay, int minute) {
                if (hourOfDay >= 8 && hourOfDay < 21){
                    tp.setCurrentHour(hourOfDay);
                }else{
                    tp.setCurrentHour(20);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                pax.setText(null);
                numb.setText(null);
                dp.updateDate(2020,5,1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                smokeArea.clearCheck();
            }
        });
    }
}