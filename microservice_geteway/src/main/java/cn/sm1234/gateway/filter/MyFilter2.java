package cn.sm1234.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 第一個Zuul過濾器
 */
//@Component
public class MyFilter2 extends ZuulFilter {

    //過濾器類型
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    //過濾器執行順序, 數值越大優先級越低
    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("執行MyFilter2過濾器");

        return null;
    }
}
