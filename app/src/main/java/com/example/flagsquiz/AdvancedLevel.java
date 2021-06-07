package com.example.flagsquiz;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static android.view.View.VISIBLE;

public class AdvancedLevel extends AppCompatActivity {

    public static int randomFlag41;
    public static int randomFlag42;
    public static int randomFlag43;
    public static String correctCountry;
    public static boolean correct = false;
    public int clickcount = 0;
    public int correctCount = 0;
    public int wrongCount = 0;

    private TextView Text1;
    private TextView Text2;
    private TextView Text3;
    private TextView  correctText41;
    private TextView incorrectText41;
    private TextView correctionText41;
    private TextView  correctText42;
    private TextView incorrectText42;
    private TextView correctionText42;
    private TextView  correctText43;
    private TextView incorrectText43;
    private TextView correctionText43;
    private Button submitButton;
    private Button nextButton;
    private Map flags4;
    private TextView score;

    private boolean isTimerOn;
    private static int TIME_OUT = 10000;
    private CountDownTimer t;
    //----Timer start------------
    private void startTimer(final TextView timer, final long finish, long tick) {
        t = new CountDownTimer(finish, tick) {

            public void onTick(long millisUntilFinished) {
                final long remainedSecs = millisUntilFinished / 1000;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //-----show the time---------
                        if (remainedSecs < 10) {
                            timer.setText(""  + " : 0" + (remainedSecs % 60));
                        } else {
                            timer.setText(""  + " : " + (remainedSecs % 60));
                        }
                    }
                });

            }

            public void onFinish() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if(Text1.getText().toString().isEmpty() & Text2.getText().toString().isEmpty() & Text3.getText().toString().isEmpty()  ){
//
                            incorrectText41.setText("WRONG!");
                            incorrectText41.setTextColor(Color.RED);
                            incorrectText42.setText("WRONG!");
                            incorrectText42.setTextColor(Color.RED);
                            incorrectText43.setText("WRONG!");
                            incorrectText43.setTextColor(Color.RED);

                            submitButton.setVisibility(View.INVISIBLE);
                            nextButton.setVisibility(View.VISIBLE);
                        }
                    }
                });
                cancel();
            }
        }.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_level);
        //--- check the front timer is on or off-------
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            isTimerOn = extras.getBoolean("timer");
        }
        //System.out.println("TEST_TIMER : "+isTimerOn);

