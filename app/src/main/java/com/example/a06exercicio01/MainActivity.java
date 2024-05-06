package com.example.a06exercicio01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a06exercicio01.model.Professor;
import com.example.a06exercicio01.model.ProfessorHorista;
import com.example.a06exercicio01.model.ProfessorTitular;

public class MainActivity extends AppCompatActivity {

    private EditText edIdade;
    private EditText edNome;
    private EditText edMatricula;
    private RadioButton rbTitular;
    private RadioButton rbHosrista;
    private EditText edInf1;
    private EditText edInf2;
    private   Professor professor;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rbTitular = findViewById(R.id.rbTitular);
        rbHosrista = findViewById(R.id.rbHorista);
        edInf1 = findViewById(R.id.edInf1);
        edInf2 = findViewById(R.id.edInf2);
        edIdade = findViewById(R.id.edIdade);
        edNome = findViewById(R.id.edNome);
        edMatricula = findViewById(R.id.edMatricula);
        tvResultado = findViewById(R.id.tvResultado);
        rbTitular.setChecked(true);
        exibeInfTitular();
        rbTitular.setOnClickListener(op -> exibeInfTitular());
        rbTitular.setOnClickListener(op -> exibeInfTitular());
        rbHosrista.setOnClickListener(op -> exibeInfHorista());
        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(op -> calcularSalario());
    }

    private void calcularSalario() {



        if(rbTitular.isChecked()){
            professor = new ProfessorTitular();
            ((ProfessorTitular) professor).setAnosInstituicao(Integer.parseInt(edInf1.getText().toString()));
            ((ProfessorTitular) professor).setSalario(Double.parseDouble(edInf2.getText().toString()));

        }
        if(rbHosrista.isChecked()){
            professor = new ProfessorHorista();
            ((ProfessorHorista) professor).setHorasAula(Integer.parseInt(edInf1.getText().toString()));
            ((ProfessorHorista) professor).setValorHoraAula(Double.parseDouble(edInf2.getText().toString()));

        }
        professor.setIdade(Integer.parseInt(edIdade.getText().toString()));
        professor.setNome(edNome.getText().toString());
        professor.setMatricula(edMatricula.getText().toString());

        tvResultado.setText(getString(R.string.tvSalario) + ""+professor.calcSalario() );


    }

    private void exibeInfHorista() {
        edInf1.setHint(R.string.horaAula);
        edInf2.setHint(R.string.ValorHoraAula);
        edInf1.setText("");
        edInf2.setText("");
    }

    private void exibeInfTitular() {
        edInf1.setHint(R.string.anosInstituicao);
        edInf2.setHint(R.string.salario);
        edInf1.setText("");
        edInf2.setText("");
    }
}