package br.edu.iff.pooa.trabalho012_2018_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static class ViewHolder{
        Spinner spinnerCargo, spinnerHoras, spinnerFaltas, spinnerFilhos;
    }

}
