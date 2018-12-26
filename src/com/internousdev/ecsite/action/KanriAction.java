package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.KanriDAO;
import com.internousdev.ecsite.dto.KanriDTO;
import com.opensymphony.xwork2.ActionSupport;

public class KanriAction extends ActionSupport{

	KanriDAO dao = new KanriDAO();
	KanriDTO dto = new KanriDTO();

	private int KID;
	private String KNAME;
	private String KPASS;

	public String execute() throws SQLException{
		dto = dao.getKanrisya(KNAME, KPASS);
		String result = ERROR;

		if(KNAME.equals(dto.getKname()) && KPASS.equals(dto.getKpass())){
			result = SUCCESS;
		}else{
			result = ERROR;
		}
		return result;

	}

	public int getKID() {
		return KID;
	}

	public void setKID(int kID) {
		KID = kID;
	}

	public String getKNAME() {
		return KNAME;
	}

	public void setKNAME(String kNAME) {
		KNAME = kNAME;
	}

	public String getKPASS() {
		return KPASS;
	}

	public void setKPASS(String kPASS) {
		KPASS = kPASS;
	}

}
