package br.edu.iff.pooa.trabalho012_2018_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
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
        this.mViewHolder.linearLayoutResultados = (LinearLayout) findViewById(R.id.linearPai);
        this.mViewHolder.resultadoProventos = (TextView) findViewById(R.id.resultadoProventos);
        this.mViewHolder.resultadoDescontos = (TextView) findViewById(R.id.resultadoDescontos);
        this.mViewHolder.resultadoSalarioLiquido = (TextView) findViewById(R.id.resultadoSalarioLiquido);

        this.mViewHolder.buttonCalcular.setOnClickListener(this);
        ArrayAdapter adapterCargo = ArrayAdapter.createFromResource(this, R.array.cargo, android.R.layout.simple_spinner_dropdown_item);
        this.mViewHolder.spinnerCargo.setAdapter(adapterCargo);

        clearScreen();

    }

    private void clearScreen() {
        this.mViewHolder.linearLayoutResultados.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        String cargo = this.mViewHolder.spinnerCargo.getSelectedItem().toString();
        int horaExtra = Integer.parseInt(this.mViewHolder.textHoraExtra.getText().toString());
        int numeroFaltas = Integer.parseInt(this.mViewHolder.textNumeroFaltas.getText().toString());
        int numeroFilhos = Integer.parseInt(this.mViewHolder.textQtdFilhos.getText().toString());

        String item = this.mViewHolder.spinnerCargo.getSelectedItem().toString();

        if (v.getId() == this.mViewHolder.buttonCalcular.getId()){

            float salarioBase, salarioLiquido;
            float valorHoraExtra, adicionalPorFilhos, debitoFaltas, debitoINSS;
            float proventos, descontos;

            if(cargo.equals("Gerente"))
            {   salarioBase = 2000; }
            else if (cargo.equals("Supervisor"))
            {   salarioBase = 900; }
            else if (cargo.equals("Servente"))
            {   salarioBase = 300; }
            else
            {   salarioBase = 0; }

            valorHoraExtra = (salarioBase / 240) * 2;
            adicionalPorFilhos = (float)(salarioBase * 1.03);
            proventos = (salarioBase + valorHoraExtra + adicionalPorFilhos);

            debitoFaltas = (salarioBase / 30) * numeroFaltas;
            debitoINSS = (float) (proventos * 0.1);
            descontos = debitoFaltas + debitoINSS;

            salarioLiquido = proventos - descontos;

            this.mViewHolder.resultadoProventos.setText(String.format("R$ ", proventos));
            this.mViewHolder.resultadoDescontos.setText(String.format("R$ ", descontos));
            this.mViewHolder.resultadoSalarioLiquido.setText(String.format("R$ ", salarioLiquido));
            this.mViewHolder.linearLayoutResultados.setVisibility(View.VISIBLE);
        }
    }

    private static class ViewHolder{
        Spinner spinnerCargo;
        Button buttonCalcular;
        EditText textHoraExtra, textNumeroFaltas, textQtdFilhos;
        LinearLayout linearLayoutResultados;
        TextView resultadoProventos, resultadoDescontos, resultadoSalarioLiquido;
    }

}
