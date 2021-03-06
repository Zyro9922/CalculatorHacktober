package tech.iosd.calculaterhacktober;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.sqrt;


public class MainActivity extends AppCompatActivity {
    Button add,sub,div,mul,one,two,three,four,five,six,seven,eight,nine,zero,equal,clear,decimal,clearall,percent,change,sign,
            pi,root,power,mod,history;

    TextView edit2,edit1;
    float value1,value2;
    float ans=0;
    boolean addition,subtraction,division,multiplication,answer,calcPower,calcMod;

    /**
     * Zyro
     * Added string to save HISTORY
     * **/

    StringBuilder historyString = new StringBuilder("");


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_history,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_history)
        {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create(); //Read Update
            alertDialog.setTitle("History");
            alertDialog.setMessage(historyString);
            alertDialog.show();  //<-- See This!
        }


return true;
    }

    /**
     * Zyro
     * Added history button
     * **/





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * 14th October 2018
         * HactoberFest
         * Zyro adds four buttons PI,root,power,mod
         **/

        pi=(Button)findViewById(R.id.pi);
        root=(Button)findViewById(R.id.root);
        power=(Button)findViewById(R.id.power);
        mod=(Button)findViewById(R.id.mod);


        add=(Button)findViewById(R.id.add);
        sub=(Button)findViewById(R.id.sub);
        mul=(Button)findViewById(R.id.mul);
        div=(Button)findViewById(R.id.div);
        one=(Button)findViewById(R.id.one);
        two=(Button)findViewById(R.id.two);
        three=(Button)findViewById(R.id.three);
        four=(Button)findViewById(R.id.four);
        five=(Button)findViewById(R.id.five);
        six=(Button)findViewById(R.id.six);
        seven=(Button)findViewById(R.id.seven);
        eight=(Button)findViewById(R.id.eight);
        nine=(Button)findViewById(R.id.nine);
        zero=(Button)findViewById(R.id.zero);
        equal=(Button)findViewById(R.id.equal);
        clear=(Button)findViewById(R.id.c);
        clearall=(Button)findViewById(R.id.ac);
        decimal=(Button)findViewById(R.id.decimal);
        edit1= (TextView) findViewById(R.id.editText1);
        edit2= (TextView) findViewById(R.id.editText2);
        percent= (Button) findViewById(R.id.percent);
        sign= (Button) findViewById(R.id.sign);
        // change= (Button) findViewById(R.id.change);

        /** Zyro add onCLickListener
         *
         */

        //What happens on PI?

        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText(edit1.getText()+"3.14159");
                historyString.append(edit1.getText()+"3.14159"+"\n");
            }
        });

        //What happens on root?

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    value1=Float.parseFloat(edit1.getText()+"");

                    edit1.setText((sqrt(value1))+"");
                    historyString.append(sqrt(value1)+"\n");
                }
                catch (Exception e){
                    edit1.setText("error");
                }
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText(edit1.getText()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText(edit1.getText()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText(edit1.getText()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText(edit1.getText()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText(edit1.getText()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText(edit1.getText()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText(edit1.getText()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText(edit1.getText()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText(edit1.getText()+"9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText(edit1.getText()+"0");

            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    value1=Float.parseFloat(edit1.getText()+"");

                    edit1.setText((value1/100)+"");
                }
                catch (Exception e){
                    edit1.setText("error");
                }
            }
        });

        clearall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText("");
                edit2.setText("");
                addition=false;
                subtraction=false;
                multiplication=false;
                division=false;
                value1=0;
                value2=0;
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText("");
            }
        });

        //What happens on power?
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    value1 = Float.parseFloat(edit1.getText() + "");
                    edit2.setText(edit1.getText() + "^");
                    historyString.append(edit1.getText() + "^" + "\n");
                    edit1.setText("");
//                ans=Float.parseFloat(edit.getText()+"");
                    calcPower = true;
                    addition = false;
                    subtraction = false;
                    division = false;
                    multiplication = false;
                    calcMod = false;
                }
                catch (Exception e){
                    edit1.setText("error");
                }

            }
        });

        //What happens on MODULUS?

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    value1 = Float.parseFloat(edit1.getText() + "");
                    edit2.setText(edit1.getText() + "%");
                    historyString.append(edit1.getText() + "%"+"\n");
                    edit1.setText("");
