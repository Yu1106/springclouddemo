package cn.sm1234.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 第一個Zuul過濾器
 */
//@Component
public class MyFilter1 extends ZuulFilter {

    //過濾器類型
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    //過濾器執行順序, 數值越大優先級越低
    @Override
    public int filterOrder() {
        return 1;
    }

    //是否讓過濾器生效
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //過濾邏輯代碼
    @Override
    public Object run() throws ZuulException {
        System.out.println("執行MyFilter1過濾器");

        return null;
    }
}
