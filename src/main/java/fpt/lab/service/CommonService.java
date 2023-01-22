package fpt.lab.service;

//import fpt.lab.constant.NumberResultConstant;
import fpt.lab.dao.AccessDao;
import fpt.lab.model.req.AccessReq;

public class CommonService {
	public int accessSite(AccessReq accessReq) {
		AccessDao accessDao = new AccessDao();
//		if(accessDao.checkAccess(accessReq))
		return accessDao.accessSite(accessReq);
//		else 
//			return NumberResultConstant.NO_ACTION;
	}	
}
