package com.example.alquran.ui.Surat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.example.alquran.R;
import com.example.alquran.adapter.Adapter_Surat;
import com.example.alquran.api.ApiInterface;
import com.example.alquran.api.RetrofitApi;
import com.example.alquran.model.ResponseSurat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Fragment_Surat extends Fragment {

private ProgressBar progressBar;
private Adapter_Surat adapter_surat;
private RecyclerView recyclerView;
private ApiInterface apiInterface;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_surat, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        progressBar = view.findViewById(R.id.progress_surat);
        recyclerView = view.findViewById(R.id.rv_surat);
        apiInterface = RetrofitApi.getClient().create(ApiInterface.class);
        loadData(view);
    }

    private void loadData(View view) {
        Call<List<ResponseSurat>> call = apiInterface.getSurat();
        call.enqueue(new Callback<List<ResponseSurat>>() {
            @Override
            public void onResponse(Call<List<ResponseSurat>> call, Response<List<ResponseSurat>> response) {
                if (response.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    generateData(response.body(),view);
                }else {
                    Toast.makeText(getContext(), "Gagal memuat Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseSurat>> call, Throwable t) {
                Toast.makeText(getContext(), "error"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateData(List<ResponseSurat> list,View view) {
        recyclerView = view.findViewById(R.id.rv_surat);
        adapter_surat = new Adapter_Surat(getContext(),list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter_surat);
    }

}
