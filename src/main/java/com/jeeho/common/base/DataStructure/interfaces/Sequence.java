package com.jeeho.common.base.DataStructure.interfaces;

import com.jeeho.common.base.DataStructure.exceptions.ExceptionBoundaryViolation;
import com.jeeho.common.base.DataStructure.exceptions.ExceptionPositionInvalid;

public interface Sequence extends List,Vector{

    Position rank2Pos(int r) throws ExceptionBoundaryViolation;

    Object Pos2Rank(Position p) throws ExceptionPositionInvalid;
}
