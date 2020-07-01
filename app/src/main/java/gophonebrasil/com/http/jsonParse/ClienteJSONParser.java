package gophonebrasil.com.http.jsonParse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import gophonebrasil.com.model.Cliente;

public class ClienteJSONParser {

    public static List<Cliente> parseDados(String content){
        try {
            JSONArray jsonArray = new JSONArray(content);
            List<Cliente> clienteList = new ArrayList<>();

            for (int i =0; i< jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Cliente cliente = new Cliente();
                cliente.setNome(jsonObject.getString("nome"));
                cliente.setCpf(jsonObject.getString("cpf"));
                cliente.setTelefone(jsonObject.getString("telefone"));
                cliente.setDataNascimento(jsonObject.getString("dataNascimento"));
                clienteList.add(cliente);
            }
            return clienteList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