//-------------------flag names and country name----------------------------
        final Map<Integer, String> flags4 = new HashMap<>();
        flags4.put(R.drawable.ad, "Andorra");
        flags4.put(R.drawable.ae, "United Arab Emirates");
        flags4.put(R.drawable.af, "Afghanistan");
        flags4.put(R.drawable.ag, "Antigua and Barbuda");
        flags4.put(R.drawable.ag, "Antigua and Barbuda");
        flags4.put(R.drawable.ai, "Anguilla");
        flags4.put(R.drawable.al, "Albania");
        flags4.put(R.drawable.am, "Armenia");
        flags4.put(R.drawable.an, "Netherlands Antilles");
        flags4.put(R.drawable.ao, "Angola");
        flags4.put(R.drawable.aq, "Antarctica");
        flags4.put(R.drawable.ar, "Argentina");
        flags4.put(R.drawable.as, "American Samoa");
        flags4.put(R.drawable.at, "Austria");
        flags4.put(R.drawable.au, "Australia");
        flags4.put(R.drawable.aw, "Aruba");
        flags4.put(R.drawable.ax, "land Islands");
        flags4.put(R.drawable.az, "Azerbaijan");
        flags4.put(R.drawable.ba, "Bosnia and Herzegovina");
        flags4.put(R.drawable.bb, "Barbados");
        flags4.put(R.drawable.bd, "Bangladesh");
        flags4.put(R.drawable.be, "Belgium");
        flags4.put(R.drawable.bf, "Burkina Faso");
        flags4.put(R.drawable.bg, "Bulgaria");
        flags4.put(R.drawable.bh, "Bahrain");
        flags4.put(R.drawable.bi, "Burundi");
        flags4.put(R.drawable.bj, "Benin");
        flags4.put(R.drawable.bl, "Saint Barthélemy");
        flags4.put(R.drawable.bm, "Bermuda");
        flags4.put(R.drawable.bn, "Brunei Darussalam");
        flags4.put(R.drawable.bo, "Bolivia, Plurinational State");
        flags4.put(R.drawable.bq, "Caribbean Netherlands");
        flags4.put(R.drawable.br, "Brazil");
        flags4.put(R.drawable.bs, "Bahamas");
        flags4.put(R.drawable.bt, "Bhutan");
        flags4.put(R.drawable.bv, "Bouvet Island");
        flags4.put(R.drawable.bw, "Botswana");
        flags4.put(R.drawable.by, "Belarus");
        flags4.put(R.drawable.bz, "Belize");
        flags4.put(R.drawable.ca, "Canada");
        flags4.put(R.drawable.cc, "Cocos (Keeling) Islands");
        flags4.put(R.drawable.cd, "Congo, the Democratic Republic of the");
        flags4.put(R.drawable.cf, "Central African Republic");
        flags4.put(R.drawable.cg, "Congo");
        flags4.put(R.drawable.ch, "Switzerland");
        flags4.put(R.drawable.ci, "Cte d'Ivoire");
        flags4.put(R.drawable.ck, "Cook Islands");
        flags4.put(R.drawable.cl, "Chile");
        flags4.put(R.drawable.cm, "Cameroon");
        flags4.put(R.drawable.cn, "China");
        flags4.put(R.drawable.co, "Colombia");
        flags4.put(R.drawable.cr, "Costa Rica");
        flags4.put(R.drawable.cu, "Cuba");
        flags4.put(R.drawable.cv, "Cape Verde");
        flags4.put(R.drawable.cw, "Curaao");
        flags4.put(R.drawable.cx, "Christmas Island");
        flags4.put(R.drawable.cy, "Cyprus");
        flags4.put(R.drawable.cz, "Czech Republic");
        flags4.put(R.drawable.de, "Germany");
        flags4.put(R.drawable.dj, "Djibouti");
        flags4.put(R.drawable.dk, "Denmark");
        flags4.put(R.drawable.dm, "Dominica");
        flags4.put(R.drawable.dob, "Dominican Republic");
        flags4.put(R.drawable.dz, "Algeria");
        flags4.put(R.drawable.ec, "Ecuador");
        flags4.put(R.drawable.ee, "Estonia");
        flags4.put(R.drawable.eg, "Egypt");
        flags4.put(R.drawable.eh, "Western Sahara");
        flags4.put(R.drawable.er, "Eritrea");
        flags4.put(R.drawable.es, "Spain");
        flags4.put(R.drawable.et, "Ethiopia");
        flags4.put(R.drawable.eu, "Europe");
        flags4.put(R.drawable.fi, "Finland");
        flags4.put(R.drawable.fj, "Fiji");
        flags4.put(R.drawable.fk, "Falkland Islands (Malvinas)");
        flags4.put(R.drawable.fm, "Micronesia, Federated States of");
        flags4.put(R.drawable.fo, "Faroe Islands");
        flags4.put(R.drawable.fr, "France");
        flags4.put(R.drawable.ga, "Gabon");
        flags4.put(R.drawable.gb, "England");
        flags4.put(R.drawable.gbeng, "Northern Ireland");
        flags4.put(R.drawable.gbnir, "Scotland");
        flags4.put(R.drawable.gbsct, "Wales");
        flags4.put(R.drawable.gbwls, "United Kingdom");
        flags4.put(R.drawable.gd, "Grenada");
        flags4.put(R.drawable.ge, "Georgia");
        flags4.put(R.drawable.gf, "French Guiana");
        flags4.put(R.drawable.gg, "Guernsey");
        flags4.put(R.drawable.gh, "Ghana");
        flags4.put(R.drawable.gi, "Gibraltar");
        flags4.put(R.drawable.gl, "Greenland");
        flags4.put(R.drawable.gm, "Gambia");
        flags4.put(R.drawable.gn, "Guinea");
        flags4.put(R.drawable.gp, "Guadeloupe");
        flags4.put(R.drawable.gq, "Equatorial Guinea");
        flags4.put(R.drawable.gr, "Greece");
        flags4.put(R.drawable.gs, "South Georgia and the South Sandwich Islands");
        flags4.put(R.drawable.gt, "Guatemala");
        flags4.put(R.drawable.gu, "Guam");
        flags4.put(R.drawable.gw, "Guinea-Bissau");
        flags4.put(R.drawable.gy, "Guyana ");
        flags4.put(R.drawable.hk, "Hong Kong");
        flags4.put(R.drawable.hm, "Heard Island and McDonald Islands");
        flags4.put(R.drawable.hn, "Honduras");
        flags4.put(R.drawable.hr, "Croatia");
        flags4.put(R.drawable.ht, "Haiti");
        flags4.put(R.drawable.hu, "Hungary");
        flags4.put(R.drawable.id, "Indonesia");
        flags4.put(R.drawable.ie, "Ireland");
        flags4.put(R.drawable.im, "Isle of Man");
        flags4.put(R.drawable.in, "India");
        flags4.put(R.drawable.io, "British Indian Ocean Territory");
        flags4.put(R.drawable.iq, "Iraq");
        flags4.put(R.drawable.ir, "Iran, Islamic Republic of");
        flags4.put(R.drawable.is, "Iceland");
        flags4.put(R.drawable.it, "Italy");
        flags4.put(R.drawable.je, "Jersey");
        flags4.put(R.drawable.jm, "Jamaica");
        flags4.put(R.drawable.jo, "Jordan");
        flags4.put(R.drawable.jp, "Japan");
        flags4.put(R.drawable.ke, "Kenya");
        flags4.put(R.drawable.kg, "Kyrgyzstan");
        flags4.put(R.drawable.kh, "Cambodia");
        flags4.put(R.drawable.ki, "Kiribati");
        flags4.put(R.drawable.km, "Comoros");
        flags4.put(R.drawable.kn, "Saint Kitts and Nevis");
        flags4.put(R.drawable.kp, "Korea, Democratic People's Republic of");
        flags4.put(R.drawable.kr, "Korea, Republic of");
        flags4.put(R.drawable.kw, "Kuwait");
        flags4.put(R.drawable.ky, "Cayman Islands");
        flags4.put(R.drawable.kz, "Kazakhstan");
        flags4.put(R.drawable.la, "Lao People's Democratic Republic");
        flags4.put(R.drawable.lb, "Lebanon");
        flags4.put(R.drawable.lc, "Saint Lucia");
        flags4.put(R.drawable.li, "Liechtenstein");
        flags4.put(R.drawable.lk, "Sri Lanka");
        flags4.put(R.drawable.lr, "Liberia");
        flags4.put(R.drawable.ls, "Lesotho");
        flags4.put(R.drawable.lt, "Lithuania");
        flags4.put(R.drawable.lu, "Luxembourg");
        flags4.put(R.drawable.lv, "Latvia");
        flags4.put(R.drawable.ly, "Libya");
        flags4.put(R.drawable.ma, "Morocco");
        flags4.put(R.drawable.mc, "Monaco");
        flags4.put(R.drawable.md, "Moldova, Republic of");
        flags4.put(R.drawable.me, "Montenegro");
        flags4.put(R.drawable.mf, "Saint Martin");
        flags4.put(R.drawable.mg, "Madagascar");
        flags4.put(R.drawable.mh, "Marshall Islands");
        flags4.put(R.drawable.mk, "Macedonia, the former Yugoslav Republic of");
        flags4.put(R.drawable.ml, "Mali");
        flags4.put(R.drawable.mm, "Myanmar");
        flags4.put(R.drawable.mn, "Mongolia");
        flags4.put(R.drawable.mo, "Macao");
        flags4.put(R.drawable.mp, "Northern Mariana Islands");
        flags4.put(R.drawable.mq, "Martinique");
        flags4.put(R.drawable.mr, "Mauritania");
        flags4.put(R.drawable.ms, "Montserrat");
        flags4.put(R.drawable.mt, "Malta");
        flags4.put(R.drawable.mu, "Mauritius");
        flags4.put(R.drawable.mv, "Maldives");
        flags4.put(R.drawable.mw, "Malawi");
        flags4.put(R.drawable.mx, "Mexico");
        flags4.put(R.drawable.my, "Malaysia");
        flags4.put(R.drawable.mz, "Mozambique");
        flags4.put(R.drawable.na, "Namibia");
        flags4.put(R.drawable.nc, "New Caledonia");
        flags4.put(R.drawable.ne, "Niger");
        flags4.put(R.drawable.nf, "Norfolk Island");
        flags4.put(R.drawable.ng, "Nigeria");
        flags4.put(R.drawable.ni, "Nicaragua");
        flags4.put(R.drawable.nl, "Netherlands");
        flags4.put(R.drawable.no, "Norway");
        flags4.put(R.drawable.np, "Nepal");
        flags4.put(R.drawable.nr, "Nauru");
        flags4.put(R.drawable.nu, "Niue");
        flags4.put(R.drawable.nz, "New Zealand");
        flags4.put(R.drawable.om, "Oman");
        flags4.put(R.drawable.pa, "Panama");
        flags4.put(R.drawable.pe, "Peru");
        flags4.put(R.drawable.pf, "French Polynesia");
        flags4.put(R.drawable.pg, "Papua New Guinea");
        flags4.put(R.drawable.ph, "Philippines");
        flags4.put(R.drawable.pk, "Pakistan");
        flags4.put(R.drawable.pl, "Poland");
        flags4.put(R.drawable.pm, "Saint Pierre and Miquelon");
        flags4.put(R.drawable.pn, "Pitcairn");
        flags4.put(R.drawable.pr, "Puerto Rico");
        flags4.put(R.drawable.ps, "Palestine");
        flags4.put(R.drawable.pt, "Portugal");
        flags4.put(R.drawable.pw, "Palau");
        flags4.put(R.drawable.py, "Paraguay");
        flags4.put(R.drawable.qa, "Qatar");
        flags4.put(R.drawable.re, "Réunion");
        flags4.put(R.drawable.ro, "Romania");
        flags4.put(R.drawable.rs, "Serbia");
        flags4.put(R.drawable.ru, "Russian Federation");
        flags4.put(R.drawable.rw, "Rwanda");
        flags4.put(R.drawable.sa, "Saudi Arabia");
        flags4.put(R.drawable.sb, "Solomon Islands");
        flags4.put(R.drawable.sc, "Seychelles");
        flags4.put(R.drawable.sd, "Sudan");
        flags4.put(R.drawable.se, "Sweden");
        flags4.put(R.drawable.sg, "Singapore");
        flags4.put(R.drawable.sh, "Saint Helena, Ascension and Tristan da Cunha");
        flags4.put(R.drawable.si, "Slovenia");
        flags4.put(R.drawable.sj, "Svalbard and Jan Mayen Islands");
        flags4.put(R.drawable.sk, "Slovakia");
        flags4.put(R.drawable.sl, "Sierra Leone");
        flags4.put(R.drawable.sm, "San Marino");
        flags4.put(R.drawable.sn, "Senegal");
        flags4.put(R.drawable.so, "Somalia");
        flags4.put(R.drawable.sr, "Suriname");
        flags4.put(R.drawable.ss, "South Sudan");
        flags4.put(R.drawable.st, "Sao Tome and Principe");
        flags4.put(R.drawable.sv, "El Salvador");
        flags4.put(R.drawable.sx, "Sint Maarten (Dutch part)");
        flags4.put(R.drawable.sy, "Syrian Arab Republic");
        flags4.put(R.drawable.sz, "Swaziland");
        flags4.put(R.drawable.tc, "Turks and Caicos Islands");
        flags4.put(R.drawable.td, "Chad");
        flags4.put(R.drawable.tf, "French Southern Territories");
        flags4.put(R.drawable.tg, "Togo");
        flags4.put(R.drawable.th, "Thailand");
        flags4.put(R.drawable.tj, "Tajikistan");
        flags4.put(R.drawable.tk, "Tokelau");
        flags4.put(R.drawable.tl, "Timor-Leste");
        flags4.put(R.drawable.tm, "Turkmenistan");
        flags4.put(R.drawable.tn, "Tunisia");
        flags4.put(R.drawable.to, "Tonga");
        flags4.put(R.drawable.tr, "Turkey");
        flags4.put(R.drawable.tt, "Trinidad and Tobago");
        flags4.put(R.drawable.tv, "Tuvalu");
        flags4.put(R.drawable.tw, "Taiwan");
        flags4.put(R.drawable.tz, "Tanzania, United Republic of");
        flags4.put(R.drawable.ua, "Ukraine");
        flags4.put(R.drawable.ug, "Uganda");
        flags4.put(R.drawable.um, "US Minor Outlying Islands");
        flags4.put(R.drawable.us, "United States");
        flags4.put(R.drawable.uy, "Uruguay");
        flags4.put(R.drawable.uz, "Uzbekistan");
        flags4.put(R.drawable.va, "Holy See (Vatican City State)");
        flags4.put(R.drawable.vc, "Saint Vincent and the Grenadines");
        flags4.put(R.drawable.ve, "Venezuela, Bolivarian Republic of");
        flags4.put(R.drawable.vg, "Virgin Islands, British");
        flags4.put(R.drawable.vi, "Virgin Islands, U.S.");
        flags4.put(R.drawable.vn, "Viet Nam");
        flags4.put(R.drawable.vu, "Vanuatu");
        flags4.put(R.drawable.wf, "Wallis and Futuna Islands");
        flags4.put(R.drawable.ws, "Samoa");
        flags4.put(R.drawable.xk, "Kosovo");
        flags4.put(R.drawable.ye, "Yemen");
        flags4.put(R.drawable.yt, "Mayotte");
        flags4.put(R.drawable.za, "South Africa");
        flags4.put(R.drawable.zm, "Zambia");
        flags4.put(R.drawable.zw, "Zimbabwe");


        //--------- get the random Flag-----------------
        final int[] FlagRandom4 = new int[flags4.size()];
        Object[] integers = flags4.keySet().toArray();
        for (int i = 0; i < FlagRandom4.length; i++) {
            FlagRandom4[i] = Integer.parseInt(integers[i].toString());
        }

        //---------show the button------------------
        final Button startButton = (Button) findViewById(R.id.startbutton4);
        submitButton = (Button) findViewById(R.id.submitButton4);
        nextButton = (Button) findViewById(R.id.nextButton4);
        //---------show the images------------------
        final ImageView image1 = (ImageView) findViewById(R.id.flagImages41);
        final ImageView image2 = (ImageView) findViewById(R.id.flagImages42);
        final ImageView image3 = (ImageView) findViewById(R.id.flagImages43);
        //---------show the edit text------------------
        Text1 = (EditText) findViewById(R.id.edit_text1);
        Text2 = (EditText) findViewById(R.id.edit_text2);
        Text3 = (EditText) findViewById(R.id.edit_text3);
        //---------show the correct massage------------------
        correctText41 = findViewById(R.id.correctText41);
        correctText42 = findViewById(R.id.correctText42);
        correctText43 = findViewById(R.id.correctText43);
        //---------show the incorrect massage------------------
        incorrectText41 = findViewById(R.id.incorrectText41);
        incorrectText42 = findViewById(R.id.incorrectText42);
        incorrectText43 = findViewById(R.id.incorrectText43);
        //---------show the correct country name ------------------
        correctionText41 = findViewById(R.id.correctionText41);
        correctionText42 = findViewById(R.id.correctionText42);
        correctionText43 = findViewById(R.id.correctionText43);

        score = findViewById(R.id.score);
        final TextView timer4 = findViewById(R.id.timerView4);

        final Random pic = new Random();

        //----------- hide the button,text,dropdown list----------------
        submitButton.setVisibility(View.INVISIBLE);
        nextButton.setVisibility(View.INVISIBLE);
        Text1.setVisibility(View.INVISIBLE);
        Text2.setVisibility(View.INVISIBLE);
        Text3.setVisibility(View.INVISIBLE);

        //-----------click the start button and show ---------------------------
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //------ if timer on show in top of right screen -------------
                if(isTimerOn){
                    if(t!=null){
                        t.cancel();
                    }

                    startTimer((TextView)findViewById(R.id.timerView4),TIME_OUT,1000);
                }
                startButton.setVisibility(View.INVISIBLE);
                submitButton.setVisibility(VISIBLE);
                Text1.setVisibility(VISIBLE);
                Text2.setVisibility(VISIBLE);
                Text3.setVisibility(VISIBLE);

                //-------get random flags-------------------
                int randImage = pic.nextInt(FlagRandom4.length);
                randomFlag41 = FlagRandom4[randImage];
                image1.setImageResource(randomFlag41);

                int randImage2 = pic.nextInt(FlagRandom4.length);
                randomFlag42 = FlagRandom4[randImage2];
                image2.setImageResource(randomFlag42);

                int randImage3 = pic.nextInt(FlagRandom4.length);
                randomFlag43 = FlagRandom4[randImage3];
                image3.setImageResource(randomFlag43);
            }
        });
        //--------------click the submit button and show items-----------------
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //------ if timer on show in top of right screen -------------
                if(isTimerOn){
                    if(t!=null){
                        t.cancel();
                    }

                    startTimer((TextView)findViewById(R.id.timerView4),TIME_OUT,1000);
                }
                //-----------check submit button click 3 times---------------------
                clickcount = clickcount + 1;
                //------------get the score------------------------
                int score1 = 0, score2 = 0, score3 = 0;

                if (clickcount <= 2) {
                    String selectedFlagName1 = Text1.getText().toString();
                    String randomFlagName1 = flags4.get(randomFlag41);
                    correctCountry = randomFlagName1;

                    if (randomFlagName1.equals(selectedFlagName1)) {
                        correct = true;
                        Text1.setBackgroundColor(Color.GREEN);
                        //---set  enable to edit------
                        Text1.setFocusable(false);
                        //---get score-----
                        score1 = 1;
                    } else {
                        correct = false;
                        Text1.setBackgroundColor(Color.RED);
                        score1 = 0;
                    }

                    String selectedFlagName2 = Text2.getText().toString();
                    String randomFlagName2 = flags4.get(randomFlag42);
                    correctCountry = randomFlagName2;

                    if (randomFlagName2.equals(selectedFlagName2)) {
                        correct = true;
                        Text2.setBackgroundColor(Color.GREEN);
                        //---set  enable to edit------
                        Text2.setFocusable(false);
                        //---get score-----
                        score2 = 1;

                    } else {
                        correct = false;
                        Text2.setBackgroundColor(Color.RED);
                        score2 = 0;
                    }

                    String selectedFlagName3 = Text3.getText().toString();
                    String randomFlagName3 = flags4.get(randomFlag43);
                    correctCountry = randomFlagName3;

                    if (randomFlagName3.equals(selectedFlagName3)) {
                        correct = true;
                        Text3.setBackgroundColor(Color.GREEN);
                        //---set  enable to edit------
                        Text3.setFocusable(false);
                        //---get score-----
                        score3 = 1;
                    } else {
                        correct = false;
                        Text3.setBackgroundColor(Color.RED);
                        score3 = 0;
                    }

                    //----- get all coreect score---------
                    correctCount = score1 + score2 + score3;
                    score.setText("Score:" + correctCount+"/3");
                    score.setTextColor(Color.WHITE);

                    //------if score is 3 show next button--------------
                    if(correctCount== 3){
                        nextButton.setVisibility(VISIBLE);
                        submitButton.setVisibility(View.INVISIBLE);

                        correctText41.setText("CORRECT!");
                        correctText41.setTextColor(Color.GREEN);
                        correctText42.setText("CORRECT!");
                        correctText42.setTextColor(Color.GREEN);
                        correctText43.setText("CORRECT!");
                        correctText43.setTextColor(Color.GREEN);

                        Text1.setVisibility(View.INVISIBLE);
                        Text2.setVisibility(View.INVISIBLE);
                        Text3.setVisibility(View.INVISIBLE);
                    }else {
                        return;
                    }

                } else {

                    clickcount = 0;
                    Text1.setVisibility(View.INVISIBLE);
                    Text2.setVisibility(View.INVISIBLE);
                    Text3.setVisibility(View.INVISIBLE);

                    //-----check flag and name is correct or wrong-----------------
                    String selectedFlagName1 = Text1.getText().toString();
                    String randomFlagName1 = flags4.get(randomFlag41);
                    correctCountry = randomFlagName1;

                    if (randomFlagName1.equals(selectedFlagName1)) {
                        correct = true;
                        //-----------get the massage correct---------
                        correctText41.setText("CORRECT!");
                        correctText41.setTextColor(Color.GREEN);

                    } else {
                        correct = false;
                        //-----------get the massage wrong and show correct flag name---------
                        incorrectText41.setText("WRONG!");
                        incorrectText41.setTextColor(Color.RED);

                        correctionText41.setText(correctCountry);
                        correctionText41.setTextColor(Color.BLUE);
                    }

                    //-----check flag and name is correct or wrong-----------------
                    String selectedFlagName2 = Text2.getText().toString();
                    String randomFlagName2 = flags4.get(randomFlag42);
                    correctCountry = randomFlagName2;

                    if (randomFlagName2.equals(selectedFlagName2)) {
                        correct = true;
                        //-----------get the massage correct---------
                        correctText42.setText("CORRECT!");
                        correctText42.setTextColor(Color.GREEN);

                    } else {
                        correct = false;
                        //-----------get the massage wrong and show correct flag name---------
                        incorrectText42.setText("WRONG!");
                        incorrectText42.setTextColor(Color.RED);
                        correctionText42.setText(correctCountry);
                        correctionText42.setTextColor(Color.BLUE);

                    }
                    //-----check flag and name is correct or wrong-----------------
                    String selectedFlagName3 = Text3.getText().toString();
                    String randomFlagName3 = flags4.get(randomFlag43);
                    correctCountry = randomFlagName3;

                    if (randomFlagName3.equals(selectedFlagName3)) {
                        correct = true;
                        //-----------get the massage correct---------
                        correctText43.setText("CORRECT!");
                        correctText43.setTextColor(Color.GREEN);
                    } else {
                        correct = false;
                        //-----------get the massage wrong and show correct flag name---------
                        incorrectText43.setText("WRONG!");
                        incorrectText43.setTextColor(Color.RED);
                        correctionText43.setText(correctCountry);
                        correctionText43.setTextColor(Color.BLUE);
                    }

                    submitButton.setVisibility(View.INVISIBLE);
                    nextButton.setVisibility(VISIBLE);

                }

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //------ if timer on show in top of right screen -------------
                if(isTimerOn){
                    if(t!=null){
                        t.cancel();
                    }

                    startTimer((TextView)findViewById(R.id.timerView4),TIME_OUT,1000);
                }
                nextButton.setVisibility(View.INVISIBLE);
                submitButton.setVisibility(VISIBLE);

                Text1.setVisibility(VISIBLE);
                Text2.setVisibility(VISIBLE);
                Text3.setVisibility(VISIBLE);

                //------ get random flags-----------------------
                int randImage = pic.nextInt(FlagRandom4.length);
                randomFlag41 = FlagRandom4[randImage];
                image1.setImageResource(randomFlag41);

                int randImage2 = pic.nextInt(FlagRandom4.length);
                randomFlag42 = FlagRandom4[randImage2];
                image2.setImageResource(randomFlag42);

                int randImage3 = pic.nextInt(FlagRandom4.length);
                randomFlag43 = FlagRandom4[randImage3];
                image3.setImageResource(randomFlag43);

                randomFlag41 = FlagRandom4[randImage];
                Text1.setText("");
                correctText41.setText("");
                incorrectText41.setText("");
                correctionText41.setText("");
                Text1.setBackgroundColor(Color.WHITE);

                randomFlag42 = FlagRandom4[randImage2];
                Text2.setText("");
                correctText42.setText("");
                incorrectText42.setText("");
                correctionText42.setText("");
                Text2.setBackgroundColor(Color.WHITE);

                randomFlag43 = FlagRandom4[randImage3];
                Text3.setText("");
                correctText43.setText("");
                incorrectText43.setText("");
                correctionText43.setText("");
                Text3.setBackgroundColor(Color.WHITE);
                score.setText("");
                //----------reset edit--------------
                Text1.setFocusableInTouchMode(true);
                Text2.setFocusableInTouchMode(true);
                Text3.setFocusableInTouchMode(true);
                correctCount = 0;
            }
        });
    }

    //------- option menu ----------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.commonmenus,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
