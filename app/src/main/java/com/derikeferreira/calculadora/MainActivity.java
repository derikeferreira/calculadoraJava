package com.derikeferreira.calculadora;

import androidx.appcompat.app.AppCompatActivity;

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
    private String strNumAntesSinal, strNumDepoisSinal;

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
                setClickInf("%");
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClickInf("x");
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setClickInf("÷");
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
                strNumAntesSinal = null;
                txtResultado.setText(strNumAntesSinal);

            }
        });

        imgDeletaUmNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (strNumAntesSinal != null) {

                    if (strNumAntesSinal.length() > 0) {

                        strNumAntesSinal = strNumAntesSinal.substring(0, strNumAntesSinal.length() - 1);
                        txtResultado.setText(strNumAntesSinal);

                    }else {
                        strNumAntesSinal = null;
                    }
                }
            }
        });


        btnVirgula.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(achaSimbolo(strNumAntesSinal, ",")){

                    //faz nada

                } else{
                    setClickInf(",");
                }

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


    }

    public void setClickInf(String sinalFunc){
        strNumAntesSinal = verificaSeENull(strNumAntesSinal,sinalFunc);
        txtResultado.setText(strNumAntesSinal);
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

    public String verificaSeENull(String strNumAntesSinalF, String opcaoBtn){

        if(strNumAntesSinalF == null ){

            if(opcaoBtn == ","){
                return "0,";
            } else if (opcaoBtn == "+") {
                Toast.makeText(MainActivity.this, "Formato usado inválido.", Toast.LENGTH_LONG).show();
                return null;
            } else if (opcaoBtn == "÷") {
                Toast.makeText(MainActivity.this, "Formato usado inválido.", Toast.LENGTH_LONG).show();
                return null;
            }else if (opcaoBtn == "x") {
                Toast.makeText(MainActivity.this, "Formato usado inválido.", Toast.LENGTH_LONG).show();
                return null;
            }else if (opcaoBtn == "%") {
                Toast.makeText(MainActivity.this, "Formato usado inválido.", Toast.LENGTH_LONG).show();
                return null;
            }else if (opcaoBtn == "-") {
                Toast.makeText(MainActivity.this, "Formato usado inválido.", Toast.LENGTH_LONG).show();
                return null;
            } else {
                return opcaoBtn;
            }

        }else{

            if(opcaoBtn == "+"){

                if( strNumAntesSinal.substring(strNumAntesSinal.length()-1).equals("+")){
                    //faz nada
                }else{

                    strNumAntesSinalF = strNumAntesSinalF + opcaoBtn;

                }

            }else if(opcaoBtn == "÷"){

                if( strNumAntesSinal.substring(strNumAntesSinal.length()-1).equals("÷")){
                    //faz nada
                }else{

                    strNumAntesSinalF = strNumAntesSinalF + opcaoBtn;

                }

            }else if(opcaoBtn == "x"){

                if( strNumAntesSinal.substring(strNumAntesSinal.length()-1).equals("x")){
                    //faz nada
                }else{

                    strNumAntesSinalF = strNumAntesSinalF + opcaoBtn;

                }

            }else if(opcaoBtn == "%"){

                if( strNumAntesSinal.substring(strNumAntesSinal.length()-1).equals("%")){
                    //faz nada
                }else{

                    strNumAntesSinalF = strNumAntesSinalF + opcaoBtn;

                }

            }else if(opcaoBtn == "-"){

                if( strNumAntesSinal.substring(strNumAntesSinal.length()-1).equals("-")){
                    //faz nada
                }else{

                    strNumAntesSinalF = strNumAntesSinalF + opcaoBtn;

                }

            }else {

                strNumAntesSinalF = strNumAntesSinalF + opcaoBtn;

            }

            return strNumAntesSinalF;
        }
    }
}