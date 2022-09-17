package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView id=(TextView)findViewById(R.id.Edite_id);
        TextView nome=(TextView)findViewById(R.id.Edite_nome);
        TextView endereco=(TextView)findViewById(R.id.edi_Endereco);
        Button adicionar=(Button)findViewById(R.id.BtAdd2);
        Button bteditar=(Button)findViewById(R.id.BtEditar2);
        Button btDelete=(Button)findViewById(R.id.btDelete2);
        Button btList=(Button)findViewById(R.id.BtList2);

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection connection=connectionclass();
                try {
                    if (connection !=null){
                        String sqlinsert="Inset into UserInfo_Tab values ('"+id.getText().toString()+"','"+nome.getText().toString()+"','"+endereco.getText().toString()+"')";
                        Statement st= connection.createStatement();
                        ResultSet rs=st.executeQuery(sqlinsert);
                    }
                }
                catch (Exception exception){
                    Log.e("Erro", exception.getMessage());
                }
            }
        });
        bteditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection connection=connectionclass();
                try {
                    if (connection !=null){
                        String sqlinsert="Edtar UserInfo_Tab values set Nome = '"+nome.getText().toString()+"',Endereco= '"+endereco.getText().toString()+"' where ID= '"+id.getText().toString()+"'";
                        Statement st= connection.createStatement();
                        ResultSet rs=st.executeQuery(sqlinsert);
                    }
                }
                catch (Exception exception){
                    Log.e("Erro", exception.getMessage());
                }
            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection connection=connectionclass();
                try {
                    if (connection !=null){
                        String sqldelete="Delete UserInfo_Tab where ID= '"+id.getText().toString()+"'";
                        Statement st= connection.createStatement();
                        ResultSet rs=st.executeQuery(sqldelete);
                    }
                }
                catch (Exception exception){
                    Log.e("Erro", exception.getMessage());
                }
            }
        });
        btList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection connection=connectionclass();
                try {
                    if (connection !=null){
                        String sqldelete="select * from UserInfo_Tab where ID= '"+id.getText().toString()+"'";
                        Statement st= connection.createStatement();
                        ResultSet rs=st.executeQuery(sqldelete);

                        while (rs.next()){
                            nome.setText(rs.getString(2));
                            endereco.setText(rs.getString(3));
                        }

                    }
                }
                catch (Exception exception){
                    Log.e("Erro", exception.getMessage());
                }
            }
        });
    }
    @SuppressLint("NovaApi")
    public Connection connectionclass(){
        Connection con=null;
        String ip="", prot="",  username="", password="", databasename="";
        StrictMode.ThreadPolicy tp=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tp);
        try {
            Class.forName("");
            String connectionUrl=":sqlserver://"+ip+":"+tp+";databasename="+databasename+";User="+username+";password="+password+";";
            con= DriverManager.getConnection(connectionUrl);
        }
        catch (Exception exception){
            Log.e("Erro", exception.getMessage());
        }
        return con;
    }
}