package com.example.flagsquiz;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static android.view.View.VISIBLE;
import static com.example.flagsquiz.GuessCountry.randomFlag;

public class GuessHints extends AppCompatActivity {
    private LinearLayout layout;
    private String flagName;
    private boolean isTimerOn;
    private Map map = new HashMap<Integer, Map<String, Boolean>>();
    private static int TIME_OUT = 10000;
    private EditText fill;
    private Button hintSubmit2,hintNextButton2;
    private TextView correctHint;
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

                        String nameAnswer = fill.getText().toString();
                        if(fill.getText().toString().isEmpty()){
//                            Toast.makeText(GuessHints.this, "WRONG!",
//                                    Toast.LENGTH_SHORT).show();
                            correctHint.setText("WRONG!");
                            correctHint.setTextColor(Color.RED);

                        }else {
                            if(addCharToText(String.valueOf(nameAnswer).toUpperCase())){
                                hintSubmit2.setVisibility(View.INVISIBLE);
                                hintNextButton2.setVisibility(View.VISIBLE);
                            }
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
        setContentView(R.layout.activity_guess_hints);
        //--- check the front timer is on or off-------
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            isTimerOn = extras.getBoolean("timer");
        }
        //System.out.println("TEST_TIMER : "+isTimerOn);

//-----------flag names and country name--------------------------
        final Map<Integer, String> flags = new HashMap<>();
        flags.put(R.drawable.ad, "Andorra");
        flags.put(R.drawable.ae, "UnitedArabEmirates");
        flags.put(R.drawable.af, "Afghanistan");
        flags.put(R.drawable.ag, "AntiguaandBarbuda");
        flags.put(R.drawable.ag, "AntiguaandBarbuda");
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
        flags.put(R.drawable.ba, "BosniaandHerzegovina");
        flags.put(R.drawable.bb, "Barbados");
        flags.put(R.drawable.bd, "Bangladesh");
        flags.put(R.drawable.be, "Belgium");
        flags.put(R.drawable.bf, "BurkinaFaso");
        flags.put(R.drawable.bg, "Bulgaria");
        flags.put(R.drawable.bh, "Bahrain");
        flags.put(R.drawable.bi, "Burundi");
        flags.put(R.drawable.bj, "Benin");
        flags.put(R.drawable.bl, "SaintBarthélemy");
        flags.put(R.drawable.bm, "Bermuda");
        flags.put(R.drawable.bn, "BruneiDarussalam");
        flags.put(R.drawable.bo, "BoliviaPlurinationalState");
        flags.put(R.drawable.bq, "CaribbeanNetherlands");
        flags.put(R.drawable.br, "Brazil");
        flags.put(R.drawable.bs, "Bahamas");
        flags.put(R.drawable.bt, "Bhutan");
        flags.put(R.drawable.bv, "BouvetIsland");
        flags.put(R.drawable.bw, "Botswana");
        flags.put(R.drawable.by, "Belarus");
        flags.put(R.drawable.bz, "Belize");
        flags.put(R.drawable.ca, "Canada");
        flags.put(R.drawable.cc, "CocosIslands");
        flags.put(R.drawable.cd, "CongoDemocraticRepublic");
        flags.put(R.drawable.cf, "CentralAfricanRepublic");
        flags.put(R.drawable.cg, "Congo");
        flags.put(R.drawable.ch, "Switzerland");
        flags.put(R.drawable.ci, "CtedIvoire");
        flags.put(R.drawable.ck, "CookIslands");
        flags.put(R.drawable.cl, "Chile");
        flags.put(R.drawable.cm, "Cameroon");
        flags.put(R.drawable.cn, "China");
        flags.put(R.drawable.co, "Colombia");
        flags.put(R.drawable.cr, "CostaRica");
        flags.put(R.drawable.cu, "Cuba");
        flags.put(R.drawable.cv, "CapeVerde");
        flags.put(R.drawable.cw, "Curaao");
        flags.put(R.drawable.cx, "ChristmasIsland");
        flags.put(R.drawable.cy, "Cyprus");
        flags.put(R.drawable.cz, "CzechRepublic");
        flags.put(R.drawable.de, "Germany");
        flags.put(R.drawable.dj, "Djibouti");
        flags.put(R.drawable.dk, "Denmark");
        flags.put(R.drawable.dm, "Dominica");
        flags.put(R.drawable.dob, "DominicanRepublic");
        flags.put(R.drawable.dz, "Algeria");
        flags.put(R.drawable.ec, "Ecuador");
        flags.put(R.drawable.ee, "Estonia");
        flags.put(R.drawable.eg, "Egypt");
        flags.put(R.drawable.eh, "WesternSahara");
        flags.put(R.drawable.er, "Eritrea");
        flags.put(R.drawable.es, "Spain");
        flags.put(R.drawable.et, "Ethiopia");
        flags.put(R.drawable.eu, "Europe");
        flags.put(R.drawable.fi, "Finland");
        flags.put(R.drawable.fj, "Fiji");
        flags.put(R.drawable.fm, "MicronesiaFederated");
        flags.put(R.drawable.fo, "FaroeIslands");
        flags.put(R.drawable.fr, "France");
        flags.put(R.drawable.ga, "Gabon");
        flags.put(R.drawable.gb, "England");
        flags.put(R.drawable.gbeng, "NorthernIreland");
        flags.put(R.drawable.gbnir, "Scotland");
        flags.put(R.drawable.gbsct, "Wales");
        flags.put(R.drawable.gbwls, "UnitedKingdom");
        flags.put(R.drawable.gd, "Grenada");
        flags.put(R.drawable.ge, "Georgia");
        flags.put(R.drawable.gf, "FrenchGuiana");
        flags.put(R.drawable.gg, "Guernsey");
        flags.put(R.drawable.gh, "Ghana");
        flags.put(R.drawable.gi, "Gibraltar");
        flags.put(R.drawable.gl, "Greenland");
        flags.put(R.drawable.gm, "Gambia");
        flags.put(R.drawable.gn, "Guinea");
        flags.put(R.drawable.gp, "Guadeloupe");
        flags.put(R.drawable.gq, "EquatorialGuinea");
        flags.put(R.drawable.gr, "Greece");
        flags.put(R.drawable.gt, "Guatemala");
        flags.put(R.drawable.gu, "Guam");
        flags.put(R.drawable.gw, "GuineaBissau");
        flags.put(R.drawable.gy, "Guyana ");
        flags.put(R.drawable.hk, "HongKong");
        flags.put(R.drawable.hm, "HeardIslandandMcDonald");
        flags.put(R.drawable.hn, "Honduras");
        flags.put(R.drawable.hr, "Croatia");
        flags.put(R.drawable.ht, "Haiti");
        flags.put(R.drawable.hu, "Hungary");
        flags.put(R.drawable.id, "Indonesia");
        flags.put(R.drawable.ie, "Ireland");
        flags.put(R.drawable.im, "IsleofMan");
        flags.put(R.drawable.in, "India");
        flags.put(R.drawable.io, "BritishIndianOcean");
        flags.put(R.drawable.iq, "Iraq");
        flags.put(R.drawable.ir, "IranIslamicRepublic");
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
        flags.put(R.drawable.kn, "SaintKittsandNevis");
        flags.put(R.drawable.kr, "KoreaRepublicof");
        flags.put(R.drawable.kw, "Kuwait");
        flags.put(R.drawable.ky, "CaymanIslands");
        flags.put(R.drawable.kz, "Kazakhstan");
        flags.put(R.drawable.la, "LaoPeoplesDemocratic");
        flags.put(R.drawable.lb, "Lebanon");
        flags.put(R.drawable.lc, "SaintLucia");
        flags.put(R.drawable.li, "Liechtenstein");
        flags.put(R.drawable.lk, "SriLanka");
        flags.put(R.drawable.lr, "Liberia");
        flags.put(R.drawable.ls, "Lesotho");
        flags.put(R.drawable.lt, "Lithuania");
        flags.put(R.drawable.lu, "Luxembourg");
        flags.put(R.drawable.lv, "Latvia");
        flags.put(R.drawable.ly, "Libya");
        flags.put(R.drawable.ma, "Morocco");
        flags.put(R.drawable.mc, "Monaco");
        flags.put(R.drawable.md, "MoldovaRepublicof");
        flags.put(R.drawable.me, "Montenegro");
        flags.put(R.drawable.mf, "SaintMartin");
        flags.put(R.drawable.mg, "Madagascar");
        flags.put(R.drawable.mh, "MarshallIslands");
        flags.put(R.drawable.ml, "Mali");
        flags.put(R.drawable.mm, "Myanmar");
        flags.put(R.drawable.mn, "Mongolia");
        flags.put(R.drawable.mo, "Macao");
        flags.put(R.drawable.mp, "NorthernMarianaIslands");
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
        flags.put(R.drawable.nc, "NewCaledonia");
        flags.put(R.drawable.ne, "Niger");
        flags.put(R.drawable.nf, "NorfolkIsland");
        flags.put(R.drawable.ng, "Nigeria");
        flags.put(R.drawable.ni, "Nicaragua");
        flags.put(R.drawable.nl, "Netherlands");
        flags.put(R.drawable.no, "Norway");
        flags.put(R.drawable.np, "Nepal");
        flags.put(R.drawable.nr, "Nauru");
        flags.put(R.drawable.nu, "Niue");
        flags.put(R.drawable.nz, "NewZealand");
        flags.put(R.drawable.om, "Oman");
        flags.put(R.drawable.pa, "Panama");
        flags.put(R.drawable.pe, "Peru");
        flags.put(R.drawable.pf, "FrenchPolynesia");
        flags.put(R.drawable.pg, "PapuaNewGuinea");
        flags.put(R.drawable.ph, "Philippines");
        flags.put(R.drawable.pk, "Pakistan");
        flags.put(R.drawable.pl, "Poland");
        flags.put(R.drawable.pm, "SaintPierreandMiquelon");
        flags.put(R.drawable.pn, "Pitcairn");
        flags.put(R.drawable.pr, "PuertoRico");
        flags.put(R.drawable.ps, "Palestine");
        flags.put(R.drawable.pt, "Portugal");
        flags.put(R.drawable.pw, "Palau");
        flags.put(R.drawable.py, "Paraguay");
        flags.put(R.drawable.qa, "Qatar");
        flags.put(R.drawable.re, "Réunion");
        flags.put(R.drawable.ro, "Romania");
        flags.put(R.drawable.rs, "Serbia");
        flags.put(R.drawable.ru, "RussianFederation");
        flags.put(R.drawable.rw, "Rwanda");
        flags.put(R.drawable.sa, "Saudi Arabia");
        flags.put(R.drawable.sb, "SolomonIslands");
        flags.put(R.drawable.sc, "Seychelles");
        flags.put(R.drawable.sd, "Sudan");
        flags.put(R.drawable.se, "Sweden");
        flags.put(R.drawable.sg, "Singapore");
        flags.put(R.drawable.si, "Slovenia");
        flags.put(R.drawable.sj, "SvalbardandJanMayen");
        flags.put(R.drawable.sk, "Slovakia");
        flags.put(R.drawable.sl, "SierraLeone");
        flags.put(R.drawable.sm, "SanMarino");
        flags.put(R.drawable.sn, "Senegal");
        flags.put(R.drawable.so, "Somalia");
        flags.put(R.drawable.sr, "Suriname");
        flags.put(R.drawable.ss, "SouthSudan");
        flags.put(R.drawable.st, "SaoTomeandPrincipe");
        flags.put(R.drawable.sv, "ElSalvador");
        flags.put(R.drawable.sx, "SintMaarten(Dutch part)");
        flags.put(R.drawable.sy, "SyrianArabRepublic");
        flags.put(R.drawable.sz, "Swaziland");
        flags.put(R.drawable.tc, "TurksandCaicosIslands");
        flags.put(R.drawable.td, "Chad");
        flags.put(R.drawable.tf, "FrenchSouthernTerritories");
        flags.put(R.drawable.tg, "Togo");
        flags.put(R.drawable.th, "Thailand");
        flags.put(R.drawable.tj, "Tajikistan");
        flags.put(R.drawable.tk, "Tokelau");
        flags.put(R.drawable.tl, "TimorLeste");
        flags.put(R.drawable.tm, "Turkmenistan");
        flags.put(R.drawable.tn, "Tunisia");
        flags.put(R.drawable.to, "Tonga");
        flags.put(R.drawable.tr, "Turkey");
        flags.put(R.drawable.tt, "TrinidadandTobago");
        flags.put(R.drawable.tv, "Tuvalu");
        flags.put(R.drawable.tw, "Taiwan");
        flags.put(R.drawable.tz, "TanzaniaUnitedRepublicof");
        flags.put(R.drawable.ua, "Ukraine");
        flags.put(R.drawable.ug, "Uganda");
        flags.put(R.drawable.um, "USMinorOutlyingIslands");
        flags.put(R.drawable.us, "UnitedStates");
        flags.put(R.drawable.uy, "Uruguay");
        flags.put(R.drawable.uz, "Uzbekistan");
        flags.put(R.drawable.va, "HolySee");
        flags.put(R.drawable.ve, "VenezuelaBolivarianRepublic");
        flags.put(R.drawable.vg, "VirginIslandsBritish");
        flags.put(R.drawable.vi, "VirginIslandsU.S.");
        flags.put(R.drawable.vn, "VietNam");
        flags.put(R.drawable.vu, "Vanuatu");
        flags.put(R.drawable.wf, "WallisandFutunaIslands");
        flags.put(R.drawable.ws, "Samoa");
        flags.put(R.drawable.xk, "Kosovo");
        flags.put(R.drawable.ye, "Yemen");
        flags.put(R.drawable.yt, "Mayotte");
        flags.put(R.drawable.za, "SouthAfrica");
        flags.put(R.drawable.zm, "Zambia");
        flags.put(R.drawable.zw, "Zimbabwe");


