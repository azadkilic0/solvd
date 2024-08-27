package Interfaces;


import hospital.entities.MedicalRecord;

public interface RecordKeeper {
    void keepRecords();
    void updateRecords(MedicalRecord record);
}