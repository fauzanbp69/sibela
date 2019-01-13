package home.com.appinto;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ActivityMain2 extends Activity implements OnClickListener {

    TooltipWindow tipWindow;
    RadioGroup radiogroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tipWindow = new TooltipWindow(ActivityMain2.this);
        radiogroup = findViewById(R.id.radiogroup);

    }
    public void onRadioButton(View view) {

        Boolean checked = ((RadioButton) view).isChecked();


        switch (view.getId()) {
            case R.id.R5:
                if (checked)
                    tampilDialog();
                break;

            case R.id.R3:
                if (checked)
                    jawabanSalah();
                break;
            case R.id.R4:
                if (checked)
                    jawabanSalah();
                break;
            case R.id.R6:
                if (checked)
                    tampilDialog1();
                break;

        }
    }
    public void tampilDialog1() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("");
        builder.setMessage("Heemm, pilihanmu kurang tepat nih,, coba hitung perlahan");
        builder.setIcon(R.drawable.crutasli);

        builder.setNegativeButton("ULANGI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                radiogroup.clearCheck();
            }
        });

        builder.create().show();

    }


    public void tampilDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Selamat !!!");
        builder.setMessage("Jawaban kamu benar : 12 , Ayo Coba Level Yang Lainnya !!");
        builder.setIcon(R.drawable.crutin);
        builder.setPositiveButton("OKE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ActivityMain2.this, "Tetap Semangat !!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("ULANGI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                radiogroup.clearCheck();
            }
        });

        builder.create().show();

    }
    //menampilkan toast text jawaban salah
    public void jawabanSalah(){

        Toast.makeText(this, "Yah,, Jawaban Kamu Kurang Tepat Nih", Toast.LENGTH_SHORT).show();

    }



    @Override
    public void onClick(View anchor) {
        if (!tipWindow.isTooltipShown())
            tipWindow.showToolTip(anchor);
    }

    @Override
    protected void onDestroy() {
        if (tipWindow != null && tipWindow.isTooltipShown())
            tipWindow.dismissTooltip();
        super.onDestroy();
    }

}
