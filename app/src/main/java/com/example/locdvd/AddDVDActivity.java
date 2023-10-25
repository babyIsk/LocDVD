package com.example.locdvd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputLayout;

public class AddDVDActivity extends Activity{
    TextInputLayout editTitreFilm;
    TextInputLayout editAnnee;
    TextInputLayout editResume;
    Button btnAddActeur;
    Button btnOk;
    LinearLayout addActeursLayout;

    /**Initialisation d'une activité, appelée qu'une seule fois au début du cycle de vie
     * Lier le layout (xml) ici car c'est la 1ère méthode invoquée
     * Recuperer les ressources du layout (comme un textview) et les affecté aux variables déclarées si dessus du meme type (ici TextView)
     **/
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //lier le layout à l'activity
        setContentView(R.layout.activity_adddvd);

        //Obtention des références sur les composants (ressources)
        editTitreFilm = (TextInputLayout) findViewById(R.id.addDVD_titre);
        editAnnee = (TextInputLayout) findViewById(R.id.addDVD_annee);
        editResume = (TextInputLayout) findViewById(R.id.addDVD_resume);
        btnAddActeur = (Button) findViewById(R.id.addDVD_addActeur);
        btnOk = (Button) findViewById(R.id.addDVD_ok);

        //LinearLayout ajouté pour lorsque l'on click sur le bouton + pour ajouter un acteur
        addActeursLayout = (LinearLayout) findViewById(R.id.addDVD_addActeurLayout);

        btnAddActeur.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addActeur(null);
            }
        });

        //Est-ce une recréaction suite à une rotation de l'écran ?
        if (savedInstanceState !=null) {
            String [] acteurs = savedInstanceState.getStringArray("acteurs");
            for(String s : acteurs) {
            addActeur(s);
            }
        } else {
            //aucun acteur saisi, on affiche un composant InputText vide
            addActeur(null);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        String[] acteurs = new String[addActeursLayout.getChildCount()];
        for(int i=0; i < addActeursLayout.getChildCount(); i++) {
            View child = addActeursLayout.getChildAt(i);
            if (child instanceof TextInputLayout)
                acteurs[i] = ((TextInputLayout)child).getEditText().toString();
        }
        savedInstanceState.putStringArray("acteurs", acteurs);
        super.onSaveInstanceState(savedInstanceState);
    }
    private void addActeur(String content) {
        TextInputLayout editNewActeur = new TextInputLayout(this);
        if (content != null) {
            editNewActeur.setHelperText(content);
        }
        addActeursLayout.addView(editNewActeur);
    }

    @Override
    protected void onStart () {
        super.onStart();
    }

    @Override
    protected void onResume () {
        super.onResume();
    }

    @Override
    protected void onPause () {
        super.onPause();
    }

    @Override
    protected void onStop () {
        super.onStop();
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
    }
}
