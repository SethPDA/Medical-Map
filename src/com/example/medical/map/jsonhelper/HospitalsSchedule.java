package com.example.medical.map.jsonhelper;

import java.io.Serializable;


@SuppressWarnings("serial")
public class HospitalsSchedule implements Serializable {

	public int ID;
	public String Name;
	public int ClosingHour;
	public int OpenHour;
	public boolean IsNonStop;
	public boolean IsOpenOnFriday;
	public boolean IsOpenOnMonday;
	public boolean IsOpenOnSaturday;
	public boolean IsOpenOnSunday;
	public boolean IsOpenOnThursday;
	public boolean IsOpenOnTuesday;
	public boolean IsOpenOnWednesday;

	public HospitalsSchedule(String City, int ID, String Street, String Name, int ClosingHour, int OpenHour, boolean IsNonStop, boolean IsOpenOnFriday, boolean IsOpenOnMonday, boolean IsOpenOnSaturday, boolean IsOpenOnSunday, boolean IsOpenOnThursday, boolean IsOpenOnTuesday, boolean IsOpenOnWednesday) {
		super();

		this.ID = ID;
		this.Name = Name;
		this.ClosingHour = ClosingHour;
		this.OpenHour = OpenHour;
		this.IsNonStop = IsNonStop;
		this.IsOpenOnFriday = IsOpenOnFriday;
		this.IsOpenOnMonday = IsOpenOnMonday; 
		this.IsOpenOnSaturday = IsOpenOnSaturday;
		this.IsOpenOnSunday = IsOpenOnSunday;
		this.IsOpenOnThursday = IsOpenOnThursday;
		this.IsOpenOnTuesday = IsOpenOnTuesday;
		this.IsOpenOnWednesday = IsOpenOnWednesday;

	}

	public int getClosingHour() {
		return ClosingHour;
	}

	public void setClosingHour(int closingHour) {
		ClosingHour = closingHour;
	}

	public int getOpenHour() {
		return OpenHour;
	}

	public void setOpenHour(int openHour) {
		OpenHour = openHour;
	}

	public boolean isIsNonStop() {
		return IsNonStop;
	}

	public void setIsNonStop(boolean isNonStop) {
		IsNonStop = isNonStop;
	}

	public boolean isIsOpenOnFriday() {
		return IsOpenOnFriday;
	}

	public void setIsOpenOnFriday(boolean isOpenOnFriday) {
		IsOpenOnFriday = isOpenOnFriday;
	}

	public boolean isIsOpenOnMonday() {
		return IsOpenOnMonday;
	}

	public void setIsOpenOnMonday(boolean isOpenOnMonday) {
		IsOpenOnMonday = isOpenOnMonday;
	}

	public boolean isIsOpenOnSaturday() {
		return IsOpenOnSaturday;
	}

	public void setIsOpenOnSaturday(boolean isOpenOnSaturday) {
		IsOpenOnSaturday = isOpenOnSaturday;
	}

	public boolean isIsOpenOnSunday() {
		return IsOpenOnSunday;
	}

	public void setIsOpenOnSunday(boolean isOpenOnSunday) {
		IsOpenOnSunday = isOpenOnSunday;
	}

	public boolean isIsOpenOnThursday() {
		return IsOpenOnThursday;
	}

	public void setIsOpenOnThursday(boolean isOpenOnThursday) {
		IsOpenOnThursday = isOpenOnThursday;
	}

	public boolean isIsOpenOnTuesday() {
		return IsOpenOnTuesday;
	}

	public void setIsOpenOnTuesday(boolean isOpenOnTuesday) {
		IsOpenOnTuesday = isOpenOnTuesday;
	}

	public boolean isIsOpenOnWednesday() {
		return IsOpenOnWednesday;
	}

	public void setIsOpenOnWednesday(boolean isOpenOnWednesday) {
		IsOpenOnWednesday = isOpenOnWednesday;
	}

	public int getId() {
		return ID;
	}

	public void setId(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

}
