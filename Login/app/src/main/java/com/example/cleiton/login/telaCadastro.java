package com.example.cleiton.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class telaCadastro extends AppCompatActivity {

    Button cadastrar;
    EditText username, senha, confirmaSenha;
    TextView erro1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        username = (EditText) findViewById(R.id.editText3);
        senha = (EditText) findViewById(R.id.editText4);
        cadastrar = (Button) findViewById(R.id.button4);
    }


    public void Voltar(View view){
        finish();
    }

    public void Salvar(View view){

        String usuario = username.getText().toString();
        String password = senha.getText().toString();

        if(usuario.equals("")){
            username.setHint(getResources().getText(R.string.cVazio));
        }if(password.equals("")){
            senha.setHint(getResources().getText(R.string.cVazio));
        }else{

            User user = new User();

            user.setNome(usuario);
            user.setSenha(password);

            UserCollections.getInstance().getUsuarios().add(user);
            Toast.makeText(getApplicationContext(), getResources().getText(R.string.cSucesso), Toast.LENGTH_LONG).show();

            finish();
        }

    }
}
