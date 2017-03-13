package com.slt.base.utils;

import java.util.Date;

import com.slt.poker.dao.OperationLogMapper;
import com.slt.poker.dto.OperationLog;

/**
 * 记录日志
 * @author Administrator
 *
 */
public class OperationLogUtil {

	public static void saveLog(OperationLogMapper operationLogMapper,String operationCode,String description,String loginId,String deviceId){
		OperationLog operationLog = new OperationLog();
		operationLog.setLoginID(loginId);
		operationLog.setDeviceID(deviceId);
		operationLog.setModule(operationCode);
		operationLog.setOpDecription(description);
		operationLog.setCreateDT(SimpleDateUtil.format(new Date(), "yyyyMMddHHmmss"));
		operationLog.setLogID(Md5Util.getUuid(28));
		operationLogMapper.insertLog(operationLog);
	}
}
