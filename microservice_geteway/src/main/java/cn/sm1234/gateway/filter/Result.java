package cn.sm1234.gateway.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 封裝響應數據
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private Boolean flag;
    private String message;
}
