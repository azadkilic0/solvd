package hospital.entities;

import java.util.Objects;

public class MedicalEquipment {
    private String equipmentName;
    private String serialNumber;

    public MedicalEquipment(String equipmentName, String serialNumber) {
        this.equipmentName = equipmentName;
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return equipmentName;
    }

    @Override
    public String toString() {
        return "MedicalEquipment{" +
                "equipmentName='" + equipmentName + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalEquipment that = (MedicalEquipment) o;
        return Objects.equals(equipmentName, that.equipmentName) &&
                Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentName, serialNumber);
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
