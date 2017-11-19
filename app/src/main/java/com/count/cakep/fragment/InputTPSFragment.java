package com.count.cakep.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.count.cakep.R;
import com.count.cakep.activity.HomeActivity;
import com.count.cakep.activity.SuccessActivity;

import static android.app.Activity.RESULT_OK;


public class InputTPSFragment extends Fragment {

    @BindView(R.id.suara_calon_layout) LinearLayout suara_calon_layout;
    @BindView(R.id.bukti_foto_image) ImageView bukti_foto_image;
    @BindView(R.id.nama_personil) EditText nama_personil;
    @BindView(R.id.nrp_personil) EditText nrp_personil;
    @BindView(R.id.jumlah_dpt) EditText jumlah_dpt;
    @BindView(R.id.input_data_button) Button input_data_button;

    private HomeActivity act;
    private Bitmap finalBitmap;
    private ProgressDialog progressDialog;
    private boolean sendDataSucess = true;
    private List<EditText> allVoteCounts = new ArrayList<EditText>();
    private static final int TAKE_PICTURE_FROM_GALLERY = 101;

    @OnClick(R.id.input_data_button)
    public void sendData() {
        //disable the button
        input_data_button.setEnabled(false);
        //show progressDialog (SOON DEPRECATED FIND ALTERNATIVE)
        progressDialog = new ProgressDialog(getActivity(), R.style.CustomDialog);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Mohon tunggu...");
        progressDialog.show();

        if(sendDataSucess) {
            new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                @Override
                public void run() {
                    progressDialog.dismiss();
                    input_data_button.setEnabled(true);
                    //get out from here
                    Intent intent = new Intent(getActivity(), SuccessActivity.class);
                    startActivity(intent);
                    //Toast.makeText(getActivity(), "Data berhasil dikirim!", Toast.LENGTH_LONG).show();
                    getActivity().finish();
                }
            }, 2500);
        } else {
            progressDialog.dismiss();
            input_data_button.setEnabled(true);
            Toast.makeText(act, "Data belum berhasil dikirim! Silahkan coba kirim dengan koneksi yang lebih stabil", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.upload_photo_input_data_button)
    public void uploadImage() {
        pickPictureFromGallery();
    }

    public InputTPSFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input_tps, container, false);
        ButterKnife.bind(this, view);
        act = (HomeActivity) getActivity();
        getActivity().setTitle("Hasil Rekap TPS");

        nama_personil.setEnabled(false);
        nrp_personil.setEnabled(false);
        jumlah_dpt.setEnabled(false);

        addNewLayout(suara_calon_layout, 6, getActivity());
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case TAKE_PICTURE_FROM_GALLERY:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();
                    InputStream image_stream = null;
                    try {
                        image_stream = getActivity().getContentResolver().openInputStream(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    finalBitmap = BitmapFactory.decodeStream(image_stream);
                    Picasso.with(getActivity()).load(getImageUri(getActivity(), finalBitmap)).resize(150, 150).centerCrop().into(bukti_foto_image);
                }

                break;
        }
    }

    private void pickPictureFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, TAKE_PICTURE_FROM_GALLERY);
    }

    private Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    private void addNewLayout(LinearLayout layout, int amount, Context ctx) {
        //adding new TextView according to amount given
        for(int x=0; x<amount; x++) {
            TextView label = new TextView(ctx);
            label.setText("Jumlah suara calon "+(x+1));
            label.setTextSize(14);

            //set layout params for the textview
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            int startMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
            lp.setMargins(startMargin, 17, 0, 0);
            label.setLayoutParams(lp);
            layout.addView(label);

            EditText ed = new EditText(ctx);
            ed.setHint("Jumlah suara calon "+(x+1));
            ed.setInputType(InputType.TYPE_CLASS_NUMBER);
            int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics());
            LinearLayout.LayoutParams lpEd = new LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.WRAP_CONTENT);
            lpEd.setMargins(startMargin, 0, 0, 0);
            ed.setLayoutParams(lpEd);
            allVoteCounts.add(ed);
            layout.addView(ed);

        }
    }
}
