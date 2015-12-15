package com.example.cleiton.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Cleiton on 10/11/2015.
 */
public class Login extends Activity{
    EditText username1, senha1;
    String username, senha;
    TextView erro2;
    Button logar, voltar;
    Intent j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Intent i = getIntent();

        username = i.getStringExtra("username");
        senha = i.getStringExtra("senha");

        username1 = (EditText) findViewById(R.id.editText2);
        senha1 = (EditText) findViewById(R.id.editText);

        erro2 = (TextView) findViewById(R.id.textView4);

        logar = (Button) findViewById(R.id.button3);
        voltar = (Button) findViewById(R.id.button2);

    }

    public void cadastrar(View view){

        Intent i = new Intent(getBaseContext(), telaCadastro.class);

        startActivity(i);
    }

    public void botaoLogar(View view){

        boolean logado = false;
        String usuario = username1.getText().toString();
        String password = senha1.getText().toString();

        if(usuario.equals("")){
            username1.setHint(getResources().getText(R.string.cVazio));
        }if(password.equals("")){
            senha1.setHint(getResources().getText(R.string.cVazio));
        }else{

            for (User user : UserCollections.getInstance().getUsuarios()){
                if(user.getNome().equals(usuario)){
                    if(user.getSenha().equals(password)){
                        logado = true;
                        break;

                    }
                }
            }

            if(logado == true){
                Intent cadSucesso = new Intent(getBaseContext(), CadSucesso.class);

                Bundle b = new Bundle();
                b.putString("usuario", usuario );

                cadSucesso.putExtras(b);

                startActivity(cadSucesso);;




            }else{
                Toast.makeText(getApplicationContext(), getResources().getText(R.string.nCadastrado), Toast.LENGTH_LONG).show();
            }

        }





    }
}
