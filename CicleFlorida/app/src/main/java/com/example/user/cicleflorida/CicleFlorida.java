package com.example.user.cicleflorida;


import java.util.ArrayList;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.LinearLayout;

public class CicleFlorida extends Activity {
    private String familiaProfessional;
    private String tipus;
    private String titol;
    private String Descripcio;

    static String o=null;
    static int l=0,r=0;

    private Nivel fn;
    private Estatico fe;
    private Listado fl;
    private FragmentManager fm;
    private FragmentTransaction ft1, ft2;



    public static void Clase(int t){

        if (t==1){
            l=1;
        }
        if (t==2){
            l=2;
        }
        if (t==3){
            l=3;
        }
    }

    public static void Clasificar(int n){

        if (n==1){
            r=1;
        }
        if (n==2){
            r=2;
        }

    }



    public CicleFlorida(String familiaProfessional, String tipus, String titol, String descripcio) {

        this.familiaProfessional = familiaProfessional;
        this.tipus = tipus;
        this.titol = titol;
        Descripcio = descripcio;
    }

    public String getFamiliaProfessional() {
        return familiaProfessional;
    }

    public void setFamiliaProfessional(String familiaProfessional) {
        this.familiaProfessional = familiaProfessional;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return Descripcio;
    }

    public void setDescripcio(String descripcio) {
        Descripcio = descripcio;
    }

    public static void creaDades(){


        CicleFlorida c;
        ArrayList<CicleFlorida> llistat_titulacions = new ArrayList<CicleFlorida>();


        c = new CicleFlorida("ESPORT","Superior","Animació d'activitats físiques i esportives","Aquesta formació concertat de nivell superior cicle formes com un Tècnic Superior en activitats físiques i esportives, que està especialitzat en ensenyament i dinamització de jocs i activitats de fitness.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("ESPORT","Mitjà","Conducción de actividades físico deportivas en el medio natural","Este Ciclo Formativo de Grado Medio te forma como Técnico/a en Conducción de actividades físico deportivas en el medio natural, permitiéndote la especialización posterior como Técnico de Actividades físico deportivas.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Gestión de Ventas y Espacios Comerciales","Nuevo ciclo formativo de grado superior concertado por la GVA");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Marketing y publicidad","Este ciclo te prepara para definir y efectuar el seguimiento de las políticas de marketing de una empresa.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Administración y Finanzas / FP Dual BANKIA","Dentro de la modalidad de FP Dual, Florida Universitaria, en colaboración con Bankia, pone en marcha el Ciclo de Técnico/a Superior en Administración y Finanzas. Este Ciclo Formativo se desarrolla 100% en modalidad DUAL, con 9 meses de estancia en las sucursales de Bankia, formándote con una alta especialización en el ámbito financiero bancario.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Mitjà","Sistemas Microinformáticos y Redes","Este Ciclo Formativo de Grado Medio concertado te forma como Técnico/a en Sistemas Microinformáticos y Redes, permitiéndote la especialización posterior en el desarrollo de aplicaciones o la administración de sistemas informáticos.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Administración de Sistemas Informáticos y en Red","Este Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en la configuración, administración y mantenimiento de sistemas informáticos en red.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Multiplataforma","Este NUEVO Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones para diferentes plataformas tecnológicas.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Web","ste NUEVO Ciclo Formativo de Grado Superior privado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones web");
        llistat_titulacions.add(c);
        if (l==3){
            if (r==1){
                o= String.valueOf(llistat_titulacions.get(1));
            }
            if (r==2) {
                o= String.valueOf(llistat_titulacions.get(2));
            }

        }
        if (l==2){
            if (r==1){
                o= String.valueOf(llistat_titulacions.get(3)+"/n"+llistat_titulacions.get(4)+"/n"+llistat_titulacions.get(5));
            }
            if (r==2) {

            }

        }
        if (l==1){
            if (r==1){
                o= String.valueOf(llistat_titulacions.get(7)+"/n"+llistat_titulacions.get(8)+"/n"+llistat_titulacions.get(9));
            }
            if (r==2) {
                o= String.valueOf(llistat_titulacions.get(6));
            }

        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm=getFragmentManager();
        fe=(Estatico) fm.findFragmentById(R.id.fragment);
        ft1=fm.beginTransaction();
        ft1.add(R.id.fragment_dinamic1,fn);
        ft1.commit();
        fl = Listado.newInstance(o);
        ft2=fm.beginTransaction();
        ft2.add(R.id.fragment_dinamic2,fl);
        ft2.commit();

    }






}
