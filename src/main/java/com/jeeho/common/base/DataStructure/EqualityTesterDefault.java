package com.jeeho.common.base.DataStructure;

import com.jeeho.common.base.DataStructure.interfaces.EqualityTester;

/**
 * 实现默认的判断器
 */
public class EqualityTesterDefault implements EqualityTester {

    public EqualityTesterDefault() {
    }

    @Override
    public boolean isEqualTo(Object a, Object b) {
        return a.equals(b);
    }
}
