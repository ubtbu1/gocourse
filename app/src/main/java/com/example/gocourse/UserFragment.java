package com.example.gocourse;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.navigation.Navigation;

public class UserFragment extends Fragment {

    public UserFragment() {
        // 默认的构造函数
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user, container, false);

        // 会员购买按钮
        Button buttonPurchase = view.findViewById(R.id.button_purchase_membership);
        buttonPurchase.setOnClickListener(v -> {
            // 处理会员购买逻辑
        });

        // 扫描按钮
        Button buttonScan = view.findViewById(R.id.button_scan);
        buttonScan.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_userFragment_to_scanFragment);
        });

        return view;
    }
}
