package com.example.treintaalda.sqlDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.treintaalda.R;

public class DBHelper extends SQLiteOpenHelper {
    public static final  String DB_NAME = "db_sinAparato";
    public static final  int DB_VERSION = 1;

    int []baja_brazo = {R.drawable.flexion_pareddepie, R.drawable.lagartija_enrodillas, R.drawable.plancha_basica, R.drawable.plancha_conbrazoarriba, R.drawable.plancha_contoquealhombro};
    int []media_brazo = {R.drawable.flexion_tricepdepie, R.drawable.plancha_conunsolobrazo, R.drawable.plancha_toqueamano};
    int []alta_brazo = {R.drawable.flexion_cangrejo, R.drawable.lagartija_brazosalternados, R.drawable.plancha_decodoadelfin};
    int []baja_abdomen = {R.drawable.elevacion_depelvis, R.drawable.elevacion_depiernasacostado, R.drawable.rodillas_alpecho};
    int []media_abdomen = {R.drawable.plancha_conestencionbrazo, R.drawable.plancha_elevaciondepierna};
    int []alta_abdomen = {R.drawable.flexion_abdominalrodillas, R.drawable.flexion_vs, R.drawable.flexion_vstoquealtalon};
    int []baja_espalda = {R.drawable.estiramiento_brazopierna, R.drawable.plancha_arcoadentro, R.drawable.plancha_levantamientolateral};
    int []media_espalda = {R.drawable.estiramiento_espaldabrazoextendido, R.drawable.plancha_elevaciondepierna, R.drawable.plancha_extenciondepuno};
    int []alta_espalda = {R.drawable.lagartija_brazosalternados, R.drawable.plancha_decodoadelfin, R.drawable.plancha_invertidaconelevacionpierna};
    int []baja_pecho = {R.drawable.flexion_pareddepie, R.drawable.plancha_basica, R.drawable.plancha_contoquealhombro, R.drawable.plancha_levantamientolateral};
    int []media_pecho = {R.drawable.plancha_extenciondepuno, R.drawable.plancha_toqueamano};
    int []alta_pecho = {R.drawable.flexion_vstoquealtalon, R.drawable.lagartija_brazosalternados, R.drawable.plancha_decodoadelfin};
    int []baja_pierna = {R.drawable.levantamiento_lateralpierna, R.drawable.rodillas_alpecho, R.drawable.sentadilla_contrapared};
    int []media_pierna = {R.drawable.flexion_desplantes, R.drawable.sentadilla_contraparedyelevacionpierna};
    int []alta_pierna = {R.drawable.flexion_vs, R.drawable.plancha_invertidaconelevacionpierna};


    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabla_altaPierna = "CREATE TABLE alta_pierna(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, series INTEGER, repeticiones INTEGER, descripcion VARCHAR, img INTEGER )";
        db.execSQL(tabla_altaPierna);
        tab_altaPierna(db);
        String tabla_mediaPierna = "CREATE TABLE media_pierna(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, series INTEGER, repeticiones INTEGER, descripcion VARCHAR, img INTEGER )";
        db.execSQL(tabla_mediaPierna);
        tab_mediaPierna(db);
        String tabla_bajaPierna = "CREATE TABLE baja_pierna(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, series INTEGER, repeticiones INTEGER, descripcion VARCHAR, img INTEGER )";
        db.execSQL(tabla_bajaPierna);
        tab_bajaPierna(db);
        String tabla_altaPecho = "CREATE TABLE alta_pecho(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, series INTEGER, repeticiones INTEGER, descripcion VARCHAR, img INTEGER )";
        db.execSQL(tabla_altaPecho);
        tab_altaPechoDB(db);
        String tabla_mediaPecho = "CREATE TABLE media_pecho(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, series INTEGER, repeticiones INTEGER, descripcion VARCHAR, img INTEGER )";
        db.execSQL(tabla_mediaPecho);
        tab_mediaPechoDB(db);
        String tabla_bajaPecho = "CREATE TABLE baja_pecho(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, series INTEGER, repeticiones INTEGER, descripcion VARCHAR, img INTEGER )";
        db.execSQL(tabla_bajaPecho);
        tab_bajaPechoDB(db);
        String tabla_altaEspalda = "CREATE TABLE alta_espalda(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, series INTEGER, repeticiones INTEGER, descripcion VARCHAR, img INTEGER )";
        db.execSQL(tabla_altaEspalda);
        tab_altaEspaldaDB(db);
        String tabla_mediaEspalda = "CREATE TABLE media_espalda(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, series INTEGER, repeticiones INTEGER, descripcion VARCHAR, img INTEGER )";
        db.execSQL(tabla_mediaEspalda);
        tab_mediaEspaldaDB(db);
        String tabla_bajaEspalda = "CREATE TABLE baja_espalda(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, series INTEGER, repeticiones INTEGER, descripcion VARCHAR, img INTEGER )";
        db.execSQL(tabla_bajaEspalda);
        tab_bajaEspaldaDB(db);
        String tabla_altaAbdomen = "CREATE TABLE alta_abdomen(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, series INTEGER, repeticiones INTEGER, descripcion VARCHAR, img INTEGER )";
        db.execSQL(tabla_altaAbdomen);
        tab_altaAbdomenDB(db);
        String tabla_mediaAbdomen = "CREATE TABLE media_abdomen(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, series INTEGER, repeticiones INTEGER, descripcion VARCHAR, img INTEGER )";
        db.execSQL(tabla_mediaAbdomen);
        tab_mediaAbdomenDB(db);
        String tabla_bajaAbdomen = "CREATE TABLE baja_abdomen(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, series INTEGER, repeticiones INTEGER, descripcion VARCHAR, img INTEGER )";
        db.execSQL(tabla_bajaAbdomen);
        tab_bajaAbdomenDB(db);
        String tabla_altaBrazo = "CREATE TABLE alta_brazo(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, series INTEGER, repeticiones INTEGER, descripcion VARCHAR, img INTEGER )";
        db.execSQL(tabla_altaBrazo);
        tab_altaBrazoDB(db);
        String tabla_mediaBrazo = "CREATE TABLE media_brazo(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, series INTEGER, repeticiones INTEGER, descripcion VARCHAR, img INTEGER )";
        db.execSQL(tabla_mediaBrazo);
        tab_mediaBrazoDB(db);
        String tabla_bajaBrazo = "CREATE TABLE baja_brazo(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, series INTEGER, repeticiones INTEGER, descripcion VARCHAR, img INTEGER)";
        db.execSQL(tabla_bajaBrazo);
        tab_bajaBrazoDB(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tab_bajaBrazoDB");
        db.execSQL("DROP TABLE IF EXISTS tab_mediaBrazoDB");
        db.execSQL("DROP TABLE IF EXISTS tab_altaBrazoDB");
        db.execSQL("DROP TABLE IF EXISTS tab_bajaAbdomenDB");
        db.execSQL("DROP TABLE IF EXISTS tab_mediaAbdomenDB");
        db.execSQL("DROP TABLE IF EXISTS tab_altaAbdomenDB");
        db.execSQL("DROP TABLE IF EXISTS tab_bajaEspaldaDB");
        db.execSQL("DROP TABLE IF EXISTS tab_mediaEspaldaDB");
        db.execSQL("DROP TABLE IF EXISTS tab_altaEspaldaDB");
        db.execSQL("DROP TABLE IF EXISTS tab_bajaPechoDB");
        db.execSQL("DROP TABLE IF EXISTS tab_mediaPechoDB");
        db.execSQL("DROP TABLE IF EXISTS tab_altaPechoDB");
        db.execSQL("DROP TABLE IF EXISTS tab_bajaPierna");
        db.execSQL("DROP TABLE IF EXISTS tab_mediaPierna");
        db.execSQL("DROP TABLE IF EXISTS tab_altaPierna");
        onCreate(db);
    }
    private void tab_altaPierna(SQLiteDatabase db){
        ContentValues abs1 = new ContentValues();
        abs1.put("name", "V's");
        abs1.put("series", 4);
        abs1.put("repeticiones", 5);
        abs1.put("descripcion", "Recostado y con las piernas elevadas, flexiona el abdomen del tal manera que las piernas y el abdomen formen una V.");
        abs1.put("img", alta_pierna[0]);
        db.insert("alta_pierna", null, abs1);
        ContentValues per2 = new ContentValues();
        per2.put("name", "Plancha invertida con elevación");
        per2.put("series", 1);
        per2.put("repeticiones", 4);
        per2.put("descripcion", "Sostente con los antebrazos y los talones, manten la posición por 30 segundos.");
        per2.put("img", alta_pierna[1]);
        db.insert("alta_pierna", null, per2);
    }
    private void tab_mediaPierna(SQLiteDatabase db){
        ContentValues per1 = new ContentValues();
        per1.put("name", "Desplante");
        per1.put("series", 3);
        per1.put("repeticiones", 15);
        per1.put("descripcion", "Da un paso y flexiona las piernas, repite el ejercicio con la otra pierna. La flexión con ambas piernas se considera 1 repetición.");
        per1.put("img", media_pierna[0]);
        db.insert("media_pierna", null, per1);
        ContentValues per2 = new ContentValues();
        per2.put("name", "Sentarse contra la pared con elevación de pierna");
        per2.put("series", 3);
        per2.put("repeticiones", 4);
        per2.put("descripcion", "Recarga la espalda sobre una pared, de ahí toma una postura como si te fueras a sentar. Eleva una pierna a la altura de la rodilla. Manten la postura por 20 segundos. Cada elevación de pierna cuenta como 1 repetición.");
        per2.put("img", media_pierna[1]);
        db.insert("media_pierna", null, per2);
    }
    private void tab_bajaPierna(SQLiteDatabase db){
        ContentValues per1 = new ContentValues();
        per1.put("name", "Elevación de pierna lateral\n");
        per1.put("series", 3);
        per1.put("repeticiones", 10);
        per1.put("descripcion", "Eleva la pierna de manera lateral lo mas que puedas a la altura de la cadera.");
        per1.put("img", baja_pierna[0]);
        db.insert("baja_pierna", null, per1);
        ContentValues per2 = new ContentValues();
        per2.put("name", "Rodillas al pecho");
        per2.put("series", 3);
        per2.put("repeticiones", 5);
        per2.put("descripcion", "Recuestate con las rodillas dobladas. Flexiona la cadera y lleva las rodillas al pecho.");
        per2.put("img", baja_pierna[1]);
        db.insert("baja_pierna", null, per2);
        ContentValues per3 = new ContentValues();
        per3.put("name", "Sentarse contra la pared");
        per3.put("series", 1);
        per3.put("repeticiones", 2);
        per3.put("descripcion", "Recarga la espalda sobre una pared, de ahí toma una postura como si te fueras a sentar. Manten la postura por 15 segundos.");
        per3.put("img", baja_pierna[2]);
        db.insert("baja_pierna", null, per3);
    }
    private void tab_altaPechoDB(SQLiteDatabase db){
        ContentValues epo1 = new ContentValues();
        epo1.put("name", "V's con toque a los talones");
        epo1.put("series", 3);
        epo1.put("repeticiones", 4);
        epo1.put("descripcion", "Recostado y con las piernas elevadas, flexiona el abdomen del tal manera que las manos toquen los pies.");
        epo1.put("img", alta_pecho[0]);
        db.insert("alta_pecho", null, epo1);
        ContentValues epo2 = new ContentValues();
        epo2.put("name", "Lagartija con brazos alternados");
        epo2.put("series", 4);
        epo2.put("repeticiones", 10);
        epo2.put("descripcion", "Toma la posición de lagartija pero con un brazo a la altura de cabeza y el otro del pecho, flexiona y no cambies de brazo. Las series se consideran por brazo.");
        epo2.put("img", alta_pecho[1]);
        db.insert("alta_pecho", null, epo2);
        ContentValues esp3 = new ContentValues();
        esp3.put("name", "Plancha codo a delfín");
        esp3.put("series", 2);
        esp3.put("repeticiones", 4);
        esp3.put("descripcion", "Toma la pose de plancha y eleva la cadera, sostente con los brazos y pies.");
        esp3.put("img", alta_pecho[2]);
        db.insert("alta_pecho", null, esp3);
    }
    private void tab_mediaPechoDB(SQLiteDatabase db){
        ContentValues  epo1 = new ContentValues();
        epo1.put("name", "Plancha con puño");
        epo1.put("series", 3);
        epo1.put("repeticiones", 4);
        epo1.put("descripcion", "En posición de plancha, extiende el brazo de tal manera que el codo quede al nivel de la cara, regresa el brazo a su posición original y repite el exerciso con el otro brazo. La extención de ambos brazos cuenta como 1 repetición.");
        epo1.put("img", media_pecho[0]);
        db.insert("media_pecho", null, epo1);
        ContentValues epo2 = new ContentValues();
        epo2.put("name", "Plancha con toque a mano");
        epo2.put("series", 3);
        epo2.put("repeticiones", 3);
        epo2.put("descripcion", "Flexiona los brazos como en una lagartija normal, al momento de subir en vez de volver a bajar, toca con mano la otra, después del toque, regresa la mano a su posición y vuelve a bajar, repite el moviento con la otra mano. Tocar ambas manos cuenta como 1 repetición.");
        epo2.put("img", media_pecho[1]);
        db.insert("media_pecho", null, epo2);
    }
    private void tab_bajaPechoDB(SQLiteDatabase db){
        ContentValues epo1 = new ContentValues();
        epo1.put("name", "Flexion de pared");
        epo1.put("series", 4);
        epo1.put("repeticiones", 10);
        epo1.put("descripcion", "Está es una flexión contra la pared, lo cuál ayuda a disminuir el esfuerzo que haces en los brazos si es que no acostumbras a ejercitarte. Si deseas aumentar el esfuerzo, solo separa el cuerpo para que quede más inclinado. Sigue aumentando la inclinación con forme progreses hasta que te sientas comodo para realizar lagartijas.");
        epo1.put("img", baja_pecho[0]);
        db.insert("baja_pecho", null, epo1);
        ContentValues epo2 = new ContentValues();
        epo2.put("name", "Plancha sencilla");
        epo2.put("series", 1);
        epo2.put("repeticiones", 1);
        epo2.put("descripcion", "Permanece en esta pose por 1 minuto. Esta pose es basica para muchos otros ejercicios relacionados con varias partes del cuerpo por lo que es muy buena para los que apenas van empezando a ejercitarse.");
        epo2.put("img", baja_pecho[1]);
        db.insert("baja_pecho", null, epo2);
        ContentValues epo3 = new ContentValues();
        epo3.put("name", "Plancha con toque al hombro");
        epo3.put("series", 3);
        epo3.put("repeticiones", 5);
        epo3.put("descripcion", "Este ejercicio estimula el moviento de los músculos, toma la posición de plancha básica y empieza moviendo alguna de tus manos al hombro contrario y regresa tu mano a su posición original, luego reptite el mismo movimiento con la otra mano. Tocar ambos hombros cuenta como 1 repetición.");
        epo3.put("img", baja_pecho[2]);
        db.insert("baja_pecho", null, epo3);
        ContentValues  esp4 = new ContentValues();
        esp4.put("name", "Plancha brazo lateral");
        esp4.put("series", 3);
        esp4.put("repeticiones", 4);
        esp4.put("descripcion", "En posición de lagartija, eleva el brazo de forma recta a un costado, de tal forma que formes una L.");
        esp4.put("img", baja_pecho[3]);
        db.insert("baja_pecho", null, esp4);
    }
    private void tab_altaEspaldaDB(SQLiteDatabase db){
        ContentValues esp1 = new ContentValues();
        esp1.put("name", "Lagartija con brazos alternados");
        esp1.put("series", 4);
        esp1.put("repeticiones", 10);
        esp1.put("descripcion", "Toma la posición de lagartija pero con un brazo a la altura de cabeza y el otro del pecho, flexiona y no cambies de brazo. Las series se consideran por brazo.");
        esp1.put("img", alta_espalda[0]);
        db.insert("alta_espalda", null, esp1);
        ContentValues esp2 = new ContentValues();
        esp2.put("name", "Plancha codo a delfín");
        esp2.put("series", 2);
        esp2.put("repeticiones", 4);
        esp2.put("descripcion", "Toma la pose de plancha y eleva la cadera, sostente con los brazos y pies.");
        esp2.put("img", alta_espalda[1]);
        db.insert("alta_espalda", null, esp2);
        ContentValues esp3 = new ContentValues();
        esp3.put("name", "Plancha invertida con elevación");
        esp3.put("series", 1);
        esp3.put("repeticiones", 4);
        esp3.put("descripcion", "Sostente con los antebrazos y los talones, manten la posición por 30 segundos.");
        esp3.put("img", alta_espalda[2]);
        db.insert("alta_espalda", null, esp3);
    }
    private void tab_mediaEspaldaDB(SQLiteDatabase db){
        ContentValues  esp1 = new ContentValues();
        esp1.put("name", "Estiramiento de espalda en rodilla");
        esp1.put("series", 4);
        esp1.put("repeticiones", 10);
        esp1.put("descripcion", "Con las rodillas y los pies tocando el suelo, posiciona las manos pos encima de la cabeza y regresa a la posición original.");
        esp1.put("img", media_espalda[0]);
        db.insert("media_espalda", null, esp1);
        ContentValues  esp2 = new ContentValues();
        esp2.put("name", "Plancha de pierna elevada");
        esp2.put("series", 4);
        esp2.put("repeticiones", 3);
        esp2.put("descripcion", "Separa las piernas a la altura de los hombros y alza un pierna de tal manera que quede recta con el resto del cuerpo. Manten la posición por 30 segundos.");
        esp2.put("img", media_espalda[1]);
        db.insert("media_espalda", null, esp2);
        ContentValues  esp3 = new ContentValues();
        esp3.put("name", "Plancha con puño");
        esp3.put("series", 3);
        esp3.put("repeticiones", 4);
        esp3.put("descripcion", "En posición de plancha, extiende el brazo de tal manera que el codo quede al nivel de la cara, regresa el brazo a su posición original y repite el exerciso con el otro brazo. La extención de ambos brazos cuenta como 1 repetición.");
        esp3.put("img", media_espalda[2]);
        db.insert("media_espalda", null, esp3);
    }
    private void tab_bajaEspaldaDB(SQLiteDatabase db){
        ContentValues  esp1 = new ContentValues();
        esp1.put("name", "Estiramiento de brazo y pierna");
        esp1.put("series", 1);
        esp1.put("repeticiones", 6);
        esp1.put("descripcion", "Con las manos y rodillas tocando el suelo, extiende el brazo y pierna opuestos y manten la posición por 20 segundos.");
        esp1.put("img", baja_espalda[0]);
        db.insert("baja_espalda", null, esp1);
        ContentValues  esp2 = new ContentValues();
        esp2.put("name", "Plancha espalda dentro");
        esp2.put("series", 2);
        esp2.put("repeticiones", 4);
        esp2.put("descripcion", "En posición de plancha, baja al abdomen al suelo sin tocarlo y regresa a la posición de plancha.");
        esp2.put("img", baja_espalda[1]);
        db.insert("baja_espalda", null, esp2);
        ContentValues  esp3 = new ContentValues();
        esp3.put("name", "Plancha brazo lateral");
        esp3.put("series", 3);
        esp3.put("repeticiones", 4);
        esp3.put("descripcion", "En posición de lagartija, eleva el brazo de forma recta a un costado, de tal forma que formes una L.");
        esp3.put("img", baja_espalda[2]);
        db.insert("baja_espalda", null, esp3);
    }
    private void tab_altaAbdomenDB(SQLiteDatabase db){
        ContentValues abs1 = new ContentValues();
        abs1.put("name", "Abdominal con flexion de piernas");
        abs1.put("series", 3);
        abs1.put("repeticiones", 5);
        abs1.put("descripcion", "Con las piernas elevadas, realiza una abdominal al mismo tiempo que llevas las rodillas al pecho.");
        abs1.put("img", alta_abdomen[0]);
        db.insert("alta_abdomen", null, abs1);
        ContentValues abs2 = new ContentValues();
        abs2.put("name", "V's");
        abs2.put("series", 4);
        abs2.put("repeticiones", 5);
        abs2.put("descripcion", "Recostado y con las piernas elevadas, flexiona el abdomen del tal manera que las piernas y el abdomen formen una V.");
        abs2.put("img", alta_abdomen[1]);
        db.insert("alta_abdomen", null, abs2);
        ContentValues abs3 = new ContentValues();
        abs3.put("name", "V's con toque a los talones");
        abs3.put("series", 3);
        abs3.put("repeticiones", 4);
        abs3.put("descripcion", "Recostado y con las piernas elevadas, flexiona el abdomen del tal manera que las manos toquen los pies.");
        abs3.put("img", alta_abdomen[2]);
        db.insert("alta_abdomen", null, abs3);

    }
    private void tab_mediaAbdomenDB(SQLiteDatabase db){
        ContentValues abs1 = new ContentValues();
        abs1.put("name", "Plancha extención brazo");
        abs1.put("series", 3);
        abs1.put("repeticiones", 6);
        abs1.put("descripcion", "En posición de plancha, extiende el brazo al frente de la manera que te sostengas con un brazo, regresa el brazo a su posición y repite con el otro brazo.");
        abs1.put("img", media_abdomen[0]);
        db.insert("media_abdomen", null, abs1);
        ContentValues abs2 = new ContentValues();
        abs2.put("name", "Plancha elevación de pierna");
        abs2.put("series", 4);
        abs2.put("repeticiones", 3);
        abs2.put("descripcion", "Separa las piernas a la altura de los hombros y alza un pierna de tal manera que quede recta con el resto del cuerpo. Manten la posición por 30 segundos.");
        abs2.put("img", media_abdomen[1]);
        db.insert("media_abdomen", null, abs2);
    }
    private void tab_bajaAbdomenDB(SQLiteDatabase db){
        ContentValues abs1 = new ContentValues();
        abs1.put("name", "Elevación de pelvis");
        abs1.put("series", 3);
        abs1.put("repeticiones", 4);
        abs1.put("descripcion", "Recuestate con las rodillas dobladas. Sosteniendo tu peso en los pies y en la espalda alta, eleva la cadera y manten la posición por 15 segundos.");
        abs1.put("img", baja_abdomen[0]);
        db.insert("baja_abdomen", null, abs1);
        ContentValues abs2 = new ContentValues();
        abs2.put("name", "Levantamiento de piernas");
        abs2.put("series", 4);
        abs2.put("repeticiones", 5);
        abs2.put("descripcion", "Rescostado boca arriba, eleva las piernas levemente.");
        abs2.put("img", baja_abdomen[1]);
        db.insert("baja_abdomen", null, abs2);
        ContentValues abs3 = new ContentValues();
        abs3.put("name", "Rodillas al pecho");
        abs3.put("series", 3);
        abs3.put("repeticiones", 5);
        abs3.put("descripcion", "Recuestate con las rodillas dobladas. Flexiona la cadera y lleva las rodillas al pecho.");
        abs3.put("img", baja_abdomen[2]);
        db.insert("baja_abdomen", null, abs3);
    }
    private void tab_altaBrazoDB(SQLiteDatabase db){
        ContentValues brazo1 = new ContentValues();
        brazo1.put("name", "Flexión cangrejo");
        brazo1.put("series", 3);
        brazo1.put("repeticiones", 4);
        brazo1.put("descripcion", "Toma posición de cangrejo y flexiona los brazos sin bajar la cadera, de lo contrario el ejercicio no tendra el resultado deseado.");
        brazo1.put("img", alta_brazo[0]);
        db.insert("alta_brazo", null, brazo1);
        ContentValues brazo2 = new ContentValues();
        brazo2.put("name", "Lagartija con brazos alternados");
        brazo2.put("series", 4);
        brazo2.put("repeticiones", 10);
        brazo2.put("descripcion", "Toma la posición de lagartija pero con un brazo a la altura de cabeza y el otro del pecho, flexiona y no cambies de brazo. Las series se consideran por brazo.");
        brazo2.put("img", alta_brazo[1]);
        db.insert("alta_brazo", null, brazo2);
        ContentValues brazo3 = new ContentValues();
        brazo3.put("name", "Plancha codo a delfín");
        brazo3.put("series", 2);
        brazo3.put("repeticiones", 4);
        brazo3.put("descripcion", "Toma la pose de plancha y eleva la cadera, sostente con los brazos y pies.");
        brazo3.put("img", alta_brazo[2]);
        db.insert("alta_brazo", null, brazo3);
    }
    private void tab_mediaBrazoDB(SQLiteDatabase db){
        ContentValues brazo1 = new ContentValues();
        brazo1.put("name", "Flexión tricep pared");
        brazo1.put("series", 3);
        brazo1.put("repeticiones", 10);
        brazo1.put("descripcion", "Similar a la flexión de pared, pero en vez de recargar el sobre las manos lo harás con la parte de abajo de los puños y con los brazos flexionados, ya en esa posición gira los puños hacia adelante al mismo tiempo que estiras los brazos, de tal manera que los nudillos toquen la pared y los brazos queden completamente estirados.");
        brazo1.put("img", media_brazo[0]);
        db.insert("media_brazo", null, brazo1);
        ContentValues brazo2 = new ContentValues();
        brazo2.put("name", "Plancha con un brazo");
        brazo2.put("series", 3);
        brazo2.put("repeticiones", 4);
        brazo2.put("descripcion", "En posición de plancha básica, pega un brazo al cuerpo mientras el otro soporta el cuerpo, el esfuerzo se debe sentir en el brazo que soporta y en el abdomen. Si necesitas auxiliarte un poco, separa la piernas hasta que sientas el esfuerzo en las areas ya mencionadas.");
        brazo2.put("img", media_brazo[1]);
        db.insert("media_brazo", null, brazo2);
        ContentValues brazo3 = new ContentValues();
        brazo3.put("name", "Plancha con toque a mano");
        brazo3.put("series", 3);
        brazo3.put("repeticiones", 3);
        brazo3.put("descripcion", "Flexiona los brazos como en una lagartija normal, al momento de subir en vez de volver a bajar, toca con mano la otra, después del toque, regresa la mano a su posición y vuelve a bajar, repite el moviento con la otra mano. Tocar ambas manos cuenta como 1 repetición.");
        brazo3.put("img", media_brazo[2]);
        db.insert("media_brazo", null, brazo3);
    }
    private void tab_bajaBrazoDB(SQLiteDatabase db){
        ContentValues brazo1 = new ContentValues();
        brazo1.put("name", "Flexión en pared");
        brazo1.put("series", 4);
        brazo1.put("repeticiones", 10);
        brazo1.put("descripcion", "Está es una flexión contra la pared, lo cuál ayuda a disminuir el esfuerzo que haces en los brazos si es que no acostumbras a ejercitarte. Si deseas aumentar el esfuerzo, solo separa el cuerpo para que quede más inclinado. Sigue aumentando la inclinación con forme progreses hasta que te sientas comodo para realizar lagartijas.");
        brazo1.put("img", baja_brazo[0]);
        db.insert("baja_brazo", null, brazo1);

        ContentValues brazo2 = new ContentValues();
        brazo2.put("name", "Lagartija con rodillas");
        brazo2.put("series", 3);
        brazo2.put("repeticiones", 5);
        brazo2.put("descripcion", "Los pies deben estan siempre alzados, esto ayuda a empezar a fortalecerlos. La cadera recta con la espalda y piernas para fortalecer el abdomen.");
        brazo2.put("img", baja_brazo[1]);
        db.insert("baja_brazo", null, brazo2);

        ContentValues brazo3 = new ContentValues();
        brazo3.put("name", "Plancha sencilla");
        brazo3.put("series", 1);
        brazo3.put("repeticiones", 1);
        brazo3.put("descripcion", "Permanece en esta pose por 1 minuto. Esta pose es basica para muchos otros ejercicios relacionados con varias partes del cuerpo por lo que es muy buena para los que apenas van empezando a ejercitarse.");
        brazo3.put("img", baja_brazo[2]);
        db.insert("baja_brazo", null, brazo3);

        ContentValues brazo4 = new ContentValues();
        brazo4.put("name", "Plancha con brazo arriba");
        brazo4.put("series", 3);
        brazo4.put("repeticiones", 4);
        brazo4.put("descripcion", "Este ejercicio ayuda a incrementar el equilibro, la clave es de manera lenta alzar el brazo en línea recta con el cuerpo, mantenerlo un segundo y de ahí fajarlo para cambiar de brazo. Cada levantamiento de brazo cuenta como 1 repetición.");
        brazo4.put("img", baja_brazo[3]);
        db.insert("baja_brazo", null, brazo4);

        ContentValues brazo5 = new ContentValues();
        brazo5.put("name", "Plancha con toque al hombro");
        brazo5.put("series", 3);
        brazo5.put("repeticiones", 5);
        brazo5.put("descripcion", "Este ejercicio estimula el moviento de los músculos, toma la posición de plancha básica y empieza moviendo alguna de tus manos al hombro contrario y regresa tu mano a su posición original, luego reptite el mismo movimiento con la otra mano. Tocar ambos hombros cuenta como 1 repetición.");
        brazo5.put("img", baja_brazo[4]);
        db.insert("baja_brazo", null, brazo5);
    }
}
