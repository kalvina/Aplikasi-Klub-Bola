package id.eudeka.osg3_klub_bola.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.educa62.osg3_klub_bola.R;

import java.util.ArrayList;
import java.util.List;

import id.eudeka.osg3_klub_bola.Injection;
import id.eudeka.osg3_klub_bola.adapter.TeamBolaAdapter;
import id.eudeka.osg3_klub_bola.model.TeamDetail;
import id.eudeka.osg3_klub_bola.navigator.TeamNavigator;
import id.eudeka.osg3_klub_bola.viewmodel.TeamViewModel;

public class FragmentUtama extends Fragment implements TeamNavigator{

    // Add RecyclerView member
    private RecyclerView recyclerView;
    private List<TeamDetail> dataListTeamBola;
    private TeamBolaAdapter adapter;
    private TeamViewModel mTeamViewModel;
    private RecyclerView recTeam;







    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_utama, container, false);




        recTeam = (RecyclerView) view.findViewById(R.id.recyclerTeamBola);
        mTeamViewModel = new TeamViewModel(Injection.provideTeamRepository(getActivity()), getActivity());
        dataListTeamBola = new ArrayList<>();
        mTeamViewModel.setNavigator(this);
        mTeamViewModel.getListTeam();


        // Add the following lines to create RecyclerView
        //recyclerView = view.findViewById(R.id.recyclerTeamBola);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recTeam.setLayoutManager(manager);
        adapter = new TeamBolaAdapter(dataListTeamBola);
        //recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recTeam.setAdapter(adapter);



        return view;
    }

    @Override
    public void loadListTeam(List<TeamDetail> listTeam) {
        dataListTeamBola.addAll(listTeam);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void errorLoadListTeam(String message) {
        Log.e("ERROR", message);
    }



}