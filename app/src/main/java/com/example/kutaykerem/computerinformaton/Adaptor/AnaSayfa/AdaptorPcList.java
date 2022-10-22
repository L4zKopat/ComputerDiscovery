package com.example.kutaykerem.computerinformaton.Adaptor.AnaSayfa;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;



import com.example.kutaykerem.computerinformaton.Models.PcNames;
import com.example.kutaykerem.computerinformaton.Pages.AnasayfaFragmentDirections;
import com.example.kutaykerem.computerinformaton.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdaptorPcList extends RecyclerView.Adapter<AdaptorPcList.Holder> {



    ArrayList<PcNames> pcNamesArrayList;
    public AdaptorPcList(ArrayList<PcNames> pcNamesArrayList) {
        this.pcNamesArrayList = pcNamesArrayList;
    }




    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_pc_list,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") int position) {
        holder.image.setImageResource(pcNamesArrayList.get(position).getImage());
        holder.name.setText(pcNamesArrayList.get(position).getName());



           holder.name.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   String names =  holder.name.getText().toString();

                   if(names.equals("Ekran Kartları")){

                       NavDirections navDirections = AnasayfaFragmentDirections.actionAnasayfaFragmentToEkranKartlariFragment2();
                       Navigation.findNavController(view).navigate(navDirections);

                   }else if (names.equals("Anakartlar")){
                       NavDirections navDirections = AnasayfaFragmentDirections.actionAnasayfaFragmentToAnakartlarFragment2();
                       Navigation.findNavController(view).navigate(navDirections);

                   }else if (names.equals("İşlemciler")){
                       NavDirections navDirections = AnasayfaFragmentDirections.actionAnasayfaFragmentToIslemcilerFragment();
                       Navigation.findNavController(view).navigate(navDirections);

                   }else if (names.equals("Ramlar")){
                       NavDirections navDirections = AnasayfaFragmentDirections.actionAnasayfaFragmentToBelleklerFragment();
                       Navigation.findNavController(view).navigate(navDirections);

                   }else if (names.equals("Güç Kaynakları")){
                       NavDirections navDirections = AnasayfaFragmentDirections.actionAnasayfaFragmentToGucKaynaklariFragment();
                       Navigation.findNavController(view).navigate(navDirections);

                   }else if (names.equals("Kasalar")){
                       NavDirections navDirections = AnasayfaFragmentDirections.actionAnasayfaFragmentToKasalarFragment();
                       Navigation.findNavController(view).navigate(navDirections);

                   }
                   if(names.equals("Graphics Cards")){

                       NavDirections navDirections = AnasayfaFragmentDirections.actionAnasayfaFragmentToEkranKartlariFragment2();
                       Navigation.findNavController(view).navigate(navDirections);

                   }else if (names.equals("Motherboards")){
                       NavDirections navDirections = AnasayfaFragmentDirections.actionAnasayfaFragmentToAnakartlarFragment2();
                       Navigation.findNavController(view).navigate(navDirections);

                   }else if (names.equals("Processors")){
                       NavDirections navDirections = AnasayfaFragmentDirections.actionAnasayfaFragmentToIslemcilerFragment();
                       Navigation.findNavController(view).navigate(navDirections);

                   }else if (names.equals("Rams")){
                       NavDirections navDirections = AnasayfaFragmentDirections.actionAnasayfaFragmentToBelleklerFragment();
                       Navigation.findNavController(view).navigate(navDirections);

                   }else if (names.equals("Power Supplies")){
                       NavDirections navDirections = AnasayfaFragmentDirections.actionAnasayfaFragmentToGucKaynaklariFragment();
                       Navigation.findNavController(view).navigate(navDirections);

                   }else if (names.equals("Safes")){
                       NavDirections navDirections = AnasayfaFragmentDirections.actionAnasayfaFragmentToKasalarFragment();
                       Navigation.findNavController(view).navigate(navDirections);

                   }





               }
           });







    }








    @Override
    public int getItemCount() {
        return pcNamesArrayList.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        CardView cardView;

        public Holder(@NonNull View itemView) {
            super(itemView);


            cardView = itemView.findViewById(R.id.anasayfa_cardview);
            image = itemView.findViewById(R.id.ekrankartiImage);
            name = itemView.findViewById(R.id.name);



        }
    }




}


