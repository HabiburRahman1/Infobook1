package com.example.habib.infobook;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClassRoutineFragment extends Fragment  implements AdapterView.OnItemSelectedListener{

    Spinner spinner;
    String level = "l";
    TextView[] day = new TextView[16];
    TextView[] time = new TextView[16];
    TextView[] cou = new TextView[16];
    TextView[] tea = new TextView[16];
    TextView[] room = new TextView[16];
    ArrayAdapter<CharSequence> adapter;


    StringBuffer buf = new StringBuffer();
    StringBuffer buf1 = new StringBuffer();
    StringBuffer buf2 = new StringBuffer();
    StringBuffer buf3 = new StringBuffer();
    StringBuffer buf4 = new StringBuffer();
    StringBuffer buf5 = new StringBuffer();
    StringBuffer buf6 = new StringBuffer();
    StringBuffer buf7 = new StringBuffer();
    StringBuffer buf8 = new StringBuffer();
    StringBuffer buf9 = new StringBuffer();
    StringBuffer buf10 = new StringBuffer();
    StringBuffer buf11 = new StringBuffer();
    TextView textView;
    View viewforthis;



    public ClassRoutineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewforthis= inflater.inflate(R.layout.fragment_class_routine, container, false);


        // Spinner element
        Spinner spinner = (Spinner) viewforthis.findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        Spinner section = (Spinner) viewforthis.findViewById(R.id.section);

        // Spinner click listener
        section.setOnItemSelectedListener(this);


        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Select Level and Term");
        categories.add("Level 1 Term 1");
        categories.add("Level 1 Term 2");
        categories.add("Level 1 Term 3");
        categories.add("Level 2 Term 1");
        categories.add("Level 2 Term 2");
        categories.add("Level 2 Term 3");
        categories.add("Level 3 Term 1");
        categories.add("Level 3 Term 2");
        categories.add("Level 3 Term 3");
        categories.add("Level 4 Term 1");
        categories.add("Level 4 Term 2");
        categories.add("Level 4 Term 3");
        List<String> Section = new ArrayList<String>();
        Section.add("Select Section");
        Section.add("A");
        Section.add("B");
        Section.add("C");
        Section.add("D");
        Section.add("F");
        Section.add("G");
        Section.add("H");
        Section.add("I");
        Section.add("J");
        Section.add("K");
        Section.add("L");
        Section.add("M");
        Section.add("N");
        Section.add("O");
        Section.add("P");
        Section.add("Q");
        Section.add("R");
        Section.add("S");
        Section.add("T");
        Section.add("U");
        Section.add("V");
        Section.add("W");
        Section.add("X");
        Section.add("Y");
        Section.add("Z");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        ArrayAdapter<String> sectionAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Section);

        // Drop down layout style - list view with radio button
        sectionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        section.setAdapter(sectionAdapter);
        //readClassRoutine();




        return viewforthis;

    }


    private void readClassRoutine(String[] subject) {
        StringBuffer bufferd = new StringBuffer();
        StringBuffer buffert = new StringBuffer();
        StringBuffer bufferc = new StringBuffer();
        StringBuffer buffertea = new StringBuffer();
        StringBuffer bufferr = new StringBuffer();
        String str = "";
        String dayname = "l";

        day[0] = (TextView) viewforthis.findViewById(R.id.day1);
        day[1] = (TextView) viewforthis.findViewById(R.id.day2);
        time[0] = (TextView) viewforthis.findViewById(R.id.time1);
        time[1] = (TextView) viewforthis.findViewById(R.id.time2);
        cou[0] = (TextView) viewforthis.findViewById(R.id.Course1);
        cou[1] = (TextView) viewforthis.findViewById(R.id.Course2);
        tea[0] = (TextView) viewforthis.findViewById(R.id.Teacher1);
        tea[1] = (TextView) viewforthis.findViewById(R.id.Teacher2);
        room[0] = (TextView) viewforthis.findViewById(R.id.Room1);
        room[1] = (TextView) viewforthis.findViewById(R.id.Room2);

        day[2] = (TextView) viewforthis.findViewById(R.id.day3);
        day[3] = (TextView) viewforthis.findViewById(R.id.day4);
        time[2] = (TextView) viewforthis.findViewById(R.id.time3);
        time[3] = (TextView) viewforthis.findViewById(R.id.time4);
        cou[2] = (TextView) viewforthis.findViewById(R.id.Course3);
        cou[3] = (TextView) viewforthis.findViewById(R.id.Course4);
        tea[2] = (TextView) viewforthis.findViewById(R.id.Teacher3);
        tea[3] = (TextView) viewforthis.findViewById(R.id.Teacher4);
        room[2] = (TextView) viewforthis.findViewById(R.id.Room3);
        room[3] = (TextView) viewforthis.findViewById(R.id.Room4);

        day[4] = (TextView) viewforthis.findViewById(R.id.day5);
        day[5] = (TextView) viewforthis.findViewById(R.id.day6);
        time[4] = (TextView) viewforthis.findViewById(R.id.time5);
        time[5] = (TextView) viewforthis.findViewById(R.id.time6);
        cou[4] = (TextView) viewforthis.findViewById(R.id.Course5);
        cou[5] = (TextView) viewforthis.findViewById(R.id.Course6);
        tea[4] = (TextView) viewforthis.findViewById(R.id.Teacher5);
        tea[5] = (TextView) viewforthis.findViewById(R.id.Teacher6);
        room[4] = (TextView) viewforthis.findViewById(R.id.Room5);
        room[5] = (TextView) viewforthis.findViewById(R.id.Room6);

        day[6] = (TextView) viewforthis.findViewById(R.id.day7);
        day[7] = (TextView) viewforthis.findViewById(R.id.day8);
        time[6] = (TextView) viewforthis.findViewById(R.id.time7);
        time[7] = (TextView) viewforthis.findViewById(R.id.time8);
        cou[6] = (TextView) viewforthis.findViewById(R.id.Course7);
        cou[7] = (TextView) viewforthis.findViewById(R.id.Course8);
        tea[6] = (TextView) viewforthis.findViewById(R.id.Teacher7);
        tea[7] = (TextView) viewforthis.findViewById(R.id.Teacher8);
        room[6] = (TextView) viewforthis.findViewById(R.id.Room7);
        room[7] = (TextView) viewforthis.findViewById(R.id.Room8);


        day[8] = (TextView) viewforthis.findViewById(R.id.day9);
        day[9] = (TextView) viewforthis.findViewById(R.id.day10);
        time[8] = (TextView) viewforthis.findViewById(R.id.time9);
        time[9] = (TextView) viewforthis.findViewById(R.id.time10);
        cou[8] = (TextView) viewforthis.findViewById(R.id.Course9);
        cou[9] = (TextView) viewforthis.findViewById(R.id.Course10);
        tea[8] = (TextView) viewforthis.findViewById(R.id.Teacher9);
        tea[9] = (TextView) viewforthis.findViewById(R.id.Teacher10);
        room[8] = (TextView) viewforthis.findViewById(R.id.Room9);
        room[9] = (TextView) viewforthis.findViewById(R.id.Room10);

        day[10] = (TextView) viewforthis.findViewById(R.id.day11);
        day[11] = (TextView) viewforthis.findViewById(R.id.day12);
        time[10] = (TextView) viewforthis.findViewById(R.id.time11);
        time[11] = (TextView) viewforthis.findViewById(R.id.time12);
        cou[10] = (TextView) viewforthis.findViewById(R.id.Course11);
        cou[11] = (TextView) viewforthis.findViewById(R.id.Course12);
        tea[10] = (TextView) viewforthis.findViewById(R.id.Teacher11);
        tea[11] = (TextView) viewforthis.findViewById(R.id.Teacher12);
        room[10] = (TextView) viewforthis.findViewById(R.id.Room11);
        room[11] = (TextView) viewforthis.findViewById(R.id.Room12);

        int k = 0;
        for (String sub : subject) {
            ArrayList<String> line = new ArrayList<String>();
            int i = 0, j = 0;
            InputStream is = this.getResources().openRawResource(R.raw.routine);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            if (is != null) {
                try {
                    while ((str = reader.readLine()) != null) {

                        line.add(str);
                        String spl[] = str.split(",");
                        for (String val : spl) {
                            if (val.equals("Saturday") || val.equals("Sunday") || val.equals("Monday") || val.equals("Tuesday") || val.equals("Wednesday") || val.equals("Thursday")) {
                                dayname = val;
                            }
                            if (val.equals(sub)) {
                                String t[] = line.get(1).split(",");
                                bufferd.append(dayname);
                                day[k].setText(bufferd.toString());
                                buffert.append(t[j - 1]);//time
                                time[k].setText(buffert.toString());
                                bufferc.append(spl[j]);//course code
                                cou[k].setText(bufferc.toString());
                                buffertea.append(spl[j + 1]);//teacher initial
                                tea[k].setText(buffertea.toString());
                                bufferr.append(spl[j - 1]);//room number
                                room[k].setText(bufferr.toString());
                                k++;
                                bufferd.delete(0, bufferd.length());
                                buffert.delete(0, buffert.length());
                                bufferc.delete(0, bufferc.length());
                                buffertea.delete(0, buffertea.length());
                                bufferr.delete(0, bufferr.length());


                            }
                            j++;
                        }
                        j = 0;
                        i++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        String Level_1_Term_1[] = {"CSE112", "MAT111", "ENG113", "PHY113"};
        String Level_1_Term_2[] = {"MAT121", "CSE122", "CSE123", "PHY123", "PHY124", "ENG123"};
        String Level_1_Term_3[] = {"CSE131", "CSE132", "CSE133", "CSE134", "CSE135", "MAT131"};
        String Level_2_Term_1[] = {"MAT211", "CSE212", "CSE213", "CSE214", "CSE215", "ED201"};
        String Level_2_Term_2[] = {"CSE221", "CSE222", "STA133", "CSE224", "CSE225"};
        String Level_2_Term_3[] = {"CSE231", "CSE232", "CSE233", "CSE234", "CSE235"};
        String Level_3_Term_1[] = {"CSE311", "CSE312", "CSE313", "CSE314", "GED321"};
        String Level_3_Term_2[] = {"CSE321", "CSE322", "CSE323", "CSE324", "ECO314"};
        String Level_3_Term_3[] = {"CSE331", "CSE332", "CSE333", "CSE334", "ACT301"};
        String Level_4_Term_1[] = {"CSE412", "CSE413", "CSE414", "CSE415", "CSE417", "CSE418"};
        String Level_4_Term_2[] = {"CSE421", "CSE422", "CSE423", "CSE XXX", "CSE499"};
        String Level_4_Term_3[] = {"CSE498", "CSE XXX", "CSE499"};

        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        if (item.equals("Level 1 Term 1")) {
            buf.append(Level_1_Term_1[0] + "\n");
            buf1.append("Computer Fundamentals\n");
            buf2.append(Level_1_Term_1[1] + "\n");
            buf3.append("Mathematics-I: Differential and Integral Calculus\n");
            buf4.append(Level_1_Term_1[2] + "\n");
            buf5.append("Basic Functional English and English Spoken\n");
            buf6.append(Level_1_Term_1[3] + "\n");
            buf7.append("Physics-I: Mechanics, Heat & Thermodynamics,Waves & Oscillation, Optics\n");
            TextView text = (TextView) viewforthis.findViewById(R.id.r2);
            TextView text1 = (TextView) viewforthis.findViewById(R.id.r3);
            TextView text2 = (TextView) viewforthis.findViewById(R.id.r4);
            TextView text3 = (TextView) viewforthis.findViewById(R.id.r5);
            TextView text4 = (TextView) viewforthis.findViewById(R.id.r6);
            TextView text5 = (TextView) viewforthis.findViewById(R.id.r7);
            TextView text6 = (TextView) viewforthis.findViewById(R.id.r8);
            TextView text7 = (TextView) viewforthis.findViewById(R.id.r9);
            text.setText(buf.toString());
            text1.setText(buf1.toString());
            text2.setText(buf2.toString());
            text3.setText(buf3.toString());
            text4.setText(buf4.toString());
            text5.setText(buf5.toString());
            text6.setText(buf6.toString());
            text7.setText(buf7.toString());
            buf.delete(0, buf.length());
            buf1.delete(0, buf1.length());
            buf2.delete(0, buf2.length());
            buf3.delete(0, buf3.length());
            buf4.delete(0, buf4.length());
            buf5.delete(0, buf5.length());
            buf6.delete(0, buf6.length());
            buf7.delete(0, buf7.length());
            buf8.delete(0, buf8.length());
            buf9.delete(0, buf9.length());
            buf10.delete(0, buf10.length());
            buf11.delete(0, buf11.length());

            level = item;
        } else if (item.equals("Level 1 Term 2")) {
            buf.append(Level_1_Term_2[0] + "\n");
            buf1.append("Mathematics -II: Complex Variable, inear Algebra and Coordinate Geometrys\n");
            buf2.append(Level_1_Term_2[1] + "\n");
            buf3.append("Programming and Problem Solving\n");
            buf4.append(Level_1_Term_2[2] + "\n");
            buf5.append("Problem Solving Lab\n");
            buf6.append(Level_1_Term_2[3] + "\n");
            buf7.append("Physics-II: Electricity, Magnetism and Modern Physics\n");
            buf8.append(Level_1_Term_2[4] + "\n");
            buf9.append("Physics-II Lab\n");
            buf10.append(Level_1_Term_2[5] + "\n");
            buf11.append("Writing and Comprehension\n");

            TextView text = (TextView) viewforthis.findViewById(R.id.r2);
            TextView text1 = (TextView) viewforthis.findViewById(R.id.r3);
            TextView text2 = (TextView) viewforthis.findViewById(R.id.r4);
            TextView text3 = (TextView) viewforthis.findViewById(R.id.r5);
            TextView text4 = (TextView) viewforthis.findViewById(R.id.r6);
            TextView text5 = (TextView) viewforthis.findViewById(R.id.r7);
            TextView text6 = (TextView) viewforthis.findViewById(R.id.r8);
            TextView text7 = (TextView) viewforthis.findViewById(R.id.r9);
            TextView text8 = (TextView) viewforthis.findViewById(R.id.r10);
            TextView text9 = (TextView) viewforthis.findViewById(R.id.r11);
            TextView text10 = (TextView) viewforthis.findViewById(R.id.r12);
            TextView text11 = (TextView) viewforthis.findViewById(R.id.r13);
            text.setText(buf.toString());
            text1.setText(buf1.toString());
            text2.setText(buf2.toString());
            text3.setText(buf3.toString());
            text4.setText(buf4.toString());
            text5.setText(buf5.toString());
            text6.setText(buf6.toString());
            text7.setText(buf7.toString());
            text8.setText(buf8.toString());
            text9.setText(buf9.toString());
            text10.setText(buf10.toString());
            text11.setText(buf11.toString());
            buf.delete(0, buf.length());
            buf1.delete(0, buf1.length());
            buf2.delete(0, buf2.length());
            buf3.delete(0, buf3.length());
            buf4.delete(0, buf4.length());
            buf5.delete(0, buf5.length());
            buf6.delete(0, buf6.length());
            buf7.delete(0, buf7.length());
            buf8.delete(0, buf8.length());
            buf9.delete(0, buf9.length());
            buf10.delete(0, buf10.length());
            buf11.delete(0, buf11.length());


            level = item;
        } else if (item.equals("Level 1 Term 3")) {
            buf.append(Level_1_Term_3[0] + "\n");
            buf1.append("Discrete Mathematics\n");
            buf2.append(Level_1_Term_3[1] + "\n");
            buf3.append("Electrical Circuits\n");
            buf4.append(Level_1_Term_3[2] + "\n");
            buf5.append("Electrical Circuits Lab\n");
            buf6.append(Level_1_Term_3[3] + "\n");
            buf7.append("Data Structure\n");
            buf8.append(Level_1_Term_3[4] + "\n");
            buf9.append("Data Structure Lab\n");
            buf10.append(Level_1_Term_3[5] + "\n");
            buf11.append("Ordinary and Partial Differential Equations\n");

            TextView text = (TextView) viewforthis.findViewById(R.id.r2);
            TextView text1 = (TextView) viewforthis.findViewById(R.id.r3);
            TextView text2 = (TextView) viewforthis.findViewById(R.id.r4);
            TextView text3 = (TextView) viewforthis.findViewById(R.id.r5);
            TextView text4 = (TextView) viewforthis.findViewById(R.id.r6);
            TextView text5 = (TextView) viewforthis.findViewById(R.id.r7);
            TextView text6 = (TextView) viewforthis.findViewById(R.id.r8);
            TextView text7 = (TextView) viewforthis.findViewById(R.id.r9);
            TextView text8 = (TextView) viewforthis.findViewById(R.id.r10);
            TextView text9 = (TextView) viewforthis.findViewById(R.id.r11);
            TextView text10 = (TextView) viewforthis.findViewById(R.id.r12);
            TextView text11 = (TextView) viewforthis.findViewById(R.id.r13);
            text.setText(buf.toString());
            text1.setText(buf1.toString());
            text2.setText(buf2.toString());
            text3.setText(buf3.toString());
            text4.setText(buf4.toString());
            text5.setText(buf5.toString());
            text6.setText(buf6.toString());
            text7.setText(buf7.toString());
            text8.setText(buf8.toString());
            text9.setText(buf9.toString());
            text10.setText(buf10.toString());
            text11.setText(buf11.toString());
            buf.delete(0, buf.length());
            buf1.delete(0, buf1.length());
            buf2.delete(0, buf2.length());
            buf3.delete(0, buf3.length());
            buf4.delete(0, buf4.length());
            buf5.delete(0, buf5.length());
            buf6.delete(0, buf6.length());
            buf7.delete(0, buf7.length());
            buf8.delete(0, buf8.length());
            buf9.delete(0, buf9.length());
            buf10.delete(0, buf10.length());
            buf11.delete(0, buf11.length());


            level = item;
        }
        else if (item.equals("Level 2 Term 1")) {
            buf.append(Level_2_Term_1[0] + "\n");
            buf1.append("Engineering Mathematics\n");
            buf2.append(Level_2_Term_1[1] + "\n");
            buf3.append("Digital Electronics\n");
            buf4.append(Level_2_Term_1[2] + "\n");
            buf5.append("Digital Electronics Lab\n");
            buf6.append(Level_2_Term_1[3] + "\n");
            buf7.append("Object Oriented Programming\n");
            buf8.append(Level_2_Term_1[4] + "\n");
            buf9.append("Object Oriented Programming Lab\n");
            buf10.append(Level_2_Term_1[5] + "\n");
            buf11.append("G Bangladesh Studie\n");

            TextView text = (TextView) viewforthis.findViewById(R.id.r2);
            TextView text1 = (TextView) viewforthis.findViewById(R.id.r3);
            TextView text2 = (TextView) viewforthis.findViewById(R.id.r4);
            TextView text3 = (TextView) viewforthis.findViewById(R.id.r5);
            TextView text4 = (TextView) viewforthis.findViewById(R.id.r6);
            TextView text5 = (TextView) viewforthis.findViewById(R.id.r7);
            TextView text6 = (TextView) viewforthis.findViewById(R.id.r8);
            TextView text7 = (TextView) viewforthis.findViewById(R.id.r9);
            TextView text8 = (TextView) viewforthis.findViewById(R.id.r10);
            TextView text9 = (TextView) viewforthis.findViewById(R.id.r11);
            TextView text10 = (TextView) viewforthis.findViewById(R.id.r12);
            TextView text11 = (TextView) viewforthis.findViewById(R.id.r13);
            text.setText(buf.toString());
            text1.setText(buf1.toString());
            text2.setText(buf2.toString());
            text3.setText(buf3.toString());
            text4.setText(buf4.toString());
            text5.setText(buf5.toString());
            text6.setText(buf6.toString());
            text7.setText(buf7.toString());
            text8.setText(buf8.toString());
            text9.setText(buf9.toString());
            text10.setText(buf10.toString());
            text11.setText(buf11.toString());
            buf.delete(0, buf.length());
            buf1.delete(0, buf1.length());
            buf2.delete(0, buf2.length());
            buf3.delete(0, buf3.length());
            buf4.delete(0, buf4.length());
            buf5.delete(0, buf5.length());
            buf6.delete(0, buf6.length());
            buf7.delete(0, buf7.length());
            buf8.delete(0, buf8.length());
            buf9.delete(0, buf9.length());
            buf10.delete(0, buf10.length());
            buf11.delete(0, buf11.length());


            level = item;
        }

        else if (item.equals("Level 2 Term 2")) {
            buf.append(Level_2_Term_2[0] + "\n");
            buf1.append("Algorithms\n");
            buf2.append(Level_2_Term_2[1] + "\n");
            buf3.append("Algorithms Lab\n");
            buf4.append(Level_2_Term_2[2] + "\n");
            buf5.append("Statistics and Probability\n");
            buf6.append(Level_2_Term_2[3] + "\n");
            buf7.append("Electronic Devices and Circuits\n");
            buf8.append(Level_2_Term_2[4] + "\n");
            buf9.append("Electronic Devices and Circuits Lab\n");


            TextView text = (TextView) viewforthis.findViewById(R.id.r2);
            TextView text1 = (TextView) viewforthis.findViewById(R.id.r3);
            TextView text2 = (TextView) viewforthis.findViewById(R.id.r4);
            TextView text3 = (TextView) viewforthis.findViewById(R.id.r5);
            TextView text4 = (TextView) viewforthis.findViewById(R.id.r6);
            TextView text5 = (TextView) viewforthis.findViewById(R.id.r7);
            TextView text6 = (TextView) viewforthis.findViewById(R.id.r8);
            TextView text7 = (TextView) viewforthis.findViewById(R.id.r9);
            TextView text8 = (TextView) viewforthis.findViewById(R.id.r10);
            TextView text9 = (TextView) viewforthis.findViewById(R.id.r11);

            text.setText(buf.toString());
            text1.setText(buf1.toString());
            text2.setText(buf2.toString());
            text3.setText(buf3.toString());
            text4.setText(buf4.toString());
            text5.setText(buf5.toString());
            text6.setText(buf6.toString());
            text7.setText(buf7.toString());
            text8.setText(buf8.toString());
            text9.setText(buf9.toString());

            buf.delete(0, buf.length());
            buf1.delete(0, buf1.length());
            buf2.delete(0, buf2.length());
            buf3.delete(0, buf3.length());
            buf4.delete(0, buf4.length());
            buf5.delete(0, buf5.length());
            buf6.delete(0, buf6.length());
            buf7.delete(0, buf7.length());
            buf8.delete(0, buf8.length());
            buf9.delete(0, buf9.length());



            level = item;
        }

        else if (item.equals("Level 2 Term 3")) {
            buf.append(Level_2_Term_3[0] + "\n");
            buf1.append("Microprocessor and Assembly Language\n");
            buf2.append(Level_2_Term_3[1] + "\n");
            buf3.append("Microprocessor and Assembly Language Lab\n");
            buf4.append(Level_2_Term_3[2] + "\n");
            buf5.append("Data Communication\n");
            buf6.append(Level_2_Term_3[3] + "\n");
            buf7.append("Numerical Methods\n");
            buf8.append(Level_2_Term_3[4] + "\n");
            buf9.append("EIntroduction to Bio-Informatics\n");


            TextView text = (TextView) viewforthis.findViewById(R.id.r2);
            TextView text1 = (TextView) viewforthis.findViewById(R.id.r3);
            TextView text2 = (TextView) viewforthis.findViewById(R.id.r4);
            TextView text3 = (TextView) viewforthis.findViewById(R.id.r5);
            TextView text4 = (TextView) viewforthis.findViewById(R.id.r6);
            TextView text5 = (TextView) viewforthis.findViewById(R.id.r7);
            TextView text6 = (TextView) viewforthis.findViewById(R.id.r8);
            TextView text7 = (TextView) viewforthis.findViewById(R.id.r9);
            TextView text8 = (TextView) viewforthis.findViewById(R.id.r10);
            TextView text9 = (TextView) viewforthis.findViewById(R.id.r11);

            text.setText(buf.toString());
            text1.setText(buf1.toString());
            text2.setText(buf2.toString());
            text3.setText(buf3.toString());
            text4.setText(buf4.toString());
            text5.setText(buf5.toString());
            text6.setText(buf6.toString());
            text7.setText(buf7.toString());
            text8.setText(buf8.toString());
            text9.setText(buf9.toString());

            buf.delete(0, buf.length());
            buf1.delete(0, buf1.length());
            buf2.delete(0, buf2.length());
            buf3.delete(0, buf3.length());
            buf4.delete(0, buf4.length());
            buf5.delete(0, buf5.length());
            buf6.delete(0, buf6.length());
            buf7.delete(0, buf7.length());
            buf8.delete(0, buf8.length());
            buf9.delete(0, buf9.length());



            level = item;
        }
        else if (item.equals("Level 3 Term 1")) {
            buf.append(Level_3_Term_1[0] + "\n");
            buf1.append("Database Management System\n");
            buf2.append(Level_3_Term_1[1] + "\n");
            buf3.append("Database Management System Lab\n");
            buf4.append(Level_3_Term_1[2] + "\n");
            buf5.append("Computer Networks\n");
            buf6.append(Level_3_Term_1[3] + "\n");
            buf7.append("Computer Networks Lab\n");
            buf8.append(Level_3_Term_1[4] + "\n");
            buf9.append("Art of Effective Living\n");


            TextView text = (TextView) viewforthis.findViewById(R.id.r2);
            TextView text1 = (TextView) viewforthis.findViewById(R.id.r3);
            TextView text2 = (TextView) viewforthis.findViewById(R.id.r4);
            TextView text3 = (TextView) viewforthis.findViewById(R.id.r5);
            TextView text4 = (TextView) viewforthis.findViewById(R.id.r6);
            TextView text5 = (TextView) viewforthis.findViewById(R.id.r7);
            TextView text6 = (TextView) viewforthis.findViewById(R.id.r8);
            TextView text7 = (TextView) viewforthis.findViewById(R.id.r9);
            TextView text8 = (TextView) viewforthis.findViewById(R.id.r10);
            TextView text9 = (TextView) viewforthis.findViewById(R.id.r11);

            text.setText(buf.toString());
            text1.setText(buf1.toString());
            text2.setText(buf2.toString());
            text3.setText(buf3.toString());
            text4.setText(buf4.toString());
            text5.setText(buf5.toString());
            text6.setText(buf6.toString());
            text7.setText(buf7.toString());
            text8.setText(buf8.toString());
            text9.setText(buf9.toString());

            buf.delete(0, buf.length());
            buf1.delete(0, buf1.length());
            buf2.delete(0, buf2.length());
            buf3.delete(0, buf3.length());
            buf4.delete(0, buf4.length());
            buf5.delete(0, buf5.length());
            buf6.delete(0, buf6.length());
            buf7.delete(0, buf7.length());
            buf8.delete(0, buf8.length());
            buf9.delete(0, buf9.length());



            level = item;
        }
        else if (item.equals("Level 3 Term 2")) {
            buf.append(Level_3_Term_2[0] + "\n");
            buf1.append("System Analysis and Design\n");
            buf2.append(Level_3_Term_2[1] + "\n");
            buf3.append("Computer Architecture and Organization\n");
            buf4.append(Level_3_Term_2[2] + "\n");
            buf5.append("Operating Systems\n");
            buf6.append(Level_3_Term_2[3] + "\n");
            buf7.append("Operating Systems Lab\n");
            buf8.append(Level_3_Term_2[4] + "\n");
            buf9.append("Economics\n");


            TextView text = (TextView) viewforthis.findViewById(R.id.r2);
            TextView text1 = (TextView) viewforthis.findViewById(R.id.r3);
            TextView text2 = (TextView) viewforthis.findViewById(R.id.r4);
            TextView text3 = (TextView) viewforthis.findViewById(R.id.r5);
            TextView text4 = (TextView) viewforthis.findViewById(R.id.r6);
            TextView text5 = (TextView) viewforthis.findViewById(R.id.r7);
            TextView text6 = (TextView) viewforthis.findViewById(R.id.r8);
            TextView text7 = (TextView) viewforthis.findViewById(R.id.r9);
            TextView text8 = (TextView) viewforthis.findViewById(R.id.r10);
            TextView text9 = (TextView) viewforthis.findViewById(R.id.r11);

            text.setText(buf.toString());
            text1.setText(buf1.toString());
            text2.setText(buf2.toString());
            text3.setText(buf3.toString());
            text4.setText(buf4.toString());
            text5.setText(buf5.toString());
            text6.setText(buf6.toString());
            text7.setText(buf7.toString());
            text8.setText(buf8.toString());
            text9.setText(buf9.toString());

            buf.delete(0, buf.length());
            buf1.delete(0, buf1.length());
            buf2.delete(0, buf2.length());
            buf3.delete(0, buf3.length());
            buf4.delete(0, buf4.length());
            buf5.delete(0, buf5.length());
            buf6.delete(0, buf6.length());
            buf7.delete(0, buf7.length());
            buf8.delete(0, buf8.length());
            buf9.delete(0, buf9.length());



            level = item;
        }

        else if (item.equals("Level 3 Term 3")) {
            buf.append(Level_3_Term_3[0] + "\n");
            buf1.append("Complier Design\n");
            buf2.append(Level_3_Term_3[1] + "\n");
            buf3.append("Complier Design Lab\n");
            buf4.append(Level_3_Term_3[2] + "\n");
            buf5.append("Software Engineering\n");
            buf6.append(Level_3_Term_3[3] + "\n");
            buf7.append("Wireless Programming\n");
            buf8.append(Level_3_Term_3[4] + "\n");
            buf9.append("Financial and Managerial Accounting 2\n");


            TextView text = (TextView) viewforthis.findViewById(R.id.r2);
            TextView text1 = (TextView) viewforthis.findViewById(R.id.r3);
            TextView text2 = (TextView) viewforthis.findViewById(R.id.r4);
            TextView text3 = (TextView) viewforthis.findViewById(R.id.r5);
            TextView text4 = (TextView) viewforthis.findViewById(R.id.r6);
            TextView text5 = (TextView) viewforthis.findViewById(R.id.r7);
            TextView text6 = (TextView) viewforthis.findViewById(R.id.r8);
            TextView text7 = (TextView) viewforthis.findViewById(R.id.r9);
            TextView text8 = (TextView) viewforthis.findViewById(R.id.r10);
            TextView text9 = (TextView) viewforthis.findViewById(R.id.r11);

            text.setText(buf.toString());
            text1.setText(buf1.toString());
            text2.setText(buf2.toString());
            text3.setText(buf3.toString());
            text4.setText(buf4.toString());
            text5.setText(buf5.toString());
            text6.setText(buf6.toString());
            text7.setText(buf7.toString());
            text8.setText(buf8.toString());
            text9.setText(buf9.toString());

            buf.delete(0, buf.length());
            buf1.delete(0, buf1.length());
            buf2.delete(0, buf2.length());
            buf3.delete(0, buf3.length());
            buf4.delete(0, buf4.length());
            buf5.delete(0, buf5.length());
            buf6.delete(0, buf6.length());
            buf7.delete(0, buf7.length());
            buf8.delete(0, buf8.length());
            buf9.delete(0, buf9.length());



            level = item;
        }

        else if (item.equals("Level 4 Term 1")) {
            buf.append(Level_4_Term_1[0] + "\n");
            buf1.append("Artificial Intelligence\n");
            buf2.append(Level_4_Term_1[1] + "\n");
            buf3.append("Artificial Intelligence Lab\n");
            buf4.append(Level_4_Term_1[2] + "\n");
            buf5.append("Simulation and Modelling\n");
            buf6.append(Level_4_Term_1[3] + "\n");
            buf7.append("Simulation and Modelling Lab\n");
            buf8.append(Level_4_Term_1[4] + "\n");
            buf9.append("Web Engineering\n");
            buf10.append(Level_4_Term_1[4] + "\n");
            buf11.append("Web Engineering Lab\n");

            TextView text = (TextView) viewforthis.findViewById(R.id.r2);
            TextView text1 = (TextView) viewforthis.findViewById(R.id.r3);
            TextView text2 = (TextView) viewforthis.findViewById(R.id.r4);
            TextView text3 = (TextView) viewforthis.findViewById(R.id.r5);
            TextView text4 = (TextView) viewforthis.findViewById(R.id.r6);
            TextView text5 = (TextView) viewforthis.findViewById(R.id.r7);
            TextView text6 = (TextView) viewforthis.findViewById(R.id.r8);
            TextView text7 = (TextView) viewforthis.findViewById(R.id.r9);
            TextView text8 = (TextView) viewforthis.findViewById(R.id.r10);
            TextView text9 = (TextView) viewforthis.findViewById(R.id.r11);

            text.setText(buf.toString());
            text1.setText(buf1.toString());
            text2.setText(buf2.toString());
            text3.setText(buf3.toString());
            text4.setText(buf4.toString());
            text5.setText(buf5.toString());
            text6.setText(buf6.toString());
            text7.setText(buf7.toString());
            text8.setText(buf8.toString());
            text9.setText(buf9.toString());

            buf.delete(0, buf.length());
            buf1.delete(0, buf1.length());
            buf2.delete(0, buf2.length());
            buf3.delete(0, buf3.length());
            buf4.delete(0, buf4.length());
            buf5.delete(0, buf5.length());
            buf6.delete(0, buf6.length());
            buf7.delete(0, buf7.length());
            buf8.delete(0, buf8.length());
            buf9.delete(0, buf9.length());



            level = item;
        }


        else if (item.equals("Level 4 Term 2")) {
            buf.append(Level_4_Term_2[0] + "\n");
            buf1.append("Computer Graphics\n");
            buf2.append(Level_4_Term_2[1] + "\n");
            buf3.append("Computer Graphics Lab\n");
            buf4.append(Level_4_Term_2[2] + "\n");
            buf7.append("Embedded Systems\n");
            buf8.append(Level_4_Term_2[4] + "\n");
            buf9.append("Project / Internship (Phase I, to be completed in Level-4 Term-3\n");


            TextView text = (TextView) viewforthis.findViewById(R.id.r2);
            TextView text1 = (TextView) viewforthis.findViewById(R.id.r3);
            TextView text2 = (TextView) viewforthis.findViewById(R.id.r4);
            TextView text3 = (TextView) viewforthis.findViewById(R.id.r5);
            TextView text4 = (TextView) viewforthis.findViewById(R.id.r6);
            TextView text5 = (TextView) viewforthis.findViewById(R.id.r7);
            TextView text6 = (TextView) viewforthis.findViewById(R.id.r8);
            TextView text7 = (TextView) viewforthis.findViewById(R.id.r9);
            TextView text8 = (TextView) viewforthis.findViewById(R.id.r10);
            TextView text9 = (TextView) viewforthis.findViewById(R.id.r11);

            text.setText(buf.toString());
            text1.setText(buf1.toString());
            text2.setText(buf2.toString());
            text3.setText(buf3.toString());
            text4.setText(buf4.toString());
            text5.setText(buf5.toString());
            text6.setText(buf6.toString());
            text7.setText(buf7.toString());
            text8.setText(buf8.toString());
            text9.setText(buf9.toString());

            buf.delete(0, buf.length());
            buf1.delete(0, buf1.length());
            buf2.delete(0, buf2.length());
            buf3.delete(0, buf3.length());
            buf4.delete(0, buf4.length());
            buf5.delete(0, buf5.length());
            buf6.delete(0, buf6.length());
            buf7.delete(0, buf7.length());
            buf8.delete(0, buf8.length());
            buf9.delete(0, buf9.length());



            level = item;
        }

        else if (item.equals("Level 4 Term 3")) {
            buf.append(Level_4_Term_3[0] + "\n");
            buf1.append("Social and Professional Issues in Computing\n");
            buf2.append(Level_4_Term_3[1] + "\n");
            buf3.append("Elective II\n");
            buf4.append(Level_4_Term_3[2] + "\n");
            buf7.append("Project / Internship (Phase II, continued from Level 4 Term 2)\n");



            TextView text = (TextView) viewforthis.findViewById(R.id.r2);
            TextView text1 = (TextView) viewforthis.findViewById(R.id.r3);
            TextView text2 = (TextView) viewforthis.findViewById(R.id.r4);
            TextView text3 = (TextView) viewforthis.findViewById(R.id.r5);
            TextView text4 = (TextView) viewforthis.findViewById(R.id.r6);
            TextView text5 = (TextView) viewforthis.findViewById(R.id.r7);
            TextView text6 = (TextView) viewforthis.findViewById(R.id.r8);
            TextView text7 = (TextView) viewforthis.findViewById(R.id.r9);

            text.setText(buf.toString());
            text1.setText(buf1.toString());
            text2.setText(buf2.toString());
            text3.setText(buf3.toString());
            text4.setText(buf4.toString());
            text5.setText(buf5.toString());
            text6.setText(buf6.toString());
            text7.setText(buf7.toString());


            buf.delete(0, buf.length());
            buf1.delete(0, buf1.length());
            buf2.delete(0, buf2.length());
            buf3.delete(0, buf3.length());
            buf4.delete(0, buf4.length());
            buf5.delete(0, buf5.length());
            buf6.delete(0, buf6.length());
            buf7.delete(0, buf7.length());

            level = item;
        }


        else if (id > 0) {
            if (level.equals("Level 1 Term 1")) {

                int c = 0;
                for (String check : Level_1_Term_1) {
                    Level_1_Term_1[c] = check + "(" + item + ")";
                    c++;
                }
                readClassRoutine(Level_1_Term_1);
            } else if (level.equals("Level 1 Term 2")) {

                int c = 0;
                for (String check : Level_1_Term_2) {
                    Level_1_Term_2[c] = check + "(" + item + ")";
                    c++;
                }
                readClassRoutine(Level_1_Term_2);
            } else if (level.equals("Level 1 Term 3")) {

                int c = 0;
                for (String check : Level_1_Term_3) {
                    Level_1_Term_3[c] = check + "(" + item + ")";
                    c++;
                }
                readClassRoutine(Level_1_Term_3);
            }

            else if (level.equals("Level 2 Term 1")) {

                int c = 0;
                for (String check : Level_2_Term_1) {
                    Level_2_Term_1[c] = check + "(" + item + ")";
                    c++;
                }
                readClassRoutine(Level_2_Term_1);
            }

            else if (level.equals("Level 2 Term 2")) {

                int c = 0;
                for (String check : Level_2_Term_2) {
                    Level_2_Term_2[c] = check + "(" + item + ")";
                    c++;
                }
                readClassRoutine(Level_2_Term_2);
            }

            else if (level.equals("Level 2 Term 3")) {

                int c = 0;
                for (String check : Level_2_Term_3) {
                    Level_2_Term_3[c] = check + "(" + item + ")";
                    c++;
                }
                readClassRoutine(Level_2_Term_3);
            }
            else if (level.equals("Level 3 Term 1")) {

                int c = 0;
                for (String check : Level_3_Term_1) {
                    Level_3_Term_1[c] = check + "(" + item + ")";
                    c++;
                }
                readClassRoutine(Level_3_Term_1);
            }

            else if (level.equals("Level 3 Term 2")) {

                int c = 0;
                for (String check : Level_3_Term_2) {
                    Level_3_Term_2[c] = check + "(" + item + ")";
                    c++;
                }
                readClassRoutine(Level_3_Term_2);
            }

            else if (level.equals("Level 3 Term 3")) {

                int c = 0;
                for (String check : Level_3_Term_3) {
                    Level_3_Term_3[c] = check + "(" + item + ")";
                    c++;
                }
                readClassRoutine(Level_3_Term_3);
            }

            else if (level.equals("Level 4 Term 1")) {

                int c = 0;
                for (String check : Level_4_Term_1) {
                    Level_4_Term_1[c] = check + "(" + item + ")";
                    c++;
                }
                readClassRoutine(Level_4_Term_1);
            }

            else if (level.equals("Level 4 Term 2")) {

                int c = 0;
                for (String check : Level_4_Term_2) {
                    Level_4_Term_2[c] = check + "(" + item + ")";
                    c++;
                }
                readClassRoutine(Level_4_Term_2);
            }
            else if (level.equals("Level 4 Term 3")) {

                int c = 0;
                for (String check : Level_4_Term_3) {
                    Level_4_Term_3[c] = check + "(" + item + ")";
                    c++;
                }
                readClassRoutine(Level_4_Term_3);
            }



        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
