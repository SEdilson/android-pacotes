package com.example.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aluraviagens.R;
import com.example.aluraviagens.models.Pacote;
import com.example.aluraviagens.utils.DataUtil;
import com.example.aluraviagens.utils.DiasUtil;
import com.example.aluraviagens.utils.DrawableUtil;
import com.example.aluraviagens.utils.MoedaUtil;

import static com.example.aluraviagens.ui.activity.PacoteKeys.PACOTE_KEY;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do Pacote";
    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APPBAR);

        configuraPacote();
        configuraBotaoDePagamento();
    }

    private void configuraPacote() {
        Intent dadosPacote = getIntent();
        if(dadosPacote.hasExtra(PACOTE_KEY)) {
            pacote = (Pacote) dadosPacote.getSerializableExtra(PACOTE_KEY);

            vinculaLocal(pacote);
            vinculaImagem(pacote);
            vinculaQuantidadeDeDiasDoPacote(pacote);
            vinculaPrecoDoPacote(pacote);
            vinculaEFormataPeriodoDaViagem(pacote);
        }
    }

    private void configuraBotaoDePagamento() {
        Button botaoPagamento = findViewById(R.id.activity_resumo_pacote_botao_pagamento);
        botaoPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
                intent.putExtra(PACOTE_KEY, pacote);
                startActivity(intent);
            }
        });
    }

    private void vinculaEFormataPeriodoDaViagem(Pacote pacote) {
        TextView periodoDaViagem = findViewById(R.id.activity_resumo_pacote_periodo);
        String dataDaViagemFormatada = DataUtil.formataDataParaPadraoBrasileiro(pacote.getDias());
        periodoDaViagem.setText(dataDaViagemFormatada);
    }

    private void vinculaPrecoDoPacote(Pacote pacote) {
        TextView precoDoPacote = findViewById(R.id.activity_resumo_pacote_preco);
        String valorConvertidoEmReais = MoedaUtil.converteParaReais(pacote.getPreco());
        precoDoPacote.setText(valorConvertidoEmReais);
    }

    private void vinculaQuantidadeDeDiasDoPacote(Pacote pacote) {
        TextView quantidadeDeDiasDoPacote = findViewById(R.id.activity_resumo_pacote_dias);
        String diasConvertidosPraTexto = DiasUtil.editaTextoDias(pacote.getDias());
        quantidadeDeDiasDoPacote.setText(diasConvertidosPraTexto);
    }

    private void vinculaImagem(Pacote pacote) {
        ImageView imagemDoPacote = findViewById(R.id.activity_resumo_pacote_imagem);
        Drawable fotoDoPacote = DrawableUtil.retornaDrawable(this, pacote.getImagem());
        imagemDoPacote.setImageDrawable(fotoDoPacote);
    }

    private void vinculaLocal(Pacote pacote) {
        TextView localDoPacote = findViewById(R.id.activity_resumo_pacote_local);
        localDoPacote.setText(pacote.getLocal());
    }
}
