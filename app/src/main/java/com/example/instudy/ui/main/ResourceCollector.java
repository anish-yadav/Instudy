package com.example.instudy.ui.main;

import com.example.instudy.R;

public class ResourceCollector {
    public int getImageResourceFromSubjectCode(String subject_code){

        subject_code = subject_code.toUpperCase();
        switch (subject_code){
            case "ICP":
                return R.drawable.ic_subject_computer;
            case "IGT":
                return R.drawable.ic_subject_maths;
            case "CALC-I":
                return R.drawable.ic_subject_maths;
            case "CALC-II":
                return R.drawable.ic_subject_maths;
            case "CTC":
                return R.drawable.ic_subject_generic;
            case "DSA":
                return R.drawable.ic_subject_computer;
            case "EM-I":
                return R.drawable.ic_subject_electrical;
            case "EMW-I":
                return  R.drawable.ic_subject_electromagnetic_waves;
            case "UPEM":
                return  R.drawable.ic_subject_physics;
                default:
                    return R.drawable.ic_subject_generic;
        }

    }
    public int getBookResourceFromSubjectCode(String subject_code){

        subject_code = subject_code.toUpperCase();
        switch (subject_code){
            case "ICP":
                return R.drawable.ic_subject_computer;
            case "IGT":
                return R.drawable.igt;
            case "CALC-I":
                return R.drawable.calc;
            case "CALC-II":
                return R.drawable.calc;
            case "CTC":
                return R.drawable.ic_subject_generic;
            case "DM":
                return R.drawable.dm;
            case "DSA":
                return R.drawable.ic_subject_computer;
            case "EM-I":
                return R.drawable.ic_subject_electrical;
            case "EMW-I":
                return  R.drawable.ic_subject_electromagnetic_waves;
            case "PME":
                return R.drawable.pme;
            case "UPEM":
                return  R.drawable.ic_subject_physics;
            default:
                return R.drawable.ic_subject_generic;
        }

    }
}
