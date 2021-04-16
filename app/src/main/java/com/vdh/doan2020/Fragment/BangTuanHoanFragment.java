package com.vdh.doan2020.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import androidx.appcompat.widget.SearchView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vdh.doan2020.Adapter.BangTuanHoanAdapter;
import com.vdh.doan2020.DataBase.DatabaseAccess;
import com.vdh.doan2020.Model.NguyenToHoaHoc;
import com.vdh.doan2020.R;

import java.util.ArrayList;
import java.util.List;

public class BangTuanHoanFragment extends Fragment implements View.OnClickListener {
    private static BangTuanHoanFragment INSTANCE;
    private RecyclerView recyclerView;
    private BangTuanHoanAdapter adapter;
    private List<NguyenToHoaHoc> nguyenToHoaHocList;
    private List<NguyenToHoaHoc>listDefault;
    private DatabaseAccess access;
    private SearchView searchView;
    private ImageView btnPhanLoai;
    private  View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_bth, container, false);
        recyclerView = view.findViewById(R.id.rv_bangtunahoan);
        recyclerView.setHasFixedSize(true);
        anhXa();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        access = DatabaseAccess.getInstance(getActivity());
        access.open();
        nguyenToHoaHocList = access.getNguyenToHoaHoc();
        listDefault=nguyenToHoaHocList;
        adapter = new BangTuanHoanAdapter(nguyenToHoaHocList, getActivity());
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void anhXa() {
        btnPhanLoai=view.findViewById(R.id.btn_phanloai);
        btnPhanLoai.setOnClickListener(this);
        searchView=view.findViewById(R.id.searchview_nthh);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
               adapter= new BangTuanHoanAdapter(listDefault,getActivity());
               recyclerView.setAdapter(adapter);
                return true;
            }
        });
    }

    public static BangTuanHoanFragment getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new BangTuanHoanFragment();
        }
        return INSTANCE;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_phanloai:
                filterAction();

        }
    }
    public void filterAction(){
        PopupMenu popupMenu = new PopupMenu(getActivity(),btnPhanLoai);
        popupMenu.getMenuInflater().inflate(R.menu.category_nthh, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                List<NguyenToHoaHoc> list = new ArrayList<>();
                switch (menuItem.getItemId()) {
                    case R.id.pl_actini:
                        list = access.phanLoaiNguyenToHoaHoc(menuItem.getTitle().toString());
                        adapter = new BangTuanHoanAdapter(list, getActivity());
                        searchView.setQuery(menuItem.getTitle().toString(), false);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                        break;
                    case R.id.pl_akim:
                        list = access.phanLoaiNguyenToHoaHoc(menuItem.getTitle().toString());
                        searchView.setQuery(menuItem.getTitle().toString(), false);
                        adapter = new BangTuanHoanAdapter(list, getActivity());
                        recyclerView.setAdapter(adapter);
                        break;
                    case R.id.pl_halogen:
                        list = access.phanLoaiNguyenToHoaHoc(menuItem.getTitle().toString());
                        searchView.setQuery(menuItem.getTitle().toString(), false);
                        adapter = new BangTuanHoanAdapter(list,  getActivity());
                        recyclerView.setAdapter(adapter);
                        break;
                    case R.id.pl_khitro:

                        list = access.phanLoaiNguyenToHoaHoc(menuItem.getTitle().toString());
                        searchView.setQuery(menuItem.getTitle().toString(), false);
                        adapter = new BangTuanHoanAdapter(list,  getActivity());
                        recyclerView.setAdapter(adapter);
                        break;
                    case R.id.pl_kimloaichichuyentiep:
                        list = access.phanLoaiNguyenToHoaHoc(menuItem.getTitle().toString());
                        searchView.setQuery(menuItem.getTitle().toString(), false);
                        adapter = new BangTuanHoanAdapter(list,  getActivity());
                        recyclerView.setAdapter(adapter);
                        break;
                    case R.id.pl_kimloaikiemtho:
                        list = access.phanLoaiNguyenToHoaHoc(menuItem.getTitle().toString());
                        searchView.setQuery(menuItem.getTitle().toString(), false);
                        adapter = new BangTuanHoanAdapter(list,  getActivity());
                        recyclerView.setAdapter(adapter);
                        break;
                    case R.id.pl_phikim:
                        list = access.phanLoaiNguyenToHoaHoc(menuItem.getTitle().toString());
                        searchView.setQuery(menuItem.getTitle().toString(), false);
                        adapter = new BangTuanHoanAdapter(list,  getActivity());
                        recyclerView.setAdapter(adapter);
                        break;
                    case R.id.pl_phimloaikiem:
                        list = access.phanLoaiNguyenToHoaHoc(menuItem.getTitle().toString());
                        searchView.setQuery(menuItem.getTitle().toString(), false);
                        adapter = new BangTuanHoanAdapter(list,  getActivity());
                        recyclerView.setAdapter(adapter);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }
}
