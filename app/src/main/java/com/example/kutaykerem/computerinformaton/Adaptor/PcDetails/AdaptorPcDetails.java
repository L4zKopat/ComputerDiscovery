package com.example.kutaykerem.computerinformaton.Adaptor.PcDetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.example.kutaykerem.computerinformaton.Models.PcDetails;
import com.example.kutaykerem.computerinformaton.Parts.AnakartlarFragmentDirections;
import com.example.kutaykerem.computerinformaton.Parts.BelleklerFragmentDirections;
import com.example.kutaykerem.computerinformaton.Parts.EkranKartlariFragmentDirections;
import com.example.kutaykerem.computerinformaton.Parts.GucKaynaklariFragmentDirections;
import com.example.kutaykerem.computerinformaton.Parts.IslemcilerFragmentDirections;
import com.example.kutaykerem.computerinformaton.Parts.KasalarFragmentDirections;
import com.example.kutaykerem.computerinformaton.R;


import java.util.ArrayList;

public class AdaptorPcDetails extends RecyclerView.Adapter<AdaptorPcDetails.HolderAnakart> {




    ArrayList<PcDetails> pcDetailsArrayList;

    public AdaptorPcDetails(ArrayList<PcDetails> pcDetailsArrayList) {
        this.pcDetailsArrayList = pcDetailsArrayList;

    }
    public void setPcDetailsArrayList(ArrayList<PcDetails> pcDetailsArrayList) {
        this.pcDetailsArrayList = pcDetailsArrayList;
    }


    @NonNull
    @Override
    public HolderAnakart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_pc_info,parent,false);
        return new HolderAnakart(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderAnakart holder, int position) {
        holder.parcaAdi.setText(pcDetailsArrayList.get(position).getName());
        holder.parcaModeli.setText(pcDetailsArrayList.get(position).getDetailsName());

        holder.parcaModeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String names = holder.parcaModeli.getText().toString();
                String parcaAdi = holder.parcaAdi.getText().toString();

                if(parcaAdi.equals("Anakartlar")){
                    AnakartlarFragmentDirections.ActionAnakartlarFragment2ToKesfetFragment2 action = AnakartlarFragmentDirections.actionAnakartlarFragment2ToKesfetFragment2();
                    action.setArananParca(names);
                    Navigation.findNavController(view).navigate(action);
                }else if (parcaAdi.equals("Ekran Kartları")){
                    EkranKartlariFragmentDirections.ActionEkranKartlariFragment2ToKesfetFragment2 action = EkranKartlariFragmentDirections.actionEkranKartlariFragment2ToKesfetFragment2();
                    action.setArananParca(names);
                    Navigation.findNavController(view).navigate(action);

                }else if (parcaAdi.equals("Ramlar")){
                    BelleklerFragmentDirections.ActionBelleklerFragmentToKesfetFragment2 action = BelleklerFragmentDirections.actionBelleklerFragmentToKesfetFragment2();
                    action.setArananParca(names);
                    Navigation.findNavController(view).navigate(action);
                } else if (parcaAdi.equals("İşlemciler")){
                    IslemcilerFragmentDirections.ActionIslemcilerFragmentToKesfetFragment2 action = IslemcilerFragmentDirections.actionIslemcilerFragmentToKesfetFragment2();
                    action.setArananParca(names);
                    Navigation.findNavController(view).navigate(action);
                }else if (parcaAdi.equals("Güç Kaynakları")){
                    GucKaynaklariFragmentDirections.ActionGucKaynaklariFragmentToKesfetFragment2 action = GucKaynaklariFragmentDirections.actionGucKaynaklariFragmentToKesfetFragment2();
                    action.setArananParca(names);
                    Navigation.findNavController(view).navigate(action);

                }else if (parcaAdi.equals("Kasalar")){
                    KasalarFragmentDirections.ActionKasalarFragmentToKesfetFragment2 action = KasalarFragmentDirections.actionKasalarFragmentToKesfetFragment2();
                    action.setArananParca(names);
                    Navigation.findNavController(view).navigate(action);

                }



            }
        });



    }

    @Override
    public int getItemCount() {
        return pcDetailsArrayList.size();
    }

    public class HolderAnakart extends RecyclerView.ViewHolder{

        TextView parcaAdi;
        TextView parcaModeli;

        public HolderAnakart(@NonNull View itemView) {
            super(itemView);

             parcaAdi = itemView.findViewById(R.id.parcaAdi);
             parcaModeli = itemView.findViewById(R.id.parcaModeli);

        }
    }


}
