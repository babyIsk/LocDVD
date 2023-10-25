package com.example.locdvd;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewDVDActivity extends Activity {

    TextView txtTitreDVD;
    TextView txtAnneeDVD;
    TextView txtActeur1;
    TextView txtResumeFilm;

    /**Initialisation d'une activité, appelée qu'une seule fois au début du cycle de vie
     * Lier le layout (xml) ici car c'est la 1ère méthode invoquée
     * Recuperer les ressources du layout (comme un textview) et les affecté aux variables déclarées si dessus du meme type (ici TextView)
    **/
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //lier le layout à l'activity
        setContentView(R.layout.activity_viewdvd);

        //Obtention des références sur les composants (ressources)
        txtTitreDVD = (TextView) findViewById(R.id.titreDVD);
        txtAnneeDVD = (TextView) findViewById(R.id.anneeDVD);
        txtActeur1 = (TextView) findViewById(R.id.acteur1);
        txtResumeFilm = (TextView) findViewById(R.id.resumeFilm);
    }

    @Override
    protected void onStart () {
        super.onStart();
    }

    @Override
    protected void onResume () {
        super.onResume();

        txtTitreDVD.setText("Les vacances du petit Nicolas");
        // ne pas faire ça : txtAnneeDVD.setText("Année de sortie : 2014");
        // car le multilingue de la date ne peux pas etre géré, donc créer un string dans le dossier res/strings (ici : annee-de-sortie)
        String.format(getString(R.string.annee_de_sortie), 2014);
        txtActeur1.setText("Valérie Lemercier");
        String resume = "Un film parlant d'école et de vacances";
        txtResumeFilm.setText(resume);
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
