package br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.R;
import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.constants.Constantes;
import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.model.Calculadora;

public class CalculadoraActivity extends AppCompatActivity implements View.OnClickListener {

    // CALCULADORA
    private Calculadora calculadora = Calculadora.getInstance();
    private Constantes constantes =  new Constantes();

    // TEXTO DA TELA
    private TextView lcdTextView;

    // BOTÕES DA TELA
    private Button botaoC;
    private Button botaoDivisao;
    private Button botaoMultiplicacao;
    private Button botaoMais;
    private Button botaoMenos;
    private Button botaoPonto;
    private Button botaoIgual;
    private Button botao0;
    private Button botao1;
    private Button botao2;
    private Button botao3;
    private Button botao4;
    private Button botao5;
    private Button botao6;
    private Button botao7;
    private Button botao8;
    private Button botao9;

    // STRING DOS BOTÕES
    private String textoValor1 = "";
    private String textoValor2 = "";
    private int sinal = -2;
    private double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        lcdTextView = findViewById(R.id.textview_lcd);
        botaoC = findViewById(R.id.button_c);
        botaoDivisao = findViewById(R.id.button_divisao);
        botaoMultiplicacao = findViewById(R.id.button_multiplicacao);
        botaoMenos = findViewById(R.id.button_subtracao);
        botaoMais = findViewById(R.id.button_adicao);
        botaoPonto = findViewById(R.id.button_ponto);
        botaoIgual = findViewById(R.id.button_igual);
        botao0 = findViewById(R.id.button_zero);
        botao1 = findViewById(R.id.button_um    );
        botao2 = findViewById(R.id.button_dois  );
        botao3 = findViewById(R.id.button_tres  );
        botao4 = findViewById(R.id.button_quatro);
        botao5 = findViewById(R.id.button_cinco );
        botao6 = findViewById(R.id.button_seis  );
        botao7 = findViewById(R.id.button_sete  );
        botao8 = findViewById(R.id.button_oito  );
        botao9 = findViewById(R.id.button_nove  );

        botaoC.setOnClickListener(this);
        botaoDivisao.setOnClickListener(this);
        botaoMultiplicacao.setOnClickListener(this);
        botaoMenos.setOnClickListener(this);
        botaoMais.setOnClickListener(this);
        botaoPonto.setOnClickListener(this);
        botaoIgual.setOnClickListener(this);
        botao0.setOnClickListener(this);
        botao1.setOnClickListener(this);
        botao2.setOnClickListener(this);
        botao3.setOnClickListener(this);
        botao4.setOnClickListener(this);
        botao5.setOnClickListener(this);
        botao6.setOnClickListener(this);
        botao7.setOnClickListener(this);
        botao8.setOnClickListener(this);
        botao9.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lcdTextView.setText( "0.0" );
    }

    @Override
    public void onClick(View v) {
        if( v == botaoC ){
            if( sinal != 2 ){
                textoValor1 = "";
            }else{
                textoValor2 = "";
            }

            lcdTextView.setText("0.0");
        }
        if( v == botaoDivisao ){
            informaOperacao(constantes.DIVISAO);
        }
        if( v == botaoMultiplicacao ){
            informaOperacao(constantes.MULTIPLICACAO);
        }
        if( v == botaoMais ){
            informaOperacao(constantes.ADICAO);
        }
        if( v == botaoMenos ){
            informaOperacao(constantes.SUBTRACAO);
        }
        if( v == botaoIgual ){
            calcular();
        }
        if( v == botaoPonto ){
            funcaoPonto();
        }
        if( v == botao0 ){
            informaTexto("0");
        }
        if( v == botao1 ){
            informaTexto("1");
        }
        if( v == botao2 ){
            informaTexto("2");
        }
        if( v == botao3 ){
            informaTexto("3");
        }
        if( v == botao4 ){
            informaTexto("4");
        }
        if( v == botao5 ){
            informaTexto("5");
        }
        if( v == botao6 ){
            informaTexto("6");
        }
        if( v == botao7 ){
            informaTexto("7");
        }
        if( v == botao8 ){
            informaTexto("8");
        }
        if( v == botao9 ){
            informaTexto("9");
        }
    }

    private void informaTexto( String num ) {
        if( sinal != -2 ){
            textoValor2 = textoValor2 + num;
            lcdTextView.setText( textoValor2 );
        }else{
            textoValor1 = textoValor1 + num;
            lcdTextView.setText( textoValor1 );
        }
    }

    private void apagarTexto(){
        lcdTextView.setText("");
    }

    private void funcaoPonto() {

        if( textoValor1 != null || textoValor1 != "" ){
            informaTexto(".");
        }

    }

    private void calcular(){

        if( textoValor2 == null || textoValor2 == "" ){
            textoValor2 = "0.0";
        }

        calculadora.setOperacao( sinal );
        resultado = calculadora.calcular( sinal , Float.valueOf( textoValor2 ) );

        lcdTextView.setText( ""+resultado );
        textoValor2 = "";
    }

    private void informaOperacao( int i ){

        if( textoValor1 == null || textoValor1 == "" ){
            textoValor1 = "0.0";
        }

        calculadora.calcular( constantes.NULO , Float.valueOf( textoValor1 ) );

        sinal = i;
        apagarTexto();
    }
}
