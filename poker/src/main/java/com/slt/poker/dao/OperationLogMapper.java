package com.slt.poker.dao;

import com.slt.poker.dto.OperationLog;

public interface OperationLogMapper extends DaoMapper{

    int insertLog(OperationLog record);

}