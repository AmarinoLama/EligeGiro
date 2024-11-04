package com.example.eligegiro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgOpciones;
    RadioButton rbTexto, rbImagen;
    Button btAceptar;
    TextView tvRespuesta;
    ImageView ivImagen;
    EditText etTexto;

    Integer rotation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();

        btAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logicaBtn();
            }
        });
    }

    public void inicializar() {
        rgOpciones = findViewById(R.id.rgOpciones);
        rbTexto = findViewById(R.id.rbTexto);
        rbImagen = findViewById(R.id.rbImagen);
        btAceptar = findViewById(R.id.btAceptar);
        tvRespuesta = findViewById(R.id.tvRespuesta);
        ivImagen = findViewById(R.id.ivImagen);
        etTexto = findViewById(R.id.etTexto);
    }

    public void logicaBtn() {
        if (etTexto.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debe introducir un valor", Toast.LENGTH_SHORT).show();
            return;
        } else if (Integer.parseInt(etTexto.getText().toString())<10 || Integer.parseInt(etTexto.getText().toString())>90) {
            Toast.makeText(this, "Valor fuera de rango", Toast.LENGTH_SHORT).show();
            return;
        }
        if (rbTexto.isChecked()) {
            tvRespuesta.setText("GIRANDO!!");
            tvRespuesta.setTextColor(getResources().getColor(R.color.green));
            rgOpciones.setVisibility(View.GONE);
            btAceptar.setVisibility(View.GONE);
            tvRespuesta.setRotation(Integer.parseInt(etTexto.getText().toString()));
            etTexto.setVisibility(View.GONE);
        } else if (rbImagen.isChecked()) {
            tvRespuesta.setVisibility(View.GONE);
            rgOpciones.setVisibility(View.GONE);
            btAceptar.setVisibility(View.GONE);
            ivImagen.setVisibility(View.VISIBLE);
            ivImagen.setRotation(Integer.parseInt(etTexto.getText().toString()));
            etTexto.setVisibility(View.GONE);
        }
    }
}