package com.derikeferreira.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.ValidationResult;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9, btnNum0;
    private Button btnSomar, btnDividir, btnSubtrair, btnMultiplicar, btnCalculo, btnPorcentagem;
    private Button btnLimpaTudo, btnParenteses, btnVirgula, btnPositivoNegativo;
    private String strCalculo;

    boolean calculoFeito = false;
    private ImageView imgDeletaUmNumero;

    private TextView txtResultado;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNum0 = findViewById(R.id.btnNum0);
        btnNum1 = findViewById(R.id.btnNum1);
        btnNum2 = findViewById(R.id.btnNum2);
        btnNum3 = findViewById(R.id.btnNum3);
        btnNum4 = findViewById(R.id.btnNum4);
        btnNum5 = findViewById(R.id.btnNum5);
        btnNum6 = findViewById(R.id.btnNum6);
        btnNum7 = findViewById(R.id.btnNum7);
        btnNum8 = findViewById(R.id.btnNum8);
        btnNum9 = findViewById(R.id.btnNum9);

        btnPositivoNegativo = findViewById(R.id.btnMaisouMenos);

        btnParenteses = findViewById(R.id.btnParenteses);

        btnSubtrair = findViewById(R.id.btnSubtracao);

        btnPorcentagem = findViewById(R.id.btnPorcentagem);

        btnVirgula = findViewById(R.id.btnVirgula);

        btnSomar = findViewById(R.id.btnSomar);

        btnMultiplicar = findViewById(R.id.btnMultiplicacao);

        btnDividir = findViewById(R.id.btnDivisao);

        btnLimpaTudo = findViewById(R.id.btnLimpatudo);

        imgDeletaUmNumero = findViewById(R.id.imgApagar);

        txtResultado = findViewById(R.id.txtNumerosConta);

        btnCalculo = findViewById(R.id.btnCalculo);


        btnParenteses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Desativado.", Toast.LENGTH_LONG).show();

            }
        });

        btnPositivoNegativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Desativado.", Toast.LENGTH_LONG).show();

            }
        });

        btnCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculoFinal();
            }
        });

        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClickInf("-");
            }
        });

        btnPorcentagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Desativado.", Toast.LENGTH_LONG).show();
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClickInf("*");
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setClickInf("/");
            }
        });

        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setClickInf("+");


            }
        });


        btnLimpaTudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strCalculo = null;
                txtResultado.setText(strCalculo);

            }
        });

        imgDeletaUmNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (strCalculo != null) {

                    if (strCalculo.length() > 0) {

                        strCalculo = strCalculo.substring(0, strCalculo.length() - 1);
                        txtResultado.setText(strCalculo);

                    }else {
                        strCalculo = null;
                    }
                }
            }
        });


        btnVirgula.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Desativado.", Toast.LENGTH_LONG).show();
              //  if(achaSimbolo(strCalculo, ",")){

                    //faz nada

               // } else{
               //     setClickInf(",");
               // }

            }
        });


        btnNum0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setClickInf("0");


            }
        });


        btnNum1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setClickInf("1");

            }
        });


        btnNum2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setClickInf("2");


            }
        });


        btnNum3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setClickInf("3");


            }
        });

        btnNum4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setClickInf("4");


            }
        });


        btnNum5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setClickInf("5");

            }
        });


        btnNum6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setClickInf("6");


            }
        });


        btnNum7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setClickInf("7");


            }
        });


        btnNum8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setClickInf("8");


            }
        });

        btnNum9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setClickInf("9");


            }
        });

    }

    public void calculoFinal(){

        if (strCalculo != null) {
            // Criar uma expressão a partir da string
            Expression expression = new ExpressionBuilder(strCalculo).build();

            // Verificar se a expressão é válida
            ValidationResult validationResult = expression.validate();
            if (!validationResult.isValid()) {
                System.out.println("Expressão inválida: " + validationResult.getErrors());
                return;
            }

            // Avaliar a expressão e obter o resultado
            double resultado = expression.evaluate();

            strCalculo = String.valueOf(resultado);
            txtResultado.setText(strCalculo);
            calculoFeito = true;

        }else {Toast.makeText(MainActivity.this, "Formato usado inválido.", Toast.LENGTH_LONG).show();}


    }

    public void setClickInf(String sinalFunc){

        strCalculo = verificaSeENull(strCalculo,sinalFunc);
        txtResultado.setText(strCalculo);
    }


    public Boolean achaSimbolo(String textoFuncao, String sinalFuncao){
        if (textoFuncao == null){
            //faz nada

        }else{
            if(textoFuncao.indexOf(sinalFuncao) > 0 ){

                return true;
            }
        }
        return false;

    }

    public String verificaSeENull(String strCalculoF, String opcaoBtn){

        if(strCalculoF == null ){ ///Verifica se o usuario digitou um numero antes do sinal

            if (opcaoBtn == "+") {
                Toast.makeText(MainActivity.this, "Formato usado inválido.", Toast.LENGTH_LONG).show();
                return null;
            } else if (opcaoBtn == "/") {
                Toast.makeText(MainActivity.this, "Formato usado inválido.", Toast.LENGTH_LONG).show();
                return null;
            }else if (opcaoBtn == "*") {
                Toast.makeText(MainActivity.this, "Formato usado inválido.", Toast.LENGTH_LONG).show();
                return null;
            }else if (opcaoBtn == "-") {
                Toast.makeText(MainActivity.this, "Formato usado inválido.", Toast.LENGTH_LONG).show();
                return null;
            } else {
                return opcaoBtn;
            }

        }else{

            if(opcaoBtn == "+" || opcaoBtn == "/" || opcaoBtn == "*" || opcaoBtn == "-" ){

                if( strCalculo.substring(strCalculo.length()-1).equals("+")){
                    //faz nada
                } else if (strCalculo.substring(strCalculo.length()-1).equals("/")) {
                    //faz nada
                } else if (strCalculo.substring(strCalculo.length()-1).equals("*")) {
                    //faz nada
                } else if (strCalculo.substring(strCalculo.length()-1).equals("-")) {
                    //faz nada
                } else{

                    if (calculoFeito == true){
                        calculoFeito = false;
                    }
                    strCalculoF = strCalculoF + opcaoBtn;

                }

            }else {

                if (calculoFeito == true){
                    strCalculoF = "";
                    calculoFeito = false;
                }

                strCalculoF = strCalculoF + opcaoBtn;

            }

            return strCalculoF;
        }
    }
}