//                ans=Float.parseFloat(edit.getText()+"");
                    calcMod = true;
                    calcPower = false;
                    addition = false;
                    subtraction = false;
                    division = false;
                    multiplication = false;
                }
                catch (Exception e){
                    edit1.setText("error");
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    value1 = Float.parseFloat(edit1.getText() + "");
                    edit2.setText(edit1.getText() + "+");
                    historyString.append(edit1.getText() + "+" + "\n");
                    edit1.setText("");
//                ans=Float.parseFloat(edit.getText()+"");
                    addition = true;
                    subtraction = false;
                    division = false;
                    multiplication = false;
                    calcPower = false;
                    calcMod = false;

//                edit.setText(null);
                }
                catch (Exception e){
                    edit1.setText("error");
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
//                    ans=Float.parseFloat(edit.getText()+"");
                    subtraction=true;
                    addition=false;
                    division=false;
                    multiplication=false;
                    calcPower=false;
                    calcMod = false;
//                    edit.setText(null);
                    value1=Float.parseFloat(edit1.getText()+"");
                    edit2.setText(edit1.getText()+"-");
                    historyString.append(edit1.getText()+"-"+"\n");
                    edit1.setText("");
                }
                catch (Exception e){
                    edit1.setText("error");
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
//                    ans=Float.parseFloat(edit.getText()+"");
                    division=true;
                    subtraction=false;
                    addition=false;
                    multiplication=false;
                    calcPower=false;
                    calcMod = false;
//                    edit.setText(null);
                    value1=Float.parseFloat(edit1.getText()+"");
                    edit2.setText(edit1.getText()+"/");
                    historyString.append(edit1.getText()+"/"+"\n");
                    edit1.setText("");
                }
                catch (Exception e){
                    edit1.setText("error");
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
//                    ans=Float.parseFloat(edit.getText()+"");
                    multiplication=true;
                    subtraction=false;
                    division=false;
                    addition=false;
                    calcPower=false;
                    calcMod = false;
//                    edit.setText(null);
                    value1=Float.parseFloat(edit1.getText()+"");
                    edit2.setText(edit1.getText()+"*");
                    historyString.append(edit1.getText()+"*"+"\n");
                    edit1.setText("");
                }
                catch (Exception e){
                    edit1.setText("error");
                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    value2=Float.parseFloat(edit1.getText()+"");
                    String str= edit2.getText().toString()+edit1.getText().toString();
                    edit2.setText(str+"=");
                    answer=true;
                    if(addition==true){
                        ans=value1+value2;
                        //addition=false;
                    }
                    else if(subtraction==true){
                        ans=value1-value2;
                        //subtraction=false;
                    }
                    else if(division==true){
                        ans=value1/value2;
                        //division=false;
                    }
                    else if(multiplication==true){
                        ans=value1*value2;
                        //multiplication=false;

                    }
                    else if(calcPower==true){
                        ans = (float)Math.pow(value1,value2);

                    }
                    else if(calcMod==true){
                        ans = value1 % value2;
                    }
                    edit1.setText(ans+"");
                    historyString.append(ans+""+"\n");
                }
                catch (Exception e){
                    edit1.setText("error");
                }
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText(edit1.getText()+".");
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{edit1.setText("-");
                }
                catch (Exception e){
                    edit1.setText("error");
                }
            }
        });

    }
//    public void scientific(View view)
//    {
//        startActivity(new Intent(this,scientificCalc.class));
//    }
}

