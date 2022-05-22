package cn.sm1234.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
public class AuthFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //模擬執行異常
//        int i = 10/0;

        //1.獲取當前請求的參數:token=user
        RequestContext currentContext = RequestContext.getCurrentContext();

        HttpServletRequest request = currentContext.getRequest();

        HttpServletResponse response = currentContext.getResponse();

        String token = request.getParameter("token");

        if (!"user".equals(token)) {
            //不轉發微服務, 給用戶響應
            currentContext.setSendZuulResponse(false);
            //設置401狀態碼
            response.setStatus(401);
            return null;
        }

        //繼續轉發
        return null;
    }
}
