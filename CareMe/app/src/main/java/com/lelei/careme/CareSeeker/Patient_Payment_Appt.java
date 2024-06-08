package com.lelei.careme.CareSeeker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lelei.careme.Helpers.Patient_Session_Management;
import com.lelei.careme.Models.Admin_Payment_Class;
import com.lelei.careme.Models.Booking_Appointments;
import com.lelei.careme.Models.Patient_Chosen_Slot_Class;
import com.lelei.careme.R;

public class Patient_Payment_Appt extends AppCompatActivity {

    private String check,date_val,fees,phone,email,chosen_time,question_data,pname,slot_val,fees_val;
    private TextView fees_show;
    private EditText tid;
    private DatabaseReference reference_user, reference_doctor, reference_booking, reference_patient, reference_details, reference_doctor_appt, reference_payment;
    private Button pay_app;
    private TextView paymentLink;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_payment);
        reference_doctor = FirebaseDatabase.getInstance("https://careconnect-2b4ca-default-rtdb.firebaseio.com/").getReference("Doctors_Data");
        reference_doctor_appt = FirebaseDatabase.getInstance("https://careconnect-2b4ca-default-rtdb.firebaseio.com/").getReference("Doctors_Appointments");
        reference_booking = FirebaseDatabase.getInstance("https://careconnect-2b4ca-default-rtdb.firebaseio.com/").getReference("Doctors_Chosen_Slots");
        reference_patient = FirebaseDatabase.getInstance("https://careconnect-2b4ca-default-rtdb.firebaseio.com/").getReference("Patient_Chosen_Slots");
        reference_details = FirebaseDatabase.getInstance("https://careconnect-2b4ca-default-rtdb.firebaseio.com/").getReference("Patient_Details");
        reference_payment = FirebaseDatabase.getInstance("https://careconnect-2b4ca-default-rtdb.firebaseio.com/").getReference("Admin_Payment");
        Patient_Session_Management session = new Patient_Session_Management(Patient_Payment_Appt.this);
        phone = session.getSession();
        pname = getIntent().getSerializableExtra("pname").toString();
        email = getIntent().getSerializableExtra("email").toString();
        chosen_time = getIntent().getSerializableExtra("chosen_time").toString();
        question_data = getIntent().getSerializableExtra("question").toString();
        slot_val = getIntent().getSerializableExtra("slot_val").toString();
        date_val = getIntent().getSerializableExtra("date").toString();
        fees_val = getIntent().getSerializableExtra("fees").toString();
        check = getIntent().getSerializableExtra("check").toString();
        tid = (EditText) findViewById(R.id.paymentsinput);
        fees_show = (TextView) findViewById(R.id.fees);
        pay_app = (Button)findViewById(R.id.book_button);
        paymentLink = (TextView) findViewById(R.id.linkPayment);
        fees_show.setText("Please Pay Ksh. "+ fees_val);
        //TODO
    }
}