package com.example.eligegiro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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

    Integer rotation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();

        btAceptar.setOnClickListener(v -> {
            if (rbTexto.isChecked()) {
                tvRespuesta.setText("GIRANDO!!");
                tvRespuesta.setTextColor(getResources().getColor(R.color.green));
                rgOpciones.setVisibility(View.GONE);
                btAceptar.setVisibility(View.GONE);
                tvRespuesta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (rotation == 360) {
                            rotation = 0;
                        }
                        rotation += 45;
                        tvRespuesta.setRotation(rotation);
                    }
                });
            } else if (rbImagen.isChecked()) {
                tvRespuesta.setVisibility(View.GONE);
                rgOpciones.setVisibility(View.GONE);
                btAceptar.setVisibility(View.GONE);
                ivImagen.setVisibility(View.VISIBLE);
                ivImagen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (rotation == 360) {
                            rotation = 0;
                        }
                        rotation += 45;
                        ivImagen.setRotation(rotation);
                    }
                });
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
    }
}