package com.cpted.dao;

import java.util.ArrayList;
import java.util.List;

import com.cpted.beans.AccidentEmergency;
import com.cpted.beans.AccidentGeneral;
import com.cpted.beans.AccidentShare;

public interface AccidentDao {
	public List<AccidentEmergency> LoadAccidentEmegencyCurrent() throws Exception;
	
	public List<AccidentGeneral> LoadAccidentGeneralCurrent() throws Exception;
	
    public List<AccidentShare> LoadAccidentShareCurrent() throws Exception;
    
    public ArrayList LoadAccidentAllCurrent() throws Exception;
    
	
}