        //------------ get the random flag--------------------------------
        final int[] FlagRandom = new int[flags.size()];
        Object[] integers = flags.keySet().toArray();
        for (int i = 0; i < FlagRandom.length; i++) {
            FlagRandom[i] = Integer.parseInt(integers[i].toString());
        }


        //---------show the button,text,images------------------
        final Button hintStartButton = (Button) findViewById(R.id.hintStartButton);

        hintSubmit2 = (Button) findViewById(R.id.hintSubmitButton);
        hintNextButton2 = (Button) findViewById(R.id.hintNextButton2);

        final ImageView image = (ImageView) findViewById(R.id.hintImage);
        final TextView textCharac = (TextView) findViewById(R.id.textView3);
        correctHint = (TextView) findViewById(R.id.correctHint);
        fill = (EditText) findViewById(R.id.fillBlanks);
        layout = (LinearLayout) findViewById(R.id.lay);


        final Random pic = new Random();

        //----------- hide the button,text,dropdown list----------------
        hintSubmit2.setVisibility(View.INVISIBLE);
        hintNextButton2.setVisibility(View.INVISIBLE);
        fill.setVisibility(View.INVISIBLE);
        textCharac.setVisibility(View.INVISIBLE);

        final Context tempThis = this;
        //-----------click start the button and show game---------------------------
        hintStartButton.setOnClickListener(new View.OnClickListener() {

            //-----when switch button on,game start on timer--------
            @Override
            public void onClick(View v) {
                //------ if timer on show in top of right screen -------------
                if(isTimerOn){
                    if(t!=null){
                        t.cancel();
                    }

                    startTimer((TextView)findViewById(R.id.timerView3),TIME_OUT,1000);
                }

                hintStartButton.setVisibility(View.INVISIBLE);
                hintSubmit2.setVisibility(VISIBLE);
                fill.setVisibility(View.VISIBLE);
                textCharac.setVisibility(View.VISIBLE);

                //-----get random flag-------------
                int randImage = pic.nextInt(FlagRandom.length);
                randomFlag = FlagRandom[randImage];
                image.setImageResource(randomFlag);

                //----- get random flag name length---------
                flagName = flags.get(randomFlag);
                for (int i = 0; i < flagName.length(); i++) {
                    layout.addView(createTextView(tempThis), 80, 100);
                }

                map = new HashMap<Integer, Map<String, Boolean>>();
                Map mapInner;

                flagName = flagName.toUpperCase();
                for (int i = 0; i < flagName.length(); i++) {
                    mapInner = new HashMap<String, Boolean>();
                    mapInner.put(Character.toString(flagName.charAt(i)), true);
                    map.put(i, mapInner);
                }

            }
        });


        hintSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //------ if timer on show in top of right screen -------------
                if(isTimerOn){
                    if(t!=null){
                        t.cancel();
                    }
                    startTimer((TextView)findViewById(R.id.timerView3),TIME_OUT,1000);
                }
                correctHint.setText("");
                String nameAnswer = fill.getText().toString();
                if(addCharToText(String.valueOf(nameAnswer).toUpperCase())){
                    hintSubmit2.setVisibility(View.INVISIBLE);
                    hintNextButton2.setVisibility(View.VISIBLE);
                }
            }
        });

        hintNextButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //------ if timer on show in top of right screen -------------
                if(isTimerOn){
                    if(t!=null){
                        t.cancel();
                    }
                    startTimer((TextView)findViewById(R.id.timerView3),TIME_OUT,1000);
                }

                hintSubmit2.setVisibility(VISIBLE);
                hintNextButton2.setVisibility(View.INVISIBLE);
                correctHint.setText("");
                //----get random flag----------
                int randImage = pic.nextInt(FlagRandom.length);
                randomFlag = FlagRandom[randImage];
                image.setImageResource(randomFlag);
                //----get random flag name length----------
                flagName = flags.get(randomFlag);
                layout.removeAllViews();
                for (int i = 0; i < flagName.length(); i++) {
                    layout.addView(createTextView(tempThis), 80, 100);
                }

                map = new HashMap<Integer, Map<String, Boolean>>();
                Map mapInner;

                flagName = flagName.toUpperCase();
                for (int i = 0; i < flagName.length(); i++) {
                    mapInner = new HashMap<String, Boolean>();
                    mapInner.put(Character.toString(flagName.charAt(i)), true);
                    map.put(i, mapInner);
                }

            }
        });

    }

    //------ clickable TextView---------
    public TextView createTextView(Context con) {
        TextView b = null;
        try {
            //-------------setting up the edit text basic attributes--------
            b = new TextView(con);
            b.setText("-");
            b.setTextSize(22.0f);
            b.setMaxLines(1);
            b.setGravity(Gravity.CENTER);
            b.setBackgroundResource(R.drawable.edit_text_bg);
            b.setShadowLayer(1, 1, 1, Color.parseColor("#000000"));
            b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            b.setTextColor(Color.parseColor("#000000"));
        } catch (Exception e) {
            e.printStackTrace();
            return b;
        }
        return b;
    }

    private boolean addCharToText(final String str) {
        boolean correct = false;
        if (flagName.contains(str)) {
            for (int i = 0; i < flagName.length(); i++) {
                Map mapL = (Map) map.get(i);
                if (mapL.get(str) != null) {
                    boolean mapM = (boolean) mapL.get(str);
                    if (mapM) {
                        final TextView editText = (TextView) layout.getChildAt(i);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                editText.setText(str);
                            }
                        });
                        mapL.put(str, false);
                        map.put(i, mapL);
                    }
                }
            }

            String nameAnswer = "";
            for (int j = 0; j < layout.getChildCount(); j++) {
                TextView editText = (TextView) layout.getChildAt(j);
                nameAnswer = nameAnswer + editText.getText().toString();


                //--------this is where trigger answer is correct or not------------
                if (flagName.toUpperCase().equals(nameAnswer.toUpperCase())) {
//                    Toast.makeText(GuessHints.this, "CORRECT!",
//                            Toast.LENGTH_SHORT).show();
                    //------if full name correct,show a massage--------
                    correctHint.setText("CORRECT!");
                    correctHint.setTextColor(Color.GREEN);
                    return true;
                }
            }

            correct = true;
        }

        if (!correct) {
//            Toast.makeText(GuessHints.this, "WRONG!",
//                    Toast.LENGTH_SHORT).show();
            //-----if character is wrong.show the massage------
            correctHint.setText("WRONG!");
            correctHint.setTextColor(Color.RED);
        }

        return false;
    }

    //------- option menu ----------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.commonmenus, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
