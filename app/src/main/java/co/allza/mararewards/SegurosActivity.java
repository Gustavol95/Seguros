package co.allza.mararewards;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;
import co.allza.mararewards.adapter.SegurosAdapter;
import co.allza.mararewards.items.SeguroItem;

public class SegurosActivity extends AppCompatActivity {

    TextView tituloToolbar;
    ListView listaSeguros;
    SegurosAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguros);
        //para Lollipop
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusBarSeguros));
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Seguros");
        toolbar.setNavigationIcon(R.drawable.ic_notifications_active_white_24dp);
        setSupportActionBar(toolbar);



        listaSeguros=(ListView)findViewById(R.id.listViewSeguros);
        adapter = new SegurosAdapter(getApplicationContext(), R.layout.listview_seguros);
        adapter.add(new SeguroItem("Mi viaje a Europa","1234567890","MAPFRE Tepeyac","01/01/2017"));
        adapter.add(new SeguroItem("Escuela segura","4918394021","Quálitas","31/07/2016"));
        adapter.add(new SeguroItem("Choca Facilito","E1397","Allza Co","01/10/1994"));
        adapter.add(new SeguroItem(null,null,null,null));
        listaSeguros.setAdapter(adapter);


    }
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
