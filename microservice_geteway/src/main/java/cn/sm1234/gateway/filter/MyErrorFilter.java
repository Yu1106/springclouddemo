package cn.sm1234.gateway.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * 自定義錯誤類型Zuul過濾器
 */
@Component
public class MyErrorFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
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

        System.out.println("進入自定義異常過濾器");

        //1.捕獲異常訊息
        RequestContext currentContext = RequestContext.getCurrentContext();

        HttpServletResponse response = currentContext.getResponse();

        //ZuulException: 封裝其他zuul過濾器執行過程中發現的異常訊息
        ZuulException exception = (ZuulException) currentContext.get("throwable");

        //2. 把異常信息以json格式輸出給前端
        //2.1 構建錯誤訊息
        Result result = new Result(false, "執行失敗 " + exception.getMessage());

        //2.2 轉換Result為json字符串
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonString = objectMapper.writeValueAsString(result);

            //2.3 把json字符串寫回給用戶
            response.setContentType("text/json:charset=utf-8");
            response.getWriter().write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
