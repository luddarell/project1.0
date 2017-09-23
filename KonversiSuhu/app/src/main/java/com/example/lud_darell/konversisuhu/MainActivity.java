package com.example.lud_darell.konversisuhu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editsuhu;
    Spinner spinnersuhuinput;
    Spinner spinnersuhuouput;
    Button Btnreset, Btnkonvert;
    TextView textConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editsuhu = (EditText) findViewById(R.id.editsuhu);
        spinnersuhuinput = (Spinner) findViewById(R.id.spinnersuhuinput);
        spinnersuhuouput = (Spinner) findViewById(R.id.spinnersuhuoutput);
        Btnreset = (Button) findViewById(R.id.Btnreset);
        Btnkonvert = (Button) findViewById(R.id.Btnkonvert);
        textConvert = (TextView) findViewById(R.id.textConvert);
        final Toast toast = Toast.makeText(this,"Null",Toast.LENGTH_SHORT);

        Btnkonvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double suhu = Double.parseDouble(editsuhu.getText().toString());
                    double hasil = 0;
                    String input1 = spinnersuhuinput.getSelectedItem().toString();
                    String input2 = spinnersuhuouput.getSelectedItem().toString();

                    if (input1.equals("Kelvin")) {
                        if (input2.equals("Kelvin")) {
                            hasil = suhu;
                        } else if (input2.equals("Fahrenheit")) {
                            hasil = (suhu * 1.8) - 459.67;
                        } else if (input2.equals("Reamur")) {
                            hasil = (suhu - 273.15) * 0.8;
                        } else if (input2.equals("Celcius")) {
                            hasil = 1.8 * (suhu - 273.15) + 32;
                        }
                    }

                    if (input1.equals("Fahrenheit")) {
                        if (input2.equals("Kelvin")) {
                            hasil = (suhu + 459.67) * 5 / 9;
                        } else if (input2.equals("Fahrenheit")) {
                            hasil = suhu;
                        } else if (input2.equals("Reamur")) {
                            hasil = (suhu - 32) * 4 / 9;
                        } else if (input2.equals("Celcius")) {
                            hasil = 1.8 * (suhu - 32) * 1.8;
                        }
                    }


                    if (input1.equals("Reamur")) {
                        if (input2.equals("Kelvin")) {
                            hasil = (suhu * 1.25) + 273.15;
                        } else if (input2.equals("Fahrenheit")) {
                            hasil = (suhu * 2.25) + 32;
                        } else if (input2.equals("Reamur")) {
                            hasil = suhu;
                        } else if (input2.equals("Celcius")) {
                            hasil = (suhu * 1.25);
                        }
                    }

                    if (input1.equals("Celcius")) {
                        if (input2.equals("Kelvin")) {
                            hasil = (suhu + 273.15);
                        } else if (input2.equals("Fahrenheit")) {
                            hasil = (suhu * 1.8) + 32;
                        } else if (input2.equals("Reamur")) {
                            hasil = (suhu * 0.8);
                        } else if (input2.equals("Celcius")) {
                            hasil = suhu;
                        }
                    }

                    String hasilbgt = Double.toString(hasil);
                    textConvert.setText(hasilbgt);
                } catch (Exception e) {
                    toast.show();
                }
            }
        });

        Btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editsuhu.setText("");
                textConvert.setText("Empty");
            }
        });
    }
}


