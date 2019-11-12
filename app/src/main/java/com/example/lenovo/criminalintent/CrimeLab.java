package com.example.lenovo.criminalintent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class CrimeLab {
    private static final CrimeLab ourInstance = new CrimeLab();
    private List<Crime>  listCrime;

    public List<Crime> getListCrime() {
        return listCrime;
    }

    static CrimeLab getInstance() {
        return ourInstance;
    }
    public Crime getCrime(UUID id){
        for (Crime crime:listCrime){
            if (crime.getmId().equals(id)){
                return crime;
            }
        }
        return null;
    }

    private CrimeLab() {
        listCrime=new ArrayList<>();
    }
}
