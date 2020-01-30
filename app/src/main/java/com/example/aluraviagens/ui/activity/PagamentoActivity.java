package com.example.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aluraviagens.R;
import com.example.aluraviagens.models.Pacote;
import com.example.aluraviagens.utils.MoedaUtil;

import static com.example.aluraviagens.ui.activity.PacoteKeys.PACOTE_KEY;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";
    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        Intent dadosPacote = getIntent();
        if(dadosPacote.hasExtra(PACOTE_KEY)) {
            pacote = (Pacote) dadosPacote.getSerializableExtra(PACOTE_KEY);

            formataEMostraPreco(pacote);
        }
        configuraBotaoFinalizaCompra();
    }

    private void configuraBotaoFinalizaCompra() {
        Button botaoFinalizaCompra = findViewById(R.id.activity_pagamento_botao_finaliza_compra);
        botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                intent.putExtra(PACOTE_KEY, pacote);
                startActivity(intent);
            }
        });
    }

    private void formataEMostraPreco(Pacote pacote) {
        TextView precoPacote = findViewById(R.id.activity_pagamento_preco);
        String precoFormatadoParaReal = MoedaUtil.converteParaReais(pacote.getPreco());
        precoPacote.setText(precoFormatadoParaReal);
    }
}
