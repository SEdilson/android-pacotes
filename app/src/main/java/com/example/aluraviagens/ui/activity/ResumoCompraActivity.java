package com.example.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aluraviagens.R;
import com.example.aluraviagens.models.Pacote;
import com.example.aluraviagens.utils.DataUtil;
import com.example.aluraviagens.utils.DrawableUtil;
import com.example.aluraviagens.utils.MoedaUtil;

import static com.example.aluraviagens.ui.activity.PacoteKeys.PACOTE_KEY;

public class ResumoCompraActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR = "Resumo da compra";
    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITULO_APPBAR);

        configuraPacote();
    }

    private void configuraPacote() {
        Intent dadosPacote = getIntent();
        if(dadosPacote.hasExtra(PACOTE_KEY)) {
            pacote = (Pacote) dadosPacote.getSerializableExtra(PACOTE_KEY);

            mostraLocal(pacote);
            formataEMostraData(pacote);
            converteEMostraPreco(pacote);
            retornaImagemDoPacote(pacote);
        }
    }

    private void retornaImagemDoPacote(Pacote pacoteSaoPaulo) {
        ImageView imagemDoPacote = findViewById(R.id.activity_resumo_compra_imagem_pacote);
        Drawable stringImagemDoPacote =
                DrawableUtil.retornaDrawable(this, pacoteSaoPaulo.getImagem());
        imagemDoPacote.setImageDrawable(stringImagemDoPacote);
    }

    private void converteEMostraPreco(Pacote pacote) {
        TextView precoPacote = findViewById(R.id.activity_resumo_compra_preco);
        String converteParaReais = MoedaUtil.converteParaReais(pacote.getPreco());
        precoPacote.setText(converteParaReais);
    }

    private void formataEMostraData(Pacote pacote) {
        TextView periodoDaViagem = findViewById(R.id.activity_resumo_compra_periodo);
        String formataDataParaPadraoBrasileiro =
                DataUtil.formataDataParaPadraoBrasileiro(pacote.getDias());
        periodoDaViagem.setText(formataDataParaPadraoBrasileiro);
    }

    private void mostraLocal(Pacote pacote) {
        TextView localPacote = findViewById(R.id.activity_resumo_compra_local);
        localPacote.setText(pacote.getLocal());
    }
}
