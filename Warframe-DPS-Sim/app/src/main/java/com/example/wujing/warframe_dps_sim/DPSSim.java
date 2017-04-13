package com.example.wujing.warframe_dps_sim;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Wujing on 2017/3/9.
 */

public class DPSSim extends AppCompatActivity{
    private EditText mInputBasicDMG;
    private EditText mInputFireRate;
    private EditText mInputCritChance;
    private EditText mInputCritDMG;
    private EditText mInputMultshot;
    private EditText mInputGenocide;
    private TextView mOutputDPSwithcrit;
    private TextView mOutputDPS;
    private TextView mOutputDPStotal;
    private TextView mOutputDPHwithcrit;
    private TextView mOutputDPH;
    private TextView mOutputDPHtotal;
    private TextView mOutputDPSwithGenocide;
    private Button mConfirmbutton;
    private CheckBox mSavedatacheckbox;
    private double mBasicDMG;
    private double mFireRate;
    private double mCritChance;
    private double mCritDMG;
    private double mMultshot;
    private double mGenocide;
    private double mDPSwithcrit;
    private double mDPS;
    private double mDPStotal;
    private double mDPHwithcrit;
    private double mDPH;
    private double mDPHtotal;
    private double mDPSwithgenocide;
    public double getBasicDMG() { return mBasicDMG;
    }
    public void setBasicDMG(double basicDMG) {
        mBasicDMG = basicDMG;
    }
    public double getFireRate() {
        return mFireRate;
    }
    public void setFireRate(double fireRate) {
        mFireRate = fireRate;
    }
    public double getCritChance() {
        return mCritChance;
    }
    public void setCritChance(double critChance) {
        mCritChance = critChance;
    }
    public double getCritDMG() {
        return mCritDMG;
    }
    public void setCritDMG(double critDMG) {
        mCritDMG = critDMG;
    }
    public double getMultshot() {
        return mMultshot;
    }
    public void setMultshot(double multshot) {
        mMultshot = multshot;
    }
    public double getGenocide() {
        return mGenocide;
    }
    public void setGenocide(double genocide) {mGenocide = genocide;}
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mConfirmbutton=(Button)findViewById(R.id.confirm_button);
        mInputBasicDMG=(EditText)findViewById(R.id.BasicDMG_editView);
        mInputFireRate=(EditText)findViewById(R.id.FireRate_editView);
        mInputCritChance=(EditText)findViewById(R.id.CritChance_editView);
        mInputCritDMG=(EditText)findViewById(R.id.CritDMG_editView);
        mInputMultshot=(EditText)findViewById(R.id.Multishot_editView);
        mInputGenocide=(EditText)findViewById(R.id.Genocide_editView);
        mOutputDPSwithcrit=(TextView)findViewById(R.id.DPSwithcrit_textview);
        mOutputDPS=(TextView)findViewById(R.id.DPS_textview) ;
        mOutputDPStotal=(TextView)findViewById(R.id.TotalDPS_textview) ;
        mOutputDPHwithcrit=(TextView)findViewById(R.id.DPHwithcrit_textview) ;
        mOutputDPH=(TextView)findViewById(R.id.DPH_textview) ;
        mOutputDPHtotal=(TextView)findViewById(R.id.TotalDPH_textview) ;
        mOutputDPSwithGenocide=(TextView)findViewById(R.id.DPSwithgenocide_textview) ;
        mSavedatacheckbox=(CheckBox)findViewById(R.id.Savedata_checkBox);
        mSavedatacheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        mConfirmbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String s1=mInputBasicDMG.getText().toString();
                if("".equals(s1)){
                    mBasicDMG = 0;
                }
                else{

                    mBasicDMG =Double.valueOf(s1);
                }
                String s2=mInputFireRate.getText().toString();
                if("".equals(s2)){
                    mFireRate = 0;
                }
                else{

                    mFireRate =Double.valueOf(s2);
                }
                String s3=mInputCritChance.getText().toString();
                if("".equals(s3)){
                    mCritChance = 0;
                }
                else{

                    mCritChance =Double.valueOf(s3);
                }
                String s4=mInputCritDMG.getText().toString();
                if("".equals(s4)){
                    mCritDMG = 0;
                }
                else{

                    mCritDMG =Double.valueOf(s4);
                }
                String s5=mInputMultshot.getText().toString();
                if("".equals(s5)){
                    mMultshot = 0;
                }
                else{

                    mMultshot =Double.valueOf(s5);
                }
                String s6=mInputGenocide.getText().toString();
                if("".equals(s6)){
                    mGenocide = 0;
                }
                else{

                    mGenocide =Double.valueOf(s6);
                }
                int mCritlevel=(new Double(mCritChance)).intValue()/1;
                //
                mDPSwithcrit=mBasicDMG*(1+mMultshot)*mCritChance*(mCritDMG-mCritlevel)*mFireRate;
                if(mCritChance>=1)
                    mDPS=0;
                        else mDPS=mBasicDMG*(1+mMultshot)*(1-mCritChance)*mFireRate;
                mDPStotal=mDPSwithcrit+mDPS;
                mDPHwithcrit=mBasicDMG*(1+mMultshot)*mCritChance*(mCritDMG-mCritlevel);
                if(mCritChance>=1)
                    mDPH=0;
                else mDPH=mBasicDMG*(1+mMultshot)*(1-mCritChance);
                mDPHtotal=mDPHwithcrit+mDPH;
                mDPSwithgenocide=mDPStotal*(1+mGenocide);
                //
                mOutputDPSwithcrit.setText(mDPSwithcrit+"(crit)");
                mOutputDPS.setText(mDPS+"(not crit)");
                mOutputDPStotal.setText(mDPStotal+"");
                mOutputDPHwithcrit.setText(mDPHwithcrit+"(crit)");
                mOutputDPH.setText(mDPH+"(not crit)");
                mOutputDPHtotal.setText(mDPHtotal+"");
                mOutputDPSwithGenocide.setText(mDPSwithgenocide+"");
                if(mSavedatacheckbox.isChecked()){


                }
            }
        });
    }



}
