package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import model.Agenda;

/**
 * Created by Cleiton Gonçalves on 04/02/2016.
 */
public class BancoHelper extends SQLiteOpenHelper {

    // Vercao do Banco
    private static final int DATABASE_VERSION = 1;

    // Nome da Base de dados
    private static final String DATABASE_NAME = "agendaTelefonica";

    // Nome da tabela
    private static final String TABLE_NAME = "agenda";

    public BancoHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Criando tabela
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE agenda(_id INTEGER PRIMARY KEY  AUTOINCREMENT,nome TEXT, telefone TEXT, imagem integer)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Deletando tabela existente
        db.execSQL("DROP TABLE IF EXISTS agenda" );
        // Criando nova tabela
        onCreate(db);
    }

    /**
     *  CRUD(Create, Read, Update, Delete)
     */

    // Adicionando nova agenda
    public void addAgenda(Agenda agenda) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", agenda.getNome());
        values.put("telefone", agenda.getTelefone());
        values.put("imagem", agenda.getImagem());

        // Inserindo valor
        db.insert(TABLE_NAME, null, values);
        //Fechando conexao
        db.close();
    }


    // Retorna um unico Agenda
    public  Agenda getAgenda(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT _id,  nome,telefone,imagem FROM agenda where _id = ?";

        Cursor cursor = db.rawQuery(sql,new String[]{ String.valueOf(id)});

        if (cursor != null){
            cursor.moveToFirst();

            Agenda agenda = new Agenda();
            agenda.setId(cursor.getInt(0));
            agenda.setNome(cursor.getString(1));
            agenda.setTelefone(cursor.getString(2));
            agenda.setImagem(cursor.getInt(3));

            // return Agenda
            return agenda;

        }
        return  null;

    }

    // Obtendo todos os Agenda
    public List<Agenda> getAllAgendas() {
        List<Agenda> agendas = new ArrayList<Agenda>();
        // Sql da consulta da base de dados
        String sql = "SELECT _id,  nome,telefone,imagem FROM agenda";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        // looping Povoando a lista de Agendas
        if (cursor.moveToFirst()) {
            do {
                Agenda agenda = new Agenda();
                //agenda.setId(cursor.getInt(0));
                agenda.setNome(cursor.getString(1));
                agenda.setTelefone(cursor.getString(2));
                agenda.setImagem(cursor.getInt(3));
                // Adicionando elemento a lista
                agendas.add(agenda);
            } while (cursor.moveToNext());
        }
        return agendas;
    }


    // Updating uma única agenda
    public int updateAgenda(Agenda agenda) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", agenda.getNome());
        values.put("telefone", agenda.getTelefone());
        values.put("imagem",agenda.getImagem());

        // updating row
        return db.update(TABLE_NAME, values,  "_id = ?",
                new String[] { String.valueOf(agenda.getId()) });
    }

    // Delettando uma agenda
    public void deleteAgenda(Agenda agenda) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, " _id= ?",
                new String[]{String.valueOf(agenda.getId())});
        db.close();
    }

    // Obter quantidade de Agendas
    public int getAgendaCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        // return count
        return cursor.getCount();
    }
}
