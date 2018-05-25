package br.edu.iff.pooa.trabalho012_2018_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.spinnerCargo = (Spinner) findViewById(R.id.spinnerCargo);
        this.mViewHolder.textHoraExtra = (EditText) findViewById(R.id.textNumeroHoras);
        this.mViewHolder.textNumeroFaltas = (EditText) findViewById(R.id.textNumeroFaltas);
        this.mViewHolder.textQtdFilhos = (EditText) findViewById(R.id.textNumeroFilhos);
        this.mViewHolder.buttonCalcular = (Button) findViewById(R.id.buttonCalcular);

        this.mViewHolder.buttonCalcular.setOnClickListener(this);
        ArrayAdapter adapterCargo = ArrayAdapter.createFromResource(this, R.array.cargo, android.R.layout.simple_spinner_dropdown_item);
        this.mViewHolder.spinnerCargo.setAdapter(adapterCargo);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == this.mViewHolder.buttonCalcular.getId()){
            String cargo = this.mViewHolder.spinnerCargo.getSelectedItem().toString();
            int horaExtra = Integer.parseInt(this.mViewHolder.textHoraExtra.getText().toString());
            int numeroFaltas = Integer.parseInt(this.mViewHolder.textNumeroFaltas.getText().toString());
            int numeroFilhos = Integer.parseInt(this.mViewHolder.textQtdFilhos.getText().toString());

            String item = this.mViewHolder.spinnerCargo.getSelectedItem().toString();
            Toast.makeText(getApplicationContext(),"Item:"+item+" Horas:"+horaExtra+" Faltas:"+numeroFaltas+" Filhos:"+numeroFilhos, Toast.LENGTH_SHORT).show();
        }
    }

    private static class ViewHolder{
        Spinner spinnerCargo;
        Button buttonCalcular;
        EditText textHoraExtra, textNumeroFaltas, textQtdFilhos;
    }

}
