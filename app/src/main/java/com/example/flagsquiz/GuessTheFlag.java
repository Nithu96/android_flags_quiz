package com.example.flagsquiz;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static android.view.View.VISIBLE;

public class GuessTheFlag extends AppCompatActivity {

    public static String randomText3;
    public static int randomFlag3;
    private Button nextButton;
    private TextView text32;

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

                        nextButton.setVisibility(VISIBLE);
                        text32.setText("WRONG!  Time is Over..");
                        text32.setTextColor(Color.RED);

                    }
                });
                cancel();
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_flag);
        //--- check the front timer is on or off-------
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            isTimerOn = extras.getBoolean("timer");
        }
        //System.out.println("TEST_TIMER : "+isTimerOn);

    //------------flag and country name----------------
        final Map<Integer, String> flags = new HashMap<>();
        flags.put(R.drawable.ad, "Andorra");
        flags.put(R.drawable.ae, "United Arab Emirates");
        flags.put(R.drawable.af, "Afghanistan");
        flags.put(R.drawable.ag, "Antigua and Barbuda");
        flags.put(R.drawable.ag, "Antigua and Barbuda");
        flags.put(R.drawable.ai, "Anguilla");
        flags.put(R.drawable.al, "Albania");
        flags.put(R.drawable.am, "Armenia");
        flags.put(R.drawable.an, "Netherlands Antilles");
        flags.put(R.drawable.ao, "Angola");
        flags.put(R.drawable.aq, "Antarctica");
        flags.put(R.drawable.ar, "Argentina");
        flags.put(R.drawable.as, "American Samoa");
        flags.put(R.drawable.at, "Austria");
        flags.put(R.drawable.au, "Australia");
        flags.put(R.drawable.aw, "Aruba");
        flags.put(R.drawable.ax, "land Islands");
        flags.put(R.drawable.az, "Azerbaijan");
        flags.put(R.drawable.ba, "Bosnia and Herzegovina");
        flags.put(R.drawable.bb, "Barbados");
        flags.put(R.drawable.bd, "Bangladesh");
        flags.put(R.drawable.be, "Belgium");
        flags.put(R.drawable.bf, "Burkina Faso");
        flags.put(R.drawable.bg, "Bulgaria");
        flags.put(R.drawable.bh, "Bahrain");
        flags.put(R.drawable.bi, "Burundi");
        flags.put(R.drawable.bj, "Benin");
        flags.put(R.drawable.bl, "Saint Barthélemy");
        flags.put(R.drawable.bm, "Bermuda");
        flags.put(R.drawable.bn, "Brunei Darussalam");
        flags.put(R.drawable.bo, "Bolivia, Plurinational State");
        flags.put(R.drawable.bq, "Caribbean Netherlands");
        flags.put(R.drawable.br, "Brazil");
        flags.put(R.drawable.bs, "Bahamas");
        flags.put(R.drawable.bt, "Bhutan");
        flags.put(R.drawable.bv, "Bouvet Island");
        flags.put(R.drawable.bw, "Botswana");
        flags.put(R.drawable.by, "Belarus");
        flags.put(R.drawable.bz, "Belize");
        flags.put(R.drawable.ca, "Canada");
        flags.put(R.drawable.cc, "Cocos (Keeling) Islands");
        flags.put(R.drawable.cd, "Congo, the Democratic Republic of the");
        flags.put(R.drawable.cf, "Central African Republic");
        flags.put(R.drawable.cg, "Congo");
        flags.put(R.drawable.ch, "Switzerland");
        flags.put(R.drawable.ci, "Cte d'Ivoire");
        flags.put(R.drawable.ck, "Cook Islands");
        flags.put(R.drawable.cl, "Chile");
        flags.put(R.drawable.cm, "Cameroon");
        flags.put(R.drawable.cn, "China");
        flags.put(R.drawable.co, "Colombia");
        flags.put(R.drawable.cr, "Costa Rica");
        flags.put(R.drawable.cu, "Cuba");
        flags.put(R.drawable.cv, "Cape Verde");
        flags.put(R.drawable.cw, "Curaao");
        flags.put(R.drawable.cx, "Christmas Island");
        flags.put(R.drawable.cy, "Cyprus");
        flags.put(R.drawable.cz, "Czech Republic");
        flags.put(R.drawable.de, "Germany");
        flags.put(R.drawable.dj, "Djibouti");
        flags.put(R.drawable.dk, "Denmark");
        flags.put(R.drawable.dm, "Dominica");
        flags.put(R.drawable.dob, "Dominican Republic");
        flags.put(R.drawable.dz, "Algeria");
        flags.put(R.drawable.ec, "Ecuador");
        flags.put(R.drawable.ee, "Estonia");
        flags.put(R.drawable.eg, "Egypt");
        flags.put(R.drawable.eh, "Western Sahara");
        flags.put(R.drawable.er, "Eritrea");
        flags.put(R.drawable.es, "Spain");
        flags.put(R.drawable.et, "Ethiopia");
        flags.put(R.drawable.eu, "Europe");
        flags.put(R.drawable.fi, "Finland");
        flags.put(R.drawable.fj, "Fiji");
        flags.put(R.drawable.fk, "Falkland Islands (Malvinas)");
        flags.put(R.drawable.fm, "Micronesia, Federated States of");
        flags.put(R.drawable.fo, "Faroe Islands");
        flags.put(R.drawable.fr, "France");
        flags.put(R.drawable.ga, "Gabon");
        flags.put(R.drawable.gb, "England");
        flags.put(R.drawable.gbeng, "Northern Ireland");
        flags.put(R.drawable.gbnir, "Scotland");
        flags.put(R.drawable.gbsct, "Wales");
        flags.put(R.drawable.gbwls, "United Kingdom");
        flags.put(R.drawable.gd, "Grenada");
        flags.put(R.drawable.ge, "Georgia");
        flags.put(R.drawable.gf, "French Guiana");
        flags.put(R.drawable.gg, "Guernsey");
        flags.put(R.drawable.gh, "Ghana");
        flags.put(R.drawable.gi, "Gibraltar");
        flags.put(R.drawable.gl, "Greenland");
        flags.put(R.drawable.gm, "Gambia");
        flags.put(R.drawable.gn, "Guinea");
        flags.put(R.drawable.gp, "Guadeloupe");
        flags.put(R.drawable.gq, "Equatorial Guinea");
        flags.put(R.drawable.gr, "Greece");
        flags.put(R.drawable.gs, "South Georgia and the South Sandwich Islands");
        flags.put(R.drawable.gt, "Guatemala");
        flags.put(R.drawable.gu, "Guam");
        flags.put(R.drawable.gw, "Guinea-Bissau");
        flags.put(R.drawable.gy, "Guyana ");
        flags.put(R.drawable.hk, "Hong Kong");
        flags.put(R.drawable.hm, "Heard Island and McDonald Islands");
        flags.put(R.drawable.hn, "Honduras");
        flags.put(R.drawable.hr, "Croatia");
        flags.put(R.drawable.ht, "Haiti");
        flags.put(R.drawable.hu, "Hungary");
        flags.put(R.drawable.id, "Indonesia");
        flags.put(R.drawable.ie, "Ireland");
        flags.put(R.drawable.im, "Isle of Man");
        flags.put(R.drawable.in, "India");
        flags.put(R.drawable.io, "British Indian Ocean Territory");
        flags.put(R.drawable.iq, "Iraq");
        flags.put(R.drawable.ir, "Iran, Islamic Republic of");
        flags.put(R.drawable.is, "Iceland");
        flags.put(R.drawable.it, "Italy");
        flags.put(R.drawable.je, "Jersey");
        flags.put(R.drawable.jm, "Jamaica");
        flags.put(R.drawable.jo, "Jordan");
        flags.put(R.drawable.jp, "Japan");
        flags.put(R.drawable.ke, "Kenya");
        flags.put(R.drawable.kg, "Kyrgyzstan");
        flags.put(R.drawable.kh, "Cambodia");
        flags.put(R.drawable.ki, "Kiribati");
        flags.put(R.drawable.km, "Comoros");
        flags.put(R.drawable.kn, "Saint Kitts and Nevis");
        flags.put(R.drawable.kp, "Korea, Democratic People's Republic of");
        flags.put(R.drawable.kr, "Korea, Republic of");
        flags.put(R.drawable.kw, "Kuwait");
        flags.put(R.drawable.ky, "Cayman Islands");
        flags.put(R.drawable.kz, "Kazakhstan");
        flags.put(R.drawable.la, "Lao People's Democratic Republic");
        flags.put(R.drawable.lb, "Lebanon");
        flags.put(R.drawable.lc, "Saint Lucia");
        flags.put(R.drawable.li, "Liechtenstein");
        flags.put(R.drawable.lk, "Sri Lanka");
        flags.put(R.drawable.lr, "Liberia");
        flags.put(R.drawable.ls, "Lesotho");
        flags.put(R.drawable.lt, "Lithuania");
        flags.put(R.drawable.lu, "Luxembourg");
        flags.put(R.drawable.lv, "Latvia");
        flags.put(R.drawable.ly, "Libya");
        flags.put(R.drawable.ma, "Morocco");
        flags.put(R.drawable.mc, "Monaco");
        flags.put(R.drawable.md, "Moldova, Republic of");
        flags.put(R.drawable.me, "Montenegro");
        flags.put(R.drawable.mf, "Saint Martin");
        flags.put(R.drawable.mg, "Madagascar");
        flags.put(R.drawable.mh, "Marshall Islands");
        flags.put(R.drawable.mk, "Macedonia, the former Yugoslav Republic of");
        flags.put(R.drawable.ml, "Mali");
        flags.put(R.drawable.mm, "Myanmar");
        flags.put(R.drawable.mn, "Mongolia");
        flags.put(R.drawable.mo, "Macao");
        flags.put(R.drawable.mp, "Northern Mariana Islands");
        flags.put(R.drawable.mq, "Martinique");
        flags.put(R.drawable.mr, "Mauritania");
        flags.put(R.drawable.ms, "Montserrat");
        flags.put(R.drawable.mt, "Malta");
        flags.put(R.drawable.mu, "Mauritius");
        flags.put(R.drawable.mv, "Maldives");
        flags.put(R.drawable.mw, "Malawi");
        flags.put(R.drawable.mx, "Mexico");
        flags.put(R.drawable.my, "Malaysia");
        flags.put(R.drawable.mz, "Mozambique");
        flags.put(R.drawable.na, "Namibia");
        flags.put(R.drawable.nc, "New Caledonia");
        flags.put(R.drawable.ne, "Niger");
        flags.put(R.drawable.nf, "Norfolk Island");
        flags.put(R.drawable.ng, "Nigeria");
        flags.put(R.drawable.ni, "Nicaragua");
        flags.put(R.drawable.nl, "Netherlands");
        flags.put(R.drawable.no, "Norway");
        flags.put(R.drawable.np, "Nepal");
        flags.put(R.drawable.nr, "Nauru");
        flags.put(R.drawable.nu, "Niue");
        flags.put(R.drawable.nz, "New Zealand");
        flags.put(R.drawable.om, "Oman");
        flags.put(R.drawable.pa, "Panama");
        flags.put(R.drawable.pe, "Peru");
        flags.put(R.drawable.pf, "French Polynesia");
        flags.put(R.drawable.pg, "Papua New Guinea");
        flags.put(R.drawable.ph, "Philippines");
        flags.put(R.drawable.pk, "Pakistan");
        flags.put(R.drawable.pl, "Poland");
        flags.put(R.drawable.pm, "Saint Pierre and Miquelon");
        flags.put(R.drawable.pn, "Pitcairn");
        flags.put(R.drawable.pr, "Puerto Rico");
        flags.put(R.drawable.ps, "Palestine");
        flags.put(R.drawable.pt, "Portugal");
        flags.put(R.drawable.pw, "Palau");
        flags.put(R.drawable.py, "Paraguay");
        flags.put(R.drawable.qa, "Qatar");
        flags.put(R.drawable.re, "Réunion");
        flags.put(R.drawable.ro, "Romania");
        flags.put(R.drawable.rs, "Serbia");
        flags.put(R.drawable.ru, "Russian Federation");
        flags.put(R.drawable.rw, "Rwanda");
        flags.put(R.drawable.sa, "Saudi Arabia");
        flags.put(R.drawable.sb, "Solomon Islands");
        flags.put(R.drawable.sc, "Seychelles");
        flags.put(R.drawable.sd, "Sudan");
        flags.put(R.drawable.se, "Sweden");
        flags.put(R.drawable.sg, "Singapore");
        flags.put(R.drawable.sh, "Saint Helena, Ascension and Tristan da Cunha");
        flags.put(R.drawable.si, "Slovenia");
        flags.put(R.drawable.sj, "Svalbard and Jan Mayen Islands");
        flags.put(R.drawable.sk, "Slovakia");
        flags.put(R.drawable.sl, "Sierra Leone");
        flags.put(R.drawable.sm, "San Marino");
        flags.put(R.drawable.sn, "Senegal");
        flags.put(R.drawable.so, "Somalia");
        flags.put(R.drawable.sr, "Suriname");
        flags.put(R.drawable.ss, "South Sudan");
        flags.put(R.drawable.st, "Sao Tome and Principe");
        flags.put(R.drawable.sv, "El Salvador");
        flags.put(R.drawable.sx, "Sint Maarten (Dutch part)");
        flags.put(R.drawable.sy, "Syrian Arab Republic");
        flags.put(R.drawable.sz, "Swaziland");
        flags.put(R.drawable.tc, "Turks and Caicos Islands");
        flags.put(R.drawable.td, "Chad");
        flags.put(R.drawable.tf, "French Southern Territories");
        flags.put(R.drawable.tg, "Togo");
        flags.put(R.drawable.th, "Thailand");
        flags.put(R.drawable.tj, "Tajikistan");
        flags.put(R.drawable.tk, "Tokelau");
        flags.put(R.drawable.tl, "Timor-Leste");
        flags.put(R.drawable.tm, "Turkmenistan");
        flags.put(R.drawable.tn, "Tunisia");
        flags.put(R.drawable.to, "Tonga");
        flags.put(R.drawable.tr, "Turkey");
        flags.put(R.drawable.tt, "Trinidad and Tobago");
        flags.put(R.drawable.tv, "Tuvalu");
        flags.put(R.drawable.tw, "Taiwan");
        flags.put(R.drawable.tz, "Tanzania, United Republic of");
        flags.put(R.drawable.ua, "Ukraine");
        flags.put(R.drawable.ug, "Uganda");
        flags.put(R.drawable.um, "US Minor Outlying Islands");
        flags.put(R.drawable.us, "United States");
        flags.put(R.drawable.uy, "Uruguay");
        flags.put(R.drawable.uz, "Uzbekistan");
        flags.put(R.drawable.va, "Holy See (Vatican City State)");
        flags.put(R.drawable.vc, "Saint Vincent and the Grenadines");
        flags.put(R.drawable.ve, "Venezuela, Bolivarian Republic of");
        flags.put(R.drawable.vg, "Virgin Islands, British");
        flags.put(R.drawable.vi, "Virgin Islands, U.S.");
        flags.put(R.drawable.vn, "Viet Nam");
        flags.put(R.drawable.vu, "Vanuatu");
        flags.put(R.drawable.wf, "Wallis and Futuna Islands");
        flags.put(R.drawable.ws, "Samoa");
        flags.put(R.drawable.xk, "Kosovo");
        flags.put(R.drawable.ye, "Yemen");
        flags.put(R.drawable.yt, "Mayotte");
        flags.put(R.drawable.za, "South Africa");
        flags.put(R.drawable.zm, "Zambia");
        flags.put(R.drawable.zw, "Zimbabwe");


        //------- get the random name -----------------------
        final String[] randName = new String[flags.size()];
        Object[] values = flags.values().toArray();
        for (int i = 0; i < values.length; i++) {
            randName[i] = values[i].toString();
        }

        //----------get the random flag-----------------------
        final int[] FlagRandom = new int[flags.size()];
        Object[] integers = flags.keySet().toArray();
        for (int i = 0; i < FlagRandom.length; i++) {
            FlagRandom[i] = Integer.parseInt(integers[i].toString());
        }
        //---------show the button,text,images------------------
        final Button startButton = (Button) findViewById(R.id.startButtonFlag3);
        nextButton = (Button) findViewById(R.id.nextButtonFlag3);
        final TextView text31 = (TextView) findViewById(R.id.countryName3Flag);
        text32 = (TextView) findViewById(R.id.correctWrong3);

        final ImageView image31 = (ImageView) findViewById(R.id.flagImages31);
        final ImageView image32 = (ImageView) findViewById(R.id.flagImages32);
        final ImageView image33 = (ImageView) findViewById(R.id.flagImages33);

        final TextView timer3= (TextView)findViewById(R.id.timerView3);

        final Random pic = new Random();

        //----------- hide the button,text,dropdown list----------------
        nextButton.setVisibility(View.INVISIBLE);
        text31.setVisibility(View.INVISIBLE);


        //----------set the image you get-----------------------
        final ImageView[] imageViews = new ImageView[3];
        imageViews[0] = image31;
        imageViews[1] = image32;
        imageViews[2] = image33;

        final int correctIndex[] = new int[1];

        //-----------click the button and show ---------------------------
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //------ if timer on show in top of right screen -------------
                if(isTimerOn){
                    if(t!=null){
                        t.cancel();
                    }

                    startTimer((TextView)findViewById(R.id.timerView3),TIME_OUT,1000);
                }

                int[] imageViewIndex = getImageViewIndex();

                startButton.setVisibility(View.INVISIBLE);
                text31.setVisibility(VISIBLE);

                //------------display random text and flags---------------
                int randText = pic.nextInt(randName.length);
                randomText3 = randName[randText];
                text31.setText(randomText3);

                imageViews[imageViewIndex[0]].setImageResource(FlagRandom[randText]);
                correctIndex[0] = imageViewIndex[0];

                int randImage2 = pic.nextInt(FlagRandom.length);
                randomFlag3 = FlagRandom[randImage2];
                imageViews[imageViewIndex[1]].setImageResource(randomFlag3);

                int randImage3 = pic.nextInt(FlagRandom.length);
                randomFlag3 = FlagRandom[randImage3];
                imageViews[imageViewIndex[2]].setImageResource(randomFlag3);

            }
        });
        //----------------when first flag click,it's correct or wrong display--------------------
        image31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                nextButton.setVisibility(VISIBLE);
                image31.setVisibility(View.INVISIBLE);
                image32.setVisibility(View.INVISIBLE);
                image33.setVisibility(View.INVISIBLE);

                if(correctIndex[0] == 0){
                    text32.setText("CORRECT!");
                    text32.setTextColor(Color.GREEN);
                }else{
                    text32.setText("WRONG!");

                    text32.setTextColor(Color.RED);
                }

            }
        });
        //----------------when second flag click,it's correct or wrong display--------------------
        image32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                nextButton.setVisibility(VISIBLE);
                image31.setVisibility(View.INVISIBLE);
                image32.setVisibility(View.INVISIBLE);
                image33.setVisibility(View.INVISIBLE);

                if(correctIndex[0] == 1){
                    text32.setText("CORRECT!");
                    text32.setTextColor(Color.GREEN);
                }else{
                    text32.setText("WRONG!");

                    text32.setTextColor(Color.RED);
                }
            }
        });
        //----------------when third flag click,it's correct or wrong display--------------------
        image33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                nextButton.setVisibility(VISIBLE);
                image31.setVisibility(View.INVISIBLE);
                image32.setVisibility(View.INVISIBLE);
                image33.setVisibility(View.INVISIBLE);

                if(correctIndex[0] == 2){
                    text32.setText("CORRECT!");
                    text32.setTextColor(Color.GREEN);
                }else{
                    text32.setText("WRONG!");
                    text32.setTextColor(Color.RED);
                }
            }
        });
        //----------------when Next button click--------------------
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //------ if timer on show in top of right screen -------------
                if(isTimerOn){
                    if(t!=null){
                        t.cancel();
                    }

                    startTimer((TextView)findViewById(R.id.timerView3),TIME_OUT,1000);
                }
                int[] imageViewIndex = getImageViewIndex();

                image31.setVisibility(View.VISIBLE);
                image32.setVisibility(View.VISIBLE);
                image33.setVisibility(View.VISIBLE);

        //-----------------get random Text and flags-----------------
                int randText = pic.nextInt(randName.length);
                randomText3 = randName[randText];
                text31.setText(randomText3);
                imageViews[imageViewIndex[0]].setImageResource(FlagRandom[randText]);
                correctIndex[0] = imageViewIndex[0];

                int randImage2 = pic.nextInt(FlagRandom.length);
                randomFlag3 = FlagRandom[randImage2];
                imageViews[imageViewIndex[1]].setImageResource(randomFlag3);

                int randImage3 = pic.nextInt(FlagRandom.length);
                randomFlag3 = FlagRandom[randImage3];
                imageViews[imageViewIndex[2]].setImageResource(randomFlag3);
                text32.setText("");

            }
        });
    }

    //--------get the random image for image view---------------------
    int[] numbers = new int[3];
    final Random random = new Random();

    public int[] getImageViewIndex() {
        numbers[0] = random.nextInt(3);

        if (numbers[0] == 0) {
            numbers[1] = 1;
            numbers[2] = 2;
        } else if (numbers[0] == 1) {
            numbers[1] = 0;
            numbers[2] = 2;
        } else if (numbers[0] == 2) {
            numbers[1] = 1;
            numbers[2] = 0;
        }

        return numbers;
    }
    //------- option menu ----------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.commonmenus,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
