package gophonebrasil.com.ui.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import gophonebrasil.com.R;
import gophonebrasil.com.http.HttpService;
import gophonebrasil.com.http.jsonParse.ClienteJSONParser;
import gophonebrasil.com.model.Cliente;

public class LoginActivity extends AppCompatActivity {
    List<Cliente> clienteList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        clienteList = new ArrayList<>();
        buscarDados("https://gophonebrasil.com/api/clientes");
    }

    private void buscarDados(String uri) {
        MyTask task = new MyTask();
        task.execute(uri);
    }

    private class MyTask extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... params) {
            String conteudo = HttpService.getDados(params[0]);
            Log.i("API", "doInBackground: "+ conteudo);
            Log.i("API", "doInBackground: "+ conteudo);
            return conteudo;
        }

        @Override
        protected void onPostExecute(String result) {
            clienteList = ClienteJSONParser.parseDados(result);
            Cliente teste = clienteList.get(0);
            Toast.makeText(LoginActivity.this, teste.getNome(), Toast.LENGTH_LONG).show();
        }
    }

